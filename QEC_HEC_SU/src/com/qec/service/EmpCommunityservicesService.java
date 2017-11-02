package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmpCommunityservicesModel;
import com.qec.common.JTableList;
public interface EmpCommunityservicesService
{
    public JTableList<EmpCommunityservicesModel> returnAllEmpCommunityservicesForGrid(HttpServletRequest request);

    public EmpCommunityservicesModel returnEmpCommunityservicesById(Integer EmpCommunityservicesId);
}
