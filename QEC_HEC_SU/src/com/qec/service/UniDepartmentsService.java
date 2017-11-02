package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.UniDepartmentsModel;
import com.qec.common.JTableList;
public interface UniDepartmentsService
{
    public JTableList<UniDepartmentsModel> returnAllUniDepartmentsForGrid(HttpServletRequest request);

    public UniDepartmentsModel returnUniDepartmentsById(Integer UniDepartmentsId);
}
