package kaikei.db;

import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

/**
 * 消費税率を管理するクラス
 * @author 1211089
 *
 */
public class TaxManage extends DBAccess {
	private String selectSql;
	private String insertSql;
	private String updateSql;
	private String deleteSql;
	private String serchSql;
	private String msg;

	/**
	 * コンストラクタ
	 */
	public TaxManage() {
		super("java:comp/env/jdbc/MySqlCon");
		selectSql = String.format("select enforcement_date, tax_rate from tax" );
	}

	/**
	 * 過去の消費税情報の一覧を取得します
	 * @return
	 * @throws Exception
	 */
	public List<TaxInfo> taxSelect() throws Exception {
		List<TaxInfo> list = new ArrayList<TaxInfo>();
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		while (getRsResult().next()) {
			TaxInfo info = new TaxInfo(
					getRsResult().getDate("enforcement_date"),
					getRsResult().getDouble("tax_rate"));
			list.add(info);
		}
		disConnect();
		return list;
	}

}
