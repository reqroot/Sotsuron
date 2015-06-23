package kaikei.db;

import java.io.Serializable;

public class ShiwakeChoInfo implements Serializable {
	private int nendo;
	private int month;
	private int day;
	private int row;
	private String kamokuKBN;
	private String kamoku;
	private String kamokuHojoKBN;
	private String kamokuHojo;
	private int karikata;
	private int kashikata;

	public ShiwakeChoInfo() {
		super();
	}

	public ShiwakeChoInfo(int nendo, int month, int day, int row,
			String kamokuKBN, String kamoku, String kamokuHojoKBN,
			String kamokuHojo, int karikata, int kashikata) {
		super();
		this.nendo = nendo;
		this.month = month;
		this.day = day;
		this.row = row;
		this.kamokuKBN = kamokuKBN;
		this.kamoku = kamoku;
		this.kamokuHojoKBN = kamokuHojoKBN;
		this.kamokuHojo = kamokuHojo;
		this.karikata = karikata;
		this.kashikata = kashikata;
	}

	public int getNendo() {
		return nendo;
	}

	public void setNendo(int nendo) {
		this.nendo = nendo;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getKamokuKBN() {
		return kamokuKBN;
	}

	public void setKamokuKBN(String kamokuKBN) {
		this.kamokuKBN = kamokuKBN;
	}

	public String getKamoku() {
		return kamoku;
	}

	public void setKamoku(String kamoku) {
		this.kamoku = kamoku;
	}

	public String getKamokuHojoKBN() {
		return kamokuHojoKBN;
	}

	public void setKamokuHojoKBN(String kamokuHojoKBN) {
		this.kamokuHojoKBN = kamokuHojoKBN;
	}

	public String getKamokuHojo() {
		return kamokuHojo;
	}

	public void setKamokuHojo(String kamokuHojo) {
		this.kamokuHojo = kamokuHojo;
	}

	public int getKarikata() {
		return karikata;
	}

	public void setKarikata(int karikata) {
		this.karikata = karikata;
	}

	public int getKashikata() {
		return kashikata;
	}

	public void setKashikata(int kashikata) {
		this.kashikata = kashikata;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShiwakeChoInfo [nendo=");
		builder.append(nendo);
		builder.append(", month=");
		builder.append(month);
		builder.append(", day=");
		builder.append(day);
		builder.append(", row=");
		builder.append(row);
		builder.append(", kamokuKBN=");
		builder.append(kamokuKBN);
		builder.append(", kamoku=");
		builder.append(kamoku);
		builder.append(", kamokuHojoKBN=");
		builder.append(kamokuHojoKBN);
		builder.append(", kamokuHojo=");
		builder.append(kamokuHojo);
		builder.append(", karikata=");
		builder.append(karikata);
		builder.append(", kashikata=");
		builder.append(kashikata);
		builder.append("]");
		return builder.toString();
	}


}
