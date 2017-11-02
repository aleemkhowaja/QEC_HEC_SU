package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.EmpIndustriallinkagesModel;
import com.qec.common.JTableList;
public interface EmpIndustriallinkagesService
{
    public JTableList<EmpIndustriallinkagesModel> returnAllEmpIndustriallinkagesForGrid(HttpServletRequest request);

    public EmpIndustriallinkagesModel returnEmpIndustriallinkagesById(Integer EmpIndustriallinkagesId);
}
