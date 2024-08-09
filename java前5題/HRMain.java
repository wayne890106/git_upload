package com.cathaybk.practice.nt50344.b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class HRMain {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Supervisor("李中白", "資訊部", 65000));
		employeeList.add(new Supervisor("林小中", "理財部", 80000));
		for (Employee employee : employeeList) {
			employee.printInfo();
		}
		List<Employee> employeeList2 = new ArrayList<>();
		employeeList2.add(employeeList.get(2));
		employeeList2.add(employeeList.get(3));
		employeeList2.add(employeeList.get(0));
		employeeList2.add(employeeList.get(1));
		String csvurl = "C://xdd/output.csv";
		File csvfile = new File(csvurl);
		try (OutputStreamWriter csvout = new OutputStreamWriter(new FileOutputStream(csvfile), "utf-8");
				BufferedWriter csvbw = new BufferedWriter(csvout)) {
			StringBuilder sb = new StringBuilder();
			for (Employee employee : employeeList2) {
				String employee_nm = employee.getName();
				int employee_pay = employee.getPayment();
				sb.append(employee_nm).append(" , ").append(employee_pay).append("\n");

			}
			System.out.println(sb.toString());
			csvbw.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
