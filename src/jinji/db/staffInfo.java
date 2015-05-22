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
		private String staff_ID;
		private String staff_Name;
		private String position_Name;
		private String department_Name;
		private String birthDay;
		private String base_Salary;

		/**
		 *
		 * @param staff_ID
		 * @param staff_Name
		 * @param staff_Position
		 * @param department_Name
		 * @param birthDay
		 * @param base_Salary
		 */
		public staffInfo(String staff_ID, String staff_Name,
				String staff_Position, String department_Name, String birthDay,
				String base_Salary) {
			super();
			this.staff_ID = staff_ID;
			this.staff_Name = staff_Name;
			this.position_Name = staff_Position;
			this.department_Name = department_Name;
			this.birthDay = birthDay;
			this.base_Salary = base_Salary;
		}

		public String getStaff_ID() {
			return staff_ID;
		}

		public void setStaff_ID(String staff_ID) {
			this.staff_ID = staff_ID;
		}

		public String getStaff_Name() {
			return staff_Name;
		}

		public void setStaff_Name(String staff_Name) {
			this.staff_Name = staff_Name;
		}

		public String getStaff_Position() {
			return position_Name;
		}

		public void setStaff_Position(String staff_Position) {
			this.position_Name = staff_Position;
		}

		public String getDepartment_Name() {
			return department_Name;
		}

		public void setDepartment_Name(String department_Name) {
			this.department_Name = department_Name;
		}

		public String getBirthDay() {
			return birthDay;
		}

		public void setBirthDay(String birthDay) {
			this.birthDay = birthDay;
		}

		public String getBase_Salary() {
			return base_Salary;
		}

		public void setBase_Salary(String base_Salary) {
			this.base_Salary = base_Salary;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("staffInfo [staff_ID=");
			builder.append(staff_ID);
			builder.append(", staff_Name=");
			builder.append(staff_Name);
			builder.append(", staff_Position=");
			builder.append(position_Name);
			builder.append(", department_Name=");
			builder.append(department_Name);
			builder.append(", birthDay=");
			builder.append(birthDay);
			builder.append(", base_Salary=");
			builder.append(base_Salary);
			builder.append("]");
			return builder.toString();
		}
}
