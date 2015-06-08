/**
 *
 */
package jinji.db.license;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jinji.db.staff.staffInfo;
import db.DBAccess;

/**
 * @author 1211091
 *
 */
public class licenseManage extends DBAccess {

	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private String selectSql;
	private String insertSql;
	private String slicenseSql;
	licenseInfo liInfo = null;

	public licenseManage() {
		super(DRIVER_NAME);
		StringBuilder sb =new StringBuilder();

				sb.append("SELECT license_id, license_name ");
				sb.append("FROM tbl_license");
				selectSql = sb.toString();
				sb.setLength(0);	//StringBuilderの初期化

				sb.append("INSERT INTO tbl_stafflicense(staff_id, license_id) ");
				 sb.append("VALUES(?, ?)");
				 insertSql = sb.toString();
				 sb.setLength(0);

				 sb.append("SELECT license.license_name ");
				 sb.append("FROM tbl_staff staff ");
				 sb.append("LEFT OUTER JOIN(tbl_stafflicense slicense INNER JOIN tbl_license license on slicense.license_id = license.license_id) on staff.staff_id = slicense.staff_id ");
				 sb.append("WHERE staff.staff_id = ?");
				 slicenseSql = sb.toString();
				 sb.setLength(0);
	}

	public List<licenseInfo> selectLicense() throws Exception{

		List<licenseInfo> list = new ArrayList<licenseInfo>();
		connect();
		createStatement();
		selectExe(selectSql);
		ResultSet rs = getRsResult();
		while (rs.next()) {
			liInfo =new licenseInfo(
					rs.getString("license_id"),
					rs.getString("license_name")
					);
			list.add(liInfo);
		}
		disConnect();
		return list ;
	}

	public List<licenseInfo> stafflicenseSelect(staffInfo sI) throws Exception{
		List<licenseInfo> list = new ArrayList<licenseInfo>();
		connect();
		createStatement(slicenseSql);
		getPstmt().setString(1, sI.getStaff_id());
		selectExe();
		ResultSet rs = getRsResult();
		while(rs.next()){
			liInfo = new licenseInfo(
					"",
					rs.getString("license_name")
					);
			list.add(liInfo);
		}
		disConnect();
		return list;

	}

	public void licenseUpdate(staffInfo sI, licenseInfo lI,int state) throws Exception{ //0:INSERT 1:UPDATE 2:DELETE
		connect();

		switch(state){
		case 0 : //INSERT
			createStatement(insertSql);
			getPstmt().setString(1, sI.getStaff_id());
			getPstmt().setString(2, lI.getLicense_id());
			break;
		case 1: //UPDATE

		case 2: //DELETE
		}//switch

		updateExe();
		disConnect();
	}
}
