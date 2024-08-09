package com.cathaybk.practice.nt50344.b;

public class Employee implements IWork {
	public String name;
	public String department;
	public int payment;

	// think of payment &salary

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public void printInfo() {

	}

}
