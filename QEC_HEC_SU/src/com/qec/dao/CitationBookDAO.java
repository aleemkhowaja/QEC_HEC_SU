package com.qec.dao;

import java.util.List;

import com.qec.model.CitationBookModel;

public interface CitationBookDAO  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param citationBook
	 * @return
	 */
	public List<CitationBookModel> returnAllCitationBookModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  citationBook) throws Exception;
	
	/**
	 * 
	 * @param citationBookId
	 * @return
	 */
	public CitationBookModel returnCitationBookModelById(Long citationBookId) throws Exception;
	

	/**
	 * return All citation Book Models
	 * @return
	 * @throws Exception
	 */
	public List<CitationBookModel> returnAllCitationBookModel() throws Exception;

	/**
	 * return Count of CitationBookModel 
	 * @param citationBook
	 * @return
	 */
	public Long returnAllCitationBookModelForGridCount(String citationBook) throws Exception;
	
	
}
