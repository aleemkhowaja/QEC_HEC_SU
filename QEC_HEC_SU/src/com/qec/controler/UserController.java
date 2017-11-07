package com.qec.controler;

import java.util.List;

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
import com.qec.dto.UniProgramsDTO;
import com.qec.dto.UserDTO;
import com.qec.model.CampusesModel;
import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;
import com.qec.model.UserModel;
import com.qec.service.CampusesService;
import com.qec.service.DepartmentsService;
import com.qec.service.EmployeesService;
import com.qec.service.UniProgramsService;
import com.qec.service.UsersService;

@Controller
public class UserController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private DepartmentsService departmentsService;
	
	/*@Autowired
	private CampusesService campusesService;*/
	
	@Autowired
	private EmployeesService employeesService;
	
	@RequestMapping(value="/qec/coordinator.htm", method=RequestMethod.GET)
	public String getUsersDetail(Model model) throws Exception {
		
		/*List<DepartmentsModel> departmentsModels = departmentsService.returnAllDepartments();*/
		List<EmployeeModel> employeeModels = employeesService.returnAllEmployeeModels();
		/*List<CampusesModel> campusesModels = campusesService.returnAllCampuses();*/
		model.addAttribute("userModel", new UserDTO());
		//model.addAttribute("departmentsModelList", departmentsModels);
		model.addAttribute("employeeModelsList", employeeModels);
		/*model.addAttribute("campusesModelsList", campusesModels);*/
		return "CoordinatorList";
		
	}
	
	@RequestMapping(value="/users/returnAllUsersForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<UserDTO> returnAllUsersForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		String a = request.getParameter("fullName");							 
		return usersService.returnAllUsersForGrid(request);
	}
	
	@RequestMapping(value="/users/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveUsers(@RequestBody UserDTO userDTO, HttpServletRequest request) {
	    String result = usersService.saveUserModel(userDTO); 
		return result; 
	}
	
	@RequestMapping(value="/users/getUsersById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public UserDTO  getUniProgramsById(@RequestParam("userId") Integer userId, Model model) {
		UserDTO userDTO = usersService.getUserModelById(Long.valueOf(userId)); 
		return userDTO;
	}
	@RequestMapping(value="/users/deleteUserById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteUserById(@RequestBody UserDTO userDTO, HttpServletRequest request) {
		String result = usersService.deleteUserModel(userDTO);
		return result;
	}

	public void setUserService(UsersService usersService) 
	{
		this.usersService = usersService;
	}
}
