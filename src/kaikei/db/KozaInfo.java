package kaikei.db;

import java.io.Serializable;

public class KozaInfo  implements Serializable {
	private String bankId;
	private String kozaShubetsu;
	private String kozaNo;
	private int kozaZangaku;

	/**
	 * コンストラクタ
	 */
	public KozaInfo() {
		super();

	}

	/**
	 * コンストラクタ
	 * @param bankId
	 * @param kozaShubetsu
	 * @param kozaNo
	 * @param kozaZangaku
	 */
	public KozaInfo(String bankId, String kozaShubetsu, String kozaNo,
			int kozaZangaku) {
		super();
		this.bankId = bankId;
		this.kozaShubetsu = kozaShubetsu;
		this.kozaNo = kozaNo;
		this.kozaZangaku = kozaZangaku;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getKozaShubetsu() {
		return kozaShubetsu;
	}

	public void setKozaShubetsu(String kozaShubetsu) {
		this.kozaShubetsu = kozaShubetsu;
	}

	public String getKozaNo() {
		return kozaNo;
	}

	public void setKozaNo(String kozaNo) {
		this.kozaNo = kozaNo;
	}

	public int getKozaZangaku() {
		return kozaZangaku;
	}

	public void setKozaZangaku(int kozaZangaku) {
		this.kozaZangaku = kozaZangaku;
	}
}
