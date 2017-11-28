package com.qec.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.dao.DashboardChartsDAO;
import com.qec.model.CitationConferenceModel;
import com.qec.model.chart.ChartBean;
import com.qec.service.DashboardChartService;

@Service
public class DashboardChartServiceImpl implements DashboardChartService {

	@Autowired
	private DashboardChartsDAO dashboardChartsDAO;
	
	@Override
	@Transactional
	public List<CitationConferenceModel> returnImpactFactorByHec() 
	{
		List<CitationConferenceModel> citationConferenceModels = null;
		try
		{
			citationConferenceModels = dashboardChartsDAO.returnImpactFactorByHec();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return citationConferenceModels;
	}

	
	@Override
	@Transactional
	public List<ChartBean> returnXYResearchPaperByDepartmentInstituteCenter()
	{
		List<ChartBean> xYResearchPapersModels = null;
		try
		{
			xYResearchPapersModels = dashboardChartsDAO.returnXYResearchPaperByDepartmentInstituteCenter();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return xYResearchPapersModels;
	}

	@Override
	@Transactional
	public List<ChartBean> returnTravelGrantsByDepartmentInstituteCenter() 
	{
		List<ChartBean> travelGrantByDepartment = null;
		try
		{
			travelGrantByDepartment = dashboardChartsDAO.returnTravelGrantsByDepartmentInstituteCenter();
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return travelGrantByDepartment;
	}
	
	

}
