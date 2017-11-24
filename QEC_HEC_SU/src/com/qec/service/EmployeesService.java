package com.qec.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.qec.common.JQGridDTO;
import com.qec.common.JTableList;
import com.qec.dto.EmployeeDTO;
import com.qec.dto.UserDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;

public interface EmployeesService
{
	/**
	 * return employee records from employee Table for employee grid
	 * @param request
	 * @return
	 */
    public JQGridDTO<EmployeeDTO> returnAllEmployeesForGrid(HttpServletRequest request);
    
    /**
     * insert record in Employee table
     * @param employeeDTO
     * @return
     */
    public String saveEmployee(EmployeeDTO employeeDTO);
	
    /**
     * delete Employee Record
     * @param employeeDTO
     * @return
     */
	public String deleteEmployee(EmployeeDTO employeeDTO);

	/**
	 * return Employee by employee id
	 * @param EmployeesId
	 * @return
	 */
    public EmployeeDTO returnEmployeesById(Integer EmployeesId);

    /**
     * return all employee models
     * @return
     */
    public List<EmployeeDTO> returnAllEmployeeModels();
}
