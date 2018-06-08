package com.qec.repository;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;

import com.qec.model.UserModel;

public interface LoginRepository {

	public UserModel login(UserModel usersModel) throws HibernateException;
	
	public UserModel findByUserName(String username)  throws HibernateException;
	
}
