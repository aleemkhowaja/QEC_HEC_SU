package com.qec.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.qec.dao.EmployeeTrainingDAO;
import com.qec.model.EmployeeTrainingModel;

@Repository
public class EmployeeTrainingDAOImpl extends SessionFactoryDAOImp implements EmployeeTrainingDAO {

	@Override
	public List<EmployeeTrainingModel> returnAllEmployeeTrainingModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String employeeTraining) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeTrainingModel.class);
		
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
	    
		if(employeeTraining != null && !"".equals(employeeTraining))
		{
			criteria.add( Restrictions.like("title", "%"+employeeTraining+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<EmployeeTrainingModel> results = criteria.list();
		return results;
	}

	@Override
	public EmployeeTrainingModel returnEmployeeTrainingModelById(Long employeeTrainingId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeTrainingModel.class);
		if(employeeTrainingId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("employeeTrainingId", employeeTrainingId));
		}
		EmployeeTrainingModel employeeTrainingModel  =  (EmployeeTrainingModel) criteria.uniqueResult();
		return employeeTrainingModel;
	}

	@Override
	public List<EmployeeTrainingModel> returnAllEmployeeTrainingModel() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeTrainingModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<EmployeeTrainingModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllEmployeeTrainingModelForGridCount(String employeeTraining) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeTrainingModel.class);
		
		if(employeeTraining != null && !"".equals(employeeTraining))
		{
			criteria.add( Restrictions.like("title", "%"+employeeTraining+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
