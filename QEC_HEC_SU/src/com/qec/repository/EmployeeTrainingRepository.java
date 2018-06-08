package com.qec.repository;

import java.util.List;

import com.qec.model.EmployeeTrainingModel;

public interface EmployeeTrainingRepository  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param employeeTraining
	 * @return
	 */
	public List<EmployeeTrainingModel> returnAllEmployeeTrainingModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  employeeTraining) throws Exception;
	
	/**
	 * 
	 * @param employeeTrainingId
	 * @return
	 */
	public EmployeeTrainingModel returnEmployeeTrainingModelById(Long employeeTrainingId) throws Exception;
	

	/**
	 * return All citation Thesis Models
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeTrainingModel> returnAllEmployeeTrainingModel() throws Exception;

	/**
	 * return Count of EmployeeTrainingModel 
	 * @param employeeTraining
	 * @return
	 */
	public Long returnAllEmployeeTrainingModelForGridCount(String employeeTraining) throws Exception;
	
	
}
