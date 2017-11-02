package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CitiesModel;
import com.qec.common.JTableList;
public interface CitiesService
{
    public JTableList<CitiesModel> returnAllCitiesForGrid(HttpServletRequest request);

    public CitiesModel returnCitiesById(Integer CitiesId);
}
