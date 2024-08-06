package com.cathaybk1;



public class ComStudent extends Student {
	
	public ComStudent() {
		System.out.println("沒有傳入參數的ComStudent建構子");
	}


	private String program;

	public ComStudent(String name,int id, int grade,String program) {
		super(name, id, grade);
		this.program = program;
	}
	public void print() {
		System.out.println("學生姓名:" + name + ",學號: " + id + " 年級:" + grade);
		System.out.println("外語:"+ program);
	}
}
