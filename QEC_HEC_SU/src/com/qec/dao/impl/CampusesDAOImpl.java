package com.qec.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qec.dao.CampusesDAO;
import com.qec.model.CampusesModel;

@Repository
public class CampusesDAOImpl implements CampusesDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<CampusesModel> returnAllCampuses() 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CampusesModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<CampusesModel> results = criteria.list();
		return results;
	}

	@Override
	public CampusesModel returnCampusByCampusId(Long campusId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(CampusesModel.class);
		if(campusId != null )
		{
			criteria.add(Restrictions.eq("campusesId", campusId));
		}
		CampusesModel campusesModel =  (CampusesModel) criteria.uniqueResult();
		return campusesModel;
	}

}
