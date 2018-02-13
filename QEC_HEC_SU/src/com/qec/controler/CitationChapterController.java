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
import com.qec.dto.CitationChapterDTO;
import com.qec.service.CitationChapterService;

@Controller
public class CitationChapterController {

	@Autowired
	private CitationChapterService citationChapterService;
	
	/**
	 * return all citation Chapter for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/chapter/returnAllCitationChapterForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<CitationChapterDTO> returnAllCitationChapterForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return citationChapterService.returnAllCitationChapterForGrid(request);
	}
	
	
	/**
	 * save citation Chapter in database
	 * @param CitationChapterDTO
	 * @param request
	 * @return result either it is add record or update record
	 */
	@RequestMapping(value="qec/chapter/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String saveCitationChapter(@RequestBody CitationChapterDTO citationChapterDTO , HttpServletRequest request) 
	{
		String result = citationChapterService.saveCitationChapter(citationChapterDTO);
		return result;
	}
	
	/**
	 * return Citation Chapter Record By ID
	 * @param citationChapterId
	 * @return
	 */
	@RequestMapping(value="qec/chapter/returnCitationChapterById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CitationChapterDTO  returnCitationChapterById(@RequestParam("citationChapterId") Integer citationChapterId) 
	{
		CitationChapterDTO citationChapterDTO = citationChapterService.returnCitationChapterById(citationChapterId); 
		return citationChapterDTO;
	}
	
	/**
	 * delete Citation Chapter Record by id
	 * @param CitationChapterDTO
	 * @return
	 */
	@RequestMapping(value="qec/chapter/deleteCitationChapterById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCitationChapterById(@RequestParam("citationChapterId") Integer citationChapterId) 
	{
		String result = citationChapterService.deleteCitationChapter(citationChapterId);
		return result;
	}
}
