package hanbai.db.member;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class MemberDBManager extends DBAccess {
	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private final static String TABLE = "members";
	private final static String ID = "member_id";
	private final static String NAME = "name";
	private final static String BIRTHDAY = "Birthday";
	private final static String SEX = "sex";
	private final static String PREFECTURE = "prefecture";
	private final static String CITY = "city";
	private final static String ADDRESS = "Address";
	private final static String TEL = "tel";
	private final static String MAIL = "mail";

	private String selectSQL;
	private String searchSQL;
	private String msg;

	public MemberDBManager() {
		super(DRIVER_NAME);
		selectSQL = String.format("SELECT %s, %s FROM %s "
				+ "WHERE member_id BETWEEN ? AND ? "
				+ "AND %s like ?"
				, ID, NAME, TABLE, NAME);

		searchSQL = String .format("SELECT %s, %s, %s, %s, %s, %s, %s, %s, %s FROM %s"
				+ "WHERE member_id = ?"
				, ID, NAME, BIRTHDAY, SEX, PREFECTURE, CITY, ADDRESS, TEL, MAIL, TABLE);

	}

	/**
	 * メッセージの取得
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * メッセージの設定
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 会員の一覧を検索して返します
	 * @param beginID 会員IDの検索範囲の開始値
	 * @param endID 会員IDの検索範囲の終了値
	 * @param name 検索する会員名（部分一致）
	 * @return 検索条件に一致する会員の一覧
	 * @throws Exception
	 */
	public List<MemberInfo> MemberSearch(String beginID, String endID, String name) throws Exception{
		List<MemberInfo> list = new ArrayList<MemberInfo>();

		//DB接続
		connect();
		//SQL設定
		createStatement(selectSQL);
		//パラメータの設定
		getPstmt().setString(1, beginID);
		getPstmt().setString(2, endID);
		getPstmt().setString(3, name);
		//実行
		selectExe();

		//データ取り出し
		ResultSet rs = getRsResult();
		while(rs.next()){
			//一件のデータ取り出し
			MemberInfo info = new MemberInfo();
			info.setMember_id(rs.getString(ID));
			info.setName(rs.getString(NAME));
			list.add(info);
		}
		disConnect();
		return list;
	}

	/**
	 * 会員の詳細情報を検索して返します
	 * @param memberID 検索する会員の会員ID
	 * @return 検索条件に一致する会員情報
	 * @throws Exception
	 */
	public MemberInfo MemberSearchDetail(String memberID) throws Exception{
		MemberInfo info = null;

		//DB接続
		connect();
		//SQL設定
		createStatement(searchSQL);
		//パラメータの設定
		getPstmt().setString(1, memberID);
		//実行
		selectExe();

		//データ取り出し
		ResultSet rs = getRsResult();
		if(rs.next()){
			//一件のデータ取り出し
			info.setMember_id(rs.getString(ID));
			info.setName(rs.getString(NAME));
			info.setBirthday(rs.getString(BIRTHDAY));
			info.setSex(rs.getString(SEX).equals("1"));
			info.setPrefecture(rs.getString(PREFECTURE));
			info.setCity(rs.getString(CITY));
			info.setAddress(rs.getString(ADDRESS));
			info.setTel(rs.getString(TEL));
			info.setMail(rs.getString(MAIL));
		}
		disConnect();
		return info;
	}


}
