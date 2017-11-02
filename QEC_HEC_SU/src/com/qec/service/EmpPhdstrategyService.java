package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmpPhdstrategyModel;
import com.qec.common.JTableList;
public interface EmpPhdstrategyService
{
    public JTableList<EmpPhdstrategyModel> returnAllEmpPhdstrategyForGrid(HttpServletRequest request);

    public EmpPhdstrategyModel returnEmpPhdstrategyById(Integer EmpPhdstrategyId);
}
