package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmployeesCitationModel;
import com.qec.common.JTableList;
public interface EmployeesCitationService
{
    public JTableList<EmployeesCitationModel> returnAllEmployeesCitationForGrid(HttpServletRequest request);

    public EmployeesCitationModel returnEmployeesCitationById(Integer EmployeesCitationId);
}
