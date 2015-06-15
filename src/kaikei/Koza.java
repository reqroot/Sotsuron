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
		String page_title="会計システム - 取引先銀行口座一覧";
		String content_page = "/kaikei/koza/koza.jsp";
		String page = null;

		BankManage bm = new BankManage();
		BankInfo bankInfo = null;
		String bankId = null;
		String bankName = null;

		List<KozaInfo> list = null;
		KozaManage km = new KozaManage();
		String kozaNo = null;
		KozaInfo kozaInfo = null;

		boolean hasErr = false;

		if (request.getParameter("bank_id") != null) {
			bankId = request.getParameter("bank_id");
		}
		if (request.getParameter("koza_no") != null) {
			kozaNo = request.getParameter("koza_no");
		}

		if (request.getParameter("page") != null) {
			page = request.getParameter("page").toString();
		}
		if (page != null && page.equals("new_input")) {
			// 新規入力ページ
			page_title="会計システム - 取引先銀行口座新規入力";
			content_page = "/kaikei/koza/new_input.jsp";

			// 口座種別取得
			KozaShubetsuManage ksm = new KozaShubetsuManage();
			try {
				List<KozaShubetsuInfo> ksList = ksm.select();
				request.setAttribute("ks_list", ksList);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (page != null && page.equals("new")) {
			// 登録
		} else if(page != null && page.equals("detail")) {
			// 口座詳細ページ
			page_title="会計システム - 取引先銀行口座 - 詳細";
			content_page = "/kaikei/koza/detail.jsp";
			kozaInfo = new KozaInfo(bankId,"",kozaNo,"");
			try {
				kozaInfo = km.search(kozaInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("info", kozaInfo);
		}

		// 表示用データ取得
		try {
			// 銀行情報取得
			bankInfo = bm.search(bankId);

			// 銀行情報から講座情報を全取得
			list = km.select(bankInfo);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);
		request.setAttribute("bank_info", bankInfo);
		request.setAttribute("list", list);

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

}
