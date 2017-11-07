package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.JQGridDTO;
import com.qec.dao.DepartmentDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dao.UserDAO;
import com.qec.dto.UserDTO;
import com.qec.model.EmployeeModel;
import com.qec.model.UserModel;
import com.qec.service.UsersService;

@Service
public class UserServiceImpl implements UsersService  {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private GenericDAO genericDAO;
	
	/*@Autowired
	private CampusesDAO campusesDAO;*/
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public JQGridDTO<UserDTO> returnAllUsersForGrid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		JQGridDTO<UserDTO> jqGridDTO = new JQGridDTO<UserDTO>();
		List<UserModel> userModels = new ArrayList<UserModel>();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		UserModel userModel = new UserModel();
		UserDTO userDTO = new UserDTO();
		
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtStartIndex = 0;
			Integer jtPageSize = request.getParameter("rows") == null ? null : Integer.parseInt(request.getParameter("rows"));
			
			String fullName = request.getParameter("fullName");
			
			userModels =  userDAO.returnAllUserModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, fullName);
			System.out.println(userModels.size());
			Long records = userDAO.returnAllUserModelForGridCount(fullName);
			for(int i=0; i<userModels.size(); i++) 
			{
				
				userModel = userModels.get(i);
				userDTO = new UserDTO();
			//	userDTO.setDepartmentName(userModel.getDepartmentsModel().getName());
				userDTO.setEmployeeFullName(userModel.getEmployeeModel().getFullName());
				//userDTO.setCampusesName(userModel.getCampusesModel().getCampusName())
				userDTO.setUsername(userModel.getUsername());
				userDTO.setFullName(userModel.getFullName());
				userDTO.setUserId(userModel.getUserId());
				userDTO.setEmail(userModel.getEmail());
				userDTOs.add(userDTO);
			}
			jqGridDTO.setRows(userDTOs);
			jqGridDTO.setTotal(String.valueOf(Math.ceil((double) records / jtPageSize)));
			jqGridDTO.setRecords(String.valueOf(records));
			jqGridDTO.setTotal(String.valueOf(Math.ceil((double) userModels.size() / jtPageSize)));
			jqGridDTO.setRecords(String.valueOf(userModels.size()));
			jqGridDTO.setPage(page);
		}catch(Exception ex)
		{			ex.printStackTrace();
		}
		
		return jqGridDTO;
	}
	
	@Override
	@Transactional
	public String saveUserModel(UserDTO userDTO) {
		// TODO Auto-generated method stub
		UserModel userModel = new UserModel();
		try 
		{
			//DepartmentsModel departmentsModel = new DepartmentsModel(); 
			EmployeeModel 	employeeModel = new EmployeeModel();
			/*if(userDTO.getDepartmentId() != null)
			{
				departmentsModel = departmentDAO.returnDepartmentById(Long.valueOf(userDTO.getDepartmentId()));
			}*/
			if(userDTO.getEmployeeId() != null)
			{
				employeeModel = employeeDAO.returnEmployeesById(Long.valueOf(userDTO.getEmployeeId()));
			}
			
			if(userDTO.getUserId() == null)
			{
				 
				userModel.setFullName(userDTO.getFullName());
				userModel.setEmail(userDTO.getEmail());
				/*userModel.setCampusId(userDTO.getCampusId());*/
				userModel.setPassword(userDTO.getPassword());
				userModel.setUsername(userDTO.getUsername());
				userModel.setEmployeeModel(employeeModel);;
				//userModel.setDepartmentsModel(departmentsModel);  //
			    userModel.setIsActive(userDTO.getIsActive());
				userModel.setIsDeleted(false);
				genericDAO.save(userModel);
				return "Record Inserted Successfully";
			}
			else
			{
				userModel = userDAO.returnUserModelById(userDTO.getUserId());
				userModel.setEmployeeModel(employeeModel);;
				//userModel.setDepartmentsModel(departmentsModel);
				userModel.setFullName(userDTO.getFullName());
				userModel.setEmail(userDTO.getEmail());
				/*userModel.setCampusId(userDTO.getCampusId());*/
				userModel.setPassword(userDTO.getPassword());
				userModel.setUsername(userDTO.getUsername());
			 	userModel.setIsActive(userDTO.getIsActive());
				genericDAO.update(userModel);
				return "Record Updated Successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public String deleteUserModel(UserDTO userDTO) {
		// TODO Auto-generated method stub
		UserModel userModels = new UserModel();
		try 
		{
			if(userDTO.getUserId() != null)
			{
				userModels = userDAO.returnUserModelById(userDTO.getUserId());
				userModels.setIsDeleted(true);
				genericDAO.update(userModels);
				return "Record Delete Successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public UserDTO getUserModelById(Long userId) {
		// TODO Auto-generated method stub
		UserModel userModel = new UserModel();
		UserDTO userDTO = new UserDTO();
		try 
		{
			userModel = userDAO.returnUserModelById(userId);
			/*userDTO.setDepartmentId(Long.valueOf(userModel.getDepartmentsModel().getDepartmentId()));*/
			userDTO.setEmployeeId(Long.valueOf(userModel.getEmployeeModel().getEmployeeId()));
			userDTO.setFullName(userModel.getFullName());
			userDTO.setUsername(userModel.getUsername());
			userDTO.setUserId(userModel.getUserId());
			userDTO.setEmail(userModel.getEmail());
		//	userDTO.setPassword(userModel.getPassword());
			userDTO.setIsActive(userModel.getIsActive());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public List<UserDTO> returnAllUserModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
