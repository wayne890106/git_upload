package com.cathaybk1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class RandomList2 {

	public static void main(String[] args) {

		ArrayList<Integer> listt = new ArrayList<Integer>();

		int sum = 0;
		int i = 0;
		while (i < 15) {
			Random rand = new Random();
			int num = rand.nextInt(100) + 1;
			if (listt.contains(num)) {
				continue;
			} else {
				listt.add(num);
				i += 1;
			}
			sum += num;
		}
		Collections.sort(listt);
		System.out.println(listt);
		System.out.println("sum:" + sum);
		System.out.println("avg:" + sum / 15);
	}
}
