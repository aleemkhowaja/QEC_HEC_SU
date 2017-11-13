package com.qec.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;

import com.qec.model.CampusesModel;
import com.qec.model.UserModel;

public interface CampusesDAO {

	/**
	 * return all campuses 
	 * @return
	 */
	 public List<CampusesModel> returnAllCampuses();
	 
	 /**
	  * return Campus Model by campusId
	  * @param campusId
	  * @return
	  */
	 public CampusesModel returnCampusByCampusId(Long campusId);
	
}
