package login;

public class LoginInfo {
	private String staffId;
	private String passwd;
	private String staffName;
	private String departmentId;
	private String positionId;
	private String educationId;
	private String birthday;
	private String enterDay;
	private String baseSalary;
	/**
	 * コンストラクタ
	 */
	public LoginInfo() {
		super();

	}

	/**
	 * パラメータ付きコンストラクタ
	 * @param staffId
	 * @param passwd
	 */
	public LoginInfo(String staffId, String passwd, String staffName,
			String departmentId, String positionId, String educationId,
			String birthday, String enterDay, String baseSalary) {
		super();
		this.staffId = staffId;
		this.passwd = passwd;
		this.staffName = staffName;
		this.departmentId = departmentId;
		this.positionId = positionId;
		this.educationId = educationId;
		this.birthday = birthday;
		this.enterDay = enterDay;
		this.baseSalary = baseSalary;
	}

	/**
	 * staffIDを取得します
	 * @return
	 */
	public String getStaffId() {
		return staffId;
	}

	/**
	 * staffIDを設定します
	 * @param staffId
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	/**
	 * パスワードを取得します
	 * @return
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * パスワードを設定します
	 * @param passwd
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getEducationId() {
		return educationId;
	}

	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEnterDay() {
		return enterDay;
	}

	public void setEnterDay(String enterDay) {
		this.enterDay = enterDay;
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
		builder.append("LoginInfo [staffId=");
		builder.append(staffId);
		builder.append(", passwd=");
		builder.append(passwd);
		builder.append("]");
		return builder.toString();
	}
}
