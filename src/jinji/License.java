package jinji;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jinji.db.license.licenseInfo;
import jinji.db.license.licenseManage;
import jinji.db.staff.staffInfo;
import jinji.db.staff.staffManage;

/**
 * Servlet implementation class License
 */
@WebServlet("/Jinji/Staff/License")
public class License extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public License() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title="";
		String content_page = "";
		String page = request.getParameter("page");
		staffManage sm = new staffManage();
		licenseManage sl = new licenseManage();
		List<staffInfo> plist = null; //スタッフ個別取得
		List<licenseInfo> lList = null;
		List<licenseInfo> sList = null;

		//staffList.jspからのstaff_idのデータ取得
		String staff_id = (request.getParameter("staff_id"));
		staffInfo sI = new staffInfo(); //スタッフid取得一件用
		sI.setStaff_id(staff_id);

//license_add_viewからの資格IDの取得
		String license_id = (request.getParameter("license_id"));
		licenseInfo lI = new licenseInfo();
		lI.setLicense_id(license_id);

		//page遷移 個人資格情報追加
		if(page != null && page.equals("addlicense")){
			try {
				sList = sl.stafflicenseSelect(sI);
				plist = sm.pstaffSelect(sI);
				lList = sl.selectLicense();
			} catch (Exception e) {
				e.printStackTrace();
			}
			page_title = "人事システム - 保有資格追加ページ";
			content_page ="/jinji/license_add_view.jsp";
		}
		//add(license)ボタン
		if(request.getParameter("add") != null){
			try {
				sl.licenseUpdate(sI, lI, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//delete(license)ボタン
		if(request.getParameter("delete")!=null){
			try {
				sl.licenseUpdate(sI, lI, 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

			request.setAttribute("page_title", page_title);
			request.setAttribute("content_page", content_page);
			request.setAttribute("plist", plist);
			request.setAttribute("lList", lList);
			request.setAttribute("sList", sList);

		//ディスパッチ処理
				RequestDispatcher dispatch = request.getRequestDispatcher("/template/layout.jsp");
				dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
