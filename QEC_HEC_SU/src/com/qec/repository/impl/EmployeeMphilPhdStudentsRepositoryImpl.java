package com.qec.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.qec.model.EmployeeMphilPhdStudentsModel;
import com.qec.repository.EmployeeMphilPhdStudentsRepository;

@Repository
public class EmployeeMphilPhdStudentsRepositoryImpl extends SessionFactoryRepositoryImp implements EmployeeMphilPhdStudentsRepository {

	@Override
	public List<EmployeeMphilPhdStudentsModel> returnAllEmployeeMphilPhdStudentsModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String studentName) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeMphilPhdStudentsModel.class, "empMPS");
		criteria.createAlias("empMPS.employee", "employee", JoinType.LEFT_OUTER_JOIN); // left outer join by
		criteria.createAlias("empMPS.departments", "departments", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		criteria.setMaxResults(jtPageSize);
		criteria.setFirstResult(jtStartIndex);
		
		if(sortingProperty.equalsIgnoreCase("employee.fullName"))
		{
			sortingProperty = "employee.fullName";
		}
		
		if(sortingProperty.equalsIgnoreCase("departments.name"))
		{
			sortingProperty = "departments.name";
		}
		
		if(order.equals("asc"))
		{
			// To sort records in ascending order
			criteria.addOrder(Order.asc(sortingProperty));
		}else {
			// To sort records in ascending order
			criteria.addOrder(Order.desc(sortingProperty));
		}
	    
		if(studentName != null && !"".equals(studentName))
		{
			criteria.add( Restrictions.like("studentName", "%"+studentName+"%"));
		}
		criteria.add(Restrictions.eq("isDeleted", false));
		List<EmployeeMphilPhdStudentsModel> results = criteria.list();
		return results;
	}

	@Override
	public EmployeeMphilPhdStudentsModel returnEmployeeMphilPhdStudentsModelById(Long employeeMphilPhdStudentsId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeMphilPhdStudentsModel.class, "empMPS");
		criteria.createAlias("empMPS.employee", "employee", JoinType.LEFT_OUTER_JOIN); // left outer join by
		criteria.createAlias("empMPS.departments", "departments", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		if(employeeMphilPhdStudentsId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("employeeMphilPhdStudentsId", employeeMphilPhdStudentsId));
		}
		EmployeeMphilPhdStudentsModel employeeMphilPhdStudentsModel =  (EmployeeMphilPhdStudentsModel) criteria.uniqueResult();
		return employeeMphilPhdStudentsModel;
	}

	@Override
	public List<EmployeeMphilPhdStudentsModel> returnAllEmployeeMphilPhdStudentsModels() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeMphilPhdStudentsModel.class, "empMPS");
		criteria.createAlias("empMPS.employee", "employee", JoinType.LEFT_OUTER_JOIN); // left outer join by
		criteria.createAlias("empMPS.departments", "departments", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		criteria.add( Restrictions.eq("isDeleted", false));
		List<EmployeeMphilPhdStudentsModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllEmployeeMphilPhdStudentsModelForGridCount(String studentName) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeMphilPhdStudentsModel.class, "empMPS");
		criteria.createAlias("empMPS.employee", "employee", JoinType.LEFT_OUTER_JOIN); // left outer join by
		criteria.createAlias("empMPS.departments", "departments", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		if(studentName != null && !"".equals(studentName))
		{
			criteria.add( Restrictions.like("studentName", "%"+studentName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
