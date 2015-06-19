package kaikei.db;

import java.io.Serializable;

public class CustomerInfo implements Serializable {
	private String customerId = null;
	private String customerName = null;
	private int urikakeZangaku;

	public CustomerInfo() {
		super();

	}

	public CustomerInfo(String customerId, String customerName, int urikakeZangaku) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.urikakeZangaku = urikakeZangaku;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getUrikakeZangaku() {
		return urikakeZangaku;
	}

	public void setUrikakeZangaku(int urikakeZangaku) {
		this.urikakeZangaku = urikakeZangaku;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerInfo [customerId=");
		builder.append(customerId);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", urikakeZangaku=");
		builder.append(urikakeZangaku);
		builder.append("]");
		return builder.toString();
	}


}
