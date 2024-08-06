package com.cathaybk1;

import java.util.Random;

public class DIceArray {

	public static void main(String[] args) { // *字版

		String[] listt = new String[] { "", "", "", "", "", "", "", "", "", "", "" };
		for (int i = 0; i < 20; i++) { // 總共擲20次
			Random rand = new Random();
			int point = rand.nextInt(6) + 1;
			int point2 = rand.nextInt(6) + 1;
			int sum = point + point2; // ex:骰到3
			listt[sum - 2] += "*";
		}
		for (int j = 0; j < 11; j++) {
			if (listt[j] == "") {
				continue;
			} else {
				System.out.println((j + 2) + listt[j]);
			}
		}
	}
}
