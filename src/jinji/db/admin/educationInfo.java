package jinji.db.admin;

import java.io.Serializable;

public class educationInfo implements Serializable {
	private String education_id;
	private String education_history;

	public educationInfo(){}

	public educationInfo(String education_id, String education_history) {
		super();
		this.education_id = education_id;
		this.education_history = education_history;
	}

	public String getEducation_id() {
		return education_id;
	}

	public void setEducation_id(String education_id) {
		this.education_id = education_id;
	}

	public String getEducation_history() {
		return education_history;
	}

	public void setEducation_history(String education_history) {
		this.education_history = education_history;
	}


}
