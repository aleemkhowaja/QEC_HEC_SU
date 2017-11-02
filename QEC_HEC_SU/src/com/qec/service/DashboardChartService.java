package com.qec.service;

import java.util.List;

import com.qec.model.CitationConferenceModel;
import com.qec.model.CitationJournalModel;

public interface DashboardChartService {
	
	/**
	 * return Impact factor by hec
	 * @return
	 * @throws Exception
	 */
	List<CitationConferenceModel> returnImpactFactorByHec();
	
	/**
	 * return XY Research Paper By Department/Institute/Center
	 * @return
	 * @throws Exception
	 */
	List<CitationJournalModel> returnXYResearchPaperByDepartmentInstituteCenter();

}
