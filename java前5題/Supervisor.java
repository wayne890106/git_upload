package com.cathaybk.practice.nt50344.b;

public class Supervisor extends Employee {
	public int payment;

	public Supervisor(String name, String department, int payment) {// from here
		super(name, department);
		this.payment = payment;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public void printInfo() {
		System.out.println("薪資單");
		System.out.println("姓名: " + name + "  工程部門: " + department);
		System.out.println("月薪: " + payment);
		System.out.println("總計: " + payment);
	}

}
