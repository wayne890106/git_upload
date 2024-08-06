package com.cathaybk1;

import java.util.Random;
import java.util.TreeSet;

public class RandomList {

	public static void main(String[] args) {

		TreeSet<Integer> listt = new TreeSet<Integer>();

		float sum = 0;
		while (listt.size() < 15) {
			Random rand = new Random();
			int num = rand.nextInt(100) + 1;
			listt.add(num);
			sum += num;
		}
		System.out.println(listt);
		System.out.println("sum:" + sum);
		System.out.println("avg:" + sum / 15);
	}
}