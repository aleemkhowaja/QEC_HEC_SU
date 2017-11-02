package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CitationThesisModel;
import com.qec.common.JTableList;
public interface CitationThesisService
{
    public JTableList<CitationThesisModel> returnAllCitationThesisForGrid(HttpServletRequest request);

    public CitationThesisModel returnCitationThesisById(Integer CitationThesisId);
}
