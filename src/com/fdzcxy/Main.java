/**
 * 
 */
package com.fdzcxy;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fdzcxy.dao.Impl.EmployeeDaoImpl;

/**
 * @author uerax
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		File file = new File("records.txt");
		
		if (!file.exists()) {
			System.out.println("※Employee information data file not found! Now exit!§");
			System.exit(0);
		}
		
		Scanner s = new Scanner(System.in);
		String str = "q";
		EmployeeDaoImpl impl = new EmployeeDaoImpl(file);

		while (true) {
			
			System.out.println("Employee Information - Main Menu");
			System.out.println("=====================================================");
			System.out.println("1 - Print All Current Records");
			System.out.println("2 每 Print All Current Records (formatted)");
			System.out.println("3 每 Print Names and Phone Numbers");
			System.out.println("4 每 Print Names and Phone Numbers (formatted)");
			System.out.println("5 - Search for specific Record(s)");
			System.out.println("6 - Add New Records");
			System.out.println("7 每 Delete Records\n");
			System.out.println("Q - Quit\n");
			System.out.print("Your Selection: ");
			
			if ((str = s.nextLine()).length() == 0) {
				System.out.println("No selection entered.Press Enter to continue＃");
				s.nextLine();
				continue;
			}
			
			
			if (str.equals("Q") || str.equals("q")) break;
			
			
			try {
				switch(str) {
					case "1" : 
						impl.select();
						System.out.print("Press Enter to continue...");
						s.nextLine();
						break;
					case "2" :
						impl.selectFormat();
						System.out.print("Press Enter to continue...");
						s.nextLine();
						break;
					case "3" :
						impl.selectNameAndPhoneNumber();
						System.out.print("Press Enter to continue...");
						s.nextLine();
						break;
					case "4" :
						impl.selectNameAndPhoneNumberFomate();
						System.out.print("Press Enter to continue...");
						s.nextLine();
						break;
					case "5" :
						impl.selectByKeyword();
						System.out.print("Press Enter to continue...");
						s.nextLine();
						break;
					case "6" :
						impl.insert();
						System.out.print("Press Enter to continue...");
						s.nextLine();
						break;
					case "7" :
						impl.delete();
						System.out.print("Press Enter to continue...");
						s.nextLine();
						break;
					default :
						System.out.print("\"Invalid code! Press Enter to continue＃");
						s.nextLine();
						
				}
			} finally {
			
				impl.writeData(file);
			}
		}
		
		
		
		
		
		

	}

}
