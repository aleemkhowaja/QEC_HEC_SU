package com.qec.dao;

import java.util.List;
import com.qec.model.CitationGoogleModel;

public interface CitationGoogleDAO  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param citationGoogle
	 * @return
	 */
	public List<CitationGoogleModel> returnAllCitationGoogleModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  url) throws Exception;
	
	/**
	 * 
	 * @param citationGoogleId
	 * @return
	 */
	public CitationGoogleModel returnCitationGoogleModelById(Long citationGoogleId) throws Exception;
	

	/**
	 * return All citation Google Models
	 * @return
	 * @throws Exception
	 */
	public List<CitationGoogleModel> returnAllCitationGoogleModel() throws Exception;

	/**
	 * return Count of CitationGoogleModel 
	 * @param citationGoogle
	 * @return
	 */
	public Long returnAllCitationGoogleModelForGridCount(String url) throws Exception;
	
	
}
