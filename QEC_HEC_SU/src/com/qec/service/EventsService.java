package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EventsModel;
import com.qec.common.JTableList;
public interface EventsService
{
    public JTableList<EventsModel> returnAllEventsForGrid(HttpServletRequest request);

    public EventsModel returnEventsById(Integer EventsId);
}
