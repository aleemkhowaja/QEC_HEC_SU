package com.qec.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;
import com.qec.dao.DashboardChartsDAO;
import com.qec.model.CitationConferenceModel;
import com.qec.model.chart.ChartBean;

@Repository
public class DashboardChartDAOImpl  extends SessionFactoryDAOImp implements DashboardChartsDAO {

	@Override
	public List<CitationConferenceModel> returnImpactFactorByHec() throws Exception
	{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationConferenceModel.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sqlGroupProjection("EXTRACT(month FROM publication_date) as month","EXTRACT(month FROM publication_date)",  new String[] {"month"}, new Type[] { StandardBasicTypes.INTEGER }));
		projectionList.add(Projections.avg("hecRecognize"));
		projectionList.add(Projections.avg("impactFactor"));
		criteria.setProjection(projectionList);
		List<CitationConferenceModel> results = criteria.list();
		return results;
	}

	@Override
	public List<ChartBean> returnXYResearchPaperByDepartmentInstituteCenter() throws Exception 
	{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer hql = new StringBuffer("SELECT new com.qec.model.chart.ChartStringsValueBean(dm.name,count(case cjm.hecRecognize when 'X' then 1 else null end),");
		hql.append("count( case cjm.hecRecognize when 'y' then 1 else null end))");
		hql.append(" FROM CitationJournalModel cjm");
		hql.append(" RIGHT OUTER JOIN cjm.employeeModel em");
		hql.append(" RIGHT OUTER JOIN em.departmentsModel dm");
		hql.append(" group by dm.departmentId");
		Query query = session.createQuery(hql.toString());
		List<ChartBean> xyResearchPapersList = query.list();	
		return xyResearchPapersList;
	}

	@Override
	public List<ChartBean> returnTravelGrantsByDepartmentInstituteCenter() throws Exception 
	{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer hql = new StringBuffer("SELECT new com.qec.model.chart.ChartStringsValueBean(dm.name,count(case when etg.locType='HEC' and etg.grandType='Travel' then 1 else null end),");
		hql.append("count(case when etg.locType='International' and etg.grandType='Travel' then 1 else null end),count(case when etg.locType='National' and etg.grandType='Travel' then 1 else null end))");
		hql.append(" FROM EmpTravelgrandsModel etg ");
		hql.append(" RIGHT OUTER JOIN etg.employeeModel em");
		hql.append(" RIGHT OUTER JOIN em.departmentsModel dm");
		hql.append(" group by dm.departmentId");
		Query query = session.createQuery(hql.toString());
		List<ChartBean> travelGrantByDepartmentList = query.list();	
		return travelGrantByDepartmentList;
	}

	@Override
	public List<ChartBean> returnResearchFundingByDepartmentInstituteCenter() throws Exception 
	{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer hql = new StringBuffer("SELECT new com.qec.model.chart.ChartStringsValueBean(dm.name,count(case when etg.locType='HEC' and etg.grandType='Research' then 1 else null end),");
		hql.append("count(case when etg.locType='International' and etg.grandType='Research' then 1 else null end),count(case when etg.locType='National' and etg.grandType='Research' then 1 else null end))");
		hql.append(" FROM EmpTravelgrandsModel etg ");
		hql.append(" RIGHT OUTER JOIN etg.employeeModel em");
		hql.append(" RIGHT OUTER JOIN em.departmentsModel dm");
		hql.append(" group by dm.departmentId");
		Query query = session.createQuery(hql.toString());
		List<ChartBean> researchFundingGrantByDepartmentList = query.list();	
		return researchFundingGrantByDepartmentList;
	}

	@Override
	public List<ChartBean> returnEmployeeCommunityServicesByDepartmentInstituteCenter() throws Exception 
	{
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer hql = new StringBuffer("SELECT new com.qec.model.chart.ChartStringsValueBean(dm.name,count(em.employeeId))");
		hql.append(" FROM EmpCommunityservicesModel ecsm ");
		hql.append(" RIGHT OUTER JOIN ecsm.employeeModel em");
		hql.append(" RIGHT OUTER JOIN em.departmentsModel dm");
		hql.append(" group by dm.departmentId");
		Query query = session.createQuery(hql.toString());
		List<ChartBean> researchFundingGrantByDepartmentList = query.list();	
		return researchFundingGrantByDepartmentList;
	}

}
