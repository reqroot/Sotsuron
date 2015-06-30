package jinji;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jinji.db.attendance.attendanceInfo;
import jinji.db.attendance.attendanceManage;

/**
 * Servlet implementation class Attendance
 */
@WebServlet("/Jinji/Attendance")
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
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
		int state =0;
		attendanceInfo aI = new attendanceInfo();
		attendanceManage am = new attendanceManage();
		ArrayList<String> js = new ArrayList<String>(); //JavaScript用List



		//JavaScriptによる時刻表示
		 page_title ="出退勤画面";
		 content_page ="/jinji/work_attendance_view.jsp";
		 js.add("../js/jquery-1.11.3.js"); //JQuery読み込み
		 js.add("../js/clock.js"); //時計表示用のJavaScript読み込み

		 //出勤確認処理
		 if(request.getParameter("attend") != null){
			 page_title ="出勤確認画面";
			 content_page ="/jinji/work_attendance_confirm.jsp";
			 try {
				 aI = am.confattend();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }

		 //出勤確定処理
		 if(request.getParameter("add_in") != null){
			 try {
				 state = 0;
				am.attendUpdate(aI,state);
				msg ="出勤済です";
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
				 aI = am.confattend();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }

		//退勤確定処理
		 if(request.getParameter("add_out") != null ){
			 try {
				 	state =1;
					 am.attendUpdate(aI,state);
					 msg ="退勤済です";
				 } catch (Exception e) {
				msg ="退勤失敗です";
				e.printStackTrace();
			}
		 }

		//出勤退勤処理後 打刻時間開示用
			try {
				aI = am.pconfattend();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		 //JSPにデータを送る準備
		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);
		request.setAttribute("js", js);
		request.setAttribute("aI", aI);
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
