package login;

public class LoginInfo {
	private String staffId;
	private String passwd;
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
	public LoginInfo(String staffId, String passwd) {
		super();
		this.staffId = staffId;
		this.passwd = passwd;
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
