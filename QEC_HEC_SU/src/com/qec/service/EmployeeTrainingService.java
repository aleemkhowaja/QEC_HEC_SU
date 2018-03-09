package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmployeeTrainingModel;
import com.qec.common.JTableList;
public interface EmployeeTrainingService
{
    public JTableList<EmployeeTrainingModel> returnAllEmpTrainingsForGrid(HttpServletRequest request);

    public EmployeeTrainingModel returnEmpTrainingsById(Integer EmpTrainingsId);
}
