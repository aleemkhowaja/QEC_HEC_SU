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
import com.qec.dto.CitationPatentDTO;
import com.qec.service.CitationPatentService;

@Controller
public class CitationPatentController {

	@Autowired
	private CitationPatentService citationPatentService;
	
	/**
	 * return all citation Patent for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/patent/returnAllCitationPatentForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<CitationPatentDTO> returnAllCitationPatentForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return citationPatentService.returnAllCitationPatentForGrid(request);
	}
	
	
	/**
	 * save citation Patent in database
	 * @param CitationPatentDTO
	 * @param request
	 * @return result either it is add record or update record
	 */
	@RequestMapping(value="qec/patent/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String saveCitationPatent(@RequestBody CitationPatentDTO citationPatentDTO , HttpServletRequest request) 
	{
		String result = citationPatentService.saveCitationPatent(citationPatentDTO);
		return result;
	}
	
	/**
	 * return Citation Patent Record By ID
	 * @param citationPatentId
	 * @return
	 */
	@RequestMapping(value="qec/patent/returnCitationPatentById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CitationPatentDTO  returnCitationPatentById(@RequestParam("citationPatentId") Integer citationPatentId) 
	{
		CitationPatentDTO citationPatentDTO = citationPatentService.returnCitationPatentById(citationPatentId); 
		return citationPatentDTO;
	}
	
	/**
	 * delete Citation Patent Record by id
	 * @param CitationPatentDTO
	 * @return
	 */
	@RequestMapping(value="qec/patent/deleteCitationPatentById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCitationPatentById(@RequestParam("citationPatentId") Integer citationPatentId) 
	{
		String result = citationPatentService.deleteCitationPatent(citationPatentId);
		return result;
	}
}
