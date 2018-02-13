package com.qec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.qec.dao.CitationGoogleDAO;
import com.qec.model.CitationGoogleModel;

@Repository
public class CitationGoogleDAOImpl extends SessionFactoryDAOImp implements CitationGoogleDAO {

	@Override
	public List<CitationGoogleModel> returnAllCitationGoogleModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String url) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationGoogleModel.class,"cg");
		criteria.createAlias("cg.employeeModel", "employeeModel", JoinType.LEFT_OUTER_JOIN); // inner join by
		
		criteria.setMaxResults(jtPageSize);
		criteria.setFirstResult(jtStartIndex);
		if(sortingProperty.equalsIgnoreCase("employeeName"))
		{
			sortingProperty = "employeeModel.fullName";
		}
		
		if(order.equals("asc"))
		{
			// To sort records in ascending order
			criteria.addOrder(Order.asc(sortingProperty));
		}else {
			// To sort records in ascending order
			criteria.addOrder(Order.desc(sortingProperty));
		}
	    
		if(url != null && !"".equals(url))
		{
			criteria.add( Restrictions.like("url", "%"+url+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationGoogleModel> results = criteria.list();
		return results;
	}

	@Override
	public CitationGoogleModel returnCitationGoogleModelById(Long citationGoogleId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationGoogleModel.class);
		if(citationGoogleId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("citationGoogleId", citationGoogleId));
		}
		CitationGoogleModel citationGoogleModel  =  (CitationGoogleModel) criteria.uniqueResult();
		return citationGoogleModel;
	}

	@Override
	public List<CitationGoogleModel> returnAllCitationGoogleModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationGoogleModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationGoogleModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllCitationGoogleModelForGridCount(String url) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationGoogleModel.class, "cg");
		criteria.createAlias("cg.employeeModel", "employeeModel", JoinType.LEFT_OUTER_JOIN); // inner join by
		
		if(url != null && !"".equals(url))
		{
			criteria.add( Restrictions.like("url", "%"+url+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
