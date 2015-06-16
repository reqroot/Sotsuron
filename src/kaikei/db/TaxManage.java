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
	private String currentSql;
	private String msg;

	/**
	 * コンストラクタ
	 */
	public TaxManage() {
		super("java:comp/env/jdbc/MySqlCon");
		selectSql = String.format("select enforcement_date, tax_rate from tax order by enforcement_date desc" );

		StringBuilder sb = new StringBuilder();

		sb.append("select enforcement_date, tax_rate from sotsuron.tax ");
		sb.append("where enforcement_date = (select max(enforcement_date) from sotsuron.tax) ");
		currentSql = sb.toString();
		sb.setLength(0);

		this.insertSql = "insert into tax (enforcement_date, tax_rate) values (?, ?)";

	}

	/**
	 * 過去の消費税情報の一覧を取得します
	 * @return
	 * @throws Exception
	 */
	public List<TaxInfo> select() throws Exception {
		List<TaxInfo> list = new ArrayList<TaxInfo>();
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		while (getRsResult().next()) {
			TaxInfo info = new TaxInfo(
					getRsResult().getString("enforcement_date"),
					getRsResult().getDouble("tax_rate"));
			list.add(info);
		}
		disConnect();
		return list;
	}

	/**
	 * 最新の消費税率を取得します
	 * @return
	 */
	public TaxInfo searchCurrent() throws Exception {
		TaxInfo info = null;

		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);

		if (getRsResult().next()) {
			info = new TaxInfo(
					getRsResult().getString("enforcement_date"),
					getRsResult().getDouble("tax_rate"));
		}

		disConnect();
		return info;
	}

	public int insert(TaxInfo info) throws Exception {
		// DB接続
		connect();
		// ステートメント
		createStatement(this.insertSql);
		this.getPstmt().setString(1, info.getEnforcementDate());
		this.getPstmt().setDouble(2, info.getTax());

		try {
			this.updateExe();
		} catch (Exception e) {
			this.msg = "消費税率の更新に失敗しました。";
		}

		disConnect();

		return this.getIntResult();
	}
}
