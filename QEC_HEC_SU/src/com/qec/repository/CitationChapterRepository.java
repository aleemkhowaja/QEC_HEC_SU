package com.qec.repository;

import java.util.List;

import com.qec.model.CitationChapterModel;

public interface CitationChapterRepository  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param citationChapter
	 * @return
	 */
	public List<CitationChapterModel> returnAllCitationChapterModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  citationChapter) throws Exception;
	
	/**
	 * 
	 * @param citationChapterId
	 * @return
	 */
	public CitationChapterModel returnCitationChapterModelById(Long citationChapterId) throws Exception;
	

	/**
	 * return All citation Chapter Models
	 * @return
	 * @throws Exception
	 */
	public List<CitationChapterModel> returnAllCitationChapterModel() throws Exception;

	/**
	 * return Count of CitationChapterModel 
	 * @param citationChapter
	 * @return
	 */
	public Long returnAllCitationChapterModelForGridCount(String citationChapter) throws Exception;
	
	
}
