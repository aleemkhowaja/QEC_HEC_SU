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
import com.qec.dto.FacultyDTO;
import com.qec.model.FacultyModel;
import com.qec.service.FacultyService;

@Controller
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	
	//start get all faculty for Grid
	@RequestMapping(value="qec/faculty/returnAllFacultyForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<FacultyModel> returnAllDepartmenForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return facultyService.returnAllFacultyForGrid(request);
	}
	//end get all faculty for Grid
	
	/**
	 * save faculty in database
	 * @param facultyModel
	 * @param request
	 * @return result either it is add record or update record
	 */
	@RequestMapping(value="/faculty/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String saveFaculty(@RequestBody FacultyDTO facultyDTO, HttpServletRequest request) 
	{
		String result = facultyService.saveFaculty(facultyDTO);
		return result;
	}

	
	/**
	 * get FacultyModel By facultyId
	 * @param facultyId
	 * @param model
	 * @return FacultyModel
	 */
	@RequestMapping(value="/faculty/getFacultyById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public FacultyModel  getFacultyById(@RequestParam("facultyId") Integer facultyId, Model model) 
	{
		FacultyModel facultyModel = facultyService.returnFacultyById(Long.valueOf(facultyId));
		return facultyModel;
	}
	
	/**
	 * 
	 * @param facultyModel
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/faculty/deleteFacultyById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteFacultyById(@RequestParam("facultyId") Integer facultyId, HttpServletRequest request) 
	{
		String result = facultyService.deleteFaculty(facultyId);
		return result;
	}
}
