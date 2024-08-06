package com.cathaybk1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomNum2 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		int i = 0;
		while (i < 5) {
			Random rand = new Random();
			int num = rand.nextInt(10) + 1;
			if (list.contains(num)) {
				continue;
			} else {
				list.add(num);
				i += 1;
			}
		}
		Collections.sort(list);
		System.out.println(list);
	}

}
