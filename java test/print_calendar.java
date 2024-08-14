package com.cathaybk.practice.nt50344;

import java.time.LocalDate;

import java.util.Calendar;

import java.util.Scanner;

/**
 * 第5題
 */
public class Print_calendar {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);

		System.out.print("請輸入介於1-12的整數m:");
		int month = sc.nextInt();// 輸入月份
		System.out.print("請輸入年:");
		int year = sc.nextInt();
		LocalDate defDate = LocalDate.of(year, month, 1);// 定義一個日期
		int weekday = defDate.getDayOfWeek().getValue();// 取得當月一號星期幾
		int maxdayofmonth = defDate.lengthOfMonth();// 找當月有幾天
		System.out.println("      " + year + "年:" + month + "月");
		System.out.println("---------------------------");
		System.out.println("日   一   二  三   四   五  六 ");
		System.out.println("===========================");
		if (weekday == 7) {
			for (int i = 1; i <= maxdayofmonth; i++) {
				System.out.printf("%-4s", i);
				if (i % 7 == 0) {
					System.out.println();
				}

			}

		} else {// 當月1號是星期一到星期六 ex:2----%6s
			System.out.printf("%" + 4 * weekday + "s", " ");
			for (int k = 1; k <= 7 - weekday; k++) {
				System.out.printf("%-4s", k);

			}
			System.out.println();
			for (int j = 8 - weekday; j <= maxdayofmonth; j++) {
				System.out.printf("%-4s", j);
				if ((j + weekday) % 7 == 0) {
					System.out.println();
				}
			}
		}
	}
}
