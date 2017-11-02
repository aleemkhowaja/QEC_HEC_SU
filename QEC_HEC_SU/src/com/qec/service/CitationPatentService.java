package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CitationPatentModel;
import com.qec.common.JTableList;
public interface CitationPatentService
{
    public JTableList<CitationPatentModel> returnAllCitationPatentForGrid(HttpServletRequest request);

    public CitationPatentModel returnCitationPatentById(Integer CitationPatentId);
}
