package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.JTableList;
import com.qec.dao.DepartmentDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.EmployeeDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;
import com.qec.service.EmployeesService;
@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	public JTableList<EmployeeModel> returnAllEmployeesForGrid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeModel returnEmployeesById(Integer EmployeesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<EmployeeDTO> returnAllEmployeeModels() {
		List employeeDTOs = new ArrayList<>(); 
		
		try
		{
			List emploayeeModel = employeeDAO.returnAllEmployeeModels();
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFullName("Select Employee");
			employeeDTOs.add(employeeDTO);
			employeeDTOs.addAll(emploayeeModel);
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		return employeeDTOs ;
	}

}
