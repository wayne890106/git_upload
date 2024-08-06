package com.cathaybk.javaedu.lesson2.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;

@SuppressWarnings({ "unused", "resource" })
public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("C:/testException.txt");
            throw new Exception("error msg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        } finally {
            System.out.println("Finally Block");
        }

    }

}
