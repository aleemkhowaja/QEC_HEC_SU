package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmployeesServicesModel;
import com.qec.common.JTableList;
public interface EmployeesServicesService
{
    public JTableList<EmployeesServicesModel> returnAllEmployeesServicesForGrid(HttpServletRequest request);

    public EmployeesServicesModel returnEmployeesServicesById(Integer EmployeesServicesId);
}
