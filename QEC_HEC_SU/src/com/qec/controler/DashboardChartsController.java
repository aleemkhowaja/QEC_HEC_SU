package com.qec.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qec.model.CitationConferenceModel;
import com.qec.model.CitationJournalModel;
import com.qec.service.DashboardChartService;

@Controller
public class DashboardChartsController {
	
	@Autowired
	private DashboardChartService dashboardChartService;

	public DashboardChartService getDashboardChartService() 
	{
		return dashboardChartService;
	}

	public void setDashboardChartService(DashboardChartService dashboardChartService) 
	{
		this.dashboardChartService = dashboardChartService;
	}
	
	/**
	 * return Impact factor for charts
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/dashboard/returnImpactFactorByHECForChart", produces = "application/json")
	@ResponseBody
	public List<CitationConferenceModel> returnImpactFactorByHECForChart(ModelMap modelMap) {
		return dashboardChartService.returnImpactFactorByHec();
	}
	//end return impact factor by hec for chart
	
	/**
	 * return XY Research Paper By Department/Institute/Center
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/dashboard/returnXYResearchPaperByDepartmentInstituteCenter", produces = "application/json")
	@ResponseBody
	public List<CitationJournalModel> returnXYResearchPaperByDepartmentInstituteCenter(ModelMap modelMap) {
		return dashboardChartService.returnXYResearchPaperByDepartmentInstituteCenter();
	}
	//end return impact factor by hec for chart
	
	
	
	

}
