package hanbai;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HanbaiHome
 */
@WebServlet("/hanbai")
public class HanbaiHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//パラメータ名
	private static final String P_SUPPLIER ="supplier";
	//URL
	public static final String CONTENT_SUPPLIER = "/hanbai/supplier_view.jsp";
	//タイトル
	public static final String TITLE_SUPPLIER = "仕入先管理画面";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HanbaiHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title = "";
		String content_page = "";
		String page = request.getParameter("page");

		if(page != null){
			if(page.equals(P_SUPPLIER)){
				page_title = TITLE_SUPPLIER;
				content_page = CONTENT_SUPPLIER;
			}
			//どのページでもないとき
			else{

			}
		//不正なアクセス
		}else{

		}

		request.setAttribute("page_title", page_title);
		request.setAttribute("content_page", content_page);

		//ディスパッチャーを取得
		RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
