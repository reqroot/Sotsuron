package kaikei.db;

import java.io.Serializable;

public class KanjoKamokuInfo implements Serializable {
	private String kamokuKbnDId;
	private String kamokuKbnSId;
	private String kamokuId;
	private String kamokuName;
	private String taisyakuKbn;
	private String taxKbnId;
	private String taxCalcKbn;
	private String taxFrac;
	private String kessansshoKoumokuId;

	public KanjoKamokuInfo() {
		super();

	}

	public KanjoKamokuInfo(String kamokuKbnDId, String kamokuKbnSId,
			String kamokuId, String kamokuName, String taisyakuKbn,
			String taxKbnId, String taxCalcKbn, String taxFrac,
			String kessansshoKoumokuId) {
		super();
		this.kamokuKbnDId = kamokuKbnDId;
		this.kamokuKbnSId = kamokuKbnSId;
		this.kamokuId = kamokuId;
		this.kamokuName = kamokuName;
		this.taisyakuKbn = taisyakuKbn;
		this.taxKbnId = taxKbnId;
		this.taxCalcKbn = taxCalcKbn;
		this.taxFrac = taxFrac;
		this.kessansshoKoumokuId = kessansshoKoumokuId;
	}

	public String getKamokuKbnDId() {
		return kamokuKbnDId;
	}

	public void setKamokuKbnDId(String kamokuKbnDId) {
		this.kamokuKbnDId = kamokuKbnDId;
	}

	public String getKamokuKbnSId() {
		return kamokuKbnSId;
	}

	public void setKamokuKbnSId(String kamokuKbnSId) {
		this.kamokuKbnSId = kamokuKbnSId;
	}

	public String getKamokuId() {
		return kamokuId;
	}

	public void setKamokuId(String kamokuId) {
		this.kamokuId = kamokuId;
	}

	public String getKamokuName() {
		return kamokuName;
	}

	public void setKamokuName(String kamokuName) {
		this.kamokuName = kamokuName;
	}

	public String getTaisyakuKbn() {
		return taisyakuKbn;
	}

	public void setTaisyakuKbn(String taisyakuKbn) {
		this.taisyakuKbn = taisyakuKbn;
	}

	public String getTaxKbnId() {
		return taxKbnId;
	}

	public void setTaxKbnId(String taxKbnId) {
		this.taxKbnId = taxKbnId;
	}

	public String getTaxCalcKbn() {
		return taxCalcKbn;
	}

	public void setTaxCalcKbn(String taxCalcKbn) {
		this.taxCalcKbn = taxCalcKbn;
	}

	public String getTaxFrac() {
		return taxFrac;
	}

	public void setTaxFrac(String taxFrac) {
		this.taxFrac = taxFrac;
	}

	public String getKessansshoKoumokuId() {
		return kessansshoKoumokuId;
	}

	public void setKessansshoKoumokuId(String kessansshoKoumokuId) {
		this.kessansshoKoumokuId = kessansshoKoumokuId;
	}



}
