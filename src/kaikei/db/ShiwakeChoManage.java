package kaikei.db;

import java.util.ArrayList;
import java.util.List;

import db.DBAccess;

public class ShiwakeChoManage extends DBAccess {
	private String selectSql;
	private String selectNendoSql;
	private String selectNendoMonthSql;
	private String selectNendoMonthDaySql;
	private String insertSql;
	private String updateSql;
	private String deleteSql;
	private String serchSql;
	private String nextRowSql;
	private String msg;

	public ShiwakeChoManage() {
		super("java:comp/env/jdbc/MySqlCon");
		StringBuilder sb = new StringBuilder();

		sb.append("select nendo, month, day, row, kamoku_kbn, kamoku as kamoku_id, ");
		sb.append("case ");
		sb.append("  when kamoku_kbn = 'D' then (select kamoku_kbn_d_name from kamoku_kbn_d where kamoku_kbn_d_id = shiwake_cho.kamoku)  ");
		sb.append("  when kamoku_kbn = 'S' then (select kamoku_kbn_s_name from kamoku_kbn_s where kamoku_kbn_s_id = shiwake_cho.kamoku) ");
		sb.append("  when kamoku_kbn = 'K' then (select kamoku_name from kanjo_kamoku where kamoku_id = shiwake_cho.kamoku) ");
		sb.append("  else '' ");
		sb.append("end as kamoku_name, ");
		sb.append("kamoku_hojo_kbn, kamoku_hojo, karikata, kashikata ");
		sb.append("from shiwake_cho ");
		sb.append("order by nendo, month, day, row ");
		this.selectSql = sb.toString();
		sb.setLength(0);

		sb.append("select Nendo, month, day, row, Kamoku_KBN, kamoku as kamoku_id, ");
		sb.append("case ");
		sb.append("  when kamoku_kbn = 'D' then (select kamoku_kbn_d_name from kamoku_kbn_d where kamoku_kbn_d_id = shiwake_cho.kamoku)  ");
		sb.append("  when kamoku_kbn = 'S' then (select kamoku_kbn_s_name from kamoku_kbn_s where kamoku_kbn_s_id = shiwake_cho.kamoku) ");
		sb.append("  when kamoku_kbn = 'K' then (select kamoku_name from kanjo_kamoku where kamoku_id = shiwake_cho.kamoku) ");
		sb.append("  else '' ");
		sb.append("end as kamoku_name, ");
		sb.append("Kamoku_Hojo_KBN, Kamoku_Hojo, Karikata, Kashikata ");
		sb.append("from shiwake_cho ");
		sb.append("where Nendo = ? ");
		sb.append("order by nendo, month, day, row ");
		this.selectNendoSql = sb.toString();
		sb.setLength(0);

		sb.append("select Nendo, month, day, row, Kamoku_KBN, kamoku as kamoku_id, ");
		sb.append("case ");
		sb.append("  when kamoku_kbn = 'D' then (select kamoku_kbn_d_name from kamoku_kbn_d where kamoku_kbn_d_id = shiwake_cho.kamoku)  ");
		sb.append("  when kamoku_kbn = 'S' then (select kamoku_kbn_s_name from kamoku_kbn_s where kamoku_kbn_s_id = shiwake_cho.kamoku) ");
		sb.append("  when kamoku_kbn = 'K' then (select kamoku_name from kanjo_kamoku where kamoku_id = shiwake_cho.kamoku) ");
		sb.append("  else '' ");
		sb.append("end as kamoku_name, ");
		sb.append("Kamoku_Hojo_KBN, Kamoku_Hojo, Karikata, Kashikata ");
		sb.append("from shiwake_cho ");
		sb.append("where Nendo = ? ");
		sb.append("and month = ? ");
		sb.append("order by nendo, month, day, row ");
		this.selectNendoMonthSql = sb.toString();
		sb.setLength(0);

		sb.append("select Nendo, month, day, row, Kamoku_KBN, kamoku as kamoku_id, ");
		sb.append("case ");
		sb.append("  when kamoku_kbn = 'D' then (select kamoku_kbn_d_name from kamoku_kbn_d where kamoku_kbn_d_id = shiwake_cho.kamoku)  ");
		sb.append("  when kamoku_kbn = 'S' then (select kamoku_kbn_s_name from kamoku_kbn_s where kamoku_kbn_s_id = shiwake_cho.kamoku) ");
		sb.append("  when kamoku_kbn = 'K' then (select kamoku_name from kanjo_kamoku where kamoku_id = shiwake_cho.kamoku) ");
		sb.append("  else '' ");
		sb.append("end as kamoku_name, ");
		sb.append("Kamoku_Hojo_KBN, Kamoku_Hojo, Karikata, Kashikata ");
		sb.append("from shiwake_cho ");
		sb.append("where Nendo = ? ");
		sb.append("and month = ? ");
		sb.append("and day = ? ");
		sb.append("order by nendo, month, day, row ");
		this.selectNendoMonthDaySql = sb.toString();
		sb.setLength(0);

		sb.append("insert into shiwake_cho (Nendo, month, day, row, Kamoku_KBN, Kamoku, Kamoku_Hojo_KBN, Kamoku_Hojo, Karikata, Kashikata) ");
		sb.append("values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		this.insertSql = sb.toString();
		sb.setLength(0);

		sb.append("update shiwake_cho set ");
		sb.append("Kamoku_KBN = ? ,");
		sb.append("Kamoku = ? ,");
		sb.append("Kamoku_Hojo_KBN = ? ,");
		sb.append("Kamoku_Hojo = ? ,");
		sb.append("Karikata = ? ,");
		sb.append("Kashikata = ?");
		sb.append("where nendo = ? ");
		sb.append("and Month = ? ");
		sb.append("and Day = ? ");
		sb.append("and Row = ?");
		this.updateSql = sb.toString();
		sb.setLength(0);

		sb.append("select Nendo, month, day, row, Kamoku_KBN, kamoku as kamoku_id, ");
		sb.append("case ");
		sb.append("  when kamoku_kbn = 'D' then (select kamoku_kbn_d_name from kamoku_kbn_d where kamoku_kbn_d_id = shiwake_cho.kamoku)  ");
		sb.append("  when kamoku_kbn = 'S' then (select kamoku_kbn_s_name from kamoku_kbn_s where kamoku_kbn_s_id = shiwake_cho.kamoku) ");
		sb.append("  when kamoku_kbn = 'K' then (select kamoku_name from kanjo_kamoku where kamoku_id = shiwake_cho.kamoku) ");
		sb.append("  else '' ");
		sb.append("end as kamoku_name, ");
		sb.append("Kamoku_Hojo_KBN, Kamoku_Hojo, Karikata, Kashikata ");
		sb.append("from shiwake_cho ");
		sb.append("where Nendo = ? ");
		sb.append("and month = ? ");
		sb.append("and day = ? ");
		sb.append("and row = ? ");
		this.serchSql = sb.toString();
		sb.setLength(0);

		sb.append("select max(row) + 1 as next from shiwake_cho ");
		sb.append("where nendo = ? ");
		sb.append("and month = ? ");
		sb.append("and day = ? ");
		this.nextRowSql = sb.toString();
		sb.setLength(0);

		sb.append("delete from shiwake_cho ");
		sb.append("where Nendo = ? ");
		sb.append("and month = ? ");
		sb.append("and day = ? ");
		sb.append("and row = ? ");
		this.deleteSql = sb.toString();
		sb.setLength(0);
	}

	public List<ShiwakeChoInfo> select() throws Exception {
		List<ShiwakeChoInfo> list = new ArrayList<ShiwakeChoInfo>();

		ShiwakeChoInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement();
		// 実行
		selectExe(selectSql);
		while (getRsResult().next()) {
			info = new ShiwakeChoInfo(
					getRsResult().getInt("nendo"),
					getRsResult().getInt("month"),
					getRsResult().getInt("day"),
					getRsResult().getInt("row"),
					getRsResult().getString("kamoku_KBN"),
					getRsResult().getString("kamoku_id"),
					getRsResult().getString("kamoku_name"),
					getRsResult().getString("kamoku_hojo_KBN"),
					getRsResult().getString("kamoku_hojo"),
					getRsResult().getInt("karikata"),
					getRsResult().getInt("kashikata"));
			list.add(info);
		}
		disConnect();
		return list;
	}

	public List<ShiwakeChoInfo> selectNendo(ShiwakeChoInfo si) throws Exception {
		List<ShiwakeChoInfo> list = new ArrayList<ShiwakeChoInfo>();

		ShiwakeChoInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement(selectNendoSql);
		this.getPstmt().setInt(1, si.getNendo());

		// 実行
		selectExe();
		while (getRsResult().next()) {
			info = new ShiwakeChoInfo(
					getRsResult().getInt("nendo"),
					getRsResult().getInt("month"),
					getRsResult().getInt("day"),
					getRsResult().getInt("row"),
					getRsResult().getString("kamoku_KBN"),
					getRsResult().getString("kamoku_id"),
					getRsResult().getString("kamoku_name"),
					getRsResult().getString("kamoku_hojo_KBN"),
					getRsResult().getString("kamoku_hojo"),
					getRsResult().getInt("karikata"),
					getRsResult().getInt("kashikata"));
			list.add(info);
		}
		disConnect();
		return list;
	}

	public List<ShiwakeChoInfo> selectNendoMonth(ShiwakeChoInfo si) throws Exception {
		List<ShiwakeChoInfo> list = new ArrayList<ShiwakeChoInfo>();

		ShiwakeChoInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement(selectNendoMonthSql);
		this.getPstmt().setInt(1, si.getNendo());
		this.getPstmt().setInt(2, si.getMonth());

		// 実行
		selectExe();
		while (getRsResult().next()) {
			info = new ShiwakeChoInfo(
					getRsResult().getInt("nendo"),
					getRsResult().getInt("month"),
					getRsResult().getInt("day"),
					getRsResult().getInt("row"),
					getRsResult().getString("kamoku_KBN"),
					getRsResult().getString("kamoku_id"),
					getRsResult().getString("kamoku_name"),
					getRsResult().getString("kamoku_hojo_KBN"),
					getRsResult().getString("kamoku_hojo"),
					getRsResult().getInt("karikata"),
					getRsResult().getInt("kashikata"));
			list.add(info);
		}
		disConnect();
		return list;
	}

	public List<ShiwakeChoInfo> selectNendoMonthDay(ShiwakeChoInfo si) throws Exception {
		List<ShiwakeChoInfo> list = new ArrayList<ShiwakeChoInfo>();

		ShiwakeChoInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement(selectNendoMonthDaySql);
		this.getPstmt().setInt(1, si.getNendo());
		this.getPstmt().setInt(2, si.getMonth());
		this.getPstmt().setInt(3, si.getDay());

		// 実行
		selectExe();
		while (getRsResult().next()) {
			info = new ShiwakeChoInfo(
					getRsResult().getInt("nendo"),
					getRsResult().getInt("month"),
					getRsResult().getInt("day"),
					getRsResult().getInt("row"),
					getRsResult().getString("kamoku_KBN"),
					getRsResult().getString("kamoku_id"),
					getRsResult().getString("kamoku_name"),
					getRsResult().getString("kamoku_hojo_KBN"),
					getRsResult().getString("kamoku_hojo"),
					getRsResult().getInt("karikata"),
					getRsResult().getInt("kashikata"));
			list.add(info);
		}
		disConnect();
		return list;
	}

	public List<ShiwakeChoInfo> serch(ShiwakeChoInfo si) throws Exception {
		List<ShiwakeChoInfo> list = new ArrayList<ShiwakeChoInfo>();

		ShiwakeChoInfo info = null;
		// DB接続
		connect();
		// ステートメント
		createStatement(this.serchSql);
		this.getPstmt().setInt(1, si.getNendo());
		this.getPstmt().setInt(2, si.getMonth());
		this.getPstmt().setInt(3, si.getDay());
		this.getPstmt().setInt(4, si.getRow());

		// 実行
		selectExe();
		while (getRsResult().next()) {
			info = new ShiwakeChoInfo(
					getRsResult().getInt("nendo"),
					getRsResult().getInt("month"),
					getRsResult().getInt("day"),
					getRsResult().getInt("row"),
					getRsResult().getString("kamoku_KBN"),
					getRsResult().getString("kamoku_id"),
					getRsResult().getString("kamoku_name"),
					getRsResult().getString("kamoku_hojo_KBN"),
					getRsResult().getString("kamoku_hojo"),
					getRsResult().getInt("karikata"),
					getRsResult().getInt("kashikata"));
			list.add(info);
		}
		disConnect();
		return list;
	}

	public int insert(ShiwakeChoInfo si) throws Exception {
		// DB接続
		connect();

		// ステートメント
		createStatement(this.insertSql);
		this.getPstmt().setInt(1, si.getNendo());
		this.getPstmt().setInt(2, si.getMonth());
		this.getPstmt().setInt(3, si.getDay());
		this.getPstmt().setInt(4, si.getRow());
		this.getPstmt().setString(5, si.getKamokuKBN());
		this.getPstmt().setString(6, si.getKamokuId());
		this.getPstmt().setString(7, si.getKamokuHojoKBN());
		this.getPstmt().setString(8, si.getKamokuHojo());
		this.getPstmt().setInt(9, si.getKarikata());
		this.getPstmt().setInt(10, si.getKashikata());

		try {
			this.updateExe();
		} catch (Exception e) {
			this.msg = "仕訳帳情報の新規登録に失敗しました。";
		}

		disConnect();
		return this.getIntResult();
	}

	public int update(ShiwakeChoInfo si) throws Exception {
		// DB接続
		connect();

		// ステートメント
		createStatement(this.updateSql);
		this.getPstmt().setString(1, si.getKamokuKBN());
		this.getPstmt().setString(2, si.getKamokuId());
		this.getPstmt().setString(3, si.getKamokuHojoKBN());
		this.getPstmt().setString(4, si.getKamokuHojo());
		this.getPstmt().setInt(5, si.getKarikata());
		this.getPstmt().setInt(6, si.getKashikata());
		this.getPstmt().setInt(7, si.getNendo());
		this.getPstmt().setInt(8, si.getMonth());
		this.getPstmt().setInt(9, si.getDay());
		this.getPstmt().setInt(10, si.getRow());

		try {
			this.updateExe();
		} catch (Exception e) {
			this.msg = "仕訳帳情報1件の更新に失敗しました。";
		}

		disConnect();
		return this.getIntResult();
	}

	public int delete(ShiwakeChoInfo si) throws Exception {
		// DB接続
				connect();

				// ステートメント
				createStatement(this.deleteSql);
				this.getPstmt().setInt(1, si.getNendo());
				this.getPstmt().setInt(2, si.getMonth());
				this.getPstmt().setInt(3, si.getDay());
				this.getPstmt().setInt(4, si.getRow());

				try {
					this.updateExe();
				} catch (Exception e) {
					this.msg = "仕訳帳情報1件の削除に失敗しました。";
				}

				disConnect();
				return this.getIntResult();
	}

	public int getNextRow(ShiwakeChoInfo si) throws Exception {
		int nextRow = 0;
		// DB接続
		connect();
		// ステートメント
		createStatement(this.nextRowSql);
		// 実行
		this.getPstmt().setInt(1, si.getNendo());
		this.getPstmt().setInt(2, si.getMonth());
		this.getPstmt().setInt(3, si.getDay());
		selectExe();
		if (getRsResult().next()) {
			nextRow = getRsResult().getInt("next");
		}
		disConnect();
		if (nextRow == 0) return 1;
		return nextRow;
	}

	public List<String> getNendoList() {
		List<String> ret = new ArrayList<String>();
		String sql = "select nendo from shiwake_cho group by nendo order by nendo";

		try {
			// DB接続
			connect();
			// ステートメント
			createStatement();
			// 実行
			selectExe(sql);

			while(getRsResult().next()) {
				ret.add(getRsResult().getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
