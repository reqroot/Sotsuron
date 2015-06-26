package jinji.db.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class positionManage extends DBAccess {
	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private String selectSql; //社員登録時>>役職一覧取得
	private String nameSearchSql;

		public positionManage() {
		super(DRIVER_NAME);
		StringBuilder sb = new StringBuilder();
		sb.append("select position_id, position_name " );
		sb.append("from tbl_position");
		selectSql = sb.toString();
		sb.setLength(0);
	}
		public List<positionInfo> positionSelect() throws Exception{
			List<positionInfo> posList = new ArrayList<positionInfo>();
			positionInfo positionInfo =null;
			connect();
			createStatement();
			selectExe(selectSql);
			ResultSet rs = getRsResult();
			while(rs.next()){
				positionInfo = new positionInfo(
				rs.getString("position_id"),
				rs.getString("position_name"),
				0
				);
				posList.add(positionInfo);
			}
			return posList;
		}

}
