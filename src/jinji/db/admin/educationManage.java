package jinji.db.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jinji.db.staff.registInfo;
import db.DBAccess;

public class educationManage extends DBAccess {
	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private String selectSql; //社員登録時>>学歴一覧取得
	private String nameSearchSql; //confirm 表示用

	List<educationInfo> eduList = new ArrayList<educationInfo>();
	educationInfo educationInfo =null;

	public educationManage() {
		super(DRIVER_NAME);
		StringBuilder sb = new StringBuilder();
		sb.append("select education_id, education_history " );
		sb.append("from tbl_education");
		selectSql = sb.toString();
		sb.setLength(0);

		sb.append("select education_history ");
		sb.append("from tbl_education ");
		sb.append("where education_id = ?");
		nameSearchSql = sb.toString();
		sb.setLength(0);
	}

	public List<educationInfo> educationSelect() throws Exception{
		connect();
		createStatement();
		selectExe(selectSql);
		ResultSet rs = getRsResult();
		while(rs.next()){
			educationInfo = new educationInfo(
			rs.getString("education_id"),
			rs.getString("education_history")
		);
			eduList.add(educationInfo);
		}
		return eduList;
	}

	public List<educationInfo> edunameSelect(registInfo rI) throws Exception{
		connect();
		createStatement(nameSearchSql);
		getPstmt().setString(1, rI.getEducation_id());
		selectExe();
		ResultSet rs = getRsResult();
		while(rs.next()){
			educationInfo = new educationInfo(
			"",
			rs.getString("education_history")
			);
			eduList.add(educationInfo);
		}
		disConnect();
		return eduList;
	}
}
