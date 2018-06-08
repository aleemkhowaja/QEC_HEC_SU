package com.qec.repository;

import java.util.List;

import com.qec.model.CitationJournalModel;
import com.qec.model.UniProgramsModel;

public interface CitationJournalRepository  {

	
	/**
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param sortingProperty
	 * @param order
	 * @param citationJournal
	 * @return
	 */
	public List<CitationJournalModel> returnAllCitationJournalModelForGrid(int jtStartIndex, int jtPageSize,String sortingProperty, String order, String  citationJournal) throws Exception;
	
	/**
	 * 
	 * @param citationJournalId
	 * @return
	 */
	public CitationJournalModel returnCitationJournalModelById(Long citationJournalId) throws Exception;
	

	/**
	 * 
	 * @return
	 */
	public List<CitationJournalModel> returnAllCitationJournalModel() throws Exception;

	/**
	 * return Count of CitationJournalModel 
	 * @param citationJournal
	 * @return
	 */
	public Long returnAllCitationJournalModelForGridCount(String citationJournal) throws Exception;
	
	
}
