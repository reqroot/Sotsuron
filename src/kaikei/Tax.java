package kaikei;

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

import kaikei.db.TaxInfo;
import kaikei.db.TaxManage;

/**
 * Servlet implementation class Tax
 */
@WebServlet("/Kaikei/Tax")
public class Tax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TaxManage tm = null;
	String page_title = null;
	String content_page = null;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		page_title = "会計システム - 消費税率";
		content_page = "/kaikei/tax/tax.jsp";
		String page = null;
		tm = new TaxManage();

		if (request.getParameter("page") != null) {
			page = request.getParameter("page").toString();
		}
		if (page != null && page.equals("history")) {
			// 消費税履歴取得
			history(request, response);
		} else if (page != null && page.equals("new_input")) {
			// 新消費税率入力
			new_input(request, response);
		}  else if (page != null && page.equals("new")) {
			// 新消費税率追加
			new_regist(request, response);
		}else {
			// 最新表示
			show(request, response);
		}


		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);

		String disp = "/template/layout.jsp";
		RequestDispatcher dispatch = request.getRequestDispatcher(disp);
		dispatch.forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		TaxInfo info = null;
		// 表示用データ取得
		try {
			info = tm.searchCurrent();
			request.setAttribute("info", info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void history(HttpServletRequest request, HttpServletResponse response) {
		List<TaxInfo> list = null;
		try {
			page_title = "会計システム - 消費税率履歴";
			content_page = "/kaikei/tax/history.jsp";

			list = tm.select();

			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void new_input(HttpServletRequest request, HttpServletResponse response) {
		// 新税率入力画面
					content_page = "/kaikei/tax/new_input.jsp";
					page_title="会計システム - 消費税率更新";

					SimpleDateFormat sdf = new SimpleDateFormat();
					Date date = new Date();
					sdf.applyPattern("yyyy");
					request.setAttribute("year", sdf.format(date));
					sdf.applyPattern("MM");
					request.setAttribute("month", sdf.format(date));
					sdf.applyPattern("dd");
					request.setAttribute("day", sdf.format(date));
	}

	private void new_regist(HttpServletRequest request, HttpServletResponse response) {
		boolean hasErr = false;
		TaxInfo info = null;
		double tax = 0;
		String year = null;
		String month = null;
		String day = null;

		if (request.getParameter("tax") != null) {
			if (!request.getParameter("tax").isEmpty()) {
				try {
					tax = Double.parseDouble(request.getParameter("tax"));
				} catch (NumberFormatException e) {
					hasErr = true;
				}
			} else {
				hasErr = true;
			}
		} else {hasErr = true;}
		if (request.getParameter("year") != null) {
			year = request.getParameter("year");
		} else {hasErr = true;}
		if (request.getParameter("month") != null) {
			month = request.getParameter("month");
		} else {hasErr = true;}
		if (request.getParameter("day") != null) {
			day = request.getParameter("day");
		} else {hasErr = true;}

		if (hasErr) {
			new_input(request, response);
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(request.getParameter("year"));
		sb.append("/");
		sb.append(request.getParameter("month"));
		sb.append("/");
		sb.append(request.getParameter("day"));
		String dt = sb.toString();
		info = new TaxInfo(dt, tax);

		try {
			tm.insert(info);
		} catch (Exception e) {
			// TODO エラー処理
		}

		// 表示用データ取得
		show(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
