package jinji.db.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jinji.db.staff.registInfo;
import db.DBAccess;

public class departmentManage extends DBAccess {
	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private String selectSql; //社員登録時>>部署一覧取得
	private String nameSearchSql;

	List<departmentInfo> depList = new ArrayList<departmentInfo>();
	departmentInfo departmentInfo =null;

	public departmentManage() {
		super(DRIVER_NAME);

		StringBuilder sb = new StringBuilder();
		sb.append("select department_id, department_name " );
		sb.append("from tbl_department");
		selectSql = sb.toString();
		sb.setLength(0);
	}

	public List<departmentInfo> departmentSelect() throws Exception{

		connect();
		createStatement();
		selectExe(selectSql);
		ResultSet rs = getRsResult();
		while(rs.next()){
			departmentInfo = new departmentInfo(
			rs.getString("department_id"),
			rs.getString("department_name")
		);
			depList.add(departmentInfo);
		}
		return depList;
	}

	public List<departmentInfo> depnameSelect(registInfo rI) throws Exception{
		List<departmentInfo> deplist = new ArrayList<departmentInfo>();
		connect();
		createStatement(nameSearchSql);
		getPstmt().setString(1, rI.getDepartment_id());
		selectExe();
		ResultSet rs = getRsResult();
		while(rs.next()){
			departmentInfo = new departmentInfo(
			"",
			rs.getString("department_name")
			);
			deplist.add(departmentInfo);
		}
		disConnect();
		return deplist;
	}

}
