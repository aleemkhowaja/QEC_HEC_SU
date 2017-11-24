package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dao.DepartmentDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.EmployeeDTO;
import com.qec.enums.EmployeeTitle;
import com.qec.enums.Gender;
import com.qec.enums.MaritalStatus;
import com.qec.enums.Religion;
import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;
import com.qec.service.EmployeesService;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	@Transactional
	public JQGridDTO<EmployeeDTO> returnAllEmployeesForGrid(HttpServletRequest request)
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
	@Transactional
	public String saveEmployee(EmployeeDTO employeeDTO)
	{
		try 
		{
			EmployeeModel employeeModel = new EmployeeModel();
			DepartmentsModel departmentsModel = new DepartmentsModel(); 
			if(employeeDTO.getDepartmentId() != null)
			{
				departmentsModel = departmentDAO.returnDepartmentById(Long.valueOf(employeeDTO.getDepartmentId()));
			}
			if(employeeDTO.getEmployeeId() == null)
			{
				employeeModel.setFullName(employeeDTO.getFullName());
				employeeModel.setFatherName(employeeDTO.getFatherName());
				employeeModel.setDob(employeeDTO.getDob());
				employeeModel.setMaritalStatus(MaritalStatus.getValue(employeeDTO.getMaritalStatus()));
				employeeModel.setEmail(employeeDTO.getEmail());
				employeeModel.setHusbandName(employeeDTO.getHusbandName());
				employeeModel.setMobile(employeeDTO.getMobile());
				employeeModel.setPhone(employeeDTO.getPhone());
				employeeModel.setSurname(employeeDTO.getSurname());
			    employeeModel.setPostalAddress(employeeDTO.getPostalAddress());
			    employeeModel.setNic(employeeDTO.getNic());
			    employeeModel.setGender(Gender.getValue(employeeDTO.getGender()));
			    employeeModel.setTitle(EmployeeTitle.getValue(employeeDTO.getTitle()));
			    employeeModel.setReligion(Religion.getValue(employeeDTO.getReligion()));
			    employeeModel.setDepartmentsModel(departmentsModel);
			    employeeModel.setIsDeleted(employeeDTO.getIsDeleted());
			    genericDAO.save(employeeModel);
			    return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				employeeModel = employeeDAO.returnEmployeesById(Long.valueOf(employeeDTO.getEmployeeId()));
				employeeModel.setFullName(employeeDTO.getFullName());
				employeeModel.setFatherName(employeeDTO.getFatherName());
				employeeModel.setDob(employeeDTO.getDob());
				employeeModel.setMaritalStatus(MaritalStatus.getValue(employeeDTO.getMaritalStatus()));
				employeeModel.setEmail(employeeDTO.getEmail());
				employeeModel.setHusbandName(employeeDTO.getHusbandName());
				employeeModel.setMobile(employeeDTO.getMobile());
				employeeModel.setPhone(employeeDTO.getPhone());
				employeeModel.setSurname(employeeDTO.getSurname());
			    employeeModel.setPostalAddress(employeeDTO.getPostalAddress());
			    employeeModel.setNic(employeeDTO.getNic());
			    employeeModel.setGender(Gender.getValue(employeeDTO.getGender()));
			    employeeModel.setTitle(EmployeeTitle.getValue(employeeDTO.getTitle()));
			    employeeModel.setReligion(Religion.getValue(employeeDTO.getReligion()));
			    employeeModel.setDepartmentsModel(departmentsModel);
			    genericDAO.update(employeeModel);
			    return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public String deleteEmployee(EmployeeDTO employeeDTO)
	{
		try
		{
			EmployeeModel employeeModel = employeeDAO.returnEmployeesById(employeeDTO.getEmployeeId());
			employeeModel.setIsDeleted(true);
			genericDAO.update(employeeModel);
			return CommonConstants.DELETE_SUCCESS_MSG;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public EmployeeDTO returnEmployeesById(Integer employeesId)
	{
		EmployeeDTO employeeDTO = new EmployeeDTO();
		try
		{
			if(employeesId != null)
			{
				EmployeeModel employeeModel = employeeDAO.returnEmployeesById(Long.valueOf(employeesId));
				employeeDTO.setEmployeeId(employeeModel.getEmployeeId());
				employeeDTO.setFullName(employeeModel.getFullName());
				employeeDTO.setGender(employeeModel.getGender());
				employeeDTO.setDob(employeeModel.getDob());
				employeeDTO.setCast(employeeModel.getCast());
				employeeDTO.setEmail(employeeModel.getEmail());
				employeeDTO.setFatherName(employeeModel.getFatherName());
				employeeDTO.setTitle(employeeModel.getTitle());
				employeeDTO.setSurname(employeeModel.getSurname());
				employeeDTO.setPostalAddress(employeeModel.getPostalAddress());
				employeeDTO.setPresentAddress(employeeModel.getPresentAddress());
				employeeDTO.setReligion(employeeModel.getReligion());
				employeeDTO.setMaritalStatus(employeeModel.getMaritalStatus());
				DepartmentsModel departmentsModel = employeeModel.getDepartmentsModel();
				if(departmentsModel != null)
				{
					employeeDTO.setDepartmentId(Integer.valueOf(departmentsModel.getDepartmentId().toString()));
				}
				employeeDTO.setPhone(employeeModel.getPhone());
				employeeDTO.setNic(employeeModel.getNic());
				employeeDTO.setMobile(employeeModel.getMobile());
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employeeDTO;
	}
	
}
