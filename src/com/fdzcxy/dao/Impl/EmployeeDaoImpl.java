/**
 * 
 */
package com.fdzcxy.dao.Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import com.fdzcxy.dao.EmployeeDao;
import com.fdzcxy.domain.Employee;

/**
 * @author uerax
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {
	
	private ArrayList<Employee> list = new ArrayList<>();
	private TreeSet<Employee> set = new TreeSet<>();

	/**
	 * 
	 */
	public EmployeeDaoImpl(File file) throws IOException {
		this.readData(file);
		set.addAll(list);
	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.dao.EmployeeDao#select(com.fdzcxy.domain.Employee)
	 */
	@Override
	public void select() {
		
		for (Employee o : list) {
			System.out.println(o);
		}

	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.dao.EmployeeDao#selectFormat(com.fdzcxy.domain.Employee)
	 */
	@Override
	public void selectFormat() {
		
		for (Employee o : set) {
			o.formatToString();
		}

	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.dao.EmployeeDao#selectNameAndPhoneNumber(com.fdzcxy.domain.Employee)
	 */
	@Override
	public void selectNameAndPhoneNumber() {
		
		for (Employee o : list) {
			o.nameAndTel();
		}

	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.dao.EmployeeDao#selectNameAndPhoneNumberFomate(com.fdzcxy.domain.Employee)
	 */
	@Override
	public void selectNameAndPhoneNumberFomate() {
		
		for (Employee o : set) {
			o.formatNameAndTel();
		}

	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.dao.EmployeeDao#selectByKeyword(com.fdzcxy.domain.Employee)
	 */
	@Override
	public void selectByKeyword() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter keyword: ");
		
		String str = s.nextLine();
		
		
		for (Employee o : list) {
			
			if (o.serch(str)) {
				
				System.out.println("\n" + o);
				System.out.println();
				return;
			}
		}
		
		System.out.println("Keyword – " + str + " - not found");
		

	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.dao.EmployeeDao#insert(com.fdzcxy.domain.Employee)
	 */
	@Override
	public void insert() {
		
		Scanner s = new Scanner(System.in);
		String str;
		Employee employee = new Employee();
		
		System.out.println("– Employee Records:");
		System.out.println("======================================\n");
		System.out.println("Employee Record Additions:\n");
		System.out.println("Enter the following details of the new employee:\n");
		System.out.println("Employee 3 digit payroll number");
		System.out.println("Phone Number");
		System.out.println("Last Name");
		System.out.println("First Name");
		System.out.println("Middle Init");
		System.out.println("Dept #");
		System.out.println("Job Title");
		System.out.println("Date Hired\n");
		
		//员工号输入检测
		payroll: while (true) {
			
			System.out.print("Enter employee 3 digit payroll number: ");
			
			str = s.nextLine();
			
			//检测用户是否只输入回车
			if (str.length() == 0) {
				
				System.out.println("No payroll number entered – try again");
				continue;
			}
			
			String payrollNumberRegex = "\\d{3}";
			
			if (str.matches(payrollNumberRegex)) {
				for (Employee em : list) {
					if (str.equals(em.getEmployeePayrollNumber())) {
						System.out.println("工号已存在请输入其他工号");
						continue payroll;
					}
				}
				employee.setEmployeePayrollNumber(str);
				break;
			}
		}
			
			
//			try {
//				if (Integer.parseInt(str) > 99 && Integer.parseInt(str) < 1000) {
//					
//					for (Employee em : list) {
//						if (str.equals(em.getEmployeePayrollNumber())) {
//							System.out.println("工号已存在请输入其他工号");
//							continue payroll;
//						}
//					}
//					
//					employee.setEmployeePayrollNumber(str);
//					break;
//				}
//			} catch (NumberFormatException e) {
//				System.out.println("Payroll number can contain only numerical characters");
//			}
//		}
		
		//员工电话号检测
		while (true) {
			
			System.out.print("Enter Phone Number (02-12345678): ");
				
			str = s.nextLine();
				
			if (str.length() == 0) {
				System.out.println("No phone number entered – try again");
				continue;
			}
			
			String telRegex = "^0[2-8]-[1-9]\\d{7}$";
		
			if (str.matches(telRegex)) {
				employee.setTelephoneNumber(str);
				break;
			} 
			else {
				System.out.println("Invalid phone number – try again");
				continue;
			}
			
		}
		
		//员工姓检测
		while (true) {
			
			System.out.print("Enter First Name: ");
			
			str = s.nextLine();
				
			if (str.length() == 0) {
				System.out.println("No first name entered – try again");
				continue;
			}
			
			String firNameRegex = "[a-zA-Z\\s+]*";
			
			if (str.matches(firNameRegex)) {
				employee.setFirstName(str);
				break;
			}
			else {
				System.out.println("First name can contain only alphabetical characters and spaces");
				continue;
			}
		}
		
		//员工名检测
		while (true) {
			
			System.out.print("Enter Last Name: ");
			
			str = s.nextLine();
				
			if (str.length() == 0) {
				System.out.println("No last name entered – try again");
				continue;
			}
			
			String lastNameRegex = "[a-zA-Z\\s+]*";
			
			if (str.matches(lastNameRegex)) {
				employee.setLastName(str);
				break;
			}
			else {
				System.out.println("Last name can contain only alphabetical characters and spaces");
				continue;
			}
		}
		
		//职位检测
		while (true) {
			
			System.out.print("Enter Middle Init: ");
			
			str = s.nextLine();
				
			if (str.length() == 0) {
				System.out.println("No Middle Init entered – try again");
				continue;
			}
			
			String initRegex = "[a-zA-Z\\s+]*";
			
			if (str.matches(initRegex)) {
				employee.setLastName(str);
				break;
			}
			else {
				System.out.println("Middle Init can contain only alphabetical characters and spaces");
				continue;
			}
		}
		
		
		//部门号码检测
		while (true) {
			
			System.out.print("Enter Dept #: ");
			
			str = s.nextLine();
				
			if (str.length() == 0) {
				System.out.println("No Dept # entered – try again");
				continue;
			}
			
			String deptRegex = "[0-9]+";
			
			if (str.matches(deptRegex)) {
				employee.setDepartmentNumber(str);
				break;
			} 
			else {
				System.out.println("Dept # can contain only digits with no spaces");
				continue;
			}
		
		}
		
		//职称检测
		while (true) {
			
			System.out.print("Enter Job Title: ");
			
			str = s.nextLine();
				
			if (str.length() == 0) {
				System.out.println("No Job title entered – try again");
				continue;
			}
			
			String jobTitleRegex = "[a-zA-Z\\s+]*";
			
			if (str.matches(jobTitleRegex)) {
				employee.setJobTitle(str);
				break;
			}
			else {
				System.out.println("Job title can contain only alphabetical characters and spaces");
				continue;
			}
			
		}
		
		//日期检测
		while (true) {
			
			System.out.print("Enter Date Hired (dd-mm-yyyy): ");
			
			str = s.nextLine();
				
			if (str.length() == 0) {
				System.out.println("No date hired entered – try again ");
				continue;
			}
			
			String dateRegex = "^[0-3]\\d-[0-1]\\d-\\d{4}";
			
			if (str.matches(dateRegex)) {
				//进行日期有效性检测
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				try {
					//严格检测日期
					sdf.setLenient(false);
					//将str转换为相同format的日期格式, 如果不符合则抛出异常
					sdf.parse(str);
					break;
				} catch (ParseException e) {
					System.out.println("Invalid Date Hired");
					continue;
				}
				
			}
			else {
				System.out.println("Invalid Date Hired");
				continue;
			}
		}
		
		list.add(employee);
		System.out.println("Record Saved");
	}
	
	
	

	/* (non-Javadoc)
	 * @see com.fdzcxy.dao.EmployeeDao#delete(java.lang.String)
	 */
	@Override
	public void delete() {
		
		Scanner s = new Scanner(System.in);
		String str;
		
		System.out.println("– Employee Records:");
		System.out.println("======================================\n");
		System.out.println("Employee Record Deletion:\n");
		
		payroll: while (true) {
			
			System.out.print("Enter employee 3 digit payroll number: ");
			
			str = s.nextLine();
			
			//检测用户是否只输入回车
			if (str.length() == 0) {
				
				System.out.println("No payroll number entered – try again");
				continue;
			}
			
			String payrollNumberRegex = "\\d{3}";
			
			if (str.matches(payrollNumberRegex)) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getEmployeePayrollNumber().equals(str)) {
						System.out.println(list.get(i).toString());
						System.out.print("Confirm record deletion, (y)es or (n)o : ");
						Scanner scan = new Scanner(System.in);
						if (scan.nextLine().equals("y")) {
							list.remove(i);
							System.out.print("Delete another? (y)es or (n)o :");
							if (scan.nextLine().equals("y")) {
								continue payroll;
							}
							break payroll;
						} else {
							continue payroll;
						}
						
						
					}
				}
				break;
			}
		}

		
	}

	@Override
	public void readData(File f) throws IOException {
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			String s = "";
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			
			while ((s = br.readLine()) != null) {
				String[] str = s.split(":");
				Employee e = new Employee();
				e.setEmployeePayrollNumber(str[0]);
				e.setTelephoneNumber(str[1]);
				e.setFirstName(str[2]);
				e.setLastName(str[3]);
				e.setInitial(str[4]);
				e.setDepartmentNumber(str[5]);
				e.setJobTitle(str[6]);
				e.setDateOfHiring(str[7]);
				list.add(e);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
		} catch (IOException e) {
			System.out.println("文件读取失败");
		} catch (Exception e) {
			System.out.println("存在未知错误");
		} finally {
			if (br != null) br.close();
			if (isr != null) isr.close();
			if (fis != null) fis.close();
		}
		
		
	}

	@Override
	public void writeData(File f) throws IOException {
		
		FileWriter fw = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			
			fw = new FileWriter(f);
			
			for (Employee e : list) {
				sb.append(e.toString()).append("\n");
			}
			
			fw.write(sb.toString());
		} catch (IOException e) {
			System.out.println("文件写入错误");
		} finally {
			if (fw != null) {
				fw.close();
			}
		}
		
		
	}

}
