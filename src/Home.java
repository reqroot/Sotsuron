import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sotsuron.SotsuronHttpServlet;

/**
 * 統合システムのホームページです。
 * ログイン後に最初に表示されるページです。
 * @author 1211089 鈴木翔
 */
@WebServlet("/Home")
public class Home extends SotsuronHttpServlet {
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
		String page_title="統合システム - ホームページ";
		String content_page = "/home.jsp";

		// セッション確認。ログイン済みでなければログイン画面へ
		if (this.isLoginDone(request, response) == null ) {
			return;
		}

		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);

		String disp = "/template/layout.jsp";
		 RequestDispatcher dispatch = request.getRequestDispatcher(disp);
		 dispatch.forward(request, response);
	}

	/**
	 * ポストメソッド処理
	 * @author 1211089 鈴木翔
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
