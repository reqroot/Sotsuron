import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 統合システムのホームページです。
 * ログイン後に最初に表示されるページです。
 * @author 1211089 鈴木翔
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ
     */
    public Home() {
        super();
    }

	/**
	 * GETメソッド処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * ポストメソッド処理
	 * @author 1211089 鈴木翔
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String disp = "./home.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(disp);
		rd.forward(request, response);
	}

}
