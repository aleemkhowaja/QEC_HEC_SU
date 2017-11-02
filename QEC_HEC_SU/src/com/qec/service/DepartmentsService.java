package com.qec.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qec.common.JQGridDTO;
import com.qec.model.DepartmentsModel;
public interface DepartmentsService
{
    public JQGridDTO<DepartmentsModel> returnAllDepartmentsForGrid(HttpServletRequest request);
	
	public String saveDepartment(DepartmentsModel departmentsModel);
	
	public String deleteDepartment(DepartmentsModel departmentsModel);
	
	public DepartmentsModel getDepartmentById(Long departmentId);
	
	public List<DepartmentsModel> returnAllDepartments();
}
