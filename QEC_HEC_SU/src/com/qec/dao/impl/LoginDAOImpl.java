package com.qec.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qec.dao.LoginDAO;
import com.qec.model.UserModel;

@Repository
public class LoginDAOImpl implements LoginDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public UserModel login(UserModel userModel) throws HibernateException {
		
		Session session = sessionFactory.getCurrentSession();
		
		// Creating a Criteria instance
		Criteria crit = session.createCriteria(UserModel.class);
		//Criteria criteriaTable2 = crit.createCriteria("employeeModel", CriteriaSpecification.LEFT_JOIN); 
		crit.setFetchMode("employeeModel", FetchMode.JOIN);
		
		Criterion usernameCriteria = Restrictions.eq("username", userModel.getUsername());
		Criterion passwordCriteria = Restrictions.eq("password", userModel.getPassword());
		
		// To get records matching with AND conditions
		LogicalExpression andExp = Restrictions.and(usernameCriteria, passwordCriteria);
		crit.add( andExp );
		
		crit.setMaxResults(1);
		userModel = (UserModel) crit.uniqueResult();
		return userModel;
	}

	@Override
	public UserModel findByUserName(String username) throws HibernateException {
		
		//UserModel userModel = new UserModel();
		Session session = sessionFactory.getCurrentSession();
		
		// Creating a Criteria instance
		Criteria crit = session.createCriteria(UserModel.class);
		//Criteria criteriaTable2 = crit.createCriteria("employeeModel", CriteriaSpecification.LEFT_JOIN); 
		crit.setFetchMode("employeeModel", FetchMode.JOIN);
		
		Criterion usernameCriteria = Restrictions.eq("username", username);
		crit.add(usernameCriteria);
		// To get records matching with AND conditions
		//LogicalExpression andExp = Restrictions.and(usernameCriteria);
		//crit.add( andExp );
		
		crit.setMaxResults(1);
		UserModel userModel = (UserModel) crit.uniqueResult();
		return userModel;
	}

}
