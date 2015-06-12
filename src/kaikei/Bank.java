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

/**
 * Servlet implementation class Bank
 */
@WebServlet("/Kaikei/Bank")
public class Bank extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title="会計システム - 取引先銀行一覧";
		String content_page = "/kaikei/bank/bank.jsp";
		List<BankInfo> list = null;
		String page = null;
		BankManage bm = new BankManage();
		BankInfo info = null;
		String bankId = null;
		String bankName = null;
		boolean hasErr = false;

		if (request.getParameter("page") != null) {
			page = request.getParameter("page").toString();
		}
		if (page != null && page.equals("update_input")) {
			// 更新入力ページ
			if (request.getParameter("bank_id") != null) {
				bankId = request.getParameter("bank_id");
			}

			// 選択された銀行情報選択
			try {
				info = bm.search(bankId);
			} catch (Exception e) {
				// エラー処理を追加
				e.printStackTrace();
			}
			page_title = "会計システム - 取引先銀行変更";
			content_page = "/kaikei/bank/update_input.jsp";
			request.setAttribute("info", info);
		} else if (page != null && page.equals("update")) {
			// 更新
			if (request.getParameter("bank_id") != null) {
				bankId = request.getParameter("bank_id");
			}
			if (request.getParameter("bank_name") != null) {
				bankName = request.getParameter("bank_name");
			} else {
				// 入力エラー インプットページへ
				hasErr = true;
			}
			if (hasErr == true) {
				// 入力エラーあり
				page_title = "会計システム - 取引先銀行変更";
				content_page = "/kaikei/bank/update_input.jsp";

				request.setAttribute("msg", bm.getMsg());
				request.setAttribute("page_title", page_title);
				request.setAttribute("content_page", content_page);

				String disp = "/template/layout.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(disp);
				dispatch.forward(request, response);
				return;
			}
			info = new BankInfo(bankId, bankName);

			// 更新
			try {
				bm.update(info);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (page != null && page.equals("new_input")) {
			// 新規入力ページ
			page_title = "会計システム - 取引先銀行新規登録";
			content_page = "/kaikei/bank/new_input.jsp";
		} else if (page != null && page.equals("new")) {
			// 新規登録
			try {
				// 銀行ID採番
				bankId = String.valueOf(bm.getNextId());

				// 登録情報作成
				if (request.getParameter("bank_name") != null) {
					bankName = request.getParameter("bank_name");
				} else {
					// 入力エラー インプットページへ
					hasErr = true;
				}
				if (hasErr == true) {
					// 入力エラーあり
					page_title = "会計システム - 取引先銀行新規登録";
					content_page = "/kaikei/bank/new_input.jsp";

					request.setAttribute("msg", bm.getMsg());
					request.setAttribute("page_title", page_title);
					request.setAttribute("content_page", content_page);

					String disp = "/template/layout.jsp";
					RequestDispatcher dispatch = request.getRequestDispatcher(disp);
					dispatch.forward(request, response);
					return;
				}
				info = new BankInfo(bankId, bankName);

				// 登録
				bm.insert(info);
			} catch (Exception e) {
				// TODO エラー処理を追加
				e.printStackTrace();
			}
		}

		// 表示用データ取得
		try {
			list = bm.select();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);
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
