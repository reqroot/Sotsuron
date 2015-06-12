package kaikei.db;

import java.io.Serializable;

public class BankInfo implements Serializable {
	private String bankId;
	private String bankName;

	/**
	 * コンストラクタ
	 */
	public BankInfo() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param bankId
	 * @param bankName
	 */
	public BankInfo(String bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BankInfo [bankId=");
		builder.append(bankId);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append("]");
		return builder.toString();
	}
}
