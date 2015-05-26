/**
 *
 */
package jinji.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	private String searchSql;
	private String msg;

	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";

	public staffManage() {
		super(DRIVER_NAME);
		selectSql = "SELECT staff.staff_id, staff.staff_name, department.department_name, position.position_name, staff.birthday,staff.enter_day,staff.base_salary "
				+ "FROM tbl_staff staff "
				+ "INNER JOIN tbl_department department on staff.department_id = department.department_id "
				+ "INNER JOIN tbl_position position on staff.position_id = position.position_id "
				+ "WHERE 1=1";
	}


	/**
	 * メッセージの取得
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	public List<staffInfo> staffSelect() throws Exception{
		List<staffInfo> list = new ArrayList<staffInfo>();

		//DB接続
		connect();
		//ステートメント作成
		createStatement();
		//SQL実行
		selectExe(selectSql);

		//データ抽出
		ResultSet rs = getRsResult();
		staffInfo info = null;
		while(rs.next()) {
			 info =new staffInfo(
					rs.getString("staff_id"),
					rs.getString("staff_name"),
					rs.getString("department_name"),
					rs.getString("position_name"),
					rs.getString("birthday"),
					rs.getString("enter_day"),
					rs.getString("base_salary"),
					"");
				list.add(info);
		}

		disConnect();
		return list;

	}
}
