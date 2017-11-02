package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.FacultyModel;
import com.qec.common.JTableList;
public interface FacultyService
{
    public JTableList<FacultyModel> returnAllFacultyForGrid(HttpServletRequest request);

    public FacultyModel returnFacultyById(Integer FacultyId);
}
