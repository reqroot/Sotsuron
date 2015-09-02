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
	private String selectSql; //社員一覧用
	private String insertSql; //社員追加用
	private String updateSql;//社員更新用
	private String deleteSql;//社員削除用
	private String deleteViewSql;//社員削除確認用
	private String idSql; //最新社員番号取得(社員登録用)
	private String searchSql;//個別ページ用
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
		sb.append("WHERE 1=1 order by staff.staff_id asc");
		selectSql = sb.toString();
		sb.setLength(0); //StringBuilderの初期化

		sb.append("SELECT staff.staff_id, staff.staff_name, department.department_name, position.position_name, staff.birthday,staff.enter_day, staff.base_salary, license.license_name ");
		sb.append("FROM tbl_staff staff ");
		sb.append("INNER JOIN tbl_department department on staff. department_id = department.department_id ");
		sb.append("INNER JOIN tbl_position position on staff.position_id = position.position_id ");
		sb.append("LEFT OUTER JOIN(tbl_stafflicense slicense INNER JOIN tbl_license license on slicense.license_id = license.license_id) on staff.staff_id = slicense.staff_id ");
		sb.append("WHERE staff.staff_id=? ");
		searchSql = sb.toString();
		sb.setLength(0);

		sb.append("SELECT staff_id, staff_name ");
		sb.append("FROM tbl_staff ");
		sb.append("WHERE staff_id=?");
		deleteViewSql = sb.toString();
		sb.setLength(0);

		sb.append("INSERT tbl_Staff(Staff_ID,Staff_Name,Department_ID,Position_ID,Education_ID,Birthday,Enter_Day,Base_Salary,Passwd) ");
		sb.append("VALUES (?,?,?,?,?,?,?,?,?)");
		insertSql = sb.toString();
		sb.setLength(0);

		deleteSql = "DELETE FROM tbl_staff WHERE staff_id = ?";

		idSql = "select MAX(staff_id)+1 from tbl_staff";

		// 2015/6/8 add 鈴木 ログイン用SQL ここから
		this.loginSql = "SELECT Staff_ID, Staff_Name, Department_ID, Position_ID, Education_ID, Birthday, Enter_Day, Base_Salary, Passwd  FROM tbl_staff where staff_id = ? and passwd = ?";
		// 2015/6/8 add 鈴木 ログイン用SQL ここまで
	}


	/**
	 * メッセージの取得
	 * @return
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 社員一覧取得用
	 * @return
	 * @throws Exception
	 */
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
					"",
					"");
				list.add(info);
		}
		disConnect();
		return list;
	}
/**
 * 	個別社員情報取得用
 * @param staffInfo
 * @return
 * @throws Exception
 */
	public List<staffInfo> pstaffSelect(staffInfo staffInfo) throws Exception{
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
	/**TODO 初期登録or今年度最新登録の場合の処理をつける
	 * 最新社員ID連番取得用
	 * @return
	 * @throws Exception
	 */
	public String idSelect() throws Exception{
		String staff_id ="";
		connect();
		createStatement();
		selectExe(idSql);
		ResultSet rs = getRsResult();
		while(rs.next()){
		staff_id = String.valueOf(rs.getInt("MAX(staff_id)+1"));
		}
		disConnect();
		return staff_id;
	}

	public void updateStaff(registInfo rI, int state) throws Exception {
		connect();
		switch(state){
		case 0 : //INSERT
			createStatement(insertSql);
			getPstmt().setString(1, rI.getStaff_id());
			getPstmt().setString(2,rI.getStaff_name());
			getPstmt().setString(3, rI.getDepartment_id());
			getPstmt().setString(4, rI.getPosition_id());
			getPstmt().setString(5, rI.getEducation_id());
			getPstmt().setString(6, rI.getBirthday());
			getPstmt().setString(7, rI.getEnter_day());
			getPstmt().setString(8, rI.getBase_salary());
			getPstmt().setString(9, rI.getPasswd());
			break;
		case 1: //DELETE
			createStatement(deleteSql);
			getPstmt().setString(1, rI.getStaff_id());
			break;
		}//switch

		updateExe();
		disConnect();
	}

	/**
	 * 	個別社員情報取得用
	 * @param staffInfo
	 * @return
	 * @throws Exception
	 */
		public List<staffInfo> deleteViewSelect(String[] staffidList) throws Exception{
			List<staffInfo> plist = new ArrayList<staffInfo>();
			staffInfo pstaff = null;
			connect();
			createStatement(deleteViewSql);
			for(int i=0; i < staffidList.length;i++){
			getPstmt().setString(1, staffidList[i]);
			selectExe();
			ResultSet rs = getRsResult();
			while (rs.next()){
				pstaff = new staffInfo(
						rs.getString("staff_id"),
						rs.getString("staff_name"),
						"",
						"",
						"",
						"",
						"",
						"",
						"");
				plist.add(pstaff);
			}
			}//for
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
			info = new LoginInfo(
					rs.getString("staff_id"),
					rs.getString("passwd"),
					rs.getString("staff_name"),
					rs.getString("department_id"),
					rs.getString("position_id"),
					rs.getString("education_id"),
					rs.getString("birthday"),
					rs.getString("enter_day"),
					rs.getString("base_salary"));
		}

		return info;
	}

}
