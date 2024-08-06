package com.cathaybk1;

public class Student implements IPrint {
	public String name = "Jason";
	public int id = 888888;
	public int grade = 1;

	public Student() {
	}

	public Student(String name, int id, int grade) {
//		super();     //?
		this.name = name;
		this.id = id;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void printt() {
		System.out.println("學生姓名:" + getName() + ",學號: " + getId() + " 年級:" + getGrade());
	}

	public void print() {
		System.out.println("學生姓名:" + getName() + ",學號: " + getId() + " 年級:" + getGrade());
	}
}
