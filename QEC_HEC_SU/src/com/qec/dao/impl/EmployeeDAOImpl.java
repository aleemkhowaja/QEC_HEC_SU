package com.qec.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import com.qec.common.JTableList;
import com.qec.dao.EmployeeDAO;
import com.qec.model.EmployeeModel;
import com.qec.model.UserModel;
@Repository
public class EmployeeDAOImpl extends SessionFactoryDAOImp implements EmployeeDAO{

	@Override
	public JTableList<EmployeeModel> returnAllEmployeesForGrid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeModel returnEmployeesById(Long employeeId) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeModel.class);
		if(employeeId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("employeeId", employeeId));
		}
		EmployeeModel employeeModel =  (EmployeeModel) criteria.uniqueResult();
		return employeeModel;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<EmployeeModel> returnAllEmployeeModels() 
	{
		Session session = getSessionFactory().getCurrentSession();		
		Criteria criteria = session.createCriteria(EmployeeModel.class,"em");
		criteria.add(Restrictions.and(Restrictions.eq("em.isDeleted", false)));
		return (List<EmployeeModel>)criteria.list();
	}
}
