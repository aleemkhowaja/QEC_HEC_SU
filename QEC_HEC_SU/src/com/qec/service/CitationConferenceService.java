package com.qec.service;
import javax.servlet.http.HttpServletRequest;

import com.qec.common.JQGridDTO;
import com.qec.dto.CitationConferenceDTO;
import com.qec.dto.CitationJournalDTO;
import com.qec.model.CitationConferenceModel;
public interface CitationConferenceService
{
	/**
	 * return All Citation Conference for Grid
	 * @param request
	 * @return
	 */
    public JQGridDTO<CitationConferenceDTO> returnAllCitationConferenceForGrid(HttpServletRequest request);

    /**
     * return Citation Conference By ID
     * @param CitationConferenceId
     * @return
     */
    public CitationConferenceDTO returnCitationConferenceById(Integer citationConferenceId);
    
    /**
     * save Citation Conference 
     * @param CitationConferenceDTO
     * @return
     */
    public String saveCitationConference(CitationConferenceDTO citationConferenceDTO);
	
    /**
     * delete Citation Conference
     * @param citationConferenceId
     * @return
     */
	public String deleteCitationConference(Integer citationConferenceId);
}
