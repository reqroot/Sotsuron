/**

 *
 */
package jinji.db;

import java.io.Serializable;

/**
 * 社員情報を保持するクラス
 * @author 1211091
 *
 */
	public class staffInfo implements Serializable {
		private String staff_id;
		private String staff_name;
		private String department_name;
		private String position_name;
		private String birthday;
		private String enter_day;
		private String base_salary;
		private String license_name;
		private String passwd;

		public staffInfo(){}

		public staffInfo(String staff_id, String staff_name,
				String department_name, String position_name, String birthday,String enter_day,
				String base_salary, String license_name,String passwd) {
			super();
			this.staff_id = staff_id;
			this.staff_name = staff_name;
			this.department_name = department_name;
			this.position_name = position_name;
			this.birthday = birthday;
			this.enter_day = enter_day;
			this.base_salary = base_salary;
			this.license_name = license_name;
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

		public String getDepartment_name() {
			return department_name;
		}

		public void setDepartment_name(String department_name) {
			this.department_name = department_name;
		}

		public String getPosition_name() {
			return position_name;
		}

		public void setPosition_name(String position_name) {
			this.position_name = position_name;
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

		public String getLicense_name() {
			return license_name;
		}

		public void setLicense_name(String license_name) {
			this.license_name = license_name;
		}

		public String getPasswd() {
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("staffInfo [staff_id=");
			builder.append(staff_id);
			builder.append(", staff_name=");
			builder.append(staff_name);
			builder.append(", department_name=");
			builder.append(department_name);
			builder.append(", position_name=");
			builder.append(position_name);
			builder.append(", birthday=");
			builder.append(birthday);
			builder.append(", enter_day=");
			builder.append(enter_day);
			builder.append(", base_salary=");
			builder.append(base_salary);
			builder.append(", license=");
			builder.append(license_name);
			builder.append(", passwd=");
			builder.append(passwd);
			builder.append("]");
			return builder.toString();
		}
}
