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
import com.qec.dto.CitationBookDTO;
import com.qec.service.CitationBookService;

@Controller
public class CitationBookController {

	@Autowired
	private CitationBookService citationBookService;
	
	/**
	 * return all citation Book for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/book/returnAllCitationBookForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<CitationBookDTO> returnAllCitationBookForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return citationBookService.returnAllCitationBookForGrid(request);
	}
	
	
	/**
	 * save citation Book in database
	 * @param CitationBookDTO
	 * @param request
	 * @return result either it is add record or update record
	 */
	@RequestMapping(value="qec/book/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String saveCitationBook(@RequestBody CitationBookDTO citationBookDTO , HttpServletRequest request) 
	{
		String result = citationBookService.saveCitationBook(citationBookDTO);
		return result;
	}
	
	/**
	 * return Citation Book Record By ID
	 * @param citationBookId
	 * @return
	 */
	@RequestMapping(value="qec/book/returnCitationBookById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CitationBookDTO  returnCitationBookById(@RequestParam("citationBookId") Integer citationBookId) 
	{
		CitationBookDTO citationBookDTO = citationBookService.returnCitationBookById(citationBookId); 
		return citationBookDTO;
	}
	
	/**
	 * delete Citation Book Record by id
	 * @param CitationBookDTO
	 * @return
	 */
	@RequestMapping(value="qec/book/deleteCitationBookById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCitationBookById(@RequestParam("citationBookId") Integer citationBookId) 
	{
		String result = citationBookService.deleteCitationBook(citationBookId);
		return result;
	}
}
