package jinji.db.license;

import java.io.Serializable;

public class licenseInfo implements Serializable {
	private String license_id;
	private String license_name;

	public licenseInfo() {
		super();

	}
	public licenseInfo(String license_id, String license_name) {
		super();
		this.license_id = license_id;
		this.license_name = license_name;
	}
	public String getLicense_id() {
		return license_id;
	}
	public void setLicense_id(String license_id) {
		this.license_id = license_id;
	}
	public String getLicense_name() {
		return license_name;
	}
	public void setLicense_name(String license_name) {
		this.license_name = license_name;
	}
}
