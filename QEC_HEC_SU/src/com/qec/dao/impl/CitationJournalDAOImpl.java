package com.qec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qec.dao.CitationJournalDAO;
import com.qec.dao.DepartmentDAO;
import com.qec.model.CitationJournalModel;
import com.qec.model.DepartmentsModel;
import com.sun.org.apache.xpath.internal.operations.Gte;

@Repository
public class CitationJournalDAOImpl extends SessionFactoryDAOImp implements CitationJournalDAO {

	@Override
	public List<CitationJournalModel> returnAllCitationJournalModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String citationJournal) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationJournalModel.class);
		
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
	    
		if(citationJournal != null && !"".equals(citationJournal))
		{
			criteria.add( Restrictions.like("title", "%"+citationJournal+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationJournalModel> results = criteria.list();
		return results;
	}

	@Override
	public CitationJournalModel returnCitationJournalModelById(Long citationJournalId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationJournalModel.class);
		if(citationJournalId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("citationJournalId", citationJournalId));
		}
		CitationJournalModel citationJournalModel  =  (CitationJournalModel) criteria.uniqueResult();
		return citationJournalModel;
	}

	@Override
	public List<CitationJournalModel> returnAllCitationJournalModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationJournalModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationJournalModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllCitationJournalModelForGridCount(String citationJournal) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationJournalModel.class);
		
		if(citationJournal != null && !"".equals(citationJournal))
		{
			criteria.add( Restrictions.like("title", "%"+citationJournal+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
