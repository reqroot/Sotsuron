package hanbai.db.genre;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class GenreDBManager extends DBAccess {
	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private final static String TABLE = "genre";
	private final static String ID = "genre_id";
	private final static String NAME = "name";
	private final static String PARENT_ID= "parent_genre_ID";

	private String selectSQL;
	private String selectParentNameSQL;
	private String msg;

	public GenreDBManager() {
		super(DRIVER_NAME);
		selectSQL = String.format("SELECT %s, %s, %s FROM %s", ID, NAME, PARENT_ID, TABLE);
		selectParentNameSQL = "SELECT a.genre_id, g.name , p.name , a.name FROM genre As a "
							+ "INNER JOIN genre As p ON a.parent_genre_ID = p.genre_ID "
							+ "INNER JOIN genre As g ON p.parent_genre_ID = g.genre_ID "
							+ "INNER JOIN genre As o ON g.parent_genre_ID = o.genre_ID";
	}

	/**
	 * メッセージの取得
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * メッセージの設定
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * ジャンルの情報を返します
	 * @return ジャンル情報
	 * @throws Exception
	 */
	public List<GenreInfo> genreSelect() throws Exception{
		List<GenreInfo> list = new ArrayList<GenreInfo>();

		//DB接続
		connect();
		//SQL設定
		this.createStatement();
		//実行
		selectExe(selectSQL);

		//データ取り出し
		ResultSet rs = getRsResult();
		while(rs.next()){
			//一件のデータ取り出し
			GenreInfo info = new GenreInfo();
			info.setGenre_id(rs.getString(ID));
			info.setName(rs.getString(NAME));
			info.setParent_genre_id(rs.getString(PARENT_ID));
			list.add(info);
		}
		disConnect();
		return list;
	}

	/**
	 * 自身のジャンル名および親子関係にあるジャンル名を取得します
	 * @return ジャンル情報
	 * @throws Exception
	 */
	public List<GenreInfo> genreSelectParentName() throws Exception{
		List<GenreInfo> list = new ArrayList<GenreInfo>();

		//DB接続
		connect();
		//SQL設定
		this.createStatement();
		//実行
		selectExe(selectParentNameSQL);

		//データ取り出し
		ResultSet rs = getRsResult();
		while(rs.next()){
			//一件のデータ取り出し
			GenreInfo info = new GenreInfo();
			info.setGenre_id(rs.getString("a.genre_ID"));
			info.setName(rs.getString("a.name"));
			info.setParent_name(rs.getString("p.name"));
			info.setGrand_name(rs.getString("g.name"));
			list.add(info);
		}
		disConnect();
		return list;
	}


}
