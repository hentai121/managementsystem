/**
 * 
 */
package com.fdzcxy.domain;

/**
 * @author uerax
 *
 */
public class Employee implements Comparable<Employee>{
	
	/**
	 * 员工号
	 */
	private String employeePayrollNumber;
	
	/**
	 * 电话
	 */
	private String telephoneNumber;
	
	/**
	 * 姓
	 */
	private String lastName;
	
	/**
	 * 名
	 */
	private String firstName;
	
	/**
	 * 职位
	 */
	private String initial;
	
	/**
	 * 部门号码
	 */
	private String departmentNumber;
	
	/**
	 * 职称
	 */
	private String jobTitle;
	
	/**
	 * 雇用日期
	 */
	private String dateOfHiring;

	public String getEmployeePayrollNumber() {
		return employeePayrollNumber;
	}

	public void setEmployeePayrollNumber(String employeePayrollNumber) {
		this.employeePayrollNumber = employeePayrollNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDateOfHiring() {
		return dateOfHiring;
	}

	public void setDateOfHiring(String dateOfHiring) {
		this.dateOfHiring = dateOfHiring;
	}
	
	public void formatToString() {
//		System.out.println(this.employeePayrollNumber + "\t\t" + this.telephoneNumber
//				+ "\t\t" + this.lastName + "\t\t" + this.firstName + "\t\t" + this.initial + "\t\t"
//				+ this.departmentNumber + "\t\t" + this.jobTitle + "\t\t" + this.dateOfHiring);
		System.out.printf("%-15s%-15s%-10s%-10s%-15s%-10s%-25s%-15s\n", this.getFirstName(), 
				this.getLastName(), this.getInitial(), this.getEmployeePayrollNumber(), this.getTelephoneNumber(), 
				this.getDepartmentNumber(), this.getJobTitle(), this.getDateOfHiring());
	}

	@Override
	public String toString() {
		return this.employeePayrollNumber + ":" + this.telephoneNumber
				+ ":" + this.lastName + ":" + this.firstName + ":" + this.initial + ":"
				+ this.departmentNumber + ":" + this.jobTitle + ":" + this.dateOfHiring;
	}
	
	public void nameAndTel() {
		System.out.println(this.firstName + "," + this.lastName + "," + this.telephoneNumber);
	}
	
	public void formatNameAndTel() {
		//System.out.println(this.firstName + "\t" + this.lastName + "\t" + this.telephoneNumber);
		System.out.printf("%-15s%-15s%-15s\n", this.firstName, this.lastName, this.telephoneNumber);
	}
	
	public boolean serch(String str) {
		
		if (str.equals(this.dateOfHiring)) return true;
		else if (str.equals(this.lastName)) return true;
		else if (str.equals(this.employeePayrollNumber)) return true;
		else if (str.equals(this.firstName)) return true;
		else if (str.equals(this.initial)) return true;
		else if (str.equals(this.telephoneNumber)) return true;
		else if (str.equals(this.departmentNumber)) return true;
		else if (str.equals(this.jobTitle)) return true;
		
		return false;
	}
	
	
	@Override
	public int hashCode() {
		
		return this.firstName.hashCode() + this.employeePayrollNumber.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj instanceof Employee) {
			Employee otherEmployee = (Employee) obj;
			return this.firstName.equals(otherEmployee.firstName) && this.employeePayrollNumber.equals(otherEmployee.employeePayrollNumber);
		}
		return false;
	}

	@Override
	public int compareTo(Employee o) {
		if (!this.firstName.equals(o.firstName)) {
			return this.firstName.compareTo(o.firstName);
		} else {
			return 0;
		}
	}
	
}
