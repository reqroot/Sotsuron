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
 * Servlet implementation class Staff
 */
@WebServlet("/Jinji/Staff")
public class Staff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<staffInfo> list = null; //スタッフ一覧取得用リスト
	List<staffInfo> plist = null; //スタッフ個別取得
	List<licenseInfo> lList = null;

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
		String content_page = "/jinji/staffList.jsp";
		String page = request.getParameter("page");
		staffManage sm = new staffManage();
		licenseManage sl = new licenseManage();

		try {
			 list = sm.staffSelect(); //スタッフ一覧取得
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//staffListからのstaff_idのデータ取得
				String staff_id = (request.getParameter("staff_id"));
				staffInfo sI = new staffInfo(); //スタッフid取得一件用
				sI.setStaff_id(staff_id);

		//page遷移 個人ページ
				if(page != null && page.equals("psearch")){
					try {
						plist = sm.pstaffSelect(sI);
					} catch (Exception e) {
						e.printStackTrace();
					}
					page_title = "人事システム - 個別ページ ";
					content_page = "/jinji/staffPersonal.jsp";
				}
		//page遷移 個人資格情報追加
			if(page != null && page.equals("addlicense")){
				try {
					plist = sm.pstaffSelect(sI);
					lList = sl.selectLicense();
				} catch (Exception e) {
					e.printStackTrace();
				}
				page_title = "人事システム - 保有資格追加ページ";
				content_page ="/jinji/license_add_view.jsp";
			}

		//JSPへデータの送る準備
		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);
		request.setAttribute("list", list);
		request.setAttribute("plist", plist);
		request.setAttribute("lList", lList);



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
