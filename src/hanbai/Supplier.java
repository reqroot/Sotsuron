package hanbai;

import hanbai.db.SupplierDBManager;
import hanbai.db.SupplierInfo;

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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		SupplierDBManager manager = new SupplierDBManager();
		//検索ボタンが押された場合
		if(request.getParameter("searchBtn") != null){
			//パラメータの取得
			String beginID = request.getParameter("beginID");
			String endID = request.getParameter("endID");
			String name = request.getParameter("name");
			String beginKaikakeStr = request.getParameter("beginKaikake");
			String endKaikakeStr = request.getParameter("endKaikake");
			int beginKaikake = beginKaikakeStr == null ? 0 : Integer.parseInt(beginKaikakeStr);
			int endKaikake = endKaikakeStr == null ? Integer.MAX_VALUE : Integer.parseInt(endKaikakeStr);

			//値の確認
			//デバッグ用
			beginID = "0000";
			endID = "0030";
			name = "%";
			beginKaikake = 0;
			endKaikake = 20000;
			try {
				List<SupplierInfo> list = manager.SupplierSelect(beginID, endID, name, beginKaikake, endKaikake);

				//JSPにデータを送る
				request.setAttribute("list", list);
				request.setAttribute("beginID", request.getParameter("beginID"));
				request.setAttribute("endID", request.getParameter("endID"));
				request.setAttribute("name",request.getParameter("name"));
				request.setAttribute("beginKaikake",request.getParameter("beginKaikake"));
				request.setAttribute("endKaikake",request.getParameter("endKaikake"));

				//ディスパッチャーを取得
				RequestDispatcher rd = request.getRequestDispatcher("/hanbai/supplier_view.jsp");//Contextの値以降のアドレスを設定
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


		}
	}

}
