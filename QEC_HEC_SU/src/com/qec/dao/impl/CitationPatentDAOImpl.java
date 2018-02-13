package com.qec.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.qec.dao.CitationPatentDAO;
import com.qec.model.CitationPatentModel;

@Repository
public class CitationPatentDAOImpl extends SessionFactoryDAOImp implements CitationPatentDAO {

	@Override
	public List<CitationPatentModel> returnAllCitationPatentModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String citationPatent) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationPatentModel.class);
		
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
	    
		if(citationPatent != null && !"".equals(citationPatent))
		{
			criteria.add( Restrictions.like("title", "%"+citationPatent+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationPatentModel> results = criteria.list();
		return results;
	}

	@Override
	public CitationPatentModel returnCitationPatentModelById(Long citationPatentId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationPatentModel.class);
		if(citationPatentId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("citationPatentId", citationPatentId));
		}
		CitationPatentModel citationPatentModel  =  (CitationPatentModel) criteria.uniqueResult();
		return citationPatentModel;
	}

	@Override
	public List<CitationPatentModel> returnAllCitationPatentModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationPatentModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationPatentModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllCitationPatentModelForGridCount(String citationPatent) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationPatentModel.class);
		
		if(citationPatent != null && !"".equals(citationPatent))
		{
			criteria.add( Restrictions.like("title", "%"+citationPatent+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
