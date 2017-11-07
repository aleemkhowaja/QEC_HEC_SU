package com.qec.controler;

import java.util.List;

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
import com.qec.dto.UniProgramsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.EventsModel;
import com.qec.service.DepartmentsService;
import com.qec.service.EventsService;
import com.qec.service.UniProgramsService;

@Controller
public class EventsControllers {

	@Autowired
	private EventsService eventsService;
	
	@Autowired
	private DepartmentsService departmentsService;
	
	@RequestMapping(value="/qec/event.htm", method=RequestMethod.GET)
	public String getEventsDetail(Model model) throws Exception {
		
		List<DepartmentsModel> departmentsModels = departmentsService.returnAllDepartments();
		model.addAttribute("eventsData", new EventsModel());
		model.addAttribute("departmentsModelList", departmentsModels);
		return "EventList";
		
	}

	@RequestMapping(value="/events/returnAllEventsForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<EventsDTO> returnAllEventsForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		
		return eventsService.returnAllEventsModelForGrid(request);
	}
	
	@RequestMapping(value="/events/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveEventsDetail(@RequestBody EventsDTO eventsDTO, HttpServletRequest request) {
		
	    String result = eventsService.saveEventsModelModel(eventsDTO); 
		return result;
	}
	
	@RequestMapping(value="/events/getEventsById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public EventsDTO  getEventsById(@RequestParam("eventsId") Integer eventsId, Model model) {
		EventsDTO eventsDTO = eventsService.getEventsModelById(Long.valueOf(eventsId)); 
		return eventsDTO;
	}
	
	@RequestMapping(value="/events/deleteEventsById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteEventsById(@RequestBody EventsDTO eventsDTO, HttpServletRequest request) {
		String result = eventsService.deleteEventsModel(eventsDTO);
		return result;
	}

	public void setEventsService(EventsService eventsService) 
	{
		this.eventsService = eventsService;
	}

}
