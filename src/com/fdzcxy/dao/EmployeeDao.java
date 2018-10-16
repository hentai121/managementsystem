/**
 * 
 */
package com.fdzcxy.dao;

import java.io.File;

import com.fdzcxy.domain.Employee;

/**
 * @author uerax
 *
 */
public interface EmployeeDao {
	public void readData(File f) throws Exception;
	public void writeData(File f) throws Exception;
	public void select() throws Exception;
	public void selectFormat() throws Exception;
	public void selectNameAndPhoneNumber() throws Exception;
	public void selectNameAndPhoneNumberFomate() throws Exception;
	public void selectByKeyword() throws Exception;
	public void insert() throws Exception;
	public void delete() throws Exception;

}
