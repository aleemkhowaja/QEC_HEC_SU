package com.qec.repository;

import java.util.List;

import com.qec.model.FacultyModel;


public interface FacultyRepository {
	
	/**
	 * return all faculty for Grid
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param facultyName
	 * @return
	 * @throws Exception
	 */
	public List<FacultyModel> returnAllFacultyForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String facultyName) throws Exception;
	
	/**
	 * return Faculty By facultyId
	 * @param facultyId
	 * @return
	 * @throws Exception
	 */
	public FacultyModel returnFacultyById(Long facultyId) throws Exception;
	
	/**
	 * return all faculty
	 * @return
	 * @throws Exception
	 */
	public List<FacultyModel> returnAllFaculty() throws Exception;
	
	/**
	 * return all faculty count
	 * @param facultyName
	 * @return
	 */
	public Long returnAllFacultyForGridCount(String facultyName);

}
