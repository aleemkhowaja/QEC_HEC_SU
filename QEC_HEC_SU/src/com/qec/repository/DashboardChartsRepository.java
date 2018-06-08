package com.qec.repository;

import java.util.List;

import com.qec.model.CitationConferenceModel;
import com.qec.model.chart.ChartBean;

public interface DashboardChartsRepository {
	
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
	List<ChartBean> returnXYResearchPaperByDepartmentInstituteCenter() throws Exception;
	
	/**
	 * return Travel Grants By Department/Institute/Center
	 * @return
	 * @throws Exception
	 */
	List<ChartBean> returnTravelGrantsByDepartmentInstituteCenter() throws Exception;
	
	/**
	 * return Research Funding By Department/Institute/Center
	 * @return
	 * @throws Exception
	 */
	List<ChartBean> returnResearchFundingByDepartmentInstituteCenter() throws Exception;
	
	/**
	 * return return Employee Community Services By Department/Institute/Center
	 * @return
	 * @throws Exception
	 */
	List<ChartBean> returnEmployeeCommunityServicesByDepartmentInstituteCenter() throws Exception;
	
	
	
	

}
