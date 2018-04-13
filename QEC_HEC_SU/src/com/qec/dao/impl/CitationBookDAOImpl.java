package com.qec.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import com.qec.dao.CitationBookDAO;
import com.qec.model.CitationBookModel;

@Repository
public class CitationBookDAOImpl extends SessionFactoryDAOImp implements CitationBookDAO {

	@Override
	public List<CitationBookModel> returnAllCitationBookModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String citationBook) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationBookModel.class, "cbook");
		criteria.createAlias("cbook.employeeModel", "employeeModel", JoinType.LEFT_OUTER_JOIN); // left outer join by
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
	    
		if(citationBook != null && !"".equals(citationBook))
		{
			criteria.add( Restrictions.like("title", "%"+citationBook+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationBookModel> results = criteria.list();
		return results;
	}

	@Override
	public CitationBookModel returnCitationBookModelById(Long citationBookId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationBookModel.class);
		if(citationBookId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("citationBookId", citationBookId));
		}
		CitationBookModel citationBookModel  =  (CitationBookModel) criteria.uniqueResult();
		return citationBookModel;
	}

	@Override
	public List<CitationBookModel> returnAllCitationBookModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationBookModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CitationBookModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllCitationBookModelForGridCount(String citationBook) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CitationBookModel.class);
		
		if(citationBook != null && !"".equals(citationBook))
		{
			criteria.add( Restrictions.like("title", "%"+citationBook+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
