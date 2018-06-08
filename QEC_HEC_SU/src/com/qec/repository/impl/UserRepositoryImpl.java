package com.qec.repository.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.qec.dto.UserDTO;
import com.qec.model.UserModel;
import com.qec.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends SessionFactoryRepositoryImp implements UserRepository {

	@Override
	public List<UserModel> returnAllUserModelForGrid(int jtStartIndex, int jtPageSize, String sortingProperty,String order, String fullName) 
	{
		Session session =  getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UserModel.class, "um");
		criteria.createAlias("um.departmentsModel", "departmentsModel"); // inner join by
		criteria.setFetchMode("departmentsModel", FetchMode.JOIN);
		criteria.createAlias("um.employeeModel", "employeeModel"); // inner join by
		criteria.setFetchMode("employeeModel", FetchMode.JOIN);
		criteria.createAlias("um.campusesModel", "campusesModel"); // inner join by
		criteria.setFetchMode("campusesModel", FetchMode.JOIN);
		criteria.setMaxResults(jtPageSize);
		criteria.setFirstResult(jtStartIndex);
		
		if(sortingProperty.equals("campusName"))
		{
			sortingProperty = "campusesModel.campusName";
		}
		else if(sortingProperty.equals("departmentName"))
		{
			sortingProperty = "departmentsModel.name";
		}
		else if(sortingProperty.equals("employeeFullName"))
		{
			sortingProperty = "employeeModel.fullName";
		}
		
		if(order.equals("asc"))
		{
			// To sort records in ascending order
			criteria.addOrder(Order.asc(sortingProperty));
		} else {
			// To sort records in ascending order
			criteria.addOrder(Order.desc(sortingProperty));
		}

		if(fullName != null && !"".equals(fullName))
		{
			criteria.add( Restrictions.like("fullName", "%"+fullName+"%"));
		}
		criteria.add(Restrictions.eq("um.isDeleted", false));
		List<UserModel> results = criteria.list();
		return results;
	}

	@Override
	public UserModel returnUserModelByUserProperties(UserDTO userDTO) 
	{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UserModel.class, "um");
		criteria.createAlias("um.departmentsModel", "departmentsModel"); // inner join by
		criteria.setFetchMode("departmentsModel", FetchMode.JOIN);
		criteria.createAlias("um.campusesModel", "campusesModel"); // inner join by
		criteria.setFetchMode("campusesModel", FetchMode.JOIN);
		criteria.add(Restrictions.eq("um.isDeleted", false));
		if(userDTO.getUserId() != null )
		{
			criteria.add( Restrictions.eq("userId", userDTO.getUserId()));
		}
		
		UserModel userModel =  (UserModel) criteria.uniqueResult();
		return userModel;
	}
	
	@Override
	public UserModel returnCheckDuplicateByUserProperties(UserDTO userDTO) 
	{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UserModel.class, "um");
		criteria.add(Restrictions.eq("um.isDeleted", false));
		if(userDTO.getUsername() != null && !"".equals(userDTO.getUsername()))
		{
			criteria.add(Restrictions.eq("username", userDTO.getUsername()));
		}
		
		UserModel userModel =  (UserModel) criteria.uniqueResult();
		return userModel;
	}

	@Override
	public List<UserModel> returnAllUserModel() 
	{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UserModel.class);
		criteria.add( Restrictions.eq("isDeleted", false));
		return (List<UserModel>)criteria.list();
	}

	@Override
	public UserModel deleteUserModelById(Long userId) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long returnAllUserModelForGridCount(String fullName) 
	{
		// TODO Auto-generated method stub
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UserModel.class, "um");
		
		criteria.createAlias("um.departmentsModel", "departmentsModel"); // inner join by
		criteria.setFetchMode("departmentsModel", FetchMode.JOIN);
		criteria.createAlias("um.employeeModel", "employeeModel"); // inner join by
		criteria.setFetchMode("employeeModel", FetchMode.JOIN);
		criteria.createAlias("um.campusesModel", "campusesModel"); // inner join by
		criteria.setFetchMode("campusesModel", FetchMode.JOIN);
		
		if(fullName != null && !"".equals(fullName))
		{
			criteria.add( Restrictions.like("fullName", "%"+fullName+"%"));
		}
		criteria.add( Restrictions.eq("isDeleted", false));
		criteria.setProjection(Projections.rowCount());
		Long records = (Long)criteria.uniqueResult();
		return records;
	}

}
