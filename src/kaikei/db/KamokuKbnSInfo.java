package kaikei.db;

import java.io.Serializable;

public class KamokuKbnSInfo implements Serializable {
	private String kamokuKbnSId;
	private String kamokuKbnDId;
	private String kamokuKbnSName;

	public KamokuKbnSInfo() {
		super();

	}

	public KamokuKbnSInfo(String kamokuKbnSId, String kamokuKbnDId, String kamokuKbnSName) {
		super();
		this.kamokuKbnSId = kamokuKbnSId;
		this.kamokuKbnDId = kamokuKbnDId;
		this.kamokuKbnSName = kamokuKbnSName;
	}

	public String getKamokuKbnSId() {
		return kamokuKbnSId;
	}

	public void setKamokuKbnSId(String kamokuKbnSId) {
		this.kamokuKbnSId = kamokuKbnSId;
	}

	public String getKamokuKbnDId() {
		return kamokuKbnDId;
	}

	public void setKamokuKbnDId(String kamokuKbnDId) {
		this.kamokuKbnDId = kamokuKbnDId;
	}

	public String getKamokuKbnSName() {
		return kamokuKbnSName;
	}

	public void setKamokuKbnSName(String kamokuKbnSName) {
		this.kamokuKbnSName = kamokuKbnSName;
	}


}
