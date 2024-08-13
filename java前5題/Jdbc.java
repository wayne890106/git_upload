package com.cathaybk.practice.nt50344;

/*
 * 第七
 */
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

public class Jdbc {

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	private static final String USER_NAME = "student";

	private static final String PASSWORD = "student123456";

	private static final String SELECT_CARS_SQL = "select * from STUDENT.CARS where MANUFACTURER = ? or MANUFACTURER = ?";
	private static final String QUERY_CARS_SQL = "select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";
	private static final String INSERT_CARS_SQL = "INSERT INTO STUDENT.CARS(MANUFACTURER,TYPE,MIN_PRICE,PRICE) VALUES (?,?,?,?)";
	private static final String UPDATE_CARS_SQL = "UPDATE STUDENT.CARS SET MIN_PRICE = ?, PRICE = ? WHERE MANUFACTURER = ? AND TYPE = ? ";
	private static final String DELETE_CARS_SQL = "DELETE FROM STUDENT.CARS WHERE MANUFACTURER = ? AND TYPE = ?";

	public static void main(String[] args) {
		// 1. 取得連線
		// 2. 寫入 SQL 指令
		/*
		 * 查所有的包含新增的
		 */
//		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
//				PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS");) {
//
//			// 3. 執行 SQL（上一步寫入的）指令
//			ResultSet rs = pstmt.executeQuery(); // ResultSet物件儲存查詢結果
//
//			List<Map<String, String>> carMapList = new ArrayList<>();
//			while (rs.next()) {
//				Map<String, String> carMap = new HashMap<>();
//				carMap.put("MANUFACTURER", rs.getString("MANUFACTURER")); // rs.getString("DB_COLUMN_NAME")
//				carMap.put("TYPE", rs.getString("TYPE"));
//				carMap.put("MIN_PRICE", rs.getString("MIN_PRICE"));
//				carMap.put("PRICE", rs.getString("PRICE"));
//				carMapList.add(carMap);
//			}
//			StringBuilder sb = new StringBuilder();
//			for (Map map : carMapList) {
//				sb.append("製造商:").append(map.get("MANUFACTURER")).append(",").append("tpye:").append(map.get("TYPE")).append(",").append("minprice:")
//						.append(map.get("MIN_PRICE")).append(",").append("price:").append(map.get("PRICE")).append("\n");
//			}
//			System.out.println(sb.toString());
//			sb.setLength(0);

		/*
		 * 查原有的(BMW、TOYOTA)
		 */

		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL);) {
			pstmt.setString(1, "Toyota");
			pstmt.setString(2, "BMW");

			// 3. 執行 SQL（上一步寫入的）指令
			ResultSet rs = pstmt.executeQuery(); // ResultSet物件儲存查詢結果

			List<Map<String, String>> carMapList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> carMap = new HashMap<>();
				carMap.put("MANUFACTURER", rs.getString("MANUFACTURER")); // rs.getString("DB_COLUMN_NAME")
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

			if (functionString.equals("select")) {
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
					ResultSet rs1 = pstmt1.executeQuery(); // ResultSet物件儲存查詢結果
					List<Map<String, String>> carMapList1 = new ArrayList<>();
					while (rs1.next()) {
						Map<String, String> carMap = new HashMap<>();
						carMap.put("MANUFACTURER", rs1.getString("MANUFACTURER")); // rs.getString("DB_COLUMN_NAME")
						carMap.put("TYPE", rs1.getString("TYPE"));
						carMap.put("MIN_PRICE", rs1.getString("MIN_PRICE"));
						carMap.put("PRICE", rs1.getString("PRICE"));
						carMapList1.add(carMap);
					}
					for (Map<String, String> map : carMapList1) {
						sb.append(map.get("MANUFACTURER")).append(",").append(map.get("TYPE")).append(",")
								.append(map.get("MIN_PRICE")).append(",").append(map.get("PRICE")).append("\n");
					}
					System.out.println(sb.toString());
					sb.setLength(0);
				} catch (Exception e) {
					System.out.println("no");
				}

			} else if (functionString.equals("insert")) {
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
						pstmt1.executeUpdate(); // ResultSet物件儲存查詢結果
						conn1.commit();
						System.out.println("新增成功");

					} catch (Exception e) {
						try {
							conn1.rollback();
							System.out.println("新增失敗");
						} catch (SQLException sqle) {
							sqle.printStackTrace();
						}
						e.printStackTrace();

					}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			} else if (functionString.equals("update")) {
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
						pstmt1.executeUpdate(); // ResultSet物件儲存查詢結果
						conn1.commit();
						System.out.println("成功");

					} catch (Exception e) {
						try {
							conn1.rollback();
							System.out.println("新增失敗");
						} catch (SQLException sqle) {
							sqle.printStackTrace();
						}
						e.printStackTrace();

					}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			} else if (functionString.equals("delete")) {
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
						pstmt1.executeUpdate(); // ResultSet物件儲存查詢結果
						conn1.commit();
						System.out.println("成功");

					} catch (Exception e) {
						try {
							conn1.rollback();
							System.out.println("失敗");
						} catch (SQLException sqle) {
							sqle.printStackTrace();
						}
						e.printStackTrace();

					}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}