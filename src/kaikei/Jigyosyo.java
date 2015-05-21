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
@WebServlet("/Kaikei/Jigyosyo")
public class Jigyosyo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jigyosyo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title="会計システム - 事業所情報";
		String content_page = "/kaikei/jigyosho.jsp";
		JigyoshoInfo info = null;

		// デフォルト動作
		JigyoshoManage jm = new JigyoshoManage();
		try {
			info = jm.jigyoshoSelect();
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

}
