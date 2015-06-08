import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jinji.db.staff.staffManage;
import login.LoginInfo;

/**
 * ログイン処理
 * @author 1211089 鈴木翔
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String err_msg = "ユーザIDかパスワードが間違っています。";

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
		String disp = "/index.jsp";

		request.setAttribute("page_title", page_title);

		RequestDispatcher rd = request.getRequestDispatcher(disp);
		rd.forward(request, response);
	}

	/**
	 * POSTメソッド処理
	 * @author 1211089 鈴木翔
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title="ログインページ";
		String disp = "/index.jsp";

		String auth = request.getParameter("auth").toString();
		if ( auth != null && auth.equals("1")) {
			String staff_id = request.getParameter("staff_id").toString();
			String passwd = request.getParameter("passwd").toString();;
			// ログインユーザ検索
			staffManage staffMng = new staffManage();
			try {
				LoginInfo loginInfo = staffMng.authSelect(staff_id, passwd);

				// チェック
				if (loginInfo != null) {
					// ログイン成功。セッションにログイン情報を埋め込んでシステムホームへ
					HttpSession session = request.getSession(false);
					if (session == null) {
						// セッション開始されていなければセッションを開始
						session = request.getSession(true);
					}
					session.setAttribute("longin_info", loginInfo);

					disp ="/Sotsuron/Home";
					response.sendRedirect(disp);
					return;
				} else {
					// 該当なしログイン失敗
					request.setAttribute("page_title", page_title);
					request.setAttribute("err_msg", err_msg);

					RequestDispatcher rd = request.getRequestDispatcher(disp);
					rd.forward(request, response);
					return;
				}

			} catch (Exception e) {
				e.printStackTrace();

				// エラー。とりあえずログイン画面に戻す
				//TODO エラー画面を作る
				request.setAttribute("page_title", page_title);
				request.setAttribute("err_msg", err_msg);

				RequestDispatcher rd = request.getRequestDispatcher(disp);
				rd.forward(request, response);
			}
		} else {
			// ログインページからのリクエストではない（であろう）ログインページへ
			request.setAttribute("page_title", page_title);

			RequestDispatcher rd = request.getRequestDispatcher(disp);
			rd.forward(request, response);
		}
	}
}
