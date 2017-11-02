package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmpTrainingsModel;
import com.qec.common.JTableList;
public interface EmpTrainingsService
{
    public JTableList<EmpTrainingsModel> returnAllEmpTrainingsForGrid(HttpServletRequest request);

    public EmpTrainingsModel returnEmpTrainingsById(Integer EmpTrainingsId);
}
