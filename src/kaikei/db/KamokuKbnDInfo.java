package kaikei.db;

import java.io.Serializable;

public class KamokuKbnDInfo implements Serializable {
	private String kamokuKbnDId;
	private String kamokuKbnDName;

	public KamokuKbnDInfo() {
		super();

	}

	public KamokuKbnDInfo(String kamokuKbnDId, String kamokuKbnDName) {
		super();
		this.kamokuKbnDId = kamokuKbnDId;
		this.kamokuKbnDName = kamokuKbnDName;
	}

	public String getKamokuKbnDId() {
		return kamokuKbnDId;
	}

	public void setKamokuKbnDId(String kamokuKbnDId) {
		this.kamokuKbnDId = kamokuKbnDId;
	}

	public String getKamokuKbnDName() {
		return kamokuKbnDName;
	}

	public void setKamokuKbnDName(String kamokuKbnDName) {
		this.kamokuKbnDName = kamokuKbnDName;
	}


}
