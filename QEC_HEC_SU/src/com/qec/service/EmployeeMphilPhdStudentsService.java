package com.qec.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.EmployeeMphilPhdStudentsDTO;

public interface EmployeeMphilPhdStudentsService
{
	
	/**
	 * return All EmployeeMphil/PhdStudents
	 * @param request
	 * @return
	 */
    public JQGridDTO<EmployeeMphilPhdStudentsDTO> returnAllEmployeeMphilPhdStudentsForGrid(HttpServletRequest request);

    /**
     * return EmployeeMphil/PhdStudents By employeeMphilPhdStudentsId
     * @param CitationChapterId
     * @return
     */
    public EmployeeMphilPhdStudentsDTO returnEmployeeMphilPhdStudentsById(Long employeeMphilPhdStudentsId);
    
    /**
     * save EmployeeMphilPhdStudents
     * @param EmployeeMphilPhdStudentsDTO
     * @return
     */
    public String saveEmployeeMphilPhdStudents(MultipartHttpServletRequest request);	
    
    /**
     * delete EmployeeMphilPhdStudents
     * @param employeeMphilPhdStudentsId
     * @return
     */
	public String deleteEmployeeMphilPhdStudents(Long employeeMphilPhdStudentsId);
	
	/**
	 * return All Employee MphilPhd Students
	 * @return
	 */
	public List<EmployeeMphilPhdStudentsDTO> returnAllEmployeeMphilPhdStudents();
}
