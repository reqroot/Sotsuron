package kaikei.db;

import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class KozaShubetsuManage extends DBAccess {
	private String selectSql;

	public KozaShubetsuManage() {
		super("java:comp/env/jdbc/MySqlCon");
		this.selectSql = "select koza_shubetsu, koza_shubetsu_name from koza_shubetsu order by koza_shubetsu";
	}

	public List<KozaShubetsuInfo> select() throws Exception {
		List<KozaShubetsuInfo> list = new ArrayList<KozaShubetsuInfo>();
		KozaShubetsuInfo info = null;

		// DB接続
		connect();

		// ステートメント
		createStatement();
		// 実行
		this.selectExe(this.selectSql);

		while (getRsResult().next()) {
			info = new KozaShubetsuInfo(
					getRsResult().getString("koza_shubetsu"),
					getRsResult().getString("koza_shubetsu_name"));
			list.add(info);
		}
		disConnect();

		return list;
	}
}
