package com.cathaybk1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class RandomNum {

	public static void main(String[] args) {

		TreeSet<Integer> list = new TreeSet<Integer>();

		while (list.size() < 5) {
			Random rand = new Random();
			int num = rand.nextInt(10) + 1;

			list.add(num);

		}
		System.out.println(list);
	}
}
