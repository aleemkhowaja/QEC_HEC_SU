package com.qec.repository;

import java.util.List;
import com.qec.model.CitationConferenceModel;

public interface CitationConferenceRepository  {
	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param citationConference
	 * @return
	 */
	public List<CitationConferenceModel> returnAllCitationConferenceModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  citationConference) throws Exception;
	
	/**
	 * 
	 * @param citationConferenceId
	 * @return
	 */
	public CitationConferenceModel returnCitationConferenceModelById(Long citationConferenceId) throws Exception;
	

	/**
	 * return All citation Conference Models
	 * @return
	 * @throws Exception
	 */
	public List<CitationConferenceModel> returnAllCitationConferenceModel() throws Exception;

	/**
	 * return Count of CitationConferenceModel 
	 * @param citationConference
	 * @return
	 */
	public Long returnAllCitationConferenceModelForGridCount(String citationConference) throws Exception;
	
	
}
