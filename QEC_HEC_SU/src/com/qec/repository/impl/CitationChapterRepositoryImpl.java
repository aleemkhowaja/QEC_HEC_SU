package com.qec.repository.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.qec.model.CitationChapterModel;
import com.qec.repository.CitationChapterRepository;

@Repository
public class CitationChapterRepositoryImpl extends SessionFactoryRepositoryImp implements CitationChapterRepository {

	@Override
	public List<CitationChapterModel> returnAllCitationChapterModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String citationChapter) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationChapterModel.class, "cch");
		criteria.createAlias("cch.employeeModel", "employeeModel", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
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
	    
		if(citationChapter != null && !"".equals(citationChapter))
		{
			criteria.add( Restrictions.like("title", "%"+citationChapter+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationChapterModel> results = criteria.list();
		return results;
	}

	@Override
	public CitationChapterModel returnCitationChapterModelById(Long citationChapterId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationChapterModel.class);
		if(citationChapterId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("citationChapterId", citationChapterId));
		}
		CitationChapterModel citationChapterModel  =  (CitationChapterModel) criteria.uniqueResult();
		return citationChapterModel;
	}

	@Override
	public List<CitationChapterModel> returnAllCitationChapterModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationChapterModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationChapterModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllCitationChapterModelForGridCount(String citationChapter) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationChapterModel.class);
		
		if(citationChapter != null && !"".equals(citationChapter))
		{
			criteria.add( Restrictions.like("title", "%"+citationChapter+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
