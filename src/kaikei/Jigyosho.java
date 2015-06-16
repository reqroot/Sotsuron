package kaikei;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kaikei.db.JigyoshoInfo;
import kaikei.db.JigyoshoManage;

/**
 * Servlet implementation class Jigyosyo
 */
@WebServlet("/Kaikei/Jigyosho")
public class Jigyosho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String page_title = null;
	String content_page = null;
	JigyoshoManage jm = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jigyosho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		page_title ="会計システム - 事業所情報";
		content_page = "/kaikei/jigyosho/jigyosho.jsp";
		JigyoshoInfo info = null;
		String page = null;
		jm = new JigyoshoManage();

		if (request.getParameter("page") != null) {
			page = request.getParameter("page").toString();
		}
		if(page != null && page.equals("update_input")) {
			// 更新入力
			update_input(request, response);
		} else if (page != null && page.equals("update")) {
			// 登録
			update(request, response);
		}

		// 表示用データ取得
		try {
			info = jm.select();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);
		request.setAttribute("jigyosho_info", info);

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

	private void update_input(HttpServletRequest request, HttpServletResponse response) {
		// 更新ページ
		content_page = "/kaikei/jigyosho/update_input.jsp";
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		JigyoshoInfo info = new JigyoshoInfo();
		info.setJigyoshoName(request.getParameter("jigyosho_name"));
		info.setPostNo(request.getParameter("post_no"));
		info.setPrefecture(request.getParameter("prefecture"));
		info.setCity(request.getParameter("city"));
		info.setAddress(request.getParameter("address"));
		info.setTel(request.getParameter("tel"));
		info.setFax(request.getParameter("fax"));
		info.setCapital(request.getParameter("capital"));
		try {
			jm.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
