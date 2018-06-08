package com.qec.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.EmployeeMphilPhdStudentsDTO;
import com.qec.service.EmployeeMphilPhdStudentsService;

@RestController
public class EmployeeMphilPhdStudentsController {

	@Autowired
	private EmployeeMphilPhdStudentsService employeeMphilPhdStudentsService;
	
	/**
	 * return all Employee Mphil/Phd Students Models from employee table for grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/employeeMphilPhdStudents/returnAllemployeeMphilPhdStudentsForGrid", produces = "application/json")
	public JQGridDTO<EmployeeMphilPhdStudentsDTO> returnAllEmployeeMphilPhdStudentsForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return employeeMphilPhdStudentsService.returnAllEmployeeMphilPhdStudentsForGrid(request);
	}
	
	/**
	 * save Employee Mphil/Phd Students
	 * @param employeeTrainingDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value="qec/employeeMphilPhdStudents/save.htm", method = RequestMethod.POST )
	public String saveEmployeeMphilPhdStudents(MultipartHttpServletRequest request, HttpServletResponse respons) 
	{
		String result = employeeMphilPhdStudentsService.saveEmployeeMphilPhdStudents(request);
		return result; 
	}
	
	/**
	 * return Employee Mphil/Phd Students Record by id
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="qec/employeeMphilPhdStudents/returnEmployeeMphilPhdStudentsById", method = RequestMethod.POST, produces = "application/json")
	public EmployeeMphilPhdStudentsDTO returnEmployeeMphilPhdStudentsById(@RequestParam("employeeMphilPhdStudentsId") Long employeeMphilPhdStudentsId) 
	{
		EmployeeMphilPhdStudentsDTO employeeMphilPhdStudentsDTO = employeeMphilPhdStudentsService.returnEmployeeMphilPhdStudentsById(employeeMphilPhdStudentsId); 
		return employeeMphilPhdStudentsDTO;
	}
	
	/**
	 * delete Employee Mphil/Phd Students Record by id
	 * @param userDTO
	 * @return
	 */
	@RequestMapping(value="qec/employeeMphilPhdStudents/deleteEmployeeMphilPhdStudentsById", method = RequestMethod.POST)
	public String  deleteEmployeeMphilPhdStudentsById(@RequestParam("employeeMphilPhdStudentsId") Long employeeMphilPhdStudentsId) 
	{
		String result = employeeMphilPhdStudentsService.deleteEmployeeMphilPhdStudents(employeeMphilPhdStudentsId);
		return result;
	}

}
