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
import com.qec.dto.CitationGoogleDTO;
import com.qec.service.CitationGoogleService;

@Controller
public class CitationGoogleController {

	@Autowired
	private CitationGoogleService citationGoogleService;
	
	/**
	 * return all citation Google for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/google/returnAllCitationGoogleForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<CitationGoogleDTO> returnAllCitationGoogleForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return citationGoogleService.returnAllCitationGoogleForGrid(request);
	}
	
	
	/**
	 * save citation Google in database
	 * @param CitationGoogleDTO
	 * @param request
	 * @return result either it is add record or update record
	 */
	@RequestMapping(value="qec/google/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String saveCitationGoogle(@RequestBody CitationGoogleDTO citationGoogleDTO , HttpServletRequest request) 
	{
		String result = citationGoogleService.saveCitationGoogle(citationGoogleDTO);
		return result;
	}
	
	/**
	 * return Citation Google Record By ID
	 * @param citationGoogleId
	 * @return
	 */
	@RequestMapping(value="qec/google/returnCitationGoogleById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CitationGoogleDTO  returnCitationGoogleById(@RequestParam("citationGoogleId") Integer citationGoogleId) 
	{
		CitationGoogleDTO citationGoogleDTO = citationGoogleService.returnCitationGoogleById(citationGoogleId); 
		return citationGoogleDTO;
	}
	
	/**
	 * delete Citation Google Record by id
	 * @param CitationGoogleDTO
	 * @return
	 */
	@RequestMapping(value="qec/google/deleteCitationGoogleById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCitationGoogleById(@RequestParam("citationGoogleId") Integer citationGoogleId) 
	{
		String result = citationGoogleService.deleteCitationGoogle(citationGoogleId);
		return result;
	}
}
