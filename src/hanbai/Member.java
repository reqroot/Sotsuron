package hanbai;

import hanbai.db.member.MemberDBManager;
import hanbai.db.member.MemberInfo;
import hanbai.db.member.MemberValidator;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Member
 */
@WebServlet("/member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "会員管理画面";
	private static final String PAGE = "/hanbai/member_view.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member() {
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

		MemberDBManager manager = new MemberDBManager();
		MemberValidator  validator = new MemberValidator();
		//検索ボタンが押された場合
		if(request.getParameter("searchBtn") != null){
			//パラメータの取得
			String beginID = request.getParameter("beginID");
			String endID = request.getParameter("endID");
			String name = request.getParameter("name");

			//SQLの検索値の作成
			beginID = validator.convertID(beginID);
			if(beginID == null){
				beginID = "0000";
			}
			endID = validator.convertID(endID);
			if(endID == null){
				endID = "9999";
			}
			name = validator.convertName(name);
			if(name == null){
				name = "%";
			}else{
				name = "%" + name + "%";
			}

			//デバッグ用
			/*beginID = "0000";
			endID = "0030";
			name = "%";
			beginKaikake = 0;
			endKaikake = 20000;*/
			try {
				List<MemberInfo> list = manager.MemberSearch(beginID, endID, name);

				//JSPにデータを送る
				//実際の検索値をメッセージとして設定する
				manager.setMsg(String.format("検索数[%s] (会員ID:%s～%s 名前:%s)", list.size(), beginID, endID, name.replace("%", "")));
				request.setAttribute("msg", manager.getMsg());
				request.setAttribute("list", list);
				//Attributeには入力された値をそのまま返す
				request.setAttribute("beginID", request.getParameter("beginID"));
				request.setAttribute("endID", request.getParameter("endID"));
				request.setAttribute("name",request.getParameter("name"));
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
