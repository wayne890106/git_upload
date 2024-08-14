package com.cathaybk.practice.nt50344;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 第七題
 */
public class Jdbc {

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	private static final String USER_NAME = "student";

	private static final String PASSWORD = "student123456";

	private static final String QUERY_CARS_SQL = "select MANUFACTURER,TYPE,MIN_PRICE,PRICE from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";
	private static final String INSERT_CARS_SQL = "insert into STUDENT.CARS(MANUFACTURER,TYPE,MIN_PRICE,PRICE) values (?,?,?,?)";
	private static final String UPDATE_CARS_SQL = "update STUDENT.CARS set MIN_PRICE = ?, PRICE = ? where MANUFACTURER = ? and TYPE = ? ";
	private static final String DELETE_CARS_SQL = "delete from STUDENT.CARS WHERE MANUFACTURER = ? and TYPE = ?";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn
						.prepareStatement("select MANUFACTURER,TYPE,MIN_PRICE,PRICE from STUDENT.CARS");) {

			// 執行 SQL（上一步寫入的）指令
			ResultSet rs = pstmt.executeQuery(); // ResultSet物件儲存查詢結果

			List<Map<String, String>> carMapList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> carMap = new HashMap<>();
				carMap.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				carMap.put("TYPE", rs.getString("TYPE"));
				carMap.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				carMap.put("PRICE", rs.getString("PRICE"));
				carMapList.add(carMap);
			}
			StringBuilder sb = new StringBuilder();
			for (Map<String, String> map : carMapList) {
				sb.append("製造商:").append(map.get("MANUFACTURER")).append(",").append("tpye:").append(map.get("TYPE"))
						.append(",").append("minprice:").append(map.get("MIN_PRICE")).append(",").append("price:")
						.append(map.get("PRICE")).append("\n");
			}
			System.out.println(sb.toString());
			sb.setLength(0);

			Scanner sc = new Scanner(System.in);
			System.out.println("輸入功能:");
			String functionString = sc.next();

			if ("select".equals(functionString)) {
				select_funtion();

			} else if ("insert".equals(functionString)) {
				insert_function();

			} else if ("update".equals(functionString)) {
				update_function();

			} else if ("delete".equals(functionString)) {
				delete_function();
			} else {
				System.out.println("輸入select、insert、update、delete");
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void delete_function() {
		try (Connection conn1 = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);) {
			try (PreparedStatement pstmt1 = conn1.prepareStatement(DELETE_CARS_SQL);
					Scanner scanner = new Scanner(System.in);) {
				conn1.setAutoCommit(false);
				System.out.println("輸入製造商:");
				String manuString = scanner.next();
				System.out.println("輸入type:");
				String typeString = scanner.next();
				pstmt1.setString(1, manuString);
				pstmt1.setString(2, typeString);
				// 3. 執行 SQL（上一步寫入的）指令
				int delete_int = pstmt1.executeUpdate();// 回傳更動的筆數
				conn1.commit();
				System.out.println("刪除成功變動:" + delete_int + "筆");

			} catch (Exception e) {
				try {
					conn1.rollback();// 有可能rollback失敗所以要再寫一層try-catch
					System.out.println("刪除失敗");
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
				e.printStackTrace();
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
	}

	private static void update_function() {
		try (Connection conn1 = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);) {
			try (PreparedStatement pstmt1 = conn1.prepareStatement(UPDATE_CARS_SQL);
					Scanner scanner = new Scanner(System.in);) {
				conn1.setAutoCommit(false);

				System.out.println("輸入製造商:");
				String manuString = scanner.next();
				System.out.println("輸入type:");
				String typeString = scanner.next();
				System.out.println("輸入min_price:");
				int minpriceString = scanner.nextInt();
				System.out.println("輸入price:");
				int priceString = scanner.nextInt();
				pstmt1.setString(3, manuString);
				pstmt1.setString(4, typeString);
				pstmt1.setInt(1, minpriceString);
				pstmt1.setInt(2, priceString);
				// 3. 執行 SQL（上一步寫入的）指令
				int update_int = pstmt1.executeUpdate();
				conn1.commit();
				System.out.println("更新成功變動:" + update_int + "筆");
			} catch (Exception e) {
				try {
					conn1.rollback();// 有可能rollback失敗所以要再寫一層try-catch
					System.out.println("更新失敗");
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
				e.printStackTrace();

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	private static void insert_function() {
		try (Connection conn1 = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);) {
			try (PreparedStatement pstmt1 = conn1.prepareStatement(INSERT_CARS_SQL);
					Scanner scanner = new Scanner(System.in);) {
				conn1.setAutoCommit(false);

				System.out.println("輸入製造商:");
				String manuString = scanner.next();
				System.out.println("輸入type:");
				String typeString = scanner.next();
				System.out.println("輸入min_price:");
				int minpriceString = scanner.nextInt();
				System.out.println("輸入price:");
				int priceString = scanner.nextInt();
				pstmt1.setString(1, manuString);
				pstmt1.setString(2, typeString);
				pstmt1.setInt(3, minpriceString);
				pstmt1.setInt(4, priceString);
				// 3. 執行 SQL（上一步寫入的）指令
				int insert_int = pstmt1.executeUpdate();
				conn1.commit();
				System.out.println("新增成功更動:" + insert_int + "筆");

			} catch (Exception e) {
				try {
					conn1.rollback();// 有可能rollback失敗所以要再寫一層try-catch
					System.out.println("新增失敗");
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
				e.printStackTrace();

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	private static void select_funtion() {
		try (Connection conn1 = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt1 = conn1.prepareStatement(QUERY_CARS_SQL);
				Scanner scanner = new Scanner(System.in);) {

			System.out.println("輸入製造商:");
			String manuString = scanner.next();
			System.out.println("輸入type:");
			String typeString = scanner.next();
			pstmt1.setString(1, manuString);
			pstmt1.setString(2, typeString);
			// 3. 執行 SQL（上一步寫入的）指令
			ResultSet rs1 = pstmt1.executeQuery(); // 回傳ResultSet物件儲存查詢結果
			List<Map<String, String>> carMapList1 = new ArrayList<>();
			while (rs1.next()) {
				Map<String, String> carMap = new HashMap<>();
				carMap.put("MANUFACTURER", rs1.getString("MANUFACTURER")); // rs.getString("DB_COLUMN_NAME")
				carMap.put("TYPE", rs1.getString("TYPE"));
				carMap.put("MIN_PRICE", rs1.getString("MIN_PRICE"));
				carMap.put("PRICE", rs1.getString("PRICE"));
				carMapList1.add(carMap);
			}
			StringBuilder sb = new StringBuilder();
			for (Map<String, String> map : carMapList1) {
				sb.append(map.get("MANUFACTURER")).append(",").append(map.get("TYPE")).append(",")
						.append(map.get("MIN_PRICE")).append(",").append(map.get("PRICE")).append("\n");
			}
			System.out.println(sb.toString());
			sb.setLength(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
