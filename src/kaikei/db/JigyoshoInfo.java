package kaikei.db;

import java.io.Serializable;

/**
 * 事業所のデータを保持するクラス
 * @author 1211089
 *
 */
public class JigyoshoInfo implements Serializable {
	private String jigyoshoName;
	private String postNo;
	private String prefecture;
	private String city;
	private String address;
	private String tel;
	private String fax;
	private String capital;

	/**
	 * コンストラクタ
	 */
	public JigyoshoInfo() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param jigyoshoName
	 * @param postNo
	 * @param prefecture
	 * @param city
	 * @param address
	 * @param tel
	 * @param fax
	 * @param capital
	 */
	public JigyoshoInfo(String jigyoshoName, String postNo, String prefecture,
			String city, String address, String tel, String fax, String capital) {
		super();
		this.jigyoshoName = jigyoshoName;
		this.postNo = postNo;
		this.prefecture = prefecture;
		this.city = city;
		this.address = address;
		this.tel = tel;
		this.fax = fax;
		this.capital = capital;
	}

	public String getJigyoshoName() {
		return jigyoshoName;
	}

	public void setJigyoshoName(String jigyoshoName) {
		this.jigyoshoName = jigyoshoName;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JigyoshoInfo [jigyoshoName=");
		builder.append(jigyoshoName);
		builder.append(", postNo=");
		builder.append(postNo);
		builder.append(", prefecture=");
		builder.append(prefecture);
		builder.append(", city=");
		builder.append(city);
		builder.append(", address=");
		builder.append(address);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", fax=");
		builder.append(fax);
		builder.append(", capital=");
		builder.append(capital);
		builder.append("]");
		return builder.toString();
	}


}
