package hanbai;

import hanbai.db.genre.GenreDBManager;
import hanbai.db.genre.GenreInfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Genre
 */
@WebServlet("/hanbai/genre")
public class Genre extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Genre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ジャンルの一覧を取得する
		request.setCharacterEncoding("UTF-8");

		GenreDBManager manager = new GenreDBManager();
		try {
			List<GenreInfo> list = manager.genreSelectParentName();

			//JSPにデータを送る
			//実際の検索値をメッセージとして設定する
			//manager.setMsg(String.format("検索数[%s] (仕入先ID:%s～%s 仕入先名:%s 買掛残高:%s～%s)", list.size(), beginID, endID, name.replace("%", ""), beginKaikake, endKaikake));
			//request.setAttribute("msg", manager.getMsg());
			request.setAttribute("list", list);
			//ページ情報の追加
			request.setAttribute("page_title", HanbaiHome.TITLE_GENRE);
			request.setAttribute("content_page", HanbaiHome.CONTENT_GENRE_VIEW);
			//ディスパッチャーを取得
			RequestDispatcher rd = request.getRequestDispatcher("/template/layout.jsp");//Contextの値以降のアドレスを設定
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
