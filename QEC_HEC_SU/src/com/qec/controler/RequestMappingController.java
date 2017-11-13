package com.qec.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qec.dto.DepartmentsDTO;
import com.qec.dto.UserDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.UniProgramsModel;
import com.qec.model.UserModel;
import com.qec.service.DepartmentsService;

@Controller
public class RequestMappingController {
	
	@Autowired
	private DepartmentsService departmentsService;
	
	/*@RequestMapping(value="/qec/login.htm", method=RequestMethod.GET)
	public String returnLoginPage(Model model) 
	{
		UserModel userModel = new UserModel();
		model.addAttribute("LoginData", userModel);
		return "redirect:/index.jsp";
	}*/
	
	@RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public String returnIndexPage(Model model) 
	{
		model.addAttribute("login", new UserDTO());
		return "LoginPage";
	}
	
	/**
	 *  return department list page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/department/department.htm", method=RequestMethod.GET)
	public String getEmployeeDetail(Model model) 
	{
		model.addAttribute("departmentData", new DepartmentsModel());
		return "DepartmentList";
	}
	
	/**
	 * return programs list page
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/programs/programs.htm", method=RequestMethod.GET)
	public String getUniProgramsDetail(Model model) 
	{
		List<DepartmentsDTO> departmentsDTOs = departmentsService.returnAllDepartments();
		model.addAttribute("uniProgramsData", new UniProgramsModel());
		model.addAttribute("departmentsModelList", departmentsDTOs);
		return "UniProgramList";
	}


	
	public DepartmentsService getDepartmentsService() 
	{
		return departmentsService;
	}

	public void setDepartmentsService(DepartmentsService departmentsService) 
	{
		this.departmentsService = departmentsService;
	}
	
	

}
