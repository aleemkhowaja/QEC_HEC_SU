package com.qec.dao;

import java.util.List;

import com.qec.model.CitationConferenceModel;
import com.qec.model.CitationJournalModel;

public interface DashboardChartsDAO {
	
	/**
	 * return Impact factor by hec
	 * @return
	 * @throws Exception
	 */
	List<CitationConferenceModel> returnImpactFactorByHec() throws Exception;
	
	/**
	 * return XY Research Paper By Department/Institute/Center
	 * @return
	 * @throws Exception
	 */
	List<CitationJournalModel> returnXYResearchPaperByDepartmentInstituteCenter() throws Exception;
	
	

}
