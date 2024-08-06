package com.cathaybk1;

import java.util.Random;

public class DiceArray2 {

	public static void main(String[] args) {// 數字版

		Integer[] listt = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < 20; i++) { // 總共擲20次
			Random rand = new Random();
			int point = rand.nextInt(6) + 1;
			int point2 = rand.nextInt(6) + 1;
			int sum = point + point2; // ex:骰到3
			listt[sum - 2] += 1;
		}
		for (int j = 0; j < 11; j++) {
			if (listt[j] == 0) {
				continue;
			} else {
				System.out.println(j + 2 + ":" + listt[j]);
			}
		}
	}
}
