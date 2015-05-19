import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ログイン処理
 * @author 1211089 鈴木翔
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ
     */
    public Login() {
        super();
    }

	/**
	 * GETメソッド処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title="ログインページ";
		String content_page = "/index.jsp";
		String disp = "/template/layout.jsp";

		// 今はザル
		if (request.getAttribute("auth") != null && request.getAttribute("auth").toString().equals("1")) {
			disp ="/Home";
		}

		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);


		RequestDispatcher rd = request.getRequestDispatcher(disp);
		rd.forward(request, response);
	}

	/**
	 * POSTメソッド処理
	 * @author 1211089 鈴木翔
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
