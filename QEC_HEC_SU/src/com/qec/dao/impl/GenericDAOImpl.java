package com.qec.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qec.dao.GenericDAO;
import com.qec.model.Model;

@Repository
public class GenericDAOImpl  implements GenericDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Model model) throws Exception {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}
	
	@Override
	public void update(Model model) throws Exception {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}
	
	@Override
	public void delete(Model model) throws Exception {
		
		//Session session = sessionFactory.getCurrentSession();
		//session.save(model);
	}

}
