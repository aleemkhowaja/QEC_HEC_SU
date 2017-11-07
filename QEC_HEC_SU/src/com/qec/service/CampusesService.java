package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CampusesModel;
import com.qec.common.JTableList;

public interface CampusesService
{
    public JTableList<CampusesModel> returnAllCampusesForGrid(HttpServletRequest request);

    public CampusesModel returnCampusesById(Integer CampusesId);
}
