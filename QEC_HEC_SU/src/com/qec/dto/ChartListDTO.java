package com.qec.dto;

import java.util.List;

import com.qec.model.CitationConferenceModel;
import com.qec.model.chart.ChartBean;

public class ChartListDTO {

	/**
	 * 
	 */
	private List<CitationConferenceModel> returnImpactFactorByHec;
	/**
	 * 
	 */
	private List<ChartBean> returnXYResearchPaperByDepartmentInstituteCenter;
	/**
	 * 
	 */
	private List<ChartBean> returnTravelGrantsByDepartmentInstituteCenter;
	/**
	 * 
	 */
	private List<ChartBean> returnResearchFundingByDepartmentInstituteCenter;
	/**
	 * 
	 */
	private List<ChartBean> returnEmployeeCommunityServicesByDepartmentInstituteCenter;
	
	public List<CitationConferenceModel> getReturnImpactFactorByHec() 
	{
		return returnImpactFactorByHec;
	}
	
	public void setReturnImpactFactorByHec(List<CitationConferenceModel> returnImpactFactorByHec) 
	{
		this.returnImpactFactorByHec = returnImpactFactorByHec;
	}
	
	public List<ChartBean> getReturnXYResearchPaperByDepartmentInstituteCenter() 
	{
		return returnXYResearchPaperByDepartmentInstituteCenter;
	}
	
	public void setReturnXYResearchPaperByDepartmentInstituteCenter(
			List<ChartBean> returnXYResearchPaperByDepartmentInstituteCenter) 
	{
		this.returnXYResearchPaperByDepartmentInstituteCenter = returnXYResearchPaperByDepartmentInstituteCenter;
	}
	
	public List<ChartBean> getReturnTravelGrantsByDepartmentInstituteCenter() 
	{
		return returnTravelGrantsByDepartmentInstituteCenter;
	}
	
	public void setReturnTravelGrantsByDepartmentInstituteCenter(
			List<ChartBean> returnTravelGrantsByDepartmentInstituteCenter) 
	{
		this.returnTravelGrantsByDepartmentInstituteCenter = returnTravelGrantsByDepartmentInstituteCenter;
	}
	
	public List<ChartBean> getReturnResearchFundingByDepartmentInstituteCenter() 
	{
		return returnResearchFundingByDepartmentInstituteCenter;
	}
	
	public void setReturnResearchFundingByDepartmentInstituteCenter(
			List<ChartBean> returnResearchFundingByDepartmentInstituteCenter) 
	{
		this.returnResearchFundingByDepartmentInstituteCenter = returnResearchFundingByDepartmentInstituteCenter;
	}
	
	public List<ChartBean> getReturnEmployeeCommunityServicesByDepartmentInstituteCenter() 
	{
		return returnEmployeeCommunityServicesByDepartmentInstituteCenter;
	}
	
	public void setReturnEmployeeCommunityServicesByDepartmentInstituteCenter(
			List<ChartBean> returnEmployeeCommunityServicesByDepartmentInstituteCenter) 
	{
		this.returnEmployeeCommunityServicesByDepartmentInstituteCenter = returnEmployeeCommunityServicesByDepartmentInstituteCenter;
	}
	
}
