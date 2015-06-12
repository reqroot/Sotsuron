package kaikei.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class BankManage extends DBAccess {
	private String selectSql;
	private String insertSql;
	private String updateSql;
	private String deleteSql;
	private String serchSql;
	private String msg;

	public BankManage() {
		super("java:comp/env/jdbc/MySqlCon");
		this.selectSql = "select bank_id, bank_name from bank";
		this.updateSql = "update bank set bank_id = ?, bank_name = ?";
		this.insertSql = "insert into bank (bank_id, bank_name) values (?, ?)";
		this.serchSql = "select bank_id, bank_name from bank where bank_id = ?";
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
	 * 銀行の情報を取得します
	 * @return
	 * @throws Exception
	 */
	public List<BankInfo> bankSelect() throws Exception {
		List<BankInfo> list = new ArrayList<BankInfo>();

		BankInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		while (getRsResult().next()) {
			info = new BankInfo(
					getRsResult().getString("bank_id"),
					getRsResult().getString("bank_name"));
			list.add(info);
		}
		disConnect();
		return list;
	}

	/**
	 * 銀行の情報を1件取得します
	 * @return
	 * @throws Exception
	 */
	public BankInfo bankSearch(String bank_id) throws Exception {
		BankInfo info = null;
		// DB接続
		connect();

		// ステートメント
		createStatement(this.serchSql);
		this.getPstmt().setString(1, bank_id);
		// 実行
		this.selectExe();

		if (getRsResult().next()) {
			info = new BankInfo(
					getRsResult().getString("bank_id"),
					getRsResult().getString("bank_name"));
		}
		disConnect();

		return info;
	}

	/**
	 * 銀行情報を登録します
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public int bankInsert(BankInfo info) throws Exception {
		this.connect();
		this.createStatement(this.insertSql);

		try {
			this.getPstmt().setString(1, info.getBankId());
			this.getPstmt().setString(2, info.getBankName());

			this.updateExe();
		} catch (Exception e) {
			this.msg = "銀行情報の登録に失敗しました";
		}
		this.disConnect();
		return this.getIntResult();
	}

	/**
	 * 銀行情報を更新します
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public int bankUpdate(BankInfo info) throws Exception {
		connect();
		this.createStatement(this.updateSql);
		try {
			 this.getPstmt().setString(1, info.getBankId());
			 this.getPstmt().setString(2, info.getBankName());

			 // 実行
			 this.updateExe();
		} catch (SQLException e) {
			e.printStackTrace();
			this.msg = "銀行情報の更新に失敗しました";
		}
		this.disConnect();
		return this.getIntResult();
	}
}
