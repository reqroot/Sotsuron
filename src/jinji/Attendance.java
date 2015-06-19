package jinji;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jinji.db.attendance.attendanceInfo;
import jinji.db.attendance.attendanceManage;

/**
 * Servlet implementation class Attendance
 */
@WebServlet("/Jinji/Attendance")
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title="";
		String content_page = "";
		String msg =""; //サクセスorエラーメッセージ
		String page = request.getParameter("page");
		attendanceInfo attendInfo = null;
		attendanceManage aM = new attendanceManage();
		ArrayList<String> js = new ArrayList<String>(); //JavaScript用List

		//時刻表示
		 page_title ="出退勤画面";
		 content_page ="/jinji/work_attendance_view.jsp";
		 js.add("../js/jquery-1.11.3.js"); //JQuery読み込み
		 js.add("../js/clock.js"); //時計のJavaScript読み込み

		 //出勤確認処理
		 if(request.getParameter("attend") != null){
			 page_title ="出勤確認画面";
			 content_page ="/jinji/work_attendance_confirm.jsp";
			 try {
				 attendInfo = aM.confattend();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }

		 //出勤確定処理
		 if(request.getParameter("add_in") != null){
			 try {
				aM.attendUpdate(0);
				msg ="出勤完了";
			} catch (Exception e) {
				msg ="すでに出勤済みです";
				e.printStackTrace();
			}
		 }

		//退勤確認処理
		 if(request.getParameter("clockout") != null){
			 page_title ="退勤確認画面";
			 content_page ="/jinji/work_attendance_confirm.jsp";
			 try {
				 attendInfo = aM.confattend();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }

		//退勤確定処理
		 if(request.getParameter("add_out") != null){
			 try {
				aM.attendUpdate(1);
				msg ="退勤完了";
			} catch (Exception e) {
				msg ="退勤失敗です";
				e.printStackTrace();
			}
		 }

		 //JSPにデータを送る準備
		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);
		request.setAttribute("js", js);
		request.setAttribute("attendInfo", attendInfo);
		request.setAttribute("msg", msg);

		//ディスパッチ処理
		RequestDispatcher dispatch = request.getRequestDispatcher("/template/layout.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
