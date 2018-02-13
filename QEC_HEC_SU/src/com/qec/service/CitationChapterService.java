package com.qec.service;
import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.CitationChapterDTO;
public interface CitationChapterService
{
	/**
	 * return All Citation Chapter for Grid
	 * @param request
	 * @return
	 */
    public JQGridDTO<CitationChapterDTO> returnAllCitationChapterForGrid(HttpServletRequest request);

    /**
     * return Citation Chapter By ID
     * @param CitationChapterId
     * @return
     */
    public CitationChapterDTO returnCitationChapterById(Integer citationChapterId);
    
    /**
     * save Citation Chapter 
     * @param CitationChapterDTO
     * @return
     */
    public String saveCitationChapter(CitationChapterDTO citationChapterDTO);
	
    /**
     * delete Citation Chapter
     * @param citationChapterId
     * @return
     */
	public String deleteCitationChapter(Integer citationChapterId);
}
