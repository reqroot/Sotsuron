package jinji;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jinji.db.admin.departmentInfo;
import jinji.db.admin.departmentManage;
import jinji.db.admin.educationInfo;
import jinji.db.admin.educationManage;
import jinji.db.admin.positionInfo;
import jinji.db.admin.positionManage;
import jinji.db.staff.registInfo;
import jinji.db.staff.staffInfo;
import jinji.db.staff.staffManage;

/**
 * Servlet implementation class Staff
 */
@WebServlet("/Jinji/Staff")
public class Staff extends HttpServlet {
	private static final long serialVersionUID = 1L;

		List<staffInfo> list = null; //スタッフ一覧取得用リスト
		List<staffInfo> plist = null; //スタッフ個別取得
		List<departmentInfo> depList = null; //部署一覧取得
		List<educationInfo> eduList = null; //学歴一覧取得
		List<positionInfo> posList = null; //役職一覧取得
		List<registInfo> regList = null;//登録用リスト


		staffInfo sI = new staffInfo(); //スタッフid取得用

	//DB操作Manager一覧
		staffManage sm = new staffManage();
		departmentManage dm = new departmentManage();
		educationManage em = new educationManage();
		positionManage pm = new positionManage();




    /**
     * @see HttpServlet#HttpServlet()
     */
    public Staff() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title="人事システム - 社員一覧";
		String content_page = "/jinji/staff_list.jsp";
		String page = request.getParameter("page");

		try {
			 list = sm.staffSelect(); //スタッフ一覧取得
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//staffList.jspからのstaff_idのデータ取得
				String staff_id = (request.getParameter("staff_id"));
				sI.setStaff_id(staff_id);

		//page遷移 個人ページ
				if(page != null && page.equals("psearch")){
					try {
						plist = sm.pstaffSelect(sI);
					} catch (Exception e) {
						e.printStackTrace();
					}
					page_title = "人事システム - 個別ページ ";
					content_page = "/jinji/staff_personal.jsp";
				}

		//page遷移 社員登録ページ
				if(page != null && page.equals("regist")){
					Calendar nowDate =Calendar.getInstance();
					int year = nowDate.get(Calendar.YEAR);

					try {
						//table状況に応じたStaff_id取得の分岐
						if(sm.idSelect().equals("0") ){
							staff_id = String.valueOf(year)+"001";

						}//if（新規登録時）

						if(staff_id == null){
						if(Integer.valueOf(sm.idSelect().substring(0, 4)).intValue() != year){
							staff_id = String.valueOf(year)+"001";
						}//年が変わっている場合
						else {
						staff_id = sm.idSelect(); //社員番号連番取得
						} //else（継続）

						}

						depList = dm.departmentSelect(); //部署一覧取得
						eduList = em.educationSelect(); //学歴取得
						posList = pm.positionSelect();//役職取得

					} catch (Exception e) {
						e.printStackTrace();
					}
					page_title = "人事システム - 社員登録";
					content_page ="/jinji/staff_regist_view.jsp";
					request.setAttribute("depList", depList);
					request.setAttribute("eduList", eduList);
					request.setAttribute("posList", posList);
					request.setAttribute("staff_id", staff_id); //連番社員ID
				}

		//JSPへデータの送る準備
		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);
		request.setAttribute("list", list);
		request.setAttribute("plist", plist);

		//ディスパッチ処理
		RequestDispatcher dispatch = request.getRequestDispatcher("/template/layout.jsp");
		dispatch.forward(request, response);

		//再読み込み時ドロップダウンの項目重複を避けるため
		depList.clear();
		posList.clear();
		eduList.clear();
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 社員登録

		String page_title ="";
		String content_page="";
		int state;
		registInfo rI = new registInfo();

		//登録確認
		if( request.getParameter("addConf") != null ){
		page_title ="人事システム - 登録確認画面";
		content_page="/jinji/staff_regist_confirm.jsp";
			try {
				depList =  dm.depnameSelect(rI);
				eduList = em.edunameSelect(rI);
				posList = pm.posnameSelect(rI);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//TODO Valid処理をかける（getParameterに）

		//staff_regist_view.jspから社員登録データ取得
				String staff_id = request.getParameter("staff_id");
				String staff_name = request.getParameter("staff_name");
				String  department_id = request.getParameter("department_id");
				String education_id = request.getParameter("education_id");
				String position_id = request.getParameter("position_id");
				String birthday =request.getParameter("birthday");
				String enter_day = request.getParameter("enter_day");
				String base_salary = request.getParameter("base_salary");
				String passwd = request.getParameter("passwd");

				rI.setStaff_id(staff_id);
				rI.setStaff_name(staff_name);
				rI.setDepartment_id(department_id);
				rI.setEducation_id(education_id);
				rI.setPosition_id(position_id);
				rI.setBirthday(birthday);
				rI.setEnter_day(enter_day);
				rI.setBase_salary(base_salary);
				rI.setPasswd(passwd);

		//登録確定
		if(request.getParameter("add") != null){
			state = 0;
			try {
				sm.updateStaff(rI, state);
			} catch (Exception e) {
				e.printStackTrace();
			}
			content_page = "/Sotsuron/Jinji/Staff";
			response.sendRedirect(content_page);
			return;
		}

		//社員削除確認
		if(request.getParameter("delConf") != null){
			String[] staffidList = request.getParameterValues("staffidList");
			if(staffidList != null){
				try {
					plist = sm.deleteViewSelect(staffidList);
					request.setAttribute("plist", plist);
					content_page ="/jinji/staff_delete_confirm.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		//社員削除確定
		if(request.getParameter("delete") != null) {
			String[] staffidList = request.getParameterValues("staffidList");
			state=1;
			for(int i = 0;i < staffidList.length;i++){
				staff_id = staffidList[i];
				rI.setStaff_id(staff_id);
				try {
					sm.updateStaff(rI, state);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			content_page = "/Sotsuron/Jinji/Staff";
			response.sendRedirect(content_page);
			return;
		}


		//JSP送信データ準備
			request.setAttribute("page_title", page_title);
			request.setAttribute("content_page", content_page);
			request.setAttribute("registInfo", rI);
			request.setAttribute("depList", depList);
			request.setAttribute("posList", posList);
			request.setAttribute("eduList", eduList);

		//ディスパッチ処理
				RequestDispatcher dispatch = request.getRequestDispatcher("/template/layout.jsp");
				dispatch.forward(request, response);

		//再読み込み時ドロップダウンの項目重複を避けるため
				depList.clear();
				posList.clear();
				eduList.clear();
		//削除重複を避ける
				plist.clear();



	}

}
