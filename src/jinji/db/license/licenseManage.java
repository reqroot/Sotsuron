/**
 *
 */
package jinji.db.license;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

/**
 * @author 1211091
 *
 */
public class licenseManage extends DBAccess {

	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private String selectSql;

	public licenseManage() {
		super(DRIVER_NAME);
		selectSql ="SELECT *"
				+ "FROM tbl_license";
	}

	public List<licenseInfo> selectLicense() throws Exception{

		List<licenseInfo> list = new ArrayList<licenseInfo>();
		licenseInfo liInfo = null;
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
}
