package com.qec.dao;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;

import com.qec.model.UserModel;

public interface LoginDAO {

	public UserModel login(UserModel usersModel) throws HibernateException;
	
}
