/**
 *
 */
package jinji.db.attendance;

import db.DBAccess;

/**
 * @author 1211091
 *
 */
public class attendanceManage extends DBAccess{
	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private String attendSql; //出勤用SQL(insert)
	private String clockoutSql; //退勤用SQL(update)
	private String confSql; //出退勤確認用(select)


	attendanceInfo attendInfo = null;

	public attendanceManage(){
		super(DRIVER_NAME);

		StringBuilder sb =new StringBuilder();

		sb.append("insert into tbl_workManage(staff_id, date, time_in, time_out) ");
		sb.append("values(?,current_date ,now(), \"\" )");
		 attendSql = sb.toString();
		 sb.setLength(0);//StringBuilderの初期化

		 sb.append("update tbl_workmanage ");
		 sb.append("set time_out =now() ");
		 sb.append("where staff_id = ? && date = current_date ");
		 clockoutSql =sb.toString();
		 sb.setLength(0);

		 confSql = "select current_date, now()";
	}

/** TODO あとで出勤確認用メソッド作成
	public attendanceInfo confattend() throws Exception{
		connect();
		createStatement();
		selectExe(confSql);
		ResultSet rs = getRsResult();
		while (rs.next()) {

		}
		disConnect();
		return attendInfo;
	}
	**/
}
