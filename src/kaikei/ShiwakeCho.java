package kaikei;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kaikei.db.ShiwakeChoInfo;
import kaikei.db.ShiwakeChoManage;

/**
 * Servlet implementation class ShiwakeCho
 */
@WebServlet("/Kaikei/ShiwakeCho")
public class ShiwakeCho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ShiwakeChoManage sm  = null;
	List<ShiwakeChoInfo> list = null;
	ShiwakeChoInfo info = null;
	private String content_page = null;
	String page_title = null;

	Calendar cal = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShiwakeCho() {
        super();

        this.cal = Calendar.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		page_title = "会計システム - %s年度%s月 仕訳一覧";
		content_page = "/kaikei/shiwakecho/shiwakecho.jsp";
		String page = null;

		sm = new ShiwakeChoManage();

		show(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		String month = null;
		String nendo = null;

		nendo = request.getParameter("nendo");
		month = request.getParameter("month");

		if ((nendo == null || nendo.isEmpty()) || (month == null ||  month.isEmpty())) {
			Date dt = new Date();
			this.cal.setTime(dt);
			nendo = Integer.toString(this.getNendo(dt));
			month = Integer.toString(this.cal.get(Calendar.MONTH));
		}
		page_title = String.format(page_title, nendo, month);
		try {
			// 表示データ取得
			info = new ShiwakeChoInfo();
			info.setNendo(Integer.parseInt(nendo));
			info.setMonth(Integer.parseInt(month));
			request.setAttribute("list", sm.selectNendoMonth(info));

			// 検索用年度リスト取得
			request.setAttribute("nendo_list", sm.getNendoList());

			request.setAttribute("page_title", page_title);
			request.setAttribute("content_page", content_page);

			String disp = "/template/layout.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(disp);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void new_input(HttpServletRequest request, HttpServletResponse response) {

	}

	public void new_regist(HttpServletRequest request, HttpServletResponse response) {

	}

	public void update_input(HttpServletRequest request, HttpServletResponse response) {

	}

	public void update_regist(HttpServletRequest request, HttpServletResponse response) {

	}

	private int getNendo(Date dt) {

		if (cal.get(Calendar.MONTH) < 4) {
			// 前年度を取得
			return cal.get(Calendar.YEAR) - 1;
		}
		// 今年度を取得
		return cal.get(Calendar.YEAR) ;
	}
}
