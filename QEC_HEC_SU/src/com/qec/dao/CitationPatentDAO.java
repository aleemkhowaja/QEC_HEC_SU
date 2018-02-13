package com.qec.dao;

import java.util.List;

import com.qec.model.CitationPatentModel;

public interface CitationPatentDAO  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param citationPatent
	 * @return
	 */
	public List<CitationPatentModel> returnAllCitationPatentModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  citationPatent) throws Exception;
	
	/**
	 * 
	 * @param citationPatentId
	 * @return
	 */
	public CitationPatentModel returnCitationPatentModelById(Long citationPatentId) throws Exception;
	

	/**
	 * return All citation Patent Models
	 * @return
	 * @throws Exception
	 */
	public List<CitationPatentModel> returnAllCitationPatentModel() throws Exception;

	/**
	 * return Count of CitationPatentModel 
	 * @param citationPatent
	 * @return
	 */
	public Long returnAllCitationPatentModelForGridCount(String citationPatent) throws Exception;
	
	
}
