package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.CitationBookDTO;
public interface CitationBookService
{
	/**
	 * return All Citation Book for Grid
	 * @param request
	 * @return
	 */
    public JQGridDTO<CitationBookDTO> returnAllCitationBookForGrid(HttpServletRequest request);

    /**
     * return Citation Book By ID
     * @param CitationBookId
     * @return
     */
    public CitationBookDTO returnCitationBookById(Integer citationBookId);
    
    /**
     * save Citation Book 
     * @param CitationBookDTO
     * @return
     */
    public String saveCitationBook(CitationBookDTO citationBookDTO);
	
    /**
     * delete Citation Book
     * @param citationBookId
     * @return
     */
	public String deleteCitationBook(Integer citationBookId);
}
