package com.qec.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qec.common.JQGridDTO;
import com.qec.dto.DepartmentsDTO;
import com.qec.model.DepartmentsModel;
public interface DepartmentsService
{
	/**
	 * 
	 * @param request
	 * @return
	 */
    public JQGridDTO<DepartmentsDTO> returnAllDepartmentsForGrid(HttpServletRequest request);
	
    /**
     * 
     * @param departmentsDTO
     * @return
     */
	public String saveDepartment(DepartmentsDTO departmentsDTO);
	
	/**
	 * 
	 * @param departmentId
	 * @return
	 */
	public String deleteDepartment(Integer departmentId);
	
	/**
	 * 
	 * @param departmentId
	 * @return
	 */
	public DepartmentsDTO returnDepartmentById(Long departmentId);
	
	/**
	 * 
	 * @return
	 */
	public List<DepartmentsDTO> returnAllDepartments();
}
