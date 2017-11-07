package com.qec.dao.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.qec.common.JTableList;
import com.qec.dao.EmployeeDAO;
import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;
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

	@Override
	public List<EmployeeModel> returnAllEmployeeModels() 
	{
		// TODO Auto-generated method stub
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		System.out.println("------"+(List<EmployeeModel>)criteria.list());
		return (List<EmployeeModel>)criteria.list();
	}
}
