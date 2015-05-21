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
		private String staffID;
		private String staffName;
		private String departmentName;
		private String birthDay;
		private String baseSalary;

	/**
	 *
	 * @param staffID
	 * @param staffName
	 * @param departmentName
	 * @param birthDay
	 * @param baseSalary
	 */
	public staffInfo(String staffID, String staffName, String departmentName,
			String birthDay, String baseSalary) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.departmentName = departmentName;
		this.birthDay = birthDay;
		this.baseSalary = baseSalary;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(String baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("staffInfo [staffID=");
		builder.append(staffID);
		builder.append(", staffName=");
		builder.append(staffName);
		builder.append(", departmentName=");
		builder.append(departmentName);
		builder.append(", birthDay=");
		builder.append(birthDay);
		builder.append(", baseSalary=");
		builder.append(baseSalary);
		builder.append("]");
		return builder.toString();
	}
}
