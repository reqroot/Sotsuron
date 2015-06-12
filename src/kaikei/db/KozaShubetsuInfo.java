package kaikei.db;

import java.io.Serializable;

public class KozaShubetsuInfo implements Serializable {
	private String kozaShubetsu;
	private String kozaShubetsuName;

	public KozaShubetsuInfo() {
		super();

	}

	public KozaShubetsuInfo(String kozaShubetsu, String kozaShubetsuName) {
		super();
		this.kozaShubetsu = kozaShubetsu;
		this.kozaShubetsuName = kozaShubetsuName;
	}

	public String getKozaShubetsu() {
		return kozaShubetsu;
	}

	public void setKozaShubetsu(String kozaShubetsu) {
		this.kozaShubetsu = kozaShubetsu;
	}

	public String getKozaShubetsuName() {
		return kozaShubetsuName;
	}

	public void setKozaShubetsuName(String kozaShubetsuName) {
		this.kozaShubetsuName = kozaShubetsuName;
	}

}
