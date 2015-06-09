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
@WebServlet("/hanbai/member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "会員管理画面";
	private static final String PAGE_VIEW = "/hanbai/member_view.jsp";
	private static final String PAGE_DETAIL = "/hanbai/member_view_detail.jsp";
	private static final String PAGE_EDIT = "/hanbai/member_view_edit.jsp";

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
		request.setAttribute("content_page", PAGE_VIEW);
		//ディスパッチャーを取得
		RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try{
			if(request.getParameter("searchBtn") != null){
				//検索ボタンが押された場合
				doSearch(request, response);
			}else if(request.getParameter("detailBtn") != null){
				//詳細ボタンが押された場合
				doDetail(request, response);
			}else if(request.getParameter("editBtn") != null){
				//編集ボタンが押された場合
				doEdit(request, response);
			}
		}catch(Exception e){
			//エラー処理
			e.printStackTrace();
		}


		//ディスパッチャーを取得
		RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
		rd.forward(request, response);
	}

	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		doDetail(request, response);
		request.setAttribute("content_page", PAGE_EDIT);
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDBManager manager = new MemberDBManager();
		MemberValidator  validator = new MemberValidator();

		//パラメータの取得
		String id = request.getParameter("id");
		System.out.println("id:" + id);
		//SQL検索値の作成
		id = validator.convertID(id);
		System.out.println("id(convert):" + id);
		//データの取得
		MemberInfo info = manager.MemberSearchDetail(id);
		System.out.println("info:" + info);
		request.setAttribute("item", info);
		//ページ情報の追加
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE_DETAIL);
	}

	private void doSearch(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberDBManager manager = new MemberDBManager();
		MemberValidator  validator = new MemberValidator();

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
		request.setAttribute("content_page", PAGE_VIEW);


	}



}
