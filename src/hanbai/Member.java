package hanbai;

import hanbai.db.member.MemberDBManager;
import hanbai.db.member.MemberInfo;
import hanbai.db.member.MemberSearchInfo;
import hanbai.validator.MemberValidator;

import java.io.IOException;
import java.text.ParseException;
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
@WebServlet("/hanbai/MasterSystem/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "会員管理画面";
	private static final String PAGE_VIEW = "/hanbai/member_view.jsp";
	private static final String PAGE_DETAIL = "/hanbai/member_view_detail.jsp";
	private static final String PAGE_EDIT = "/hanbai/member_view_edit.jsp";
	private static final String PAGE_ADD = "/hanbai/member_add.jsp";

	private static final String S_SELECT = "select";
	private static final String S_ADD = "add";
	private static final String S_EDIT = "edit";
	private static final String S_DETAIL = "detail";
	private static final String S_CONFIRM = "confirm";
	private static final String S_COMMIT = "commit";
	private static final String S_DELETE = "delete";
	private static final String S_DELETE_CONFIRM = "deleteConfirm";
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
		/*//ジャンルの一覧を取得する
		request.setCharacterEncoding("UTF-8");

		//ページ情報の追加
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE_VIEW);
		//ディスパッチャーを取得
		RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
		rd.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		/*try{
			if(request.getParameter("searchBtn") != null){
				//検索ボタンが押された場合
				doSearch(request, response);
			}else if(request.getParameter("detailBtn") != null){
				//詳細ボタンが押された場合
				doDetail(request, response);
			}else if(request.getParameter("editBtn") != null){
				//編集ボタンが押された場合
				doEdit(request, response);
			}else if(request.getParameter("deleteConfirmBtn") != null){
				//削除確認ボタンが押された
				doDeleteConfirm(request, response);
			}else if(request.getParameter("deleteBtn") != null){
				//削除ボタンが押された
				doDeleteData(request, response);
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
		}*/

		try{
			//メニューボタン
			if(request.getParameter("search") != null){
				//検索ページに移動
				request.setAttribute("page_title", TITLE);
				request.setAttribute("content_page", PAGE_VIEW);
				request.setAttribute("state", S_SELECT);
			}else if(request.getParameter("add") != null){
				//新規ページに移動
				request.setAttribute("page_title", TITLE);
				request.setAttribute("content_page", PAGE_VIEW);
				request.setAttribute("state", S_ADD);
			}else if(request.getParameter("edit") != null){
				//編集ページに移動
				request.setAttribute("page_title", TITLE);
				request.setAttribute("content_page", PAGE_VIEW);
				request.setAttribute("state", S_EDIT);
			}else if(request.getParameter("delete") != null){
				//削除ページに移動
				request.setAttribute("page_title", TITLE);
				request.setAttribute("content_page", PAGE_VIEW);
				request.setAttribute("state", S_DELETE);
			}
			//その他ボタン
			//検索ボタン
			else if(request.getParameter("searchBtn") != null){
				doSearch(request, response);
			//詳細ボタン
			}else if(request.getParameter("detailBtn") != null){
				doDetail(request, response);
			//編集ボタン
			}else if(request.getParameter("editBtn") != null){
				doEdit(request, response);
			//編集確定ボタン
			}else if(request.getParameter("confirmBtn") != null){
				//確認ボタンが押された場合
				doConfirm(request, response);
			}
		}catch(Exception e){
			//エラー処理
			e.printStackTrace();
		}


		//ディスパッチャーを取得
		RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
		rd.forward(request, response);
	}

	private void doSearch(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberDBManager manager = new MemberDBManager();


		//パラメータの取得
		MemberSearchInfo searchInfo = makeSearchData(request.getParameter("beginID"),
													request.getParameter("endID"),
													request.getParameter("beginDate"),
													request.getParameter("endDate"),
													request.getParameter("name"));

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
		request.setAttribute("state", request.getParameter("state"));
	}//doSearch

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDBManager manager = new MemberDBManager();
		MemberValidator  validator = new MemberValidator();

		//パラメータの取得
		String id = request.getParameter("member_id");
		System.out.println("id:" + id);
		//SQL検索値の作成
		id = validator.convertID(id);
		System.out.println("id(convert):" + id);
		//データの取得
		MemberInfo info = manager.MemberSearchDetail(id);
		System.out.println("info:" + info);
		System.out.println("sexInt: " + info.getSexInt());
		request.setAttribute("item", info);
		//ページ情報の追加
		request.setAttribute("state", S_DETAIL);
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE_DETAIL);
	}

	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		doDetail(request, response);
		request.setAttribute("state", S_EDIT);
		request.setAttribute("content_page", PAGE_EDIT);
	}

	private void doDeleteConfirm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		doDetail(request, response);

		request.setAttribute("state", S_DELETE_CONFIRM);
		request.setAttribute("content_page", PAGE_DETAIL);
	}

	private void doDeleteData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("member_id");
		MemberInfo info = new MemberInfo();
		info.setMember_id(id);

		//データベースに登録
		MemberDBManager manager = new MemberDBManager();
		manager.MemberDelete(info);

		request.setAttribute("state", S_DELETE);
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE_DETAIL);
	}

	private void doConfirm(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberValidator  validator = new MemberValidator();
		MemberInfo info = validatorMemberInfo(validator, request);

		//データの検証
		//データに異常があれば編集画面に戻る
		if(validator.getErrs() > 0){
			//入力されたデータをそのまま返す
			//性別でエラーが起きていた場合はfalseを設定する
			if(validator.getErrMessage("sex") != null){
				info.setSex(false);
			}
			info.setName(request.getParameter("name"));
			info.setBirthday(request.getParameter("birthday"));
			info.setPrefecture(request.getParameter("prefecture"));
			info.setCity(request.getParameter("city"));
			info.setAddress(request.getParameter("address"));
			info.setTel(request.getParameter("tel"));
			info.setMail(request.getParameter("mail"));
			request.setAttribute("errs", validator.getErrMessages());
			request.setAttribute("content_page", PAGE_EDIT);
		}else{
			request.setAttribute("state", S_CONFIRM);
			request.setAttribute("page_title", TITLE);
			request.setAttribute("content_page", PAGE_DETAIL);
			request.setAttribute("msg", "情報を更新しました");
		}

		request.setAttribute("item", info);
	}

	private void doEditBack(HttpServletRequest request,HttpServletResponse response) {
		MemberValidator  validator = new MemberValidator();
		MemberInfo info = validatorMemberInfo(validator, request);

		request.setAttribute("item", info);
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE_EDIT);
	}

	private void doCommit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberValidator  validator = new MemberValidator();
		MemberInfo info = validatorMemberInfo(validator, request);

		//データベースに登録
		MemberDBManager manager = new MemberDBManager();
		if(!manager.MemberUpdate(info)){
			System.out.println("アップデート失敗");
		};

		request.setAttribute("item", info);
		request.setAttribute("state", S_COMMIT);
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE_DETAIL);
	}

	private void redirectView(HttpServletRequest request,HttpServletResponse response) {

	}

	//検索条件を作成する
	private MemberSearchInfo makeSearchData(String beginID, String endID, String beginDate, String endDate, String name) throws ParseException{
		MemberValidator  validator = new MemberValidator();
		MemberSearchInfo searchInfo = new MemberSearchInfo();
		//SQLの検索値の作成
		beginID = validator.convertID(beginID);
		endID = validator.convertID(endID);
		Date beginDated = validator.convertEntryDate(beginDate);
		Date endDated = validator.convertEntryDate(endDate);
		name = validator.convertName(name);


		//デフォルト値の設定
		if(beginID == null) beginID = "0000000";
		if(endID == null) endID = "9999999";
		if(beginDated == null) beginDated = new SimpleDateFormat("yyyy/MM/dd").parse("2000/01/01");
		if(endDated == null) endDated = new Date();

		//検索Infoの作成
		searchInfo.setBeginID(beginID);
		searchInfo.setEndID(endID);
		searchInfo.setBeginDate(beginDated);
		searchInfo.setEndDate(endDated);
		searchInfo.setName(name);

		return searchInfo;
	}

	private MemberInfo validatorMemberInfo(MemberValidator validator, HttpServletRequest request){

		MemberInfo info = new MemberInfo();
		//データの検証
		info.setMember_id(request.getParameter("member_id"));
		info.setName(validator.convertName(request.getParameter("name")));
		info.setBirthday(validator.convertBirthdayStr(request.getParameter("birthday")));
		info.setSex(validator.convertSex(request.getParameter("sex")));
		info.setPrefecture(validator.convertPrefecture(request.getParameter("prefecture")));
		info.setCity(validator.convertCity(request.getParameter("city")));
		info.setAddress(validator.convertAddress(request.getParameter("address")));
		info.setTel(validator.convertTel(request.getParameter("tel")));
		info.setMail(validator.convertMail(request.getParameter("mail")));
		info.setEntry_date(request.getParameter("entry_date"));

		return info;
	}
}
