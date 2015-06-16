package kaikei;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kaikei.db.BankInfo;
import kaikei.db.BankManage;
import kaikei.db.KozaInfo;
import kaikei.db.KozaManage;
import kaikei.db.KozaShubetsuInfo;
import kaikei.db.KozaShubetsuManage;

/**
 * Servlet implementation class Koza
 */
@WebServlet("/Kaikei/Koza")
public class Koza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String page_title = null;
	String content_page = null;
	BankManage bm = null;
	KozaManage km = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Koza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		page_title ="会計システム - 取引先銀行口座一覧";
		content_page = "/kaikei/koza/koza.jsp";
		String page = null;

		bm = new BankManage();

		km = new KozaManage();





		if (request.getParameter("page") != null) {
			page = request.getParameter("page").toString();
		}
		if (page != null && page.equals("new_input")) {
			// 新規入力ページ
			new_input(request, response);
		} else if (page != null && page.equals("new")) {
			// 新規登録
			new_regist(request, response);
		} else if(page != null && page.equals("detail")) {
			// 詳細ページ
			detail(request, response);
		} else {
			show(request, response);
		}

		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);


		String disp = "/template/layout.jsp";
		RequestDispatcher dispatch = request.getRequestDispatcher(disp);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		BankInfo bankInfo = null;
		List<KozaInfo> list = null;
		String bankId = null;

		// 表示用データ取得
		try {
			if (request.getParameter("bank_id") != null) {
				bankId = request.getParameter("bank_id");
			} else { bankId = "";}

			// 銀行情報取得
			bankInfo = bm.search(bankId);

			// 銀行情報から講座情報を全取得
			list = km.select(bankInfo);

			request.setAttribute("list", list);
			request.setAttribute("bank_info", bankInfo);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private void new_input(HttpServletRequest request, HttpServletResponse response) {
		page_title="会計システム - 取引先銀行口座新規入力";
		content_page = "/kaikei/koza/new_input.jsp";
		String bankId = null;
		BankInfo bankInfo = null;

		if (request.getParameter("bank_id") != null) {
			bankId = request.getParameter("bank_id");
		} else { bankId = "";}
		try {
			bankInfo = bm.search(bankId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 口座種別取得
		KozaShubetsuManage ksm = new KozaShubetsuManage();
		try {
			List<KozaShubetsuInfo> ksList = ksm.select();
			request.setAttribute("ks_list", ksList);
			request.setAttribute("bank_info", bankInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void new_regist(HttpServletRequest request, HttpServletResponse response) {
		KozaInfo kozaInfo = null;
		String bankId = null;
		String kozaShubetsu = null;
		String kozaNo = null;
		int zangaku = 0;
		boolean hasErr = false;
		int result = 0;

		if (request.getParameter("bank_id") != null) {
			bankId = request.getParameter("bank_id");
		} else {
			hasErr = true;
		}
		if (request.getParameter("koza_shubetsu") != null) {
			kozaShubetsu = request.getParameter("koza_shubetsu");
		} else {
			hasErr = true;
		}
		if (request.getParameter("koza_no") != null) {
			kozaNo = request.getParameter("koza_no");
		} else {
			hasErr = true;
		}
		if (request.getParameter("yokingaku") != null) {
			zangaku = Integer.parseInt(request.getParameter("yokingaku"));
		} else {
			hasErr = true;
		}

		if (hasErr) {
			new_input(request, response);
		}

		// 登録
		kozaInfo = new KozaInfo(bankId, kozaShubetsu, kozaNo, zangaku);
		try {
			result = km.insert(kozaInfo);
			if (result <= 0) {
				request.setAttribute("msg", km.getMsg());
			} else {
				request.setAttribute("msg", "口座情報を登録しました");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		show(request, response);
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) {
		// 口座詳細ページ
		page_title="会計システム - 取引先銀行口座 - 詳細";
		content_page = "/kaikei/koza/detail.jsp";
		String bankId = null;
		String kozaNo = null;

		KozaInfo kozaInfo = null;
		BankInfo bankInfo = null;

		if (request.getParameter("bank_id") != null) {
			bankId = request.getParameter("bank_id");
		}
		if (request.getParameter("koza_no") != null) {
			kozaNo = request.getParameter("koza_no");
		}

		kozaInfo = new KozaInfo(bankId,"",kozaNo,0);
		try {
			kozaInfo = km.search(kozaInfo);
			bankInfo = bm.search(bankId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("info", kozaInfo);
		request.setAttribute("bank_info", bankInfo);
	}
}
