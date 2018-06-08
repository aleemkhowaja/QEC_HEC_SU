package com.qec.repository.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.qec.model.CitationThesisModel;
import com.qec.repository.CitationThesisRepository;

@Repository
public class CitationThesisRepositoryImpl extends SessionFactoryRepositoryImp implements CitationThesisRepository {

	@Override
	public List<CitationThesisModel> returnAllCitationThesisModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String citationThesis) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationThesisModel.class, "cth");
		criteria.createAlias("cth.employeeModel", "employeeModel", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		if(sortingProperty.equalsIgnoreCase("employee.fullName"))
		{
			sortingProperty = "employeeModel.fullName";
		}
		
		criteria.setMaxResults(jtPageSize);
		criteria.setFirstResult(jtStartIndex);
		if(order.equals("asc"))
		{
			// To sort records in ascending order
			criteria.addOrder(Order.asc(sortingProperty));
		}else {
			// To sort records in ascending order
			criteria.addOrder(Order.desc(sortingProperty));
		}
	    
		if(citationThesis != null && !"".equals(citationThesis))
		{
			criteria.add( Restrictions.like("title", "%"+citationThesis+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationThesisModel> results = criteria.list();
		return results;
	}

	@Override
	public CitationThesisModel returnCitationThesisModelById(Long citationThesisId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationThesisModel.class);
		if(citationThesisId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("citationThesisId", citationThesisId));
		}
		CitationThesisModel citationThesisModel  =  (CitationThesisModel) criteria.uniqueResult();
		return citationThesisModel;
	}

	@Override
	public List<CitationThesisModel> returnAllCitationThesisModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationThesisModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationThesisModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllCitationThesisModelForGridCount(String citationThesis) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationThesisModel.class);
		
		if(citationThesis != null && !"".equals(citationThesis))
		{
			criteria.add( Restrictions.like("title", "%"+citationThesis+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
