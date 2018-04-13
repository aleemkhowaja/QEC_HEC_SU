package com.qec.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qec.common.JQGridDTO;
import com.qec.dto.FacultyDTO;
import com.qec.model.FacultyModel;
public interface FacultyService
{
	/**
	 * return All faculty for Grid
	 * @param request
	 * @return
	 */
	 public JQGridDTO<FacultyModel> returnAllFacultyForGrid(HttpServletRequest request);
		
	 /**
	  * save Faculty
	  * @param facultyDTO
	  * @return
	  */
	 public String saveFaculty(FacultyDTO facultyDTO);
		
	 /**
	  * delete Faculty
	  * @param facultyId
	  * @return
	  */
	 public String deleteFaculty(Integer facultyId);
		
	 /**
	  * return Faculty By Id
	  * @param facultyId
	  * @return
	  */
	 public FacultyModel returnFacultyById(Long facultyId);
		
	 /**
	  * return All Faculty
	  * @return
	  */
	 public List<FacultyDTO> returnAllFaculty();

}
