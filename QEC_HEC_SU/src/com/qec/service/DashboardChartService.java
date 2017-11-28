package com.qec.service;

import java.util.List;

import com.qec.model.CitationConferenceModel;
import com.qec.model.chart.ChartBean;

public interface DashboardChartService {
	
	/**
	 * return Impact factor by hec
	 * @return
	 */
	List<CitationConferenceModel> returnImpactFactorByHec();
	
	/**
	 * return XY Research Paper By Department/Institute/Center
	 * @return
	 */
	List<ChartBean> returnXYResearchPaperByDepartmentInstituteCenter();
	
	/**
	 * return Travel Grants By Department/Institute/Center
	 * @return
	 */
	List<ChartBean> returnTravelGrantsByDepartmentInstituteCenter();

}
