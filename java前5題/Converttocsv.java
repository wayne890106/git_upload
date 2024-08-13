package com.cathaybk.practice.nt50344;

/*
 * 第六題
 */
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

public class Converttocsv {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String line = "";
		String splitby = ",";
		String csvurl = "C://xdd/cars2.csv";
		File csvfile = new File(csvurl);
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream("C://xdd/Java評量_第6題cars.csv"));
				OutputStreamWriter csvout = new OutputStreamWriter(new FileOutputStream(csvfile), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter csvbw = new BufferedWriter(csvout)) {
			br.readLine();
			List<Map<String, Object>> carMapList = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				String item[] = line.split(splitby);
				String manufacturer = item[0].trim();// 移除空格
				String TYPE = item[1].trim();
				double minPrice = Double.parseDouble(item[2].trim());// 把string 轉double
				double price = Double.parseDouble(item[3].trim());
				Map<String, Object> carMap = new HashMap<>();
				carMap.put("manufacturer", manufacturer);
				carMap.put("type", TYPE);
				carMap.put("minprice", minPrice);
				carMap.put("price", price);
				carMapList.add(carMap);
			}

			Collections.sort(carMapList, new Comparator<Map<String, Object>>() {

				@Override

				public int compare(Map<String, Object> o1, Map<String, Object> o2) {
					BigDecimal d1 = new BigDecimal(String.valueOf(o1.get("price")));
					BigDecimal d2 = new BigDecimal(String.valueOf(o2.get("price")));
					return d2.compareTo(d1);

				}

			});
			System.out.println(carMapList);
			StringBuilder sb = new StringBuilder();
			sb.append("manufacturer").append(",").append("type").append(",").append("min.price").append(",")
					.append("price").append("\n");
			for (Map<String, Object> map : carMapList) {
				sb.append(map.get("manufacturer")).append(",").append(map.get("type")).append(",")
						.append(map.get("minprice")).append(",").append(map.get("price")).append("\n");
			}
			csvbw.write(sb.toString());
			TreeSet<String> manuSet = new TreeSet<String>();
			for (Map<String, Object> map : carMapList) {
				manuSet.add((String) (map.get("manufacturer")));
			}
			System.out.printf("manufacturer  " + "  type    " + "      min.price " + "price" + "\n");
			BigDecimal minprice_total = new BigDecimal(0);
			BigDecimal price_total = new BigDecimal(0);
			for (String string : manuSet) {
				BigDecimal minprice = new BigDecimal(0);
				BigDecimal price = new BigDecimal(0);

				for (Map<String, Object> map : carMapList) {
					if (string.equals((String) (map.get("manufacturer")))) {
						BigDecimal objtobig_minprice = new BigDecimal(String.valueOf(map.get("minprice")));
						minprice = minprice.add(objtobig_minprice);
						BigDecimal objtobig_price = new BigDecimal(String.valueOf(map.get("price")));
						price = price.add(objtobig_price);
						System.out.printf("%-10s\t%-10s%10s%10s", map.get("manufacturer"), map.get("type"),
								map.get("minprice"), map.get("price") + "\n");
						minprice_total = minprice_total.add(objtobig_minprice);
						price_total = price_total.add(objtobig_price);

					}
				}
				System.out.printf("%s\t\t\t\t%s\t %s", "小計", minprice, price);
				System.out.println("");
			}

			System.out.println("合計                             " + minprice_total + "    " + price_total);
		}
		;

	}
}