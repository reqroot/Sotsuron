package kaikei;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kaikei.db.CustomerInfo;
import kaikei.db.CustomerManage;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Kaikei/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerManage cm = null;
	private String content_page = null;
	String page_title = null;
	List<CustomerInfo> list = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		page_title = "会計システム - 取引先一覧";
		content_page = "/kaikei/customer/customer.jsp";
		cm = new CustomerManage();
		String page = null;

		if (request.getParameter("page") != null) {
			page = request.getParameter("page").toString();
		}

		if (page != null && page.equals("new_input")) {
			// 新規入力画面
			new_input(request, response);
		} else if (page != null && page.equals("new")){
			// 登録
			new_regist(request, response);
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
			list = cm.select();
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private void new_input(HttpServletRequest request, HttpServletResponse response) {
		page_title = "会計システム - 取引先新規登録";
		content_page = "/kaikei/customer/new_input.jsp";
	}

	private void new_regist(HttpServletRequest request, HttpServletResponse response) {
		String customerId = null;
		String customerName = null;
		int urikakeZangaku = 0;
		boolean hasErr = false;
		CustomerInfo info = null;
		String msg = null;
		int result = 0;

		try {
			customerId = String.valueOf(cm.getNextId());
		} catch (Exception e1) {
			// TODO エラー処理
		}
		if (request.getParameter("customer_name") != null) {
			customerName = request.getParameter("customer_name");
		}else {
			hasErr = true;
		}
		if (request.getParameter("urikake_zangaku") != null) {
			if (!request.getParameter("urikake_zangaku").isEmpty()) {
				try {
					urikakeZangaku = Integer.parseInt(request.getParameter("urikake_zangaku"));
				} catch (NumberFormatException e) {
					urikakeZangaku = 0;
				}
			} else {
				urikakeZangaku = 0;
			}
		} else {
			urikakeZangaku = 0;
		}

		if (hasErr) {
			new_input(request, response);
			return;
		}

		info = new CustomerInfo(customerId, customerName, urikakeZangaku);
		try {
			result = cm.insert(info);
			request.setAttribute("msg", cm.getMsg());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 表示用データ取得
		show(request, response);
	}
}
