package com.qec.dao;

import java.util.List;

import com.qec.model.DepartmentsModel;


public interface DepartmentDAO {
	
	public List<DepartmentsModel> returnAllDepartmentForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String departmentName) throws Exception;
	
	public void deleteDepartment(Integer departmentId);
	
	public DepartmentsModel returnDepartmentById(Long departmentId) throws Exception;
	
	public List<DepartmentsModel> returnAllDepartments() throws Exception;
	
	public Long returnAllDepartmentForGridCount(String departmentName);

}
