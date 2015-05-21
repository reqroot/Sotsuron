package hanbai.db;

public class SupplierInfo {
	private String supplier_id;
	private String name;
	private int kaikake_zangaku;

	public SupplierInfo(String supplier_id, String name, int kaikake_zangaku) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
		this.kaikake_zangaku = kaikake_zangaku;
	}

	public SupplierInfo(){}

	/**
	 * 仕入先IDを取得します
	 * @return 仕入先ID
	 */
	public String getSupplier_id() {
		return supplier_id;
	}


	/**
	 * 仕入先IDを設定する
	 * @param supplier_id 設定する仕入先ID
	 */
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	/**
	 * 仕入先名を取得します
	 * @return 仕入先名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 仕入先名を設定します
	 * @param name 設定する仕入先名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 買掛金残額を取得します
	 * @return 買掛金残額
	 */
	public int getKaikake_zangaku() {
		return kaikake_zangaku;
	}

	/**
	 * 買掛金残額を設定します
	 * @param kaikake_zangaku 設定する買掛金残額
	 */
	public void setKaikake_zangaku(int kaikake_zangaku) {
		this.kaikake_zangaku = kaikake_zangaku;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("仕入先情報 [supplier_id=");
		builder.append(supplier_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", kaikake_zangaku=");
		builder.append(kaikake_zangaku);
		builder.append("]");
		return builder.toString();
	}


}
