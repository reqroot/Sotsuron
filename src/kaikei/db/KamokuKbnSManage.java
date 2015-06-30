package kaikei.db;

import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class KamokuKbnSManage extends DBAccess {
	private String selectSql;

	public KamokuKbnSManage() {
		super("java:comp/env/jdbc/MySqlCon");

		this.selectSql = "select kamoku_kbn_s_id, kamoku_kbn_d_id, kamoku_kbn_s_name from kamoku_kbn_s order by kamoku_kbn_s_id";
	}

	public List<KamokuKbnSInfo> select() throws Exception {
		List<KamokuKbnSInfo> list = new ArrayList<KamokuKbnSInfo>();

		KamokuKbnSInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		while (getRsResult().next()) {
			info = new KamokuKbnSInfo(
					getRsResult().getString("kamoku_kbn_s_id"),
					getRsResult().getString("kamoku_kbn_d_id"),
					getRsResult().getString("kamoku_kbn_s_name"));
			list.add(info);
		}
		disConnect();
		return list;
	}

}
