package com.qec.repository;

import java.util.List;
import com.qec.model.EmployeeMphilPhdStudentsModel;

public interface EmployeeMphilPhdStudentsRepository  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param employeeMphilPhdStudents
	 * @return
	 */
	public List<EmployeeMphilPhdStudentsModel> returnAllEmployeeMphilPhdStudentsModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  employeeMphilPhdStudents) throws Exception;
	
	/**
	 * return Count of EmployeeMphilPhdStudentsModel 
	 * @param employeeMphilPhdStudents
	 * @return
	 */
	public Long returnAllEmployeeMphilPhdStudentsModelForGridCount(String employeeMphilPhdStudents) throws Exception;
	
	
	/**
	 * 
	 * @param employeeMphilPhdStudentsId
	 * @return
	 */
	public EmployeeMphilPhdStudentsModel returnEmployeeMphilPhdStudentsModelById(Long employeeMphilPhdStudentsId) throws Exception;
	

	/**
	 * return All citation Thesis Models
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeMphilPhdStudentsModel> returnAllEmployeeMphilPhdStudentsModels() throws Exception;

}
