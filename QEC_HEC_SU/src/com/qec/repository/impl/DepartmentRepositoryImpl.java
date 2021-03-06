package com.qec.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qec.model.CitationConferenceModel;
import com.qec.model.DepartmentsModel;
import com.qec.repository.DepartmentRepository;
import com.sun.org.apache.xpath.internal.operations.Gte;

@Repository
public class DepartmentRepositoryImpl extends SessionFactoryRepositoryImp implements DepartmentRepository{

	@Override
	public List<DepartmentsModel> returnAllDepartmentForGrid(int jtStartIndex, int jtPageSize, String sortingProperty, 
		String order, String departmentName) throws Exception 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(DepartmentsModel.class, "dm");
		criteria.createAlias("dm.faculty", "faculty", JoinType.LEFT_OUTER_JOIN); // left outer join by
		criteria.setMaxResults(jtPageSize);
		criteria.setFirstResult(jtStartIndex);
		
		if(sortingProperty.equalsIgnoreCase("facultyDTO.facultyName"))
		{
			sortingProperty = "faculty.facultyName";
		}
		
		if(order.equals("asc"))
		{
			// To sort records in ascending order
			criteria.addOrder(Order.asc(sortingProperty));
		}else {
			// To sort records in ascending order
			criteria.addOrder(Order.desc(sortingProperty));
		}
	    
		if(departmentName != null && !"".equals(departmentName))
		{
			criteria.add( Restrictions.like("name", "%"+departmentName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		List<DepartmentsModel> results = criteria.list();
		return results;
	}

	@Override
	public void deleteDepartment(Integer departmentId) {
		
		
	}

	@Override
	public DepartmentsModel returnDepartmentById(Long departmentId) throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(DepartmentsModel.class, "dm");
		criteria.createAlias("dm.faculty", "faculty", JoinType.LEFT_OUTER_JOIN); // left outer join by
		
		if(departmentId != null )
		{
			criteria.add( Restrictions.eqOrIsNull("departmentId", departmentId));
		}
		DepartmentsModel departmentsModel =  (DepartmentsModel) criteria.uniqueResult();
		return departmentsModel;
	}

	@Override
	public List<DepartmentsModel> returnAllDepartments() throws Exception
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(DepartmentsModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		List<DepartmentsModel> results = criteria.list();
		return results;
	}

	@Override
	public Long returnAllDepartmentForGridCount(String departmentName) 
	{
		//get Session Factory from SessionFactoryDAOImp
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(DepartmentsModel.class);
		
		if(departmentName != null && !"".equals(departmentName))
		{
			criteria.add( Restrictions.like("name", "%"+departmentName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
