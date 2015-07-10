package kaikei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kaikei.db.KamokuKbnDInfo;
import kaikei.db.KamokuKbnDManage;
import kaikei.db.KamokuKbnSInfo;
import kaikei.db.KamokuKbnSManage;
import kaikei.db.KanjoKamokuInfo;
import kaikei.db.KanjoKamokuManage;
import kaikei.db.ShiwakeChoInfo;
import kaikei.db.ShiwakeChoManage;

/**
 * Servlet implementation class ShiwakeCho
 */
@WebServlet("/Kaikei/ShiwakeCho")
public class ShiwakeCho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShiwakeChoManage sm  = null;
	private KamokuKbnDManage kdm = null;
	private KamokuKbnSManage ksm = null;
	private KanjoKamokuManage kkm = null;
	private List<ShiwakeChoInfo> list = null;
	private ShiwakeChoInfo info = null;
	private String content_page = null;
	private String page_title = null;

	private Calendar cal = null;
	private List<Integer> daysLong = new ArrayList<Integer>();
	private List<Integer> daysShort = new ArrayList<Integer>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShiwakeCho() {
        super();

        this.cal = Calendar.getInstance();
        int i = 1;
        for (; i <=30; i++) {
        	daysLong.add(i);
        	daysShort.add(i);
        }
        daysLong.add(i);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		page_title = "会計システム - 仕訳帳";
		content_page = "/kaikei/shiwakecho/shiwakecho.jsp";
		String page = null;

		sm = new ShiwakeChoManage();
		kdm = new KamokuKbnDManage();
		ksm = new KamokuKbnSManage();
		kkm = new KanjoKamokuManage();

		if (request.getParameter("page") != null) {
			page = request.getParameter("page").toString();
		}

		if (page != null && page.equals("new_input")) {
			new_input(request, response);
		} else {
			show(request, response);
		}

		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);

		String disp = "/template/layout.jsp";
		RequestDispatcher dispatch = request.getRequestDispatcher(disp);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		page_title = "会計システム - 仕訳帳";
		content_page = "/kaikei/shiwakecho/shiwakecho.jsp";
		String page = null;

		sm = new ShiwakeChoManage();
		new_regist(request, response);

	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		String month = null;
		String nendo = null;

		nendo = request.getParameter("nendo");
		month = request.getParameter("month");

		if ((nendo == null || nendo.isEmpty()) || (month == null ||  month.isEmpty())) {
			Date dt = new Date();
			this.cal.setTime(dt);
			nendo = Integer.toString(this.getNendo(dt));
			month = Integer.toString(this.cal.get(Calendar.MONTH));
		}
		request.setAttribute("nendo", nendo);
		request.setAttribute("month", month);

		try {
			// 表示データ取得
			info = new ShiwakeChoInfo();
			info.setNendo(Integer.parseInt(nendo));
			info.setMonth(Integer.parseInt(month));
			request.setAttribute("list", sm.selectNendoMonth(info));

			// 検索用年度リスト取得
			request.setAttribute("nendo_list", sm.getNendoList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void new_input(HttpServletRequest request, HttpServletResponse response) {
		String month = null;
		String nendo = null;
		List<Integer> days = null;
		int row = 0;
		boolean hasErr = false;
		Pattern p = Pattern.compile("2|4|6|9|12");
		Matcher m = null;

		this.page_title = "会計システム - 仕訳帳新規登録";
		this.content_page = "/kaikei/shiwakecho/new_input.jsp";

		nendo = request.getParameter("nendo");
		month = request.getParameter("month");

		if ((nendo == null || nendo.isEmpty()) || (month == null ||  month.isEmpty())) {
			hasErr = true;
		}
		if (hasErr) {
			request.setAttribute("msg", "年度または月が選択されていません。");
			show(request, response);
			return;
		}
		request.setAttribute("nendo", nendo);
		request.setAttribute("month", month);

		m = p.matcher(month);
		if (m.find()) {
			// 2,4,6,9,12月
			request.setAttribute("days", daysShort);
		} else {
			request.setAttribute("days", daysLong);
		}
		List<String> kamokuList = this.getKamokuList();
		request.setAttribute("kamoku_list", kamokuList);
	}

	public void new_regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("shiwake_regist") == null) {
				response.sendRedirect("/Sotsuron/Kaikei/ShiwakeCho");
		}

		String[] k = request.getParameter("kamoku").split("_");
		String kamoku_kbn = k[0];
		String kamokuId = k[1];
		String kashi = request.getParameter("kashikata");
		int kashkata = 0;
		if (kashi != null && !kashi.isEmpty()) {
			kashkata = Integer.parseInt(kashi);
		}
		String kari = request.getParameter("karikata");
		int karikata = 0;
		if(kari != null && !kari.isEmpty()) {
			karikata = Integer.parseInt(kari);
		}
		this.info = new ShiwakeChoInfo(Integer.parseInt(request.getParameter("nendo")),
														Integer.parseInt(request.getParameter("month")),
														Integer.parseInt(request.getParameter("day")),
														0,
														kamoku_kbn,
														kamokuId,
														"",
														request.getParameter("kamoku_hojo_kbn"),
														request.getParameter("kamoku_hojo"),
														kashkata,
														karikata);
		try {
			this.info.setRow(sm.getNextRow(this.info));

			sm.insert(this.info);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/Sotsuron/Kaikei/ShiwakeCho");
	}

	public void update_input(HttpServletRequest request, HttpServletResponse response) {

	}

	public void update_regist(HttpServletRequest request, HttpServletResponse response) {

	}

	private int getNendo(Date dt) {

		if (cal.get(Calendar.MONTH) < 4) {
			// 前年度を取得
			return cal.get(Calendar.YEAR) - 1;
		}
		// 今年度を取得
		return cal.get(Calendar.YEAR) ;
	}

	private List<String> getKamokuList() {
		List<String> list = new ArrayList<String>();
		List<KamokuKbnDInfo> kdiList = null;
		List<KamokuKbnSInfo> ksiList = null;
		List<KanjoKamokuInfo> kkiList = null;
		try {
			kdiList = kdm.select();
			ksiList = ksm.select();
			kkiList = kkm.select();
		} catch (Exception e) {
			return list;
		}
		for (KamokuKbnDInfo kdi: kdiList){
			  list.add(String.format("<option value=\"D_%s\">%s</option>", kdi.getKamokuKbnDId(), kdi.getKamokuKbnDName()));
			  for (KamokuKbnSInfo ksi : ksiList) {
				  if (ksi.getKamokuKbnDId().equals(kdi.getKamokuKbnDId())) {
					  list.add(String.format("<option value=\"S_%s\">　　%s</option>",
							  ksi.getKamokuKbnSId(),
							  ksi.getKamokuKbnSName()));
					  for (KanjoKamokuInfo kki : kkiList) {
						  if (kki.getKamokuKbnDId().equals(kdi.getKamokuKbnDId()) && kki.getKamokuKbnSId().equals(ksi.getKamokuKbnSId())) {
							  list.add(String.format("<option value=\"K_%s\">　　　　%s</option>",
									  kki.getKamokuId(),
									  kki.getKamokuName()));
						  }
					  }
				  }
			  }
		}
		return list;
	}
}
