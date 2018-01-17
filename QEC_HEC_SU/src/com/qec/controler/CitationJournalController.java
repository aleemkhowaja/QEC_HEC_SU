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
import com.qec.dto.CitationJournalDTO;
import com.qec.dto.UserDTO;
import com.qec.service.CitationJournalService;
import com.qec.service.UsersService;

@Controller
public class CitationJournalController {

	@Autowired
	private CitationJournalService citationJournalService;
	
	/**
	 * return all citation Journal for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/journal/returnAllCitationJournalForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<CitationJournalDTO> returnAllCitationJournalForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return citationJournalService.returnAllCitationJournalForGrid(request);
	}

}
