package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.common.JQGridDTO;
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
	@Transactional
	public JQGridDTO<EmployeeDTO> returnAllEmployeesForGrid(HttpServletRequest request) throws Exception 
	{
		JQGridDTO<EmployeeDTO> jqGridDTO = new JQGridDTO<EmployeeDTO>();
		List<EmployeeModel> employeeModels = new ArrayList<EmployeeModel>();
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		
		EmployeeModel employeeModel = new EmployeeModel();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String employeeName = request.getParameter("fullName");
			
			employeeModels = employeeDAO.returnAllEmployeesForGrid(jtStartIndex, jtPageSize, sortingProperty, order, employeeName);
			Long records =   employeeDAO.returnAllEmployeeForGridCount(employeeName);
			for(int i=0; i<employeeModels.size(); i++) 
			{
				employeeModel = employeeModels.get(i);
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployeeId(employeeModel.getEmployeeId());
				employeeDTO.setFullName(employeeModel.getFullName());
				employeeDTO.setFatherName(employeeModel.getFatherName());
				employeeDTO.setEmail(employeeModel.getEmail());
				employeeDTO.setGender(employeeModel.getGender());
				employeeDTO.setMobile(employeeModel.getMobile());
				employeeDTO.setSurname(employeeModel.getSurname());
				employeeDTOs.add(employeeDTO);
			}
			jqGridDTO.setRows(employeeDTOs);
			jqGridDTO.setTotal(String.valueOf(Math.ceil((double) records / jtPageSize)));
			jqGridDTO.setRecords(String.valueOf(records));
			jqGridDTO.setPage(page);
			
		}catch(Exception ex)
		{			
			ex.printStackTrace();
		}
		
		return jqGridDTO;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<EmployeeDTO> returnAllEmployeeModels() 
	{
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

	@Override
	public String saveEmployee(EmployeeDTO employeeDTO) throws Exception 
	{
		return null;
	}

	@Override
	public String deleteDepartment(DepartmentsModel departmentsModel) throws Exception
	{
		return null;
	}

	@Override
	public EmployeeDTO returnEmployeesById(Integer EmployeesId) throws Exception
	{
		return null;
	}
	
}
