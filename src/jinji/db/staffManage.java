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
		selectSql ="select staff.staff_ID,staff.staff_Name,position.position_Name,"
				+ "department.department_Name,staff.Birthday,staff.Base_Salary "
				+ "from tbl_staff staff "
				+ "inner join tbl_department department on staff.department_ID=department.department_ID "
				+ "inner join tbl_position position on staff.position_ID=position.position_ID "
				+ "WHERE 1=1";
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
		if (getRsResult().next()) {
			info = new staffInfo(
					getRsResult().getString("staff_ID"),
					getRsResult().getString("staff_Name"),
					getRsResult().getString("position_Name"),
					getRsResult().getString("department_Name"),
					getRsResult().getString("birthDay"),
					getRsResult().getString("base_Salary"));
		}
		disConnect();
		return info;
	}
}
