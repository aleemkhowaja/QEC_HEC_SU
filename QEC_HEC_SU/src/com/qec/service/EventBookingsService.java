package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EventBookingsModel;
import com.qec.common.JTableList;
public interface EventBookingsService
{
    public JTableList<EventBookingsModel> returnAllEventBookingsForGrid(HttpServletRequest request);

    public EventBookingsModel returnEventBookingsById(Integer EventBookingsId);
}
