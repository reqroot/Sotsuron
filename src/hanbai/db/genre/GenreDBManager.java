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
	private String msg;

	public GenreDBManager() {
		super(DRIVER_NAME);
		selectSQL = String.format("SELECT %s, %s, %s FROM %s", ID, NAME, PARENT_ID, TABLE);
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
	public List<GenreInfo> SupplierSelect() throws Exception{
		List<GenreInfo> list = new ArrayList<GenreInfo>();

		//DB接続
		connect();
		//SQL設定
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
}
