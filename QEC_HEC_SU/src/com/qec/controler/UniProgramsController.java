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
import com.qec.dto.UniProgramsDTO;
import com.qec.service.UniProgramsService;

@Controller
public class UniProgramsController {
	
	@Autowired
	private UniProgramsService uniProgramsService;
	
	/**
	 * return all uni programs for grod
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/programs/returnAllProgramsForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<UniProgramsDTO> returnAllUniProgramsForGrid(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap) 
	{
		return uniProgramsService.returnAllUniProgramsModelForGrid(request);
	}
	
	/**
	 * 
	 * @param UniProgramsDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/programs/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveUniPrograms(@RequestBody UniProgramsDTO uniProgramsDTO, HttpServletRequest request) 
	{
	    String result = uniProgramsService.saveUniProgramsModel(uniProgramsDTO); 
		return result;
	}

	/**
	 * 
	 * @param uniProgramsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/programs/getUniProgramsById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public UniProgramsDTO  getUniProgramsById(@RequestParam("uniProgramsId") Integer uniProgramsId, Model model) 
	{
		UniProgramsDTO uniProgramsDTO = uniProgramsService.getUniProgramsModelById(Long.valueOf(uniProgramsId)); 
		return uniProgramsDTO;
	}
	
	/**
	 * 
	 * @param uniProgramsDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/programs/deleteUniProgrmsById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteDepartmentById(@RequestBody UniProgramsDTO uniProgramsDTO, HttpServletRequest request) 
	{
		String result = uniProgramsService.deleteUniProgramsModel(uniProgramsDTO);
		return result;
	}

	/**
	 * 
	 * @param uniProgramsService
	 */
	public void setUniProgramsService(UniProgramsService uniProgramsService) 
	{
		this.uniProgramsService = uniProgramsService;
	}

}
