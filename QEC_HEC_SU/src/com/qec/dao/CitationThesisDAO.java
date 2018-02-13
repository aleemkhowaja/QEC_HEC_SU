package com.qec.dao;

import java.util.List;

import com.qec.model.CitationThesisModel;

public interface CitationThesisDAO  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param citationThesis
	 * @return
	 */
	public List<CitationThesisModel> returnAllCitationThesisModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  citationThesis) throws Exception;
	
	/**
	 * 
	 * @param citationThesisId
	 * @return
	 */
	public CitationThesisModel returnCitationThesisModelById(Long citationThesisId) throws Exception;
	

	/**
	 * return All citation Thesis Models
	 * @return
	 * @throws Exception
	 */
	public List<CitationThesisModel> returnAllCitationThesisModel() throws Exception;

	/**
	 * return Count of CitationThesisModel 
	 * @param citationThesis
	 * @return
	 */
	public Long returnAllCitationThesisModelForGridCount(String citationThesis) throws Exception;
	
	
}
