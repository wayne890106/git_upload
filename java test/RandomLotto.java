package com.cathaybk.practice.nt50344;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * 第二題
 */
public class RandomLotto {

	public static void main(String[] args) {
		Random rand = new Random();
		HashSet<Integer> lottolist = new HashSet<Integer>();
		while (lottolist.size() < 6) {
			int rand_num = rand.nextInt(49) + 1;
			lottolist.add(rand_num);
		}
		System.out.print("排序前:");
		for (Integer intt : lottolist) {
			System.out.printf("%2d ", intt);
		}

		TreeSet<Integer> lottolist2tree = new TreeSet<Integer>();
		lottolist2tree.addAll(lottolist);
		System.out.println();
		System.out.print("排序後:");
		for (Integer inttt : lottolist2tree) {
			System.out.printf("%2d ", inttt);
		}
	}

}