package com.qec.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qec.model.Model;
import com.qec.repository.GenericRepository;

@Repository
public class GenericRepositoryImpl  implements GenericRepository {

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
