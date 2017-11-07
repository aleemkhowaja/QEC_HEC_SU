package com.qec.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qec.common.JTableList;
import com.qec.model.EmployeeModel;

public interface EmployeeDAO {

	 public JTableList<EmployeeModel> returnAllEmployeesForGrid(HttpServletRequest request);

	    public EmployeeModel returnEmployeesById(Long EmployeesId);
	    
	    public List<EmployeeModel> returnAllEmployeeModels();
}
