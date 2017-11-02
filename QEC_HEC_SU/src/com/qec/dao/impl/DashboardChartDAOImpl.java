package com.qec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.qec.dao.DashboardChartsDAO;
import com.qec.model.CitationConferenceModel;
import com.qec.model.CitationJournalModel;

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
	public List<CitationJournalModel> returnXYResearchPaperByDepartmentInstituteCenter() throws Exception 
	{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationJournalModel.class, "cj");
		criteria.createAlias("cj.employeeModel", "em"); // inner join by default
		criteria.createAlias("em.departmentsModel", "dm");
		criteria.add(Restrictions.eq("cj.hecRecognize", "X"));
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add( Projections.count("cj.hecRecognize" ));
		projectionList.add( Projections.groupProperty("dm.departmentId" ));
		criteria.setProjection(projectionList);
		List citationJournalModels = criteria.list();
		
		criteria = session.createCriteria(CitationJournalModel.class, "cj");
		criteria.createAlias("cj.employeeModel", "em"); // inner join by default
		criteria.createAlias("em.departmentsModel", "dm");
		criteria.add(Restrictions.eq("cj.hecRecognize", "Y"));
		
		projectionList = Projections.projectionList();
		projectionList.add( Projections.count("cj.hecRecognize" ));
		projectionList.add( Projections.groupProperty("dm.departmentId" ));
		criteria.setProjection(projectionList);
		List citationJournalYModels = criteria.list();
		citationJournalModels.add(citationJournalYModels);
		
		
		
		//StringBuilder hql = new StringBuilder("select (SELECT COUNT(cjs.hecRecognize) FROM CitationJournalModel cjs WHERE  hecRecognize = 'X' ) AS X, (SELECT COUNT(cjs.hecRecognize) FROM CitationJournalModel cjs WHERE  hecRecognize = 'Y' ) AS Y, cjm.citationJournalId from CitationJournalModel  cjm left outer join fetch cjm.employeeModel em left outer join fetch em.departmentsModel d where cjm.isDeleted=true  ");
		
		
		
		/*Criteria criteria = session.createCriteria(CitationJournalModel.class, "cj");
		ProjectionList projectionList = Projections.projectionList();
		
		//sub query
		DetachedCriteria userSubquery = DetachedCriteria.forClass(CitationJournalModel.class, "cjsub")
		// Filter the Subquery
		.add(Restrictions.eq("cjsub.hecRecognize", "X"));
		//.add(Restrictions.eq("cj.hecRecognize", "cjsub.hecRecognize"));
		// SELECT The User Id  
		userSubquery.setProjection(Projections.count("cjsub.hecRecognize"));
		criteria.createAlias(Subqueries.exists(userSubquery));
		
		criteria.createAlias("cj.employeeModel", "em"); // inner join by default
		criteria.createAlias("em.departmentsModel", "dm");
		projectionList = Projections.projectionList();
		projectionList.add(Projections.groupProperty("dm.departmentId"));
		
		criteria.setProjection(projectionList);
		criteria.addQueryHint("");
		//criteria.add(Subqueries.propertyIn("cj.hecRecognize", userSubquery) );
		List<CitationJournalModel> citationJournalModels = criteria.list();*/
		// TODO Auto-generated method stub

		//Query query = session.createQuery(hql.toString());
		//List<ChartBean> citationJournalModels = query.list();
		
		return citationJournalModels;
	}

}
