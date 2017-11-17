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
import com.qec.dto.EventsDTO;
import com.qec.service.EventsService;

@Controller
public class EventsControllers {

	@Autowired
	private EventsService eventsService;
	
	/**
	 * return employee models from grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/events/returnAllEventsForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<EventsDTO> returnAllEventsForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return eventsService.returnAllEventsModelForGrid(request);
	}
	
	/**
	 * save record
	 * @param eventsDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value="qec/events/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveEvents(@RequestBody EventsDTO eventsDTO, HttpServletRequest request) 
	{
	    String result = eventsService.saveEventsModelModel(eventsDTO); 
		return result;
	}
	
	/**
	 * retrun event DTO by event id
	 * @param eventsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="qec/events/returnEventByEventId", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public EventsDTO returnEventByEventId(@RequestParam("eventsId") Integer eventsId, Model model) 
	{
		EventsDTO eventsDTO = eventsService.getEventsModelById(Long.valueOf(eventsId)); 
		return eventsDTO;
	}
	
	/**
	 * delete event by event id
	 * @param eventsDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value="qec/events/deleteEventByEventId", method = RequestMethod.POST)
	@ResponseBody
	public String deleteEventByEventId(@RequestBody EventsDTO eventsDTO, HttpServletRequest request) {
		String result = eventsService.deleteEventsModel(eventsDTO);
		return result;
	}

}
