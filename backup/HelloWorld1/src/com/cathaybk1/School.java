package com.cathaybk1;

public class School {
    public static void main(String[] args) {
        LangStudent langStudent = new LangStudent();
        ComStudent comStudent = new ComStudent();
        System.out.println("--------------");
		Student student1 = new LangStudent("小明", 88888, 1, "英文");//跑到LangStudent傳入四個方法
        Student student2 = new ComStudent("小華", 77777, 2, "Java");
        student1.print();  //到LangStudent中沒有傳入參數的方法
        student2.print();
    }
}