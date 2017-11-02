package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CitationOtherModel;
import com.qec.common.JTableList;
public interface CitationOtherService
{
    public JTableList<CitationOtherModel> returnAllCitationOtherForGrid(HttpServletRequest request);

    public CitationOtherModel returnCitationOtherById(Integer CitationOtherId);
}
