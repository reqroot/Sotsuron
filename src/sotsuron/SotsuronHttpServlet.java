package sotsuron;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginInfo;


public class SotsuronHttpServlet extends HttpServlet {
	protected LoginInfo isLoginDone(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		LoginInfo loginInfo =  (LoginInfo) session.getAttribute("login_info");
		if (loginInfo == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Login");
			try {
				rd.forward(request, response);
				return null;
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("login_info", loginInfo);
		return loginInfo;
	}
}
