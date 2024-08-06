package com.cathaybk1;

public class LangStudent extends Student {

	public LangStudent() {
		 super(); //預設，有沒有打沒差
		 System.out.println("沒有傳入參數的LangStudent建構子");
	}

	public LangStudent(String name, int id, int grade, String language) {
		super(name, id, grade); // 拿Student中傳入三個參數的方法(11行)拿到3個參數
		this.language = language;

	}

	private String language;

	public void print() {
		System.out.println("學生姓名:" + name + ",學號: " + id + " 年級:" + grade);
		System.out.println("外語:" + language);

	}
}
