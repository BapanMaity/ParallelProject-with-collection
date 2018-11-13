package com.cg.ppc.dto;

public class Customer {
	private String name;
	private String mobileNo;
	private int age;
	private double initialBalance;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNo=" + mobileNo + ", age=" + age + ", initialBalance="
				+ initialBalance + "]";
	}
	public Customer(String name, String mobileNo, int age, double initialBalance) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.age = age;
		this.initialBalance = initialBalance;
	}
	public Customer() {
		super();
	}
}
