package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmployeesEducationModel;
import com.qec.common.JTableList;
public interface EmployeesEducationService
{
    public JTableList<EmployeesEducationModel> returnAllEmployeesEducationForGrid(HttpServletRequest request);

    public EmployeesEducationModel returnEmployeesEducationById(Integer EmployeesEducationId);
}
