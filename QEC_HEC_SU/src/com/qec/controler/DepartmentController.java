package com.qec.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qec.common.JQGridDTO;
import com.qec.dto.DepartmentsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.service.DepartmentsService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentsService departmentsService;
	
	//start get all department for Grid
	@RequestMapping(value="qec/department/returnAllDepartmentsForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<DepartmentsDTO> returnAllDepartmenForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return departmentsService.returnAllDepartmentsForGrid(request);
	}
	//end get all department for Grid
	
	/**
	 * save department in database
	 * @param departmentsModel
	 * @param request
	 * @return result either it is add record or update record
	 */
	@RequestMapping(value="/department/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String saveDepartment(@RequestBody DepartmentsDTO departmentsDTO, HttpServletRequest request) 
	{
		String result = departmentsService.saveDepartment(departmentsDTO);
		return result;
	}

	
	/**
	 * get DepartmentModel By departmentId
	 * @param departmentId
	 * @param model
	 * @return DepartmentModel
	 */
	@RequestMapping(value="/department/returnDepartmentById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public DepartmentsDTO  returnDepartmentById(@RequestParam("departmentId") Integer departmentId, Model model) 
	{
		DepartmentsDTO departmentsDTO = departmentsService.returnDepartmentById(Long.valueOf(departmentId));
		return departmentsDTO;
	}
	
	/**
	 * 
	 * @param departmentsModel
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/department/deleteDepartmentById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteDepartmentById(@RequestParam("departmentId") Integer departmentId, HttpServletRequest request) 
	{
		String result = departmentsService.deleteDepartment(departmentId);
		return result;
	}
}
