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
	private String serchSql;
	private String msg;

	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";

	public staffManage() {
		super(DRIVER_NAME);
		selectSql = "SELECT staff.staff_id, staff.staff_name, department.department_name, position.position_name, staff.birthday,staff.base_salary "
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
		while(rs.next()) {
			staffInfo info = new staffInfo(
					getRsResult().getString("staff_id"),
					getRsResult().getString("staff_name"),
					getRsResult().getString("department_name"),
					getRsResult().getString("position_name"),
					getRsResult().getString("birthday"),
					getRsResult().getString("base_salary"));
				list.add(info);
		}

		disConnect();
		return list;

	}
}