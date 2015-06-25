package jinji;

import java.io.IOException;

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
		String license_name =""; //資格名取得用
		String msg ="";
		staffManage sm = new staffManage();
		licenseManage lm = new licenseManage();

		//staffList.jspからのstaff_idのデータ取得
		String staff_id = (request.getParameter("staff_id"));
		String staff_name =(request.getParameter("staff_name"));
		staffInfo sI = new staffInfo(); //スタッフid取得一件用
		sI.setStaff_name(staff_name);
		sI.setStaff_id(staff_id);

		//license_add_viewからの資格IDの取得
		String license_id = (request.getParameter("license_id"));
		licenseInfo lI = new licenseInfo();
		lI.setLicense_id(license_id);

		//page遷移 個人資格情報追加画面
				if(page != null && page.equals("addlicense")){
					page_title = "人事システム - 保有資格追加・削除ページ";
					content_page ="/jinji/license_update_view.jsp";
				}

		//資格インサート確認用
			if(request.getParameter("add_conf") != null){
				try {
					license_name = lm.conflicenseSelect(lI);
				} catch (Exception e) {
					e.printStackTrace();
				}
				page_title = "人事システム - 資格追加確認ページ";
				content_page ="/jinji/license_update_confirm.jsp";
			}

			//資格デリート確認用
			if(request.getParameter("delete_conf") != null){
				try {
					license_name = lm.conflicenseSelect(lI);
				} catch (Exception e) {
					e.printStackTrace();
				}
				page_title = "人事システム - 資格削除確認ページ";
				content_page ="/jinji/license_update_confirm.jsp";
			}

		//資格追加確定
		if(request.getParameter("add") != null){
			page_title = "人事システム - 保有資格追加・削除ページ";
			content_page = "/jinji/license_update_view.jsp";
			try {
				lm.licenseUpdate(sI, lI, 0);
				msg = "追加に成功しました";
			} catch (Exception e) {
				e.printStackTrace();
				msg ="追加に失敗しました";
			}
		}

		//資格削除確定
		if(request.getParameter("delete")!=null){
			try {
				lm.licenseUpdate(sI, lI, 1);
				msg ="削除に成功しました";
			} catch (Exception e) {
				e.printStackTrace();
				msg = "削除に失敗しました";
			}
			page_title = "人事システム - 保有資格追加・削除ページ";
			content_page = "/jinji/license_update_view.jsp";
		}
			//JSPへ送るデータの準備
			request.setAttribute("page_title", page_title);
			request.setAttribute("content_page", content_page);
			request.setAttribute("license_name",license_name);
			request.setAttribute("license_id",license_id);
			request.setAttribute("staff_id",staff_id);
			request.setAttribute("staff_name",staff_name);
			request.setAttribute("msg",msg);

			try {
				request.setAttribute("plist", sm.pstaffSelect(sI));
				request.setAttribute("lList", lm.selectLicense());
				request.setAttribute("sList", lm.stafflicenseSelect(sI));
			} catch (Exception e) {
				e.printStackTrace();
			}

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
