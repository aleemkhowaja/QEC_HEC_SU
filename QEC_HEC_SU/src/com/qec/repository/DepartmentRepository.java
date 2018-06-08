package com.qec.repository;

import java.util.List;

import com.qec.model.DepartmentsModel;


public interface DepartmentRepository {
	
	/**
	 * return all department for Grid
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param departmentName
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentsModel> returnAllDepartmentForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String departmentName) throws Exception;
	
	/**
	 * delete department
	 * @param departmentId
	 */
	public void deleteDepartment(Integer departmentId);
	
	/**
	 * return Department By departmentId
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public DepartmentsModel returnDepartmentById(Long departmentId) throws Exception;
	
	/**
	 * return all departments
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentsModel> returnAllDepartments() throws Exception;
	
	/**
	 * return all department count
	 * @param departmentName
	 * @return
	 */
	public Long returnAllDepartmentForGridCount(String departmentName);

}
