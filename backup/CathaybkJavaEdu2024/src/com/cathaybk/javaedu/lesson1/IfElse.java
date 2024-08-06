package com.cathaybk.javaedu.lesson1;

/**
 * <pre>
 * if-else 條件
 * </pre>
 */
public class IfElse {

    public static void main(String[] args) {
        int score = 57;

        if (score >= 80) {
            System.out.println("優");
        } else if (score < 80 && score >= 60) {   //score < 80 可刪掉cuz前面條件score必<80
            System.out.println("甲");
        } else if (score < 60 && score >= 40) {
            System.out.println("乙");
        } else {
            System.out.println("丙");
        }
    }

}
