package com.cathaybk.practice.nt50344;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 第六題
 */
public class Converttocsv2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String line = "";
		String firstline = "";
		String splitby = ",";
		String csvurl = "C://xdd/cars2.csv";
		File csvfile = new File(csvurl);
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream("C://xdd/Java評量_第6題cars.csv"));
				OutputStreamWriter csvout = new OutputStreamWriter(new FileOutputStream(csvfile), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter csvbw = new BufferedWriter(csvout)) {
			firstline = br.readLine();// 讀取第一行存到firstline
			String item1[] = firstline.split(splitby);
			List<Map<String, String>> carMapList = new ArrayList<>();
			while ((line = br.readLine()) != null) {// 當讀的到值時
				String item[] = line.split(splitby);
				String manufacturer = item[0].trim();// 移除空格
				String TYPE = item[1].trim();
				String minPrice = item[2].trim();
				String price = item[3].trim();
				Map<String, String> carMap = new HashMap<>();
				carMap.put(item1[0], manufacturer);// get string "manufacturer"
				carMap.put(item1[1], TYPE);
				carMap.put(item1[2], minPrice);
				carMap.put(item1[3], price);
				carMapList.add(carMap);
			}

			Collections.sort(carMapList, new Comparator<Map<String, String>>() {

				@Override

				public int compare(Map<String, String> o1, Map<String, String> o2) {
					BigDecimal d1 = new BigDecimal(o1.get(item1[3]));
					BigDecimal d2 = new BigDecimal(o2.get(item1[3]));
					return d2.compareTo(d1);// 回傳型別為int

				}

			});
			System.out.println(carMapList);
			StringBuilder sb = new StringBuilder();
			sb.append(item1).append("\n");
			for (Map<String, String> map : carMapList) {
				sb.append(map.get(item1[0])).append(",").append(map.get(item1[1])).append(",").append(map.get(item1[2]))
						.append(",").append(map.get(item1[3])).append("\n");
			}
			csvbw.write(sb.toString());
			TreeSet<String> manuSet = new TreeSet<String>();
			for (Map<String, String> map : carMapList) {
				manuSet.add((String) (map.get(item1[0])));
			}
			System.out.printf("Manufacturer  " + "  TYPE    " + "      Min.price " + "Price" + "\n");

			BigDecimal minprice_total = BigDecimal.ZERO;
			BigDecimal price_total = BigDecimal.ZERO;
			for (String string : manuSet) {
				BigDecimal minprice = BigDecimal.ZERO;
				BigDecimal price = BigDecimal.ZERO;

				for (Map<String, String> map : carMapList) {
					if (string.equals((String) (map.get(item1[0])))) {
						BigDecimal minprice_single = new BigDecimal(map.get(item1[2]));
						minprice = minprice.add(minprice_single);
						BigDecimal price_single = new BigDecimal(map.get(item1[3]));
						price = price.add(price_single);
						System.out.printf("%-10s\t%-10s%10s%10s", map.get(item1[0]), map.get(item1[1]),
								map.get(item1[2]), map.get(item1[3]) + "\n");
						minprice_total = minprice_total.add(minprice_single);
						price_total = price_total.add(price_single);
					}
				}
				System.out.printf("%s\t\t\t\t%s\t %s", "小計", minprice, price);
				System.out.println("");
			}

			System.out.println("合計                             " + minprice_total + "    " + price_total);
		}

	}
}