package com.gauri.rest.poc.data;

public class Person {
	private String customerType;
	private AccountInfo[] accounts;
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public AccountInfo[] getAccounts() {
		return accounts;
	}
	public void setAccounts(AccountInfo[] accounts) {
		this.accounts = accounts;
	}
	
}
