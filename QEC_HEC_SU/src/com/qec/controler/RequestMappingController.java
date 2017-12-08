package com.qec.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qec.dto.CampusesDTO;
import com.qec.dto.DepartmentsDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.dto.EventsDTO;
import com.qec.dto.UserDTO;
import com.qec.enums.EmployeeTitle;
import com.qec.enums.Gender;
import com.qec.enums.MaritalStatus;
import com.qec.enums.Religion;
import com.qec.model.DepartmentsModel;
import com.qec.model.UniProgramsModel;
import com.qec.service.CampusesService;
import com.qec.service.DepartmentsService;
import com.qec.service.EmployeesService;

@Controller
public class RequestMappingController {
	
	@Autowired
	private DepartmentsService departmentsService;
	
	@Autowired
	private CampusesService campusesService;
	
	@Autowired
	private EmployeesService employeesService;
	
	/**
	 * return login page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login.htm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView returnLoginPage(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) 
	{
		ModelAndView model = new ModelAndView();
		if (error != null) 
		{
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) 
		{
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.addObject("login", new UserDTO());
		model.setViewName("LoginPage");
		return model;
	}
	
	
	/**
	 * return dashboard Page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="qec/dashboard.htm", method=RequestMethod.GET)
	public ModelAndView returnDashboardPage() 
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
		return model;
	}
	
	/**
	 *  return department list page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/department/department.htm", method=RequestMethod.GET)
	public String getEmployeePage(Model model) 
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
	@RequestMapping(value="/qec/programs/programs.htm", method=RequestMethod.GET)
	public String returnUniProgramsPage(Model model) 
	{
		List<DepartmentsDTO> departmentsDTOs = departmentsService.returnAllDepartments();
		model.addAttribute("uniProgramsData", new UniProgramsModel());
		model.addAttribute("departmentsModelList", departmentsDTOs);
		return "UniProgramList";
	}
	
	/**
	 * return Coordinator Page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/coordinator/coordinator.htm", method=RequestMethod.GET)
	public String returnPage(Model model) 
	{
		List<DepartmentsDTO> departmentsDTOs = new ArrayList<DepartmentsDTO>();
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		List<CampusesDTO> campusesDTOs = new ArrayList<CampusesDTO>();
		try 
		{
			employeeDTOs    = employeesService.returnAllEmployeeModels();
			departmentsDTOs = departmentsService.returnAllDepartments();
			campusesDTOs    = campusesService.returnAllCampuses();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		model.addAttribute("user", new UserDTO());
		model.addAttribute("departmentsList", departmentsDTOs);
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("campusesList", campusesDTOs);
		return "CoordinatorList";
	}
	
	/**
	 * return event page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/event/event.htm", method=RequestMethod.GET)
	public String returnEventsPage(Model model) 
	{
		List<DepartmentsDTO> departmentsModels = departmentsService.returnAllDepartments();
		model.addAttribute("events", new EventsDTO());
		model.addAttribute("departmentsModelList", departmentsModels);
		return "EventList";
	}
	
	/**
	 * return employee page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/employee/employee.htm", method=RequestMethod.GET)
	public String returnEmployeePage(Model model) 
	{
		try 
		{
			EmployeeTitle employeeTitle[]= EmployeeTitle.values();
			Gender gender[] = Gender.values();
			MaritalStatus maritalStatus[] = MaritalStatus.values();
			Religion religion[] = Religion.values();
			List<DepartmentsDTO> departmentsDTOs = departmentsService.returnAllDepartments();
			
			model.addAttribute("employee", new EmployeeDTO());
			model.addAttribute("employeeTitleList",employeeTitle);
			model.addAttribute("genderList",gender);
			model.addAttribute("maritalStatusList",maritalStatus);
			model.addAttribute("religionList", religion);
			model.addAttribute("departmentList", departmentsDTOs);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "EmployeeList";
	}

}
