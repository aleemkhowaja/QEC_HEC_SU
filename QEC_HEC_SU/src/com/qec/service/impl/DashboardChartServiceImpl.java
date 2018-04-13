package com.qec.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.dao.DashboardChartsDAO;
import com.qec.dto.ChartListDTO;
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


	@Override
	@Transactional
	public List<ChartBean> returnResearchFundingByDepartmentInstituteCenter() 
	{
		List<ChartBean> researchFundingGrantByDepartment = null;
		try
		{
			researchFundingGrantByDepartment = dashboardChartsDAO.returnResearchFundingByDepartmentInstituteCenter();
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return researchFundingGrantByDepartment;
	}


	@Override
	@Transactional
	public List<ChartBean> returnEmployeeCommunityServicesByDepartmentInstituteCenter() {
		List<ChartBean> employeeCommunityServicesByDepartment = null;
		try
		{
			employeeCommunityServicesByDepartment = dashboardChartsDAO.returnEmployeeCommunityServicesByDepartmentInstituteCenter();
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return employeeCommunityServicesByDepartment;
	}


	@Override
	@Transactional
	public ChartListDTO returnDashboardCharts() 
	{
		ChartListDTO chartListDTO = new ChartListDTO();
		try
		{
			List<CitationConferenceModel> citationConferenceModels = dashboardChartsDAO.returnImpactFactorByHec();
			List<ChartBean> xYResearchPapersModels =  dashboardChartsDAO.returnXYResearchPaperByDepartmentInstituteCenter();
			List<ChartBean> travelGrantByDepartment = dashboardChartsDAO.returnTravelGrantsByDepartmentInstituteCenter();
			List<ChartBean> researchFundingGrantByDepartment = dashboardChartsDAO.returnResearchFundingByDepartmentInstituteCenter();
			List<ChartBean> employeeCommunityServicesByDepartment  = dashboardChartsDAO.returnEmployeeCommunityServicesByDepartmentInstituteCenter();
			chartListDTO.setReturnImpactFactorByHec(citationConferenceModels);
			chartListDTO.setReturnXYResearchPaperByDepartmentInstituteCenter(xYResearchPapersModels);
			chartListDTO.setReturnTravelGrantsByDepartmentInstituteCenter(travelGrantByDepartment);
			chartListDTO.setReturnResearchFundingByDepartmentInstituteCenter(researchFundingGrantByDepartment);
			chartListDTO.setReturnEmployeeCommunityServicesByDepartmentInstituteCenter(employeeCommunityServicesByDepartment);
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return chartListDTO;
	}
	
	

}
