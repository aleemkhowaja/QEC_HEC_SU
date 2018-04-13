package com.qec.service;

import java.util.List;

import com.qec.dto.ChartListDTO;
import com.qec.model.CitationConferenceModel;
import com.qec.model.chart.ChartBean;

public interface DashboardChartService {
	
	/**
	 * return all dashboard charts
	 * @return
	 */
	ChartListDTO returnDashboardCharts();
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
	
	/**
	 * return Research Funding By Department/Institute/Center
	 * @return
	 */
	List<ChartBean> returnResearchFundingByDepartmentInstituteCenter();
	
	/**
	 * return return Employee Community Services By Department/Institute/Center
	 * @return
	 */
	List<ChartBean> returnEmployeeCommunityServicesByDepartmentInstituteCenter();

}
