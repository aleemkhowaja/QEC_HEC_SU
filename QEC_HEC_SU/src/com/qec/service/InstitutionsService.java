package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.InstitutionsModel;
import com.qec.common.JTableList;
public interface InstitutionsService
{
    public JTableList<InstitutionsModel> returnAllInstitutionsForGrid(HttpServletRequest request);

    public InstitutionsModel returnInstitutionsById(Integer InstitutionsId);
}
