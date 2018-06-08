package com.qec.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.qec.model.FacultyModel;
import com.qec.repository.FacultyRepository;

@Repository
public class FacultyRepositoryImpl extends SessionFactoryRepositoryImp implements FacultyRepository{

	@Override
	public List<FacultyModel> returnAllFacultyForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String facultyName) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(FacultyModel.class);
		
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
	    
		if(facultyName != null && !"".equals(facultyName))
		{
			criteria.add( Restrictions.like("facultyName", "%"+facultyName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<FacultyModel> results = criteria.list();
		return results;
	}

	@Override
	public FacultyModel returnFacultyById(Long facultyId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(FacultyModel.class);
		if(facultyId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("facultyId", facultyId));
		}
		FacultyModel facultysModel =  (FacultyModel) criteria.uniqueResult();
		return facultysModel;
	}

	@Override
	public List<FacultyModel> returnAllFaculty() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(FacultyModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<FacultyModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllFacultyForGridCount(String facultyName) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(FacultyModel.class);
		
		if(facultyName != null && !"".equals(facultyName))
		{
			criteria.add( Restrictions.like("facultyName", "%"+facultyName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
