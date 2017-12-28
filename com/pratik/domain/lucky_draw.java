package com.pratik.domain;

public class lucky_draw {
	public int coupenNumber;
	public String customerName;
	public float billAmount;
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCoupenNumber() {
		return coupenNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCoupenNumber(int coupenNumber) {
		this.coupenNumber = coupenNumber;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "lucky_draw [coupenNumber=" + coupenNumber + ", customerName=" + customerName + ", billAmount="
				+ billAmount + "]";
	}
}
