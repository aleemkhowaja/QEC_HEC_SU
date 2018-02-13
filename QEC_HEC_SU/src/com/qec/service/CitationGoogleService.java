package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.CitationGoogleDTO;
public interface CitationGoogleService
{
	/**
	 * return All Citation Google for Grid
	 * @param request
	 * @return
	 */
    public JQGridDTO<CitationGoogleDTO> returnAllCitationGoogleForGrid(HttpServletRequest request);

    /**
     * return Citation Google By ID
     * @param CitationGoogleId
     * @return
     */
    public CitationGoogleDTO returnCitationGoogleById(Integer citationGoogleId);
    
    /**
     * save Citation Google 
     * @param CitationGoogleDTO
     * @return
     */
    public String saveCitationGoogle(CitationGoogleDTO citationGoogleDTO);
	
    /**
     * delete Citation Google
     * @param citationGoogleId
     * @return
     */
	public String deleteCitationGoogle(Integer citationGoogleId);
}
