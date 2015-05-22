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
		private String base_salary;
		public staffInfo(){}
		public staffInfo(String staff_id, String staff_name,
				String department_name, String position_name, String birthday,
				String base_salary) {
			super();
			this.staff_id = staff_id;
			this.staff_name = staff_name;
			this.department_name = department_name;
			this.position_name = position_name;
			this.birthday = birthday;
			this.base_salary = base_salary;
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
		public String getBase_salary() {
			return base_salary;
		}
		public void setBase_salary(String base_salary) {
			this.base_salary = base_salary;
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
			builder.append(", base_salary=");
			builder.append(base_salary);
			builder.append("]");
			return builder.toString();
		}
}
