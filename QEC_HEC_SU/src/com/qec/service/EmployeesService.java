package com.qec.service;
import javax.servlet.http.HttpServletRequest;

import com.qec.common.JTableList;
import com.qec.model.EmployeeModel;
public interface EmployeesService
{
    public JTableList<EmployeeModel> returnAllEmployeesForGrid(HttpServletRequest request);

    public EmployeeModel returnEmployeesById(Integer EmployeesId);
}
