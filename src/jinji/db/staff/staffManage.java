/**
 *
 */
package jinji.db.staff;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import login.LoginInfo;
import db.DBAccess;

/**
 * @author 1211091
 *
 */
public class staffManage extends DBAccess {
	private String selectSql; //スタッフ一覧用
	private String licenseAddSql;//個人資格情報追加用
	private String updateSql;
	private String deleteSql;
	private String searchSql;//スタッフ一件用
	private String loginSql; // 2015/6/8 add 鈴木 ログイン用SQL
	private String msg;



	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";

	public staffManage() {
		super(DRIVER_NAME);
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT staff.staff_id, staff.staff_name, department.department_name, position.position_name, staff.birthday,staff.enter_day,staff.base_salary ");
		sb.append("FROM tbl_staff staff ");
		sb.append("INNER JOIN tbl_department department on staff.department_id = department.department_id ");
		sb.append("INNER JOIN tbl_position position on staff.position_id = position.position_id ");
		sb.append("WHERE 1=1");
		selectSql = sb.toString();
		sb.setLength(0); //StringBuilderの初期化

		sb.append("SELECT staff.staff_id, staff.staff_name, department.department_name, position.position_name, staff.birthday,staff.enter_day, staff.base_salary, license.license_name ");
		sb.append("FROM tbl_staff staff ");
		sb.append("INNER JOIN tbl_department department on staff. department_id = department.department_id ");
		sb.append("INNER JOIN tbl_position position on staff.position_id = position.position_id ");
		sb.append("LEFT OUTER JOIN(tbl_stafflicense slicense INNER JOIN tbl_license license on slicense.license_id = license.license_id) on staff.staff_id = slicense.staff_id ");
		sb.append("WHERE staff.staff_id=?");
		searchSql = sb.toString();
		sb.setLength(0);

		licenseAddSql ="INSERT INTO tbl_StaffLicense(Staff_ID,License_ID) values(?,?)";

		// 2015/6/8 add 鈴木 ログイン用SQL ここから
		this.loginSql = "SELECT staff_id, passwd FROM tbl_staff where staff_id = ? and passwd = ?";
		// 2015/6/8 add 鈴木 ログイン用SQL ここまで
	}


	/**
	 * メッセージの取得
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	public List<staffInfo> staffSelect() throws Exception{ 		//スタッフ一覧取得
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
					"",
					"");
				list.add(info);
		}
		disConnect();
		return list;
	}

	public List<staffInfo> pstaffSelect(staffInfo staffInfo) throws Exception{		//個人ページ取得
		List<staffInfo> plist = new ArrayList<staffInfo>();
		staffInfo pstaff = null;
		connect();
		createStatement(searchSql);
		getPstmt().setString(1, staffInfo.getStaff_id());
		selectExe();
		ResultSet rs = getRsResult();
		while (rs.next()){
			pstaff = new staffInfo(
					rs.getString("staff_id"),
					rs.getString("staff_name"),
					rs.getString("department_name"),
					rs.getString("position_name"),
					rs.getString("birthday"),
					rs.getString("enter_day"),
					rs.getString("base_salary"),
					rs.getString("license_name"),
					"");
			plist.add(pstaff);
		}
		disConnect();
		return  plist;		//個人ページ取得
	}

	/**
	 *  ログイン用検索
	 * @param staffID
	 * @param passwd
	 * @return ログインユーザ情報（NULL該当ユーザなし）
	 * @author 鈴木 翔
	 */
	public LoginInfo authSelect(String staffID, String passwd) throws Exception {
		LoginInfo info = null;

		// DBを検索
		this.connect();
		this.createStatement(loginSql);
		this.getPstmt().setString(1, staffID);
		this.getPstmt().setString(2, passwd);
		this.selectExe();
		ResultSet rs = getRsResult();
		if (rs.next()) {
			info = new LoginInfo(rs.getString("staff_id"),rs.getString("passwd"));
		}

		return info;
	}

	/*public licenseInfo licenseUpdate(staffInfo sI){
		connect();
		createStatement();
		return null;

	} */  //add用
}
