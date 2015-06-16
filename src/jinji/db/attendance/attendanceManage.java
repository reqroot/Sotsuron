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
	private String confSql; //出勤登録確認用SQL(select)
	public attendanceManage(){
		super(DRIVER_NAME);

		StringBuilder sb =new StringBuilder();

		sb.append("INSERT INTO tbl_workManage(staff_id, date, time_in, time_out) ");
		sb.append("VALUES(?,current_date ,now(), \"\" )");
		 attendSql = sb.toString();
		 sb.setLength(0);//StringBuilderの初期化

		 sb.append("select date,date_format(time_in,'%k:%i') ");
		 sb.append("from tbl_workmanage");
		 confSql = sb.toString();
		 sb.setLength(0);//StringBuilderの初期化
	}

}
