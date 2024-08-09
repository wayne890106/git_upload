package com.cathaybk.practice.nt50344.b;

public class Sales extends Employee {
	public int bonus;// payment-bonus = salary
	public int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Sales(String name, String department, int salary, int bonus) {// from here
		super(name, department);
		this.salary = salary;
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getPayment() {
		int payment = (int) (getBonus() * 0.05) + getSalary();
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public void printInfo() {
		int bonus_money = (int) (bonus * 0.05);
		System.out.println("薪資單");
		System.out.println("姓名: " + name + "   工程部門: " + department);
		System.out.println("月薪: " + salary);
		System.out.println("業績獎金: " + bonus_money);
		System.out.println("總計: " + (bonus_money + salary));
	}

}
