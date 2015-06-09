package kaikei.db;

import java.sql.SQLException;

import db.DBAccess;

public class JigyoshoManage extends DBAccess {
	private String selectSql;
	private String insertSql;
	private String updateSql;
	private String deleteSql;
	private String serchSql;
	private String msg;

	public JigyoshoManage() {
		super("java:comp/env/jdbc/MySqlCon");
		this.selectSql = "select jigyosho_name, post_no, prefecture, city, address, tel, fax, capital from jigyosho ";
		this.updateSql = "UPDATE jigyosho SET Jigyosho_Name = ?, Post_No = ?, Prefecture = ?, City = ?, Address = ?, Tel = ?, Fax = ?, Capital = ?";
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
	 * 事業所の情報を取得します
	 * @return
	 * @throws Exception
	 */
	public JigyoshoInfo jigyoshoSelect() throws Exception {
		JigyoshoInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		if (getRsResult().next()) {
			info = new JigyoshoInfo(
					getRsResult().getString("jigyosho_name"),
					getRsResult().getString("post_no"),
					getRsResult().getString("prefecture"),
					getRsResult().getString("city"),
					getRsResult().getString("address"),
					getRsResult().getString("tel"),
					getRsResult().getString("fax"),
					getRsResult().getString("capital"));
		}
		disConnect();
		return info;
	}

	public int jigyoshoUpdate(JigyoshoInfo info) throws Exception {
		connect();
		this.createStatement(this.updateSql);
		try {
			 this.getPstmt().setString(1, info.getJigyoshoName());
			 this.getPstmt().setString(2, info.getPostNo());
			 this.getPstmt().setString(3, info.getPrefecture());
			 this.getPstmt().setString(4, info.getCity());
			 this.getPstmt().setString(5, info.getAddress());
			 this.getPstmt().setString(6, info.getTel());
			 this.getPstmt().setString(7, info.getFax());
			 this.getPstmt().setString(8, info.getCapital());

			 // 実行
			 this.updateExe();
		} catch (SQLException e) {
			e.printStackTrace();
			this.msg = "事業所情報の更新に失敗しました";
		}
		this.disConnect();
		return this.getIntResult();
	}
}
