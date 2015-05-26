package hanbai.db.supplier;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class SupplierDBManager extends DBAccess {
	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private final static String ID = "supplier_id";
	private final static String NAME = "name";
	private final static String KAIKAKE = "kaikake_zangaku";

	private String selectSQL;
	private String msg;

	public SupplierDBManager() {
		super(DRIVER_NAME);
		selectSQL = "SELECT supplier_id,name, kaikake_zangaku from supplier "
				+   "WHERE supplier_id BETWEEN ? AND ? AND "
				+   "name like ? AND "
				+   "kaikake_zangaku BETWEEN ? AND ?";
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
	 * 仕入先の情報を検索して返します
	 * @param beginID 仕入先IDの検索範囲の開始値
	 * @param endID 仕入先IDの検索範囲の終了値
	 * @param name 検索する仕入先名（部分一致）
	 * @param beginKaikake 買掛残額の検索範囲の開始値
	 * @param endKaikake 買掛残額の検索範囲の終了値
	 * @return 検索条件に一致する仕入先情報
	 * @throws Exception
	 */
	public List<SupplierInfo> SupplierSelect(String beginID, String endID, String name,
											 long beginKaikake, long endKaikake) throws Exception{
		List<SupplierInfo> list = new ArrayList<SupplierInfo>();

		//DB接続
		connect();
		//SQL設定
		createStatement(selectSQL);
		//パラメータの設定
		getPstmt().setString(1, beginID);
		getPstmt().setString(2, endID);
		getPstmt().setString(3, name);
		getPstmt().setLong(4, beginKaikake);
		getPstmt().setLong(5, endKaikake);
		//実行
		selectExe();

		//データ取り出し
		ResultSet rs = getRsResult();
		while(rs.next()){
			//一件のデータ取り出し
			SupplierInfo info = new SupplierInfo();
			info.setSupplier_id(rs.getString(ID));
			info.setName(rs.getString(NAME));
			info.setKaikake_zangaku(rs.getInt(KAIKAKE));
			list.add(info);
		}
		disConnect();
		return list;
	}
}
