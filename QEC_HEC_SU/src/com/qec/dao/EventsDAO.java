package com.qec.dao;

import java.util.List;

import com.qec.model.EventsModel;

public interface EventsDAO {
	
	public List<EventsModel> returnAllEventsModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  programsName);
	
	public EventsModel returnEventsModelById(Long eventsId);
	
	public List<EventsModel> returnAllEventsModelModel();

	public EventsModel deleteEventsModelById(Long eventsId);
	
	public Long returnAllEventsModelForGridCount(String eventTitle);

}
