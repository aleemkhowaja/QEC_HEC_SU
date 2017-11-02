package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.AccreditationsModel;
import com.qec.common.JTableList;
public interface AccreditationsService
{
    public JTableList<AccreditationsModel> returnAllAccreditationsForGrid(HttpServletRequest request);

    public AccreditationsModel returnAccreditationsById(Integer AccreditationsId);
}
