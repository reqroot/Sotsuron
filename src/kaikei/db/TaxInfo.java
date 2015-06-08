package kaikei.db;

import java.io.Serializable;
import java.util.Date;

/**
 * 消費税率のデータを保持するクラス
 * @author 1211089
 *
 */
public class TaxInfo implements Serializable {
	private Date enforcementDate;
	private double taxRate;

	/**
	 * コンストラクタ
	 * @param enforcementDate
	 * @param taxRate
	 */
	public TaxInfo() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param enforcementDate
	 * @param taxRate
	 */
	public TaxInfo(Date enforcementDate, double taxRate) {
		super();
		this.enforcementDate = enforcementDate;
		this.taxRate = taxRate;
	}

	/**
	 * 施工年月日を取得します
	 * @return
	 */
	public Date getEnforcementDate() {
		return enforcementDate;
	}

	/**
	 * 施工年月日を設定します
	 * @param enforcementDate
	 */
	public void setEnforcementDate(Date enforcementDate) {
		this.enforcementDate = enforcementDate;
	}

	/**
	 * 税率を取得します
	 * @return
	 */
	public double getTax() {
		return taxRate;
	}

	/**
	 * 税率を設定します
	 * @param taxRate
	 */
	public void setTax(double taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaxInfo [enforcementDate=");
		builder.append(enforcementDate);
		builder.append(", taxRate=");
		builder.append(taxRate);
		builder.append("]");
		return builder.toString();
	}
}
