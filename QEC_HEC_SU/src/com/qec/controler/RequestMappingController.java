package com.qec.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qec.dto.CampusesDTO;
import com.qec.dto.CitationBookDTO;
import com.qec.dto.CitationChapterDTO;
import com.qec.dto.CitationConferenceDTO;
import com.qec.dto.CitationGoogleDTO;
import com.qec.dto.CitationJournalDTO;
import com.qec.dto.CitationPatentDTO;
import com.qec.dto.CitationThesisDTO;
import com.qec.dto.DepartmentsDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.dto.EmployeeMphilPhdStudentsDTO;
import com.qec.dto.EmployeeTrainingDTO;
import com.qec.dto.EventsDTO;
import com.qec.dto.FacultyDTO;
import com.qec.dto.UserDTO;
import com.qec.enums.DegreeType;
import com.qec.enums.EmployeeTitle;
import com.qec.enums.Gender;
import com.qec.enums.HECRecognize;
import com.qec.enums.ImpactFactor;
import com.qec.enums.MaritalStatus;
import com.qec.enums.Religion;
import com.qec.model.DepartmentsModel;
import com.qec.model.FacultyModel;
import com.qec.model.UniProgramsModel;
import com.qec.service.CampusesService;
import com.qec.service.DepartmentsService;
import com.qec.service.EmployeesService;
import com.qec.service.FacultyService;

@Controller
public class RequestMappingController {
	
	@Autowired
	private FacultyService facultyService;
	
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
		@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) 
	{
		String ip = request.getLocalAddr();
		
		Map<String, String> result = new HashMap<>();

	    /*Enumeration headerNames = request.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	        String key = (String) headerNames.nextElement();
	        String value = request.getHeader(key);
	        System.out.println(key+" ++++++++++"+value);
	    }*/

	    
		System.out.println("ip:::"+ip);
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
	@RequestMapping(value="/qec/faculty/faculty.htm", method=RequestMethod.GET)
	public String getFacultyPage(Model model) 
	{
		model.addAttribute("facultyData", new FacultyDTO());
		return "FacultyList";
	}
	
	/**
	 *  return department list page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/department/department.htm", method=RequestMethod.GET)
	public String getDepartmentPage(Model model) 
	{
		List<FacultyDTO> facultyDTOs = facultyService.returnAllFaculty();
		model.addAttribute("facultyModelList", facultyDTOs);
		model.addAttribute("departmentData", new DepartmentsDTO());
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
		/*try 
		{*/
			employeeDTOs    = employeesService.returnAllEmployeeModels();
			departmentsDTOs = departmentsService.returnAllDepartments();
			campusesDTOs    = campusesService.returnAllCampuses();
		/*} catch (Exception e) 
		{
			e.printStackTrace();
		}*/
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
		/*try 
		{*/
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
		/*} catch (Exception e) 
		{
			e.printStackTrace();
		}*/
		return "EmployeeList";
	}
	
	/**
	 * return publication page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/publication/publication.htm", method=RequestMethod.GET)
	public String returnPublicationPage(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		ImpactFactor impactFactors[] = ImpactFactor.values();
		HECRecognize hecRecognize[] = HECRecognize.values();
		
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("impactFactorList", impactFactors);
		model.addAttribute("hecRecognizeList", hecRecognize);
		model.addAttribute("journal", new CitationJournalDTO());
		return "PublicationsList";
	}
	
	/**
	 * return Journal page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/publication/journal.htm", method=RequestMethod.GET)
	public ModelAndView returnJournalDetailsPage(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		ImpactFactor impactFactors[] = ImpactFactor.values();
		HECRecognize hecRecognize[] = HECRecognize.values();
		
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("impactFactorList", impactFactors);
		model.addAttribute("hecRecognizeList", hecRecognize);
		model.addAttribute("journal", new CitationJournalDTO());
		return new ModelAndView( "CitationJournalList" );
	}
	
	/**
	 * return Conference page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/publication/conference.htm", method=RequestMethod.GET)
	public ModelAndView returnConferenceDetailsPage(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		ImpactFactor impactFactors[] = ImpactFactor.values();
		HECRecognize hecRecognize[] = HECRecognize.values();
		
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("impactFactorList", impactFactors);
		model.addAttribute("hecRecognizeList", hecRecognize);
		model.addAttribute("conference", new CitationConferenceDTO());
		return new ModelAndView("CitationConferenceList");
	}
	
	/**
	 * return Chapter page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/publication/chapter.htm", method=RequestMethod.GET)
	public ModelAndView returnChapterDetailsPage(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("chapter", new CitationChapterDTO());
		return new ModelAndView("CitationChapterList");
	}
	
	/**
	 * return Book page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/publication/book.htm", method=RequestMethod.GET)
	public ModelAndView returnBookDetailsPage(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("book", new CitationBookDTO());
		return new ModelAndView("CitationBookList");
	}
	
	/**
	 * return Thesis page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/publication/thesis.htm", method=RequestMethod.GET)
	public ModelAndView returnThesisDetailsPage(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("thesis", new CitationThesisDTO());
		return new ModelAndView("CitationThesisList");
	}
	
	/**
	 * return Patent page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/publication/patent.htm", method=RequestMethod.GET)
	public ModelAndView returnPatentDetailsPage(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("patent", new CitationPatentDTO());
		return new ModelAndView("CitationPatentList");
	}
	
	/**
	 * return Google page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/publication/google.htm", method=RequestMethod.GET)
	public ModelAndView returnGoogleDetailsPage(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("google", new CitationGoogleDTO());
		return new ModelAndView("CitationGoogleList");
	}
	
	
	/**
	 * return Coordinator Page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/employeeTraining/employeeTraining.htm", method=RequestMethod.GET)
	public String returnEmployeeTraining(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		/*try 
		{*/
			employeeDTOs    = employeesService.returnAllEmployeeModels();
		/*} catch (Exception e) 
		{
			e.printStackTrace();
		}*/
		model.addAttribute("employeeTraining", new EmployeeTrainingDTO());
		model.addAttribute("employeeList", employeeDTOs);
		return "EmployeeTrainingList";
	}
	
	/**
	 * return Coordinator Page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/qec/employeeMphilPhdStudents/employeeMphilPhdStudent.htm", method=RequestMethod.GET)
	public String returnEmployeeMphilPhdStudent(Model model) 
	{
		List<EmployeeDTO> employeeDTOs = employeesService.returnAllEmployeeModels();
		List<DepartmentsDTO> departmentsDTOs = departmentsService.returnAllDepartments();
		DegreeType degreeType[] = DegreeType.values();
		model.addAttribute("employeeList", employeeDTOs);
		model.addAttribute("departmentList", departmentsDTOs);
		model.addAttribute("degreeTypeList", degreeType);
		model.addAttribute("employeeMphilPhdStudent", new EmployeeMphilPhdStudentsDTO());
		return "EmployeeMphilPhdStudentList";
	}
	
	
}
