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
import com.qec.common.JQGridDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.dto.UserDTO;
import com.qec.service.EmployeesService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeesService employeesService;
	
	/**
	 * return all Employee Models from employee table for grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/employee/returnAllEmployeeForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<EmployeeDTO> returnAllEmployeeForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		JQGridDTO<EmployeeDTO> jqGridDTO = new JQGridDTO<EmployeeDTO>();
		try {
			jqGridDTO =  employeesService.returnAllEmployeesForGrid(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jqGridDTO;
	}
	
	
	@RequestMapping(value="qec/employee/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO, HttpServletRequest request) 
	{
		String result = "";
		try {
			result = employeesService.saveEmployee(employeeDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
	}
	
	/**
	 * return Coordinator by id
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="qec/employee/returnEmployeeById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public EmployeeDTO  returnCoordinatorById(@RequestParam("employeeId") Integer employeeId) 
	{
		EmployeeDTO employeeDTO = employeesService.returnEmployeesById(employeeId); 
		return employeeDTO;
	}
	
	/**
	 * delete coordinator by id
	 * @param userDTO
	 * @return
	 */
	@RequestMapping(value="qec/employee/deleteCoordinatorById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteCoordinatorById(@RequestBody UserDTO userDTO) 
	{
	//	String result = usersService.deleteUserModel(userDTO);
		return null;
	}

}
