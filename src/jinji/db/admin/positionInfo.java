package jinji.db.admin;

import java.io.Serializable;

public class positionInfo implements Serializable {
	private String position_id;
	private String position_name;
	private int position_amount;

	public positionInfo(){}

	public positionInfo(String position_id, String position_name,
			int position_amount) {
		super();
		this.position_id = position_id;
		this.position_name = position_name;
		this.position_amount = position_amount;
	}

	public String getPosition_id() {
		return position_id;
	}

	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public int getPosition_amount() {
		return position_amount;
	}

	public void setPosition_amount(int position_amount) {
		this.position_amount = position_amount;
	}


}
