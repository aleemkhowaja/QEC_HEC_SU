package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.common.SecurityUtil;
import com.qec.dto.UserDTO;
import com.qec.enums.Role;
import com.qec.model.CampusesModel;
import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;
import com.qec.model.UserModel;
import com.qec.repository.CampusesRepository;
import com.qec.repository.DepartmentRepository;
import com.qec.repository.EmployeeRepository;
import com.qec.repository.GenericRepository;
import com.qec.repository.UserRepository;
import com.qec.service.UsersService;

@Service
public class UserServiceImpl implements UsersService  {
	
	@Autowired
	private UserRepository userDAO;
	
	@Autowired
	private GenericRepository genericDAO;
	
	@Autowired
	private DepartmentRepository departmentDAO;
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	@Autowired
	private CampusesRepository campusesDAO;
	

	@Override
	@Transactional
	public JQGridDTO<UserDTO> returnAllUsersForGrid(HttpServletRequest request) 
	{
		JQGridDTO<UserDTO> jqGridDTO = new JQGridDTO<UserDTO>();
		List<UserModel> userModels = new ArrayList<UserModel>();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		UserModel userModel = new UserModel();
		UserDTO userDTO = new UserDTO();
		
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String fullName = request.getParameter("fullName");
			
			userModels =  userDAO.returnAllUserModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, fullName);
			Long records = userDAO.returnAllUserModelForGridCount(fullName);
			for(int i=0; i<userModels.size(); i++) 
			{
				userModel = userModels.get(i);
				userDTO = new UserDTO();
				userDTO.setDepartmentName(userModel.getDepartmentsModel().getName());
				userDTO.setEmployeeFullName(userModel.getEmployeeModel().getFullName());
				userDTO.setCampusName(userModel.getCampusesModel().getCampusName());
				userDTO.setUsername(userModel.getUsername());
				userDTO.setFullName(userModel.getFullName());
				userDTO.setUserId(userModel.getUserId());
				userDTO.setEmail(userModel.getEmail());
				if(userModel.getIsActive())
				{
					userDTO.setStatus("Yes");
				}
				else
				{
					userDTO.setStatus("No");
				}
				userDTOs.add(userDTO);
			}
			jqGridDTO.setRows(userDTOs);
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
	@Transactional
	public String saveUserModel(UserDTO userDTO) 
	{
		try 
		{
			if(!userDTO.getUsername().equals(userDTO.getOldUsername()))
			{
				UserModel userModel = userDAO.returnCheckDuplicateByUserProperties(userDTO);
				if(userModel != null)
				{
					return "Duplicate";
				}
				
			}
			UserModel userModel = new UserModel();
			DepartmentsModel departmentsModel = new DepartmentsModel(); 
			EmployeeModel 	employeeModel = new EmployeeModel();
			CampusesModel campusesModel = new CampusesModel();
			if(userDTO.getDepartmentId() != null)
			{
				departmentsModel = departmentDAO.returnDepartmentById(Long.valueOf(userDTO.getDepartmentId()));
			}
			if(userDTO.getEmployeeId() != null)
			{
				employeeModel = employeeDAO.returnEmployeesById(Long.valueOf(userDTO.getEmployeeId()));
			}
			if(userDTO.getCampusesId() != null)
			{
				campusesModel = campusesDAO.returnCampusByCampusId(userDTO.getCampusesId());
			}
			
			if(userDTO.getUserId() == null)
			{
				userModel.setFullName(userDTO.getFullName());
				userModel.setEmail(userDTO.getEmail());
				userModel.setPassword(SecurityUtil.encodePassword(userDTO.getPassword()));
				userModel.setUsername(userDTO.getUsername());
				userModel.setEmployeeModel(employeeModel);
				userModel.setDepartmentsModel(departmentsModel);
				userModel.setCampusesModel(campusesModel);
			    userModel.setIsActive(userDTO.getIsActive());
				userModel.setIsDeleted(userDTO.getIsDeleted());
				userModel.setRole(Role.Coordinator.getValue());
				genericDAO.save(userModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				userModel = userDAO.returnUserModelByUserProperties(userDTO);
				userModel.setEmployeeModel(employeeModel);
				userModel.setDepartmentsModel(departmentsModel);
				userModel.setCampusesModel(campusesModel);
				userModel.setFullName(userDTO.getFullName());
				userModel.setEmail(userDTO.getEmail());
				userModel.setPassword(userDTO.getPassword());
				userModel.setUsername(userDTO.getUsername());
			 	userModel.setIsActive(userDTO.getIsActive());
				genericDAO.update(userModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public String deleteUserModel(UserDTO userDTO) 
	{
		UserModel userModels = new UserModel();
		try 
		{
			if(userDTO.getUserId() != null)
			{
				userModels = userDAO.returnUserModelByUserProperties(userDTO);
				userModels.setIsDeleted(true);
				genericDAO.update(userModels);
				return CommonConstants.DELETE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public UserDTO getUserModelById(Long userId) 
	{
		UserModel userModel = new UserModel();
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		try 
		{
			userModel = userDAO.returnUserModelByUserProperties(userDTO);
			userDTO.setDepartmentId(userModel.getDepartmentsModel() != null ? userModel.getDepartmentsModel().getDepartmentId():Long.valueOf(""));
			userDTO.setEmployeeId(userModel.getEmployeeModel() != null ? userModel.getEmployeeModel().getEmployeeId() : Long.valueOf(""));
			userDTO.setCampusesId(userModel.getCampusesModel() != null ? userModel.getCampusesModel().getCampusesId() : Long.valueOf(""));
			userDTO.setFullName(userModel.getFullName());
			userDTO.setUsername(userModel.getUsername());
			userDTO.setUserId(userModel.getUserId());
			userDTO.setEmail(userModel.getEmail());
			userDTO.setIsActive(userModel.getIsActive());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public List<UserDTO> returnAllUserModel() 
	{
		return null;
	}

	
}
