package com.cathaybk.practice.nt50344;


/*
 * 第5題
 */
import java.time.LocalDate;

import java.util.Calendar;

import java.util.Scanner;

public class print_calendar {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		Scanner sc = new Scanner(System.in);

		System.out.print("請輸入介於1-12的整數m:");
		int m = sc.nextInt();
		cal.set(2024, m, 2);
		LocalDate defDate = LocalDate.of(2024, m, 1);// 定義一個日期
		int weekday = defDate.getDayOfWeek().getValue();// 取得星期幾
//		System.out.println("當月一號星期幾:" + defDate.getDayOfWeek().getValue());

//		int weekday =  (cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));

//		System.out.println("這個月一號是星期幾:" + weekday);//印禮拜幾

		int firstdayofmonth = cal.getMinimum(Calendar.DAY_OF_MONTH);// 當月一號
//		System.out.println(firstdayofmonth);
		cal.set(Calendar.DAY_OF_MONTH, firstdayofmonth - 1);// to find the last month
//		System.out.println(cal.get(Calendar.MONTH));
		int lastday1 = cal.getActualMaximum(Calendar.DAY_OF_MONTH);////////////////////////////////
//		System.out.println("幾天:" + lastday1);

		System.out.printf("%12d年%2d月", 2024, m);
		System.out.println("\n-----------------------");
		System.out.println("   日  一  二  三   四   五   六");
		System.out.println("================================");
		if (weekday == 7) {
			System.out.println("   1   2   3   4   5   6   7");
		} else if (weekday == 1) {
			System.out.println("       1   2   3   4   5   6");// +8-weekday
		} else if (weekday == 2) {
			System.out.println("           1   2   3   4   5");
		} else if (weekday == 3) {
			System.out.println("               1   2   3   4");
		} else if (weekday == 4) {
			System.out.println("                   1   2   3");
		} else if (weekday == 5) {
			System.out.println("                       1   2");
		} else {
			System.out.println("                           1");
		}
		if (weekday == 7) {
			for (int i = 8; i < 15; i++) {
				System.out.printf("%4d", i);
			}
			System.out.println();
			for (int j = 15; j < 22; j++) {
				System.out.printf("%4d", j);
			}
			System.out.println();
			for (int k = 22; k < 29; k++) {
				System.out.printf("%4d", k);
			}
			System.out.println();
			for (int l = 29; l <= lastday1; l++) {
				System.out.printf("%4d", l);
			}

		} else {// weekday= 1~6

			for (int i = 8 - weekday; i < 15 - weekday; i++) {
				System.out.printf("%4d", i);
			}
			System.out.println();
			for (int j = 15 - weekday; j < 22 - weekday; j++) {
				System.out.printf("%4d", j);
			}
			System.out.println();
			for (int k = 22 - weekday; k < 29 - weekday; k++) {
				System.out.printf("%4d", k);
			}
			System.out.println();
			if (lastday1 - 29 + weekday >= 7) {// 要再多印一行
				for (int m1 = 29 - weekday; m1 < 36 - weekday; m1++) {
					System.out.printf("%4d", m1);
				}
				System.out.println();
				for (int x = 36 - weekday; x <= lastday1; x++) {
					System.out.printf("%4d", x);

				}

			} else {
				for (int l = 29 - weekday; l <= lastday1; l++) {
					System.out.printf("%4d", l);
				}
			}

		}
		sc.close();
	}

}
