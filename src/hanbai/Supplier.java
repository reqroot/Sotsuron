package hanbai;

import hanbai.db.supplier.SupplierDBManager;
import hanbai.db.supplier.SupplierInfo;
import hanbai.db.supplier.SupplierRegex;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Supplier
 */
@WebServlet("/hanbai/supplier")
public class Supplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "仕入先管理画面";
	private static final String PAGE = "/hanbai/supplier_view.jsp";


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ジャンルの一覧を取得する
		request.setCharacterEncoding("UTF-8");

		//ページ情報の追加
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE);
		//ディスパッチャーを取得
		RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		SupplierDBManager manager = new SupplierDBManager();
		SupplierRegex  regex = new SupplierRegex();
		//検索ボタンが押された場合
		if(request.getParameter("searchBtn") != null){
			//パラメータの取得
			String beginID = request.getParameter("beginID");
			String endID = request.getParameter("endID");
			String name = request.getParameter("name");
			String beginKaikakeStr = request.getParameter("beginKaikake");
			String endKaikakeStr = request.getParameter("endKaikake");
			long beginKaikake;
			long endKaikake ;

			//SQLの検索値の作成
			beginID = regex.convertID(beginID);
			if(beginID == null){
				beginID = "0000";
			}
			endID = regex.convertID(endID);
			if(endID == null){
				endID = "9999";
			}
			name = regex.convertName(name);
			if(name == null){
				name = "%";
			}else{
				name = "%" + name + "%";
			}
			beginKaikakeStr = regex.convertKaikake(beginKaikakeStr);
			if(beginKaikakeStr == null){
				beginKaikake = 0;
			}else{
				beginKaikake = Long.parseLong(beginKaikakeStr);
			}
			endKaikakeStr = regex.convertKaikake(endKaikakeStr);
			if(endKaikakeStr == null){
				endKaikake = 9999999999L;
			}else{
				endKaikake = Long.parseLong(endKaikakeStr);
			}

			//デバッグ用
			/*beginID = "0000";
			endID = "0030";
			name = "%";
			beginKaikake = 0;
			endKaikake = 20000;*/
			try {
				List<SupplierInfo> list = manager.SupplierSelect(beginID, endID, name, beginKaikake, endKaikake);

				//JSPにデータを送る
				//実際の検索値をメッセージとして設定する
				manager.setMsg(String.format("検索数[%s] (仕入先ID:%s～%s 仕入先名:%s 買掛残高:%s～%s)", list.size(), beginID, endID, name.replace("%", ""), beginKaikake, endKaikake));
				request.setAttribute("msg", manager.getMsg());
				request.setAttribute("list", list);
				//Attributeには入力された値をそのまま返す
				request.setAttribute("beginID", request.getParameter("beginID"));
				request.setAttribute("endID", request.getParameter("endID"));
				request.setAttribute("name",request.getParameter("name"));
				request.setAttribute("beginKaikake",request.getParameter("beginKaikake"));
				request.setAttribute("endKaikake",request.getParameter("endKaikake"));
				//ページ情報の追加
				request.setAttribute("page_title", TITLE);
				request.setAttribute("content_page", PAGE);
				//ディスパッチャーを取得
				RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}//if
	}


}
