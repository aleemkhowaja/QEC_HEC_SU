package com.qec.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qec.common.JTableList;
import com.qec.dto.EmployeeDTO;
import com.qec.model.EmployeeModel;
public interface EmployeesService
{
    public JTableList<EmployeeModel> returnAllEmployeesForGrid(HttpServletRequest request);

    public EmployeeModel returnEmployeesById(Integer EmployeesId);
    
    public List<EmployeeDTO> returnAllEmployeeModels();
}
