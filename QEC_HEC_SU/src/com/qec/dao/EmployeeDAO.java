package com.qec.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qec.common.JTableList;
import com.qec.model.EmployeeModel;

public interface EmployeeDAO {

	/**
	 * return employee records from employee Table for employee grid
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param departmentName
	 * @return
	 */
	 public List<EmployeeModel> returnAllEmployeesForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
				String order, String employeeName) throws Exception;

	 /**
	  * return number of record in from employee table for employee Grid
	  * @param employeeName
	  * @return
	  * @throws Exception
	  */
	 public Long returnAllEmployeeForGridCount(String employeeName) throws Exception ;
	 
	 /**
	  * return EmployeeModel by id
	  * @param EmployeesId
	  * @return
	  */
	 public EmployeeModel returnEmployeesById(Long EmployeesId) throws Exception;
	 
	 /**
	  * return all employee models
	  * @return
	  */
	 public List<EmployeeModel> returnAllEmployeeModels() throws Exception;
}
