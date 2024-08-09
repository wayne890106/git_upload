package com.cathaybk.practice.nt50344.b;

public class NineNineTable {

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				int res = i * j;
				System.out.printf("%2d*%d=%2d", j, i, res);
			}
			System.out.println("\n");
		}
	}

}
