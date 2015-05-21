/**
 *
 */
package jinji.db;

import db.DBAccess;

/**
 * @author 1211091
 *
 */
public class staffManage extends DBAccess {
	private String selectSql;
	private String insertSql;
	private String updateSql;
	private String deleteSql;
	private String serchSql;
	private String msg;

	public staffManage() {
		super("java:comp/env/jdbc/MySqlCon");
		// TODO あとで
	}

	/**
	 * メッセージの取得
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	public staffInfo staffSelect() throws Exception{
		staffInfo info = null;
		//DB接続
		connect();
		//ステートメント作成
		createStatement();
		//SQL実行
		selectExe(selectSql);


		return info;

	}
}
