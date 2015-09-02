package hanbai;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MasterSystem
 */
@WebServlet("/hanbai/MasterSystem")
public class MasterSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "マスタ管理画面";
	private static final String PAGE = "/hanbai/MasterSystem.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterSystem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ページ情報の追加
		request.setAttribute("page_title", TITLE);
		request.setAttribute("content_page", PAGE);
		//ディスパッチャーを取得
		RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	}

}
