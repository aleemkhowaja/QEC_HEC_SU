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
    public JQGridDTO<EmployeeDTO> returnAllEmployeesForGrid(HttpServletRequest request) throws Exception ;
    
    /**
     * insert record in Employee table
     * @param employeeDTO
     * @return
     */
    public String saveEmployee(EmployeeDTO employeeDTO) throws Exception ;
	
    /**
     * delete record from employee table
     * @param departmentsModel
     * @return
     */
	public String deleteDepartment(DepartmentsModel departmentsModel) throws Exception ;

	/**
	 * return Employee by employee id
	 * @param EmployeesId
	 * @return
	 */
    public EmployeeDTO returnEmployeesById(Integer EmployeesId) throws Exception ;

    /**
     * return all employee models
     * @return
     */
    public List<EmployeeDTO> returnAllEmployeeModels() throws Exception ;
}
