package com.qec.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.dao.DashboardChartsDAO;
import com.qec.model.CitationConferenceModel;
import com.qec.model.CitationJournalModel;
import com.qec.service.DashboardChartService;

@Service
public class DashboardChartServiceImpl implements DashboardChartService {

	@Autowired
	private DashboardChartsDAO dashboardChartsDAO;
	
	/**
	 * 
	 * @return DashboardChartsDAO
	*/
	public DashboardChartsDAO getDashboardChartsDAO() 
	{
		return dashboardChartsDAO;
	}

	/**
	 * 
	 * @param dashboardChartsDAO
	*/
	public void setDashboardChartsDAO(DashboardChartsDAO dashboardChartsDAO) 
	{
		this.dashboardChartsDAO = dashboardChartsDAO;
	}


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
	public List<CitationJournalModel> returnXYResearchPaperByDepartmentInstituteCenter()
	{
		List<CitationJournalModel> citationJournalModels = null;
		try
		{
			citationJournalModels = dashboardChartsDAO.returnXYResearchPaperByDepartmentInstituteCenter();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return citationJournalModels;
	}
	
	

}
