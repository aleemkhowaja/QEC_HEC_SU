package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.JTableList;
import com.qec.dao.CampusesDAO;
import com.qec.dto.CampusesDTO;
import com.qec.model.CampusesModel;
import com.qec.service.CampusesService;

@Service
public class CampusesServiceImpl implements CampusesService  {

	@Autowired
	private CampusesDAO campusesDAO;
	
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

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<CampusesDTO> returnAllCampuses() 
	{
		List campusesDTOs = new ArrayList<CampusesDTO>();
		try
		{
			List campusesModels = campusesDAO.returnAllCampuses();
			
			CampusesDTO campusesDTO = new CampusesDTO();
			campusesDTO.setCampusName("Select Campus");
			campusesDTOs.add(campusesDTO);
			campusesDTOs.addAll(campusesModels);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return campusesDTOs;
	}

/*	public CampusesDAO getCampusesDAO() {
		return campusesDAO;
	}

	public void setCampusesDAO(CampusesDAO campusesDAO) {
		this.campusesDAO = campusesDAO;
	}*/
	

	
}
