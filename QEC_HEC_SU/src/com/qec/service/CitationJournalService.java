package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.model.CitationJournalModel;
import com.qec.common.JTableList;
public interface CitationJournalService
{
    public JTableList<CitationJournalModel> returnAllCitationJournalForGrid(HttpServletRequest request);

    public CitationJournalModel returnCitationJournalById(Integer CitationJournalId);
}
