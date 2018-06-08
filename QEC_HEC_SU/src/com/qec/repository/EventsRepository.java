package com.qec.repository;

import java.util.List;

import com.qec.model.EventsModel;

public interface EventsRepository {
	
	public List<EventsModel> returnAllEventsModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  programsName) throws Exception;
	
	public EventsModel returnEventsModelById(Long eventsId) throws Exception;
	
	public List<EventsModel> returnAllEventsModelModel() throws Exception;

	public EventsModel deleteEventsModelById(Long eventsId) throws Exception;
	
	public Long returnAllEventsModelForGridCount(String eventTitle) throws Exception;

}
