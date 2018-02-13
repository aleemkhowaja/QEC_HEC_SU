package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.CitationThesisDTO;
public interface CitationThesisService
{
	/**
	 * return All Citation Thesis for Grid
	 * @param request
	 * @return
	 */
    public JQGridDTO<CitationThesisDTO> returnAllCitationThesisForGrid(HttpServletRequest request);

    /**
     * return Citation Thesis By ID
     * @param CitationThesisId
     * @return
     */
    public CitationThesisDTO returnCitationThesisById(Integer citationThesisId);
    
    /**
     * save Citation Thesis 
     * @param CitationThesisDTO
     * @return
     */
    public String saveCitationThesis(CitationThesisDTO citationThesisDTO);
	
    /**
     * delete Citation Thesis
     * @param citationThesisId
     * @return
     */
	public String deleteCitationThesis(Integer citationThesisId);
}
