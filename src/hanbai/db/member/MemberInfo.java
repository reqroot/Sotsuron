package hanbai.db.member;


public class MemberInfo {
	private String member_id;
	private String name;
	private String birthday;
	private boolean sex;
	private String postcode;
	private String prefecture;
	private String city;
	private String Address;
	private String tel;
	private String mail;
	private String entry_date;
	private String update_date;

	public MemberInfo(){}

	public MemberInfo(String member_id, String name, String birthday,
			boolean sex, String postcode, String prefecture, String city, String address,
			String tel, String mail) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.postcode = postcode;
		this.prefecture = prefecture;
		this.city = city;
		Address = address;
		this.tel = tel;
		this.mail = mail;
	}

	/**
	 * member_idを取得します
	 * @return member_id
	 */
	public String getMember_id() {
		return member_id;
	}

	/**
	 * member_idを設定します
	 * @param member_id 設定するmember_id
	 */
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	/**
	 * nameを取得します
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定します
	 * @param name 設定するname
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * birthdayを取得します
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * birthdayを設定します
	 * @param birthday 設定するbirthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 性別(文字列)を取得します
	 * @return sex
	 */
	public String getSex() {
		if(sex){
			return "女";
		}else{
			return "男";
		}
	}

	/**
	 * 性別(DB上での値)を取得します
	 * @return
	 */
	public int getSexInt(){
		if(sex){
			return 1;//女
		}else{
			return 0;//男
		}

	}

	/**
	 * sexを設定します
	 * @param sex 設定するsex falseなら男、trueなら女
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	/**
	 * postcodeを取得します
	 * @return postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * postcodeを設定します
	 * @param postcode 設定するpostcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * prefectureを取得します
	 * @return prefecture
	 */
	public String getPrefecture() {
		return prefecture;
	}

	/**
	 * prefectureを設定します
	 * @param prefecture 設定するprefecture
	 */
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	/**
	 * cityを取得します
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * cityを設定します
	 * @param city 設定するcity
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * addressを取得します
	 * @return address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * addressを設定します
	 * @param address 設定するaddress
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * telを取得します
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * telを設定します
	 * @param tel 設定するtel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * mailを取得します
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * mailを設定します
	 * @param mail 設定するmail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}



	/**
	 * entry_dateを取得します
	 * @return entry_date
	 */
	public String getEntry_date() {
		return entry_date;
	}

	/**
	 * entry_dateを設定します
	 * @param entry_date 設定するentry_date
	 */
	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	/**
	 * update_dateを取得します
	 * @return update_date
	 */
	public String getUpdate_date() {
		return update_date;
	}

	/**
	 * update_dateを設定します
	 * @param update_date 設定するupdate_date
	 */
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberInfo [member_id=");
		builder.append(member_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", prefecture=");
		builder.append(prefecture);
		builder.append(", city=");
		builder.append(city);
		builder.append(", Address=");
		builder.append(Address);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", entry_date=");
		builder.append(entry_date);
		builder.append("]");
		return builder.toString();
	}


}
