package kaikei.db;

import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class KozaManage extends DBAccess {
	private String selectSql;
	private String insertSql;
	private String updateSql;
	private String deleteSql;
	private String serchSql;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public KozaManage() {
		super("java:comp/env/jdbc/MySqlCon");
		StringBuilder sb = new StringBuilder();

		// 選択
		sb.append("select bank_id, koza_no, koza.koza_shubetsu, shubetsu.koza_shubetsu_name, koza_zangaku ");
		sb.append("from sotsuron.koza as koza, sotsuron.koza_shubetsu as shubetsu ");
		sb.append("where koza.koza_shubetsu = shubetsu.koza_shubetsu ");
		sb.append("and koza.bank_id = ?");
		this.selectSql = sb.toString();
		sb.setLength(0);

		sb.append("select bank_id, koza_no, koza.koza_shubetsu, shubetsu.koza_shubetsu_name, koza_zangaku ");
		sb.append("from sotsuron.koza as koza, sotsuron.koza_shubetsu as shubetsu ");
		sb.append("where koza.koza_shubetsu = shubetsu.koza_shubetsu ");
		sb.append("and koza.bank_id = ? ");
		sb.append("and koza.Koza_No = ? ");
		serchSql = sb.toString();
		sb.setLength(0);

		sb.append("insert into koza (bank_id, koza_shubetsu, koza_no, koza_zangaku) ");
		sb.append("values (?, ?, ?, ?)");
		this.insertSql = sb.toString();
		sb.setLength(0);
	}

	public List<KozaInfo> select(BankInfo bi) throws Exception {
		List<KozaInfo> list = new ArrayList<KozaInfo>();
		KozaInfo info = null;

		// DB接続
		connect();

		// ステートメント
		createStatement(this.selectSql);
		this.getPstmt().setString(1, bi.getBankId());
		// 実行
		this.selectExe();

		while (getRsResult().next()) {
			info = new KozaInfo(
					getRsResult().getString("bank_id"),
					getRsResult().getString("koza_shubetsu_name"),
					getRsResult().getString("koza_no"),
					getRsResult().getInt("koza_zangaku"));
			list.add(info);
		}
		disConnect();

		return list;
	}

	public KozaInfo search(KozaInfo ki) throws Exception {
		KozaInfo info = null;

		// DB接続
		connect();

		// ステートメント
		createStatement(this.serchSql);
		this.getPstmt().setString(1, ki.getBankId());
		this.getPstmt().setString(2, ki.getKozaNo());
		// 実行
		this.selectExe();

		if (getRsResult().next()) {
			info = new KozaInfo(
					getRsResult().getString("bank_id"),
					getRsResult().getString("koza_shubetsu_name"),
					getRsResult().getString("koza_no"),
					getRsResult().getInt("koza_zangaku"));
		}
		disConnect();

		return info;
	}

	public int insert(KozaInfo ki) throws Exception {
		// DB接続
		connect();

		// ステートメント
		createStatement(this.insertSql);
		this.getPstmt().setString(1, ki.getBankId());
		this.getPstmt().setString(2, ki.getKozaShubetsu());
		this.getPstmt().setString(3, ki.getKozaNo());
		this.getPstmt().setInt(4, ki.getKozaZangaku());

		try {
			this.updateExe();
		} catch (Exception e) {
			this.msg = "口座情報の新規登録に失敗しました。";
		}

		disConnect();
		return this.getIntResult();
	}
}
