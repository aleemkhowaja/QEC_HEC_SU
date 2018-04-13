package com.qec.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import com.qec.dao.CitationConferenceDAO;
import com.qec.model.CitationConferenceModel;

@Repository
public class CitationConferenceDAOImpl extends SessionFactoryDAOImp implements CitationConferenceDAO {

	@Override
	public List<CitationConferenceModel> returnAllCitationConferenceModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String citationConference) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationConferenceModel.class, "cc");
		criteria.createAlias("cc.employeeModel", "employeeModel", JoinType.LEFT_OUTER_JOIN); // left outer join by
		criteria.setMaxResults(jtPageSize);
		criteria.setFirstResult(jtStartIndex);
		if(sortingProperty.equalsIgnoreCase("employee.fullName"))
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
	    
		if(citationConference != null && !"".equals(citationConference))
		{
			criteria.add( Restrictions.like("title", "%"+citationConference+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationConferenceModel> results = criteria.list();
		return results;
	}

	@Override
	public CitationConferenceModel returnCitationConferenceModelById(Long citationConferenceId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationConferenceModel.class);
		if(citationConferenceId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("citationConferenceId", citationConferenceId));
		}
		CitationConferenceModel citationConferenceModel  =  (CitationConferenceModel) criteria.uniqueResult();
		return citationConferenceModel;
	}

	@Override
	public List<CitationConferenceModel> returnAllCitationConferenceModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationConferenceModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationConferenceModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllCitationConferenceModelForGridCount(String citationConference) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationConferenceModel.class);
		
		if(citationConference != null && !"".equals(citationConference))
		{
			criteria.add( Restrictions.like("title", "%"+citationConference+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
