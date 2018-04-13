package com.qec.service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.EventsDTO;

public interface EventsService
{

	public JQGridDTO<EventsDTO> returnAllEventsModelForGrid(HttpServletRequest request);
	
	public String saveEvents(MultipartHttpServletRequest request);
	
	public EventsDTO returnEventsModelById(Integer eventsId);
	
	public List<EventsDTO> returnAllEventsModelModel();

	public EventsDTO getEventsModelById(Long eventsId);
	
	public String deleteEventsModel(EventsDTO eventsDTO);
}
