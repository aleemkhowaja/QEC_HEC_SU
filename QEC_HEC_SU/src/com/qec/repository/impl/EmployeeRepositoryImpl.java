package com.qec.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;
import com.qec.model.UserModel;
import com.qec.repository.EmployeeRepository;
@Repository
public class EmployeeRepositoryImpl extends SessionFactoryRepositoryImp implements EmployeeRepository{

	@Override
	public List<EmployeeModel> returnAllEmployeesForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
			String order, String employeeName) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeModel.class);
				
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
		    
		if(employeeName != null && !"".equals(employeeName))
		{
			criteria.add( Restrictions.like("fullName", "%"+employeeName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<EmployeeModel> results = criteria.list();
		return results;
	}
	
	@Override
	public Long returnAllEmployeeForGridCount(String employeeName) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeModel.class);
		
		if(employeeName != null && !"".equals(employeeName))
		{
			criteria.add( Restrictions.like("fullName", "%"+employeeName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

	@Override
	public EmployeeModel returnEmployeesById(Long employeeId) throws Exception 
	{
		// TODO Auto-generated method stub
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeModel.class, "em");
		criteria.createAlias("em.departmentsModel", "departmentsModel", JoinType.LEFT_OUTER_JOIN); // inner join by
		if(employeeId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("employeeId", employeeId));
		}
		EmployeeModel employeeModel =  (EmployeeModel) criteria.uniqueResult();
		return employeeModel;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<EmployeeModel> returnAllEmployeeModels() throws Exception 
	{
		Session session = getSessionFactory().getCurrentSession();		
		Criteria criteria = session.createCriteria(EmployeeModel.class,"em");
		criteria.add(Restrictions.and(Restrictions.eq("em.isDeleted", false)));
		return (List<EmployeeModel>)criteria.list();
	}
}
