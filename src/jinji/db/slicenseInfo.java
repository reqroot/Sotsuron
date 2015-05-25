/**
 *
 */
package jinji.db;

import java.io.Serializable;

/**
 * @author 1211091
 *
 */
public class slicenseInfo implements Serializable {
	private String staff_id;
	private String license_id;

	public slicenseInfo(){}

	public slicenseInfo(String staff_id, String license_id) {
		super();
		this.staff_id = staff_id;
		this.license_id = license_id;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getLicense_id() {
		return license_id;
	}

	public void setLicense_id(String license_id) {
		this.license_id = license_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("slicenseInfo [staff_id=");
		builder.append(staff_id);
		builder.append(", license_id=");
		builder.append(license_id);
		builder.append("]");
		return builder.toString();
	}


}
