package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.JQGridDTO;
import com.qec.common.JTableList;
import com.qec.dao.DepartmentDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dao.UserDAO;
import com.qec.dto.UserDTO;
import com.qec.model.CampusesModel;
import com.qec.model.EmployeeModel;
import com.qec.model.UserModel;
import com.qec.service.CampusesService;
import com.qec.service.UsersService;

@Service
public class CampusesServiceImpl implements CampusesService  {

	@Override
	public JTableList<CampusesModel> returnAllCampusesForGrid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CampusesModel returnCampusesById(Integer CampusesId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
