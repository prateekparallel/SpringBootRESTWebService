package com.web.car.bean;

import java.util.List;


public class CarInfoBean {
	private String userId;

	private String passWord;

	private List<CustomerRequestInfo> customerRequestInfo;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<CustomerRequestInfo> getCustomerRequestInfo() {
		return customerRequestInfo;
	}

	public void setCustomerRequestInfo(List<CustomerRequestInfo> customerRequestInfo) {
		this.customerRequestInfo = customerRequestInfo;
	}

}