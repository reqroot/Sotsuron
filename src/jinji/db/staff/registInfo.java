/**
 *
 */
package jinji.db.staff;

import java.io.Serializable;

/**
 * @author 1211091
 *	社員登録情報を保持するクラス
 */
public class registInfo implements Serializable {
	private String staff_id;
	private String staff_name;
	private String department_id;
	private String position_id;
	private String education_id;
	private String birthday;
	private String enter_day;
	private String base_salary;
	private String passwd;

	public registInfo(){
	}

	public registInfo(String staff_id, String staff_name, String department_id,
			String position_id, String education_id, String birthday,
			String enter_day, String base_salary, String passwd) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.department_id = department_id;
		this.position_id = position_id;
		this.education_id = education_id;
		this.birthday = birthday;
		this.enter_day = enter_day;
		this.base_salary = base_salary;
		this.passwd = passwd;
	}

	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getPosition_id() {
		return position_id;
	}
	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}
	public String getEducation_id() {
		return education_id;
	}
	public void setEducation_id(String education_id) {
		this.education_id = education_id;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEnter_day() {
		return enter_day;
	}
	public void setEnter_day(String enter_day) {
		this.enter_day = enter_day;
	}
	public String getBase_salary() {
		return base_salary;
	}
	public void setBase_salary(String base_salary) {
		this.base_salary = base_salary;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
