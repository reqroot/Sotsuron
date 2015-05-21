package hanbai.db;

import java.util.List;

import db.DBAccess;

public class SupplierDBManager extends DBAccess {
	private final static String DRIVER_NAME = "java:comp/env/jdbc/MySqlCon";
	private final static String ID = "id";
	private final static String Name="name";
	private final static String KAIKAKE = "kaikake_zangaku";

	private String selectSQL;

	public SupplierDBManager() {
		super(DRIVER_NAME);
		selectSQL = "SELECT supplier_id, kaikake_zangaku from supplier "
				+   "WHERE supplier_id BETWEEN ? AND ? AND "
				+   "name like ? AND"
				+   "kaikake_zangaku BETWEEN ? AND ?";
	}

	public List<SupplierInfo> SupplierSelect(){
		return null;
	}
}
