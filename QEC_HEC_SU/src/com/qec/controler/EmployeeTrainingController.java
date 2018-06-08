package com.qec.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qec.common.JQGridDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.dto.EmployeeTrainingDTO;
import com.qec.service.EmployeeTrainingService;

@Controller
public class EmployeeTrainingController {

	@Autowired
	private EmployeeTrainingService employeeTrainingService;
	
	/**
	 * return all Employee Training Models from employee table for grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/employeeTraining/returnAllEmployeeTrainingForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<EmployeeTrainingDTO> returnAllEmployeeTrainingForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return employeeTrainingService.returnAllEmployeeTrainingsForGrid(request);
	}
	
	/**
	 * save Employee Training
	 * @param employeeTrainingDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value="qec/employeeTraining/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveEmployeeTraining(MultipartHttpServletRequest request, HttpServletResponse respons) 
	{
		String result = employeeTrainingService.saveEmployeeTraining(request);
		return result; 
	}
	
	/**
	 * return Employee Training Record by id
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="qec/employeeTraining/returnEmployeeTrainingById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public EmployeeTrainingDTO  returnEmployeeTrainingById(@RequestParam("employeeTrainingId") Long employeeTrainingId) 
	{
		EmployeeTrainingDTO employeeTrainingDTO = employeeTrainingService.returnEmployeesTrainingById(employeeTrainingId); 
		return employeeTrainingDTO;
	}
	
	/**
	 * delete Employee Training Record by id
	 * @param userDTO
	 * @return
	 */
	@RequestMapping(value="qec/employeeTraining/deleteEmployeeTrainingById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteEmployeeTrainingById(@RequestParam("employeeTrainingId") Long employeeTrainingId) 
	{
		String result = employeeTrainingService.deleteEmployeesTraining(employeeTrainingId);
		return result;
	}

}
