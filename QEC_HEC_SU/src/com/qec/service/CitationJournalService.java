package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.CitationJournalDTO;
import com.qec.model.CitationJournalModel;
public interface CitationJournalService
{
	/**
	 * 
	 * @param request
	 * @return
	 */
    public JQGridDTO<CitationJournalDTO> returnAllCitationJournalForGrid(HttpServletRequest request);

    /**
     * 
     * @param CitationJournalId
     * @return
     */
    public CitationJournalDTO returnCitationJournalById(Integer citationJournalId);
    
    /**
     * 
     * @param citationJournalModel
     * @return
     */
    public String saveCitationJournal(CitationJournalDTO citationJournalDTO);
	
    /**
     * 
     * @param citationJournalModel
     * @return
     */
	public String deleteCitationJournal(Integer citationJournalId);
	
}
