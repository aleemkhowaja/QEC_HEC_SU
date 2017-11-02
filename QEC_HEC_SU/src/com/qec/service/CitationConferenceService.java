package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CitationConferenceModel;
import com.qec.common.JTableList;
public interface CitationConferenceService
{
    public JTableList<CitationConferenceModel> returnAllCitationConferenceForGrid(HttpServletRequest request);

    public CitationConferenceModel returnCitationConferenceById(Integer CitationConferenceId);
}
