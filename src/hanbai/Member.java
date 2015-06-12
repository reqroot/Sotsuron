package hanbai;

import hanbai.db.member.MemberDBManager;
import hanbai.db.member.MemberInfo;
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
		String beginID;
		String endID;
		Date beginDate;
		Date endDate;
		String name;

		//SQLの検索値の作成
		//会員番号
		beginID = validator.convertID(request.getParameter("beginID"), "0000000");
		endID = validator.convertID(request.getParameter("endID"), "9999999");
		//入れ替え
		if(validator.maxID(beginID, endID).equals(beginID)){
			String t = beginID;
			beginID = endID;
			endID = t;
		}

		//登録年月日
		beginDate = validator.convertDate(request.getParameter("beginDate"), new SimpleDateFormat("yyyy/MM/dd").parse("2000/01/01"));
		endDate = validator.convertDate(request.getParameter("endDate"), new Date());
		//入れ替え
		if(validator.maxDate(beginDate, endDate) == beginDate){
			Date t = beginDate;
			beginDate = endDate;
			endDate = t;
		}

		//名前
		name = validator.convertName(request.getParameter("name"), null);
		if(name == null){
			name = "%";
		}else{
			name = "%" + name + "%";
		}

		String beginDateStr = new SimpleDateFormat("yyyy/MM/dd").format(beginDate);
		String endDateStr = new SimpleDateFormat("yyyy/MM/dd").format(endDate);
		List<MemberInfo> list = manager.MemberSearch(beginID, endID,beginDateStr, endDateStr, name);

		//JSPにデータを送る
		//実際の検索値をメッセージとして設定する
		manager.setMsg(String.format("検索数[%s] (会員ID:%s～%s 登録年月日%s～%s 名前:%s)", list.size(), beginID, endID, beginDateStr, endDateStr, name.replace("%", "")));
		request.setAttribute("msg", manager.getMsg());
		request.setAttribute("list", list);
		request.setAttribute("beginID", beginID);
		request.setAttribute("endID", endID);
		request.setAttribute("beginDate", beginDateStr);
		request.setAttribute("endDate", endDateStr);
		request.setAttribute("name",name.replace("%", ""));
		//ページ情報の追加
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE_VIEW);


	}



}
