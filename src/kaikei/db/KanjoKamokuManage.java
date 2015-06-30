package kaikei.db;

import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class KanjoKamokuManage extends DBAccess {
	private String selectSql;

	public KanjoKamokuManage() {
		super("java:comp/env/jdbc/MySqlCon");
		StringBuilder sb = new StringBuilder();

		sb.append("select ");
		sb.append("kamoku_kbn_d_id, kamoku_kbn_s_id, kamoku_id, kamoku_name, taisyaku_kbn, tax_kbn_id, tax_calc_kbn, tax_frac, kessanssho_koumoku_id ");
		sb.append("from kanjo_kamoku order by kamoku_kbn_d_id,kamoku_kbn_s_id, kamoku_id");
		this.selectSql = sb.toString();
		sb.setLength(0);
	}

	public List<KanjoKamokuInfo> select() throws Exception {
		List<KanjoKamokuInfo> list = new ArrayList<KanjoKamokuInfo>();

		KanjoKamokuInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		while (getRsResult().next()) {
			info = new KanjoKamokuInfo(getRsResult().getString("kamoku_kbn_d_id"),
					getRsResult().getString("kamoku_kbn_s_id"),
					getRsResult().getString("kamoku_id"),
					getRsResult().getString("kamoku_name"),
					getRsResult().getString("taisyaku_kbn"),
					getRsResult().getString("tax_kbn_id"),
					getRsResult().getString("tax_calc_kbn"),
					getRsResult().getString("tax_frac"),
					getRsResult().getString("kessanssho_koumoku_id"));
			list.add(info);
		}
		disConnect();
		return list;
	}
}
