package com.qec.service;

import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.CitationPatentDTO;
public interface CitationPatentService
{
	/**
	 * return All Citation Patent for Grid
	 * @param request
	 * @return
	 */
    public JQGridDTO<CitationPatentDTO> returnAllCitationPatentForGrid(HttpServletRequest request);

    /**
     * return Citation Patent By ID
     * @param CitationPatentId
     * @return
     */
    public CitationPatentDTO returnCitationPatentById(Integer citationPatentId);
    
    /**
     * save Citation Patent 
     * @param CitationPatentDTO
     * @return
     */
    public String saveCitationPatent(CitationPatentDTO citationPatentDTO);
	
    /**
     * delete Citation Patent
     * @param citationPatentId
     * @return
     */
	public String deleteCitationPatent(Integer citationPatentId);
}
