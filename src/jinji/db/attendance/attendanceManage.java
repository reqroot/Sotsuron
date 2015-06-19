/**
 *
 */
package jinji.db.attendance;

import java.sql.ResultSet;

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
		sb.append("values(?,current_date ,CURTIME(), \"\" )");
		 attendSql = sb.toString();
		 sb.setLength(0);//StringBuilderの初期化

		 sb.append("update tbl_workmanage ");
		 sb.append("set time_out = CURTIME() ");
		 sb.append("where staff_id = ? && date = current_date ");
		 clockoutSql =sb.toString();
		 sb.setLength(0);

		 confSql = "select current_date, CURTIME()";
	}


	public attendanceInfo confattend() throws Exception{
		connect();
		createStatement();
		selectExe(confSql);
		ResultSet rs = getRsResult();
		while (rs.next()) {
			attendInfo =new attendanceInfo("",
					rs.getDate("current_date"),
					rs.getTime("CURTIME()"),
					null);
		}
		disConnect();
		return attendInfo;
	}

	public void attendUpdate(int state) throws Exception{ //0:出勤 1:退勤 2:DELETE
		connect();

		switch(state){
		case 0 : //出勤
			createStatement(attendSql);
			getPstmt().setString(1, "2015001"); //TODO ログイン情報から社員番号を選択する処理
			break;
		case 1: //退勤
			createStatement(clockoutSql);
			getPstmt().setString(1, "2015001"); //TODO ログイン情報から社員番号を選択する処理
			break;
		}//switch

		updateExe();
		disConnect();
	}
}
