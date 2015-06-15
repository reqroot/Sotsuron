package hanbai;

import hanbai.db.member.MemberDBManager;
import hanbai.db.member.MemberInfo;
import hanbai.db.member.MemberSerchInfo;
import hanbai.db.member.MemberValidator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			}else if(request.getParameter("confirmBtn") != null){
				//確認ボタンが押された場合
				doConfirm(request, response);
			}else if(request.getParameter("editBackBtn") != null){
				//編集に戻るボタンが押された場合
				doEditBack(request, response);
			}else if(request.getParameter("commitBtn") != null){
				//確定ボタンが押された場合
				doCommit(request, response);
			}else if(request.getParameter("backBtn") != null){
				//一覧に戻るボタンが押された場合
				redirectView(request, response);
			}
		}catch(Exception e){
			//エラー処理
			e.printStackTrace();
		}


		//ディスパッチャーを取得
		RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
		rd.forward(request, response);
	}

	private void doEditBack(HttpServletRequest request,HttpServletResponse response) {
	}

	private void redirectView(HttpServletRequest request,HttpServletResponse response) {

	}

	private void doCommit(HttpServletRequest request,HttpServletResponse response) {
	}

	private void doConfirm(HttpServletRequest request,HttpServletResponse response) {

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
		id = validator.convertID(id,"9999999");
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
		MemberSerchInfo searchInfo = new MemberSerchInfo();

		//SQLの検索値の作成
		//会員番号
		searchInfo.setBeginID(validator.convertID(request.getParameter("beginID"), "0000000"));
		searchInfo.setEndID(validator.convertID(request.getParameter("endID"), "9999999"));
		//登録年月日
		searchInfo.setBeginDate(validator.convertDate(request.getParameter("beginDate"), new SimpleDateFormat("yyyy/MM/dd").parse("2000/01/01")));
		searchInfo.setEndDate(validator.convertDate(request.getParameter("endDate"), new Date()));
		//名前
		searchInfo.setName(validator.convertName(request.getParameter("name"), null));

		//DBからデータ取得
		List<MemberInfo> list = manager.MemberSearch(
				searchInfo.getBeginID(), searchInfo.getEndID(),
				searchInfo.getBeginDateStr(), searchInfo.getEndDateStr(), searchInfo.getNameSqlParam());

		//JSPにデータを送る
		//リクエストパラメータの追加
		manager.setMsg(String.format("検索数[%s] (会員ID:%s～%s 登録年月日%s～%s 名前:%s)",
				list.size(), searchInfo.getBeginID(), searchInfo.getEndID(),
				searchInfo.getBeginDateStr(), searchInfo.getEndDateStr(), searchInfo.getName()));
		request.setAttribute("msg", manager.getMsg());
		request.setAttribute("list", list);
		//セッションパラメータの追加
		request.setAttribute("searchInfo", searchInfo);
		//ページ情報の追加
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE_VIEW);
	}//doSearch
}
