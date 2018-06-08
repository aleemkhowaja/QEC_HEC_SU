package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dto.DepartmentsDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.dto.EmployeeMphilPhdStudentsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;
import com.qec.model.EmployeeMphilPhdStudentsModel;
import com.qec.repository.EmployeeMphilPhdStudentsRepository;
import com.qec.repository.EmployeeRepository;
import com.qec.repository.GenericRepository;
import com.qec.service.EmployeeMphilPhdStudentsService;

@Service
public class EmployeesMphilPhdStudentsServiceImpl implements EmployeeMphilPhdStudentsService {

	@Autowired
	private EmployeeMphilPhdStudentsRepository employeeMphilPhdStudentsDAO;
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	@Autowired
	private GenericRepository genericDAO;

	@Override
	@Transactional
	public JQGridDTO<EmployeeMphilPhdStudentsDTO> returnAllEmployeeMphilPhdStudentsForGrid(HttpServletRequest request) {
		JQGridDTO<EmployeeMphilPhdStudentsDTO> jqGridDTO = new JQGridDTO<EmployeeMphilPhdStudentsDTO>();
		List<EmployeeMphilPhdStudentsModel> employeeMphilPhdStudentsModels = new ArrayList<EmployeeMphilPhdStudentsModel>();
		List<EmployeeMphilPhdStudentsDTO> employeeMphilPhdStudentsDTOs = new ArrayList<EmployeeMphilPhdStudentsDTO>();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String employeeMphilPhdStudents = request.getParameter("EmployeeMphilPhdStudentsDTO");
			
			employeeMphilPhdStudentsModels =  employeeMphilPhdStudentsDAO.returnAllEmployeeMphilPhdStudentsModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, employeeMphilPhdStudents);
			Long records = employeeMphilPhdStudentsDAO.returnAllEmployeeMphilPhdStudentsModelForGridCount(employeeMphilPhdStudents);
			EmployeeMphilPhdStudentsDTO  employeeMphilPhdStudentsDTO = null;
			EmployeeDTO  employeeDTO = null;
			DepartmentsDTO departmentsDTO = null;
			for(int i=0; i<employeeMphilPhdStudentsModels.size(); i++)
			{
				employeeDTO = new EmployeeDTO();
				departmentsDTO = new DepartmentsDTO();
				employeeMphilPhdStudentsDTO = new EmployeeMphilPhdStudentsDTO();
				EmployeeMphilPhdStudentsModel employeeMphilPhdStudentsModel = employeeMphilPhdStudentsModels.get(i);
				EmployeeModel employeeModel =  employeeMphilPhdStudentsModel.getEmployee();
				DepartmentsModel  departmentsModel = employeeMphilPhdStudentsModel.getDepartments();
				if(employeeModel != null)
				{
					employeeDTO.setEmployeeId(employeeModel.getEmployeeId());
					employeeDTO.setFullName(employeeModel.getFullName());
				}
				
				if(departmentsModel != null)
				{
					departmentsDTO.setDepartmentId(departmentsModel.getDepartmentId());
					departmentsDTO.setName(departmentsModel.getName());
				}
				employeeMphilPhdStudentsDTO.setEmployeeMphilPhdStudentsId(employeeMphilPhdStudentsModel.getEmployeeMphilPhdStudentsId());
				employeeMphilPhdStudentsDTO.setEmployee(employeeDTO);
				employeeMphilPhdStudentsDTO.setStartDate(String.valueOf(employeeMphilPhdStudentsModel.getStartDate()));
				employeeMphilPhdStudentsDTO.setStudentName(employeeMphilPhdStudentsModel.getStudentName());
				employeeMphilPhdStudentsDTO.setDtype(employeeMphilPhdStudentsModel.getDtype());
				employeeMphilPhdStudentsDTO.setDepartments(departmentsDTO);
				employeeMphilPhdStudentsDTO.setNoOfStudents(employeeMphilPhdStudentsModel.getNoOfStudents());
				employeeMphilPhdStudentsDTO.setRegistrationDate(String.valueOf(employeeMphilPhdStudentsModel.getRegistrationDate()));
				employeeMphilPhdStudentsDTO.setStudentId(employeeMphilPhdStudentsModel.getStudentId());
				employeeMphilPhdStudentsDTO.setApprovedTopic(employeeMphilPhdStudentsModel.getApprovedTopic());
				employeeMphilPhdStudentsDTOs.add(employeeMphilPhdStudentsDTO);
				/*Class tClass = employeeTrainingModel.getClass();
				Method[] methods = tClass.getMethods();
				for (int j = 0; j < methods.length; j++) {
					System.out.println("public method: " + methods[j].);
				}*/
			}
			//trainingDTOs.addAll(trainingModels);
			
			jqGridDTO.setRows(employeeMphilPhdStudentsDTOs);
			jqGridDTO.setTotal(String.valueOf(Math.ceil((double) records / jtPageSize)));
			jqGridDTO.setRecords(String.valueOf(records));
			jqGridDTO.setPage(page);
			
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return jqGridDTO;
	}

	@Override
	@Transactional
	public EmployeeMphilPhdStudentsDTO returnEmployeeMphilPhdStudentsById(Long employeeMphilPhdStudentsId) {
		EmployeeMphilPhdStudentsDTO employeeMphilPhdStudentsDTO = new EmployeeMphilPhdStudentsDTO();
		try
		{
			EmployeeMphilPhdStudentsModel employeeMphilPhdStudentsModel = employeeMphilPhdStudentsDAO.returnEmployeeMphilPhdStudentsModelById(employeeMphilPhdStudentsId);
			EmployeeModel employeeModel = employeeMphilPhdStudentsModel.getEmployee();
			DepartmentsModel departmentsModel = employeeMphilPhdStudentsModel.getDepartments();
			
			employeeMphilPhdStudentsDTO.setEmployeeMphilPhdStudentsId(employeeMphilPhdStudentsModel.getEmployeeMphilPhdStudentsId());
			if(employeeModel != null)
			{
				employeeMphilPhdStudentsDTO.setEmployeeId(employeeModel.getEmployeeId());
			}
			
			if(departmentsModel != null)
			{
				employeeMphilPhdStudentsDTO.setDepartmentId(departmentsModel.getDepartmentId());
			}
			employeeMphilPhdStudentsDTO.setStudentName(employeeMphilPhdStudentsModel.getStudentName());
			employeeMphilPhdStudentsDTO.setDtype(employeeMphilPhdStudentsModel.getDtype());
			employeeMphilPhdStudentsDTO.setStartDate(String.valueOf(employeeMphilPhdStudentsModel.getStartDate()));
			employeeMphilPhdStudentsDTO.setRegistrationDate(String.valueOf(employeeMphilPhdStudentsModel.getRegistrationDate()));
			employeeMphilPhdStudentsDTO.setStudentId(employeeMphilPhdStudentsModel.getStudentId());
			employeeMphilPhdStudentsDTO.setApprovedTopic(employeeMphilPhdStudentsModel.getApprovedTopic());
			employeeMphilPhdStudentsDTO.setNoOfStudents(employeeMphilPhdStudentsModel.getNoOfStudents());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return employeeMphilPhdStudentsDTO;
	}

	@Override
	@Transactional
	public String saveEmployeeMphilPhdStudents(MultipartHttpServletRequest request) 
	{
		/*try {
			
			MultipartFile multipartFile = request.getFile("employeeTraining_file");
			
			String employeeId = request.getParameter("employeeId");
			String employeeTrainingDate = request.getParameter("dateof");
			String employeeTrainingName = request.getParameter("name");
			String locality = request.getParameter("locality");
			String trainingCondition = request.getParameter("trainingCondition");
			String instituteName = request.getParameter("instituteName");
			String employeeTrainingid = request.getParameter("employeeTrainingsId");
			
			Long size = multipartFile.getSize();
			
			String fileName = "employeeTrainingFile"+System.currentTimeMillis()+".txt";
		    String contentType = multipartFile.getContentType();
		    InputStream stream;
		    byte[] bytes;
		    //get input stream from multipart/ upload file
			stream = multipartFile.getInputStream();
			//get bytes from upload file
			bytes = IOUtils.toByteArray(stream);
			File path = new File(CommonConstants.uploadFileUrl+"employeeTrainingFile/"+fileName);
			path.setReadable(true, false);
			path.setExecutable(true, false);
			path.setWritable(true, false);
			
			if(!path.exists())
			{
				path.createNewFile();
			}
			FileOutputStream out = new FileOutputStream (path);
			try 
			{
				out.write(bytes);
			} finally 
			{
				stream.close();
			}
			EmployeeModel employeeModel = new EmployeeModel();
			if(employeeId != null && !employeeId.equals(""))
			{
				employeeModel = employeeDAO.returnEmployeesById(Long.valueOf(employeeId));
			}
			
			EmployeeTrainingModel employeeTrainingModel = new EmployeeTrainingModel();
			if(employeeTrainingid == null || "".equals(employeeTrainingid))
			{
				employeeTrainingModel.setInstituteName(instituteName);
				employeeTrainingModel.setLocality(locality);
				employeeTrainingModel.setName(employeeTrainingName);
				employeeTrainingModel.setTrainingCondition(trainingCondition);
				employeeTrainingModel.setEmployee(employeeModel);
				employeeTrainingModel.setDateof(DateUtil.stringToDate(employeeTrainingDate));
				employeeTrainingModel.setIsDeleted(false);
				genericDAO.save(employeeTrainingModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				employeeTrainingModel = employeeTrainingDAO.returnEmployeeTrainingModelById(Long.valueOf(employeeTrainingid));
				employeeTrainingModel.setInstituteName(instituteName);
				employeeTrainingModel.setLocality(locality);
				employeeTrainingModel.setName(employeeTrainingName);
				employeeTrainingModel.setTrainingCondition(trainingCondition);
				employeeTrainingModel.setEmployee(employeeModel);
				employeeTrainingModel.setDateof(DateUtil.stringToDate(employeeTrainingDate));
				employeeTrainingModel.setEmployee(employeeModel);
				genericDAO.update(employeeTrainingModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return null;
	}

	@Override
	@Transactional
	public String deleteEmployeeMphilPhdStudents(Long employeeMphilPhdStudentsId) 
	{
		try
		{
			EmployeeMphilPhdStudentsModel employeeMphilPhdStudentsModel = employeeMphilPhdStudentsDAO.returnEmployeeMphilPhdStudentsModelById(employeeMphilPhdStudentsId);
			employeeMphilPhdStudentsModel.setIsDeleted(true);
			genericDAO.update(employeeMphilPhdStudentsModel);
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
	public List<EmployeeMphilPhdStudentsDTO> returnAllEmployeeMphilPhdStudents() 
	{
		EmployeeDTO  employeeDTO = null;
		DepartmentsDTO departmentsDTO = null;
		EmployeeMphilPhdStudentsDTO  employeeMphilPhdStudentsDTO = null;
		List<EmployeeMphilPhdStudentsDTO> employeeMphilPhdStudentsDTOs = new ArrayList<EmployeeMphilPhdStudentsDTO>();
		try
		{
			List<EmployeeMphilPhdStudentsModel> employeeMphilPhdStudentsModels = employeeMphilPhdStudentsDAO.returnAllEmployeeMphilPhdStudentsModels();
			for(int i=0; i<employeeMphilPhdStudentsModels.size(); i++)
			{
				employeeDTO = new EmployeeDTO();
				departmentsDTO = new DepartmentsDTO();
				employeeMphilPhdStudentsDTO = new EmployeeMphilPhdStudentsDTO();
				EmployeeMphilPhdStudentsModel employeeMphilPhdStudentsModel = employeeMphilPhdStudentsModels.get(i);
				EmployeeModel employeeModel =  employeeMphilPhdStudentsModel.getEmployee();
				DepartmentsModel  departmentsModel = employeeMphilPhdStudentsModel.getDepartments();
				if(employeeModel != null)
				{
					employeeDTO.setEmployeeId(employeeModel.getEmployeeId());
					employeeDTO.setFullName(employeeModel.getFullName());
				}
				
				if(departmentsModel != null)
				{
					departmentsDTO.setDepartmentId(departmentsModel.getDepartmentId());
					departmentsDTO.setName(departmentsModel.getName());
				}
				employeeMphilPhdStudentsDTO.setEmployeeMphilPhdStudentsId(employeeMphilPhdStudentsModel.getEmployeeMphilPhdStudentsId());
				employeeMphilPhdStudentsDTO.setEmployee(employeeDTO);
				employeeMphilPhdStudentsDTO.setStartDate(String.valueOf(employeeMphilPhdStudentsModel.getStartDate()));
				employeeMphilPhdStudentsDTO.setStudentName(employeeMphilPhdStudentsModel.getStudentName());
				employeeMphilPhdStudentsDTO.setDtype(employeeMphilPhdStudentsModel.getDtype());
				employeeMphilPhdStudentsDTO.setDepartments(departmentsDTO);
				employeeMphilPhdStudentsDTO.setNoOfStudents(employeeMphilPhdStudentsModel.getNoOfStudents());
				employeeMphilPhdStudentsDTO.setRegistrationDate(String.valueOf(employeeMphilPhdStudentsModel.getRegistrationDate()));
				employeeMphilPhdStudentsDTO.setStudentId(employeeMphilPhdStudentsModel.getStudentId());
				employeeMphilPhdStudentsDTO.setApprovedTopic(employeeMphilPhdStudentsModel.getApprovedTopic());
				employeeMphilPhdStudentsDTOs.add(employeeMphilPhdStudentsDTO);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return employeeMphilPhdStudentsDTOs;
	}
	
	
	
}
