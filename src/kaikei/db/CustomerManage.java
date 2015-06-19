package kaikei.db;

import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class CustomerManage extends DBAccess {
	private String selectSql;
	private String insertSql;
	private String updateSql;
	private String deleteSql;
	private String serchSql;
	private String nextIdSql;
	private String msg;

	public CustomerManage() {
		super("java:comp/env/jdbc/MySqlCon");
		this.selectSql = "select customer_id, customer_name, urikake_zangaku from customer";
		this.insertSql = "insert into customer (customer_id, customer_name, urikake_zangaku) values (?, ?, ?)";
		this.updateSql = "update customer set urikake_zangaku = ? where customer_id = ?";
		this.serchSql = "select customer_id, customer_name, urikake_zangaku from customer where customer_id = ?";
		this.nextIdSql = "select max(cast(customer_id as unsigned)) + 1 as next from customer";
	}

	/**
	 * メッセージの取得
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	public List<CustomerInfo> select() throws Exception {
		List<CustomerInfo> list = new ArrayList<CustomerInfo>();

		CustomerInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		while (getRsResult().next()) {
			info = new CustomerInfo(
					getRsResult().getString("customer_id"),
					getRsResult().getString("customer_name"),
					getRsResult().getInt("urikake_zangaku"));
			list.add(info);
		}
		disConnect();
		return list;
	}

	/**
	 * 顧客の情報を1件取得します
	 * @return
	 * @throws Exception
	 */
	public CustomerInfo search(String customer_id) throws Exception {
		CustomerInfo info = null;
		// DB接続
		connect();

		// ステートメント
		createStatement(this.serchSql);
		this.getPstmt().setString(1, customer_id);
		// 実行
		this.selectExe();

		if (getRsResult().next()) {
			info = new CustomerInfo(
					getRsResult().getString("customer_id"),
					getRsResult().getString("customer_name"),
					getRsResult().getInt("urikake_zangaku"));
		}
		disConnect();

		return info;
	}

	public int insert(CustomerInfo info) throws Exception {
		// DB接続
		connect();

		// ステートメント
		createStatement(this.insertSql);
		this.getPstmt().setString(1, info.getCustomerId());
		this.getPstmt().setString(2, info.getCustomerName());
		this.getPstmt().setInt(3, info.getUrikakeZangaku());

		try {
			this.updateExe();
		} catch (Exception e) {
			this.msg = "顧客情報の新規登録に失敗しました。";
		}

		disConnect();
		return this.getIntResult();
	}

	public int getNextId() throws Exception{
		int nextId = 0;
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(this.nextIdSql);
		if (getRsResult().next()) {
			nextId = getRsResult().getInt("next");
		}
		disConnect();
		return nextId;
	}
}
