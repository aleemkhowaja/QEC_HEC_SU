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
import com.qec.dto.CampusesDTO;
import com.qec.dto.DepartmentsDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.dto.UserDTO;
import com.qec.enums.AccountStatus;
import com.qec.service.CampusesService;
import com.qec.service.DepartmentsService;
import com.qec.service.EmployeesService;
import com.qec.service.UsersService;

@Controller
public class CoordinatorController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private DepartmentsService departmentsService;
	
	@Autowired
	private CampusesService campusesService;
	
	@Autowired
	private EmployeesService employeesService;
	
	/**
	 * return Coordinator Page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/coordinator/coordinator.htm", method=RequestMethod.GET)
	public String getCoordinatiorPage(Model model) throws Exception {
		
		List<DepartmentsDTO> departmentsDTOs = departmentsService.returnAllDepartments();
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		List<CampusesDTO> campusesDTOs = campusesService.returnAllCampuses();
		model.addAttribute("user", new UserDTO());
		model.addAttribute("departmentsList", departmentsDTOs);
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("campusesList", campusesDTOs);
		return "CoordinatorList";
		
	}
	
	/**
	 * return all coordinators for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/coordinator/returnAllCoordinatorsForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<UserDTO> returnAllCoordinatorsForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		return usersService.returnAllUsersForGrid(request);
	}
	
	/**
	 * save record of Coordinator
	 * @param userDTO
	 * @return
	 */
	@RequestMapping(value="/coordinator/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveCoordinator(@RequestBody UserDTO userDTO, HttpServletRequest request) {
	    String result = usersService.saveUserModel(userDTO); 
		return result; 
	}
	
	/**
	 * return Coordinator by id
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/coordinator/returnCoordinatorById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public UserDTO  returnCoordinatorById(@RequestParam("userId") Integer userId) {
		UserDTO userDTO = usersService.getUserModelById(Long.valueOf(userId)); 
		return userDTO;
	}
	
	/**
	 * delete coordinator by id
	 * @param userDTO
	 * @return
	 */
	@RequestMapping(value="/coordinator/deleteCoordinatorById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteCoordinatorById(@RequestBody UserDTO userDTO) {
		String result = usersService.deleteUserModel(userDTO);
		return result;
	}

	public void setUserService(UsersService usersService) 
	{
		this.usersService = usersService;
	}
}
