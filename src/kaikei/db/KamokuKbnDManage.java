package kaikei.db;

import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class KamokuKbnDManage extends DBAccess {
	private String selectSql;

	public KamokuKbnDManage() {
		super("java:comp/env/jdbc/MySqlCon");

		this.selectSql = "select kamoku_kbn_d_id, kamoku_kbn_d_name from kamoku_kbn_d order by kamoku_kbn_d_id";
	}

	public List<KamokuKbnDInfo> select() throws Exception {
		List<KamokuKbnDInfo> list = new ArrayList<KamokuKbnDInfo>();

		KamokuKbnDInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		while (getRsResult().next()) {
			info = new KamokuKbnDInfo(
					getRsResult().getString("kamoku_kbn_d_id"),
					getRsResult().getString("kamoku_kbn_d_name"));
			list.add(info);
		}
		disConnect();
		return list;
	}
}
