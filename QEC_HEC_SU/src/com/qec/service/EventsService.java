package com.qec.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.qec.model.EventsModel;
import com.qec.model.UniProgramsModel;
import com.qec.common.JQGridDTO;
import com.qec.common.JTableList;
import com.qec.dto.EventsDTO;
import com.qec.dto.UniProgramsDTO;

public interface EventsService
{

	public JQGridDTO<EventsDTO> returnAllEventsModelForGrid(HttpServletRequest request);
	
	public String saveEventsModelModel(EventsDTO eventsDTO);
	
	public EventsDTO returnEventsModelById(Integer eventsId);
	
	public List<EventsDTO> returnAllEventsModelModel();

	public EventsDTO getEventsModelById(Long eventsId);
	
	public String deleteEventsModel(EventsDTO eventsDTO);
}
