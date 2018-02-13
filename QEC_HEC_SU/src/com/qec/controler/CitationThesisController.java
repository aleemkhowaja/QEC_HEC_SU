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
import com.qec.dto.CitationThesisDTO;
import com.qec.service.CitationThesisService;

@Controller
public class CitationThesisController {

	@Autowired
	private CitationThesisService citationThesisService;
	
	/**
	 * return all citation Thesis for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/thesis/returnAllCitationThesisForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<CitationThesisDTO> returnAllCitationThesisForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return citationThesisService.returnAllCitationThesisForGrid(request);
	}
	
	
	/**
	 * save citation Thesis in database
	 * @param CitationThesisDTO
	 * @param request
	 * @return result either it is add record or update record
	 */
	@RequestMapping(value="qec/thesis/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String saveCitationThesis(@RequestBody CitationThesisDTO citationThesisDTO , HttpServletRequest request) 
	{
		String result = citationThesisService.saveCitationThesis(citationThesisDTO);
		return result;
	}
	
	/**
	 * return Citation Thesis Record By ID
	 * @param citationThesisId
	 * @return
	 */
	@RequestMapping(value="qec/thesis/returnCitationThesisById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CitationThesisDTO  returnCitationThesisById(@RequestParam("citationThesisId") Integer citationThesisId) 
	{
		CitationThesisDTO citationThesisDTO = citationThesisService.returnCitationThesisById(citationThesisId); 
		return citationThesisDTO;
	}
	
	/**
	 * delete Citation Thesis Record by id
	 * @param CitationThesisDTO
	 * @return
	 */
	@RequestMapping(value="qec/thesis/deleteCitationThesisById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCitationThesisById(@RequestParam("citationThesisId") Integer citationThesisId) 
	{
		String result = citationThesisService.deleteCitationThesis(citationThesisId);
		return result;
	}
}
