package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CountriesModel;
import com.qec.common.JTableList;
public interface CountriesService
{
    public JTableList<CountriesModel> returnAllCountriesForGrid(HttpServletRequest request);

    public CountriesModel returnCountriesById(Integer CountriesId);
}
