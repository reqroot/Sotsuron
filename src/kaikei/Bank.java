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
import sotsuron.SotsuronHttpServlet;

/**
 * Servlet implementation class Bank
 */
@WebServlet("/Kaikei/Bank")
public class Bank extends SotsuronHttpServlet {
	private static final long serialVersionUID = 1L;

	BankManage bm = null;
	private String content_page = null;
	String page_title = null;
	List<BankInfo> list = null;

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
		// セッション確認。ログイン済みでなければログイン画面へ
		if (this.isLoginDone(request, response) == null ) {
			return;
		}

		page_title = "会計システム - 取引先銀行一覧";
		content_page = "/kaikei/bank/bank.jsp";
		String page = null;
		bm = new BankManage();


		if (request.getParameter("page") != null) {
			page = request.getParameter("page").toString();
		}
		if (page != null && page.equals("update_input")) {
			// 更新内容入力
			update_input(request, response);
		} else if (page != null && page.equals("update")) {
			// 更新
			update(request, response);
		} else if (page != null && page.equals("new_input")) {
			// 新規入力ページ
			new_input(request, response);
		} else if (page != null && page.equals("new")) {
			// 新規登録
			new_regest(request, response);
		} else {
			// 表示用データ取得
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
		// 表示用データ取得
		try {
			list = bm.select();
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private void update_input(HttpServletRequest request, HttpServletResponse response) {
		String bankId = null;
		BankInfo info = null;

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
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		BankInfo info = null;
		String bankId = null;
		String bankName = null;
		boolean hasErr = false;

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
			update_input(request, response);
			return;
		}
		info = new BankInfo(bankId, bankName);

		// 更新
		try {
			bm.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}


		// 表示用データ取得
		show(request, response);
	}

	private void new_input(HttpServletRequest request, HttpServletResponse response) {
		page_title = "会計システム - 取引先銀行新規登録";
		content_page = "/kaikei/bank/new_input.jsp";
	}

	private void new_regest(HttpServletRequest request, HttpServletResponse response) {
		String bankId = null;
		String bankName = null;
		boolean hasErr = false;
		BankInfo info = null;

		// 銀行ID採番
		try {
			bankId = String.valueOf(bm.getNextId());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 登録情報作成
		if (request.getParameter("bank_name") != null) {
			bankName = request.getParameter("bank_name");
		} else {
			// 入力エラー インプットページへ
			hasErr = true;
		}
		if (hasErr == true) {
			// 入力エラーあり
			new_input(request, response);
			return;
		}
		info = new BankInfo(bankId, bankName);

		// 登録
		try {
			bm.insert(info);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 表示用データ取得
		show(request, response);
	}
}
