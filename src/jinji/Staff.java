package jinji;

import java.io.IOException;
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
		registInfo rI = new registInfo();


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
					try {
						staff_id = sm.idSelect(); //社員番号連番取得
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 社員登録

		String page_title ="";
		String content_page="";

		//TODO Valid処理をかける（getParameterに）

		//staff_regist_view.jspからデータ取得
				String staff_id = (request.getParameter("staff_id"));
				String staff_name = (request.getParameter("staff_name"));
				String  department_id = (request.getParameter("department_id"));
				String education_id = (request.getParameter("education_id"));
				String position_id = (request.getParameter("position_id"));
				rI.setStaff_id(staff_id);
				rI.setStaff_name(staff_name);
				rI.setDepartment_id(department_id);
				rI.setEducation_id(education_id);
				rI.setPosition_id(position_id);

			//登録確認
			if( request.getParameter("add_conf") != null ){
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

		//登録確定
		if(request.getParameter("add") != null){


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



	}

}
