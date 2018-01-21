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
import com.qec.dto.CitationConferenceDTO;
import com.qec.service.CitationConferenceService;

@Controller
public class CitationConferenceController {

	@Autowired
	private CitationConferenceService citationConferenceService;
	
	/**
	 * return all citation Conference for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/conference/returnAllCitationConferenceForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<CitationConferenceDTO> returnAllCitationConferenceForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return citationConferenceService.returnAllCitationConferenceForGrid(request);
	}
	
	
	/**
	 * save citation Conference in database
	 * @param CitationConferenceDTO
	 * @param request
	 * @return result either it is add record or update record
	 */
	@RequestMapping(value="qec/conference/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String saveCitationConference(@RequestBody CitationConferenceDTO citationConferenceDTO , HttpServletRequest request) 
	{
		String result = citationConferenceService.saveCitationConference(citationConferenceDTO);
		return result;
	}
	
	/**
	 * return Citation Conference Record By ID
	 * @param citationConferenceId
	 * @return
	 */
	@RequestMapping(value="qec/conference/returnCitationConferenceById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CitationConferenceDTO  returnCitationConferenceById(@RequestParam("citationConferenceId") Integer citationConferenceId) 
	{
		CitationConferenceDTO citationConferenceDTO = citationConferenceService.returnCitationConferenceById(citationConferenceId); 
		return citationConferenceDTO;
	}
	
	/**
	 * delete Citation Conference Record by id
	 * @param CitationConferenceDTO
	 * @return
	 */
	@RequestMapping(value="qec/conference/deleteCitationConferenceById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCitationConferenceById(@RequestParam("citationConferenceId") Integer citationConferenceId) 
	{
		String result = citationConferenceService.deleteCitationConference(citationConferenceId);
		return result;
	}
}
