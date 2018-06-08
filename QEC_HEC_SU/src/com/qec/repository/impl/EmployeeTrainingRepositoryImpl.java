package com.qec.repository.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeTrainingModel;
import com.qec.repository.EmployeeTrainingRepository;

@Repository
public class EmployeeTrainingRepositoryImpl extends SessionFactoryRepositoryImp implements EmployeeTrainingRepository {

	@Override
	public List<EmployeeTrainingModel> returnAllEmployeeTrainingModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String employeeTraining) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeTrainingModel.class, "empT");
		criteria.createAlias("empT.employee", "employee", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		criteria.setMaxResults(jtPageSize);
		criteria.setFirstResult(jtStartIndex);
		
		if(sortingProperty.equalsIgnoreCase("employee.fullName"))
		{
			sortingProperty = "employee.fullName";
		}
		
		if(order.equals("asc"))
		{
			// To sort records in ascending order
			criteria.addOrder(Order.asc(sortingProperty));
		}else {
			// To sort records in ascending order
			criteria.addOrder(Order.desc(sortingProperty));
		}
	    
		if(employeeTraining != null && !"".equals(employeeTraining))
		{
			criteria.add( Restrictions.like("name", "%"+employeeTraining+"%"));
		}
		criteria.add(Restrictions.eq("isDeleted", false));
		List<EmployeeTrainingModel> results = criteria.list();
		return results;
	}

	@Override
	public EmployeeTrainingModel returnEmployeeTrainingModelById(Long employeeTrainingId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeTrainingModel.class, "empT");
		criteria.createAlias("empT.employee", "employee", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		if(employeeTrainingId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("empTrainingsId", employeeTrainingId));
		}
		EmployeeTrainingModel employeeTrainingModel  =  (EmployeeTrainingModel) criteria.uniqueResult();
		return employeeTrainingModel;
	}

	@Override
	public List<EmployeeTrainingModel> returnAllEmployeeTrainingModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeTrainingModel.class, "empT");
		criteria.createAlias("empT.employee", "employee", JoinType.LEFT_OUTER_JOIN); // left outer join by
		criteria.add( Restrictions.eq("isDeleted", false));
		List<EmployeeTrainingModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllEmployeeTrainingModelForGridCount(String employeeTraining) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeTrainingModel.class, "empT");
		criteria.createAlias("empT.employee", "employee", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		
		if(employeeTraining != null && !"".equals(employeeTraining))
		{
			criteria.add( Restrictions.like("name", "%"+employeeTraining+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
