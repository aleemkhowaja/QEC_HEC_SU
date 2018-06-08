package com.qec.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qec.common.CommonConstants;
import com.qec.common.DateUtil;
import com.qec.common.JQGridDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.dto.EmployeeTrainingDTO;
import com.qec.model.CitationBookModel;
import com.qec.model.DepartmentsModel;
import com.qec.model.EmployeeModel;
import com.qec.model.EmployeeTrainingModel;
import com.qec.repository.EmployeeRepository;
import com.qec.repository.EmployeeTrainingRepository;
import com.qec.repository.GenericRepository;
import com.qec.service.EmployeeTrainingService;

@Service
public class EmployeesTrainingServiceImpl implements EmployeeTrainingService {

	@Autowired
	private EmployeeTrainingRepository employeeTrainingDAO;
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	@Autowired
	private GenericRepository genericDAO;

	@Override
	@Transactional
	public JQGridDTO<EmployeeTrainingDTO> returnAllEmployeeTrainingsForGrid(HttpServletRequest request) {
		JQGridDTO<EmployeeTrainingDTO> jqGridDTO = new JQGridDTO<EmployeeTrainingDTO>();
		List<EmployeeTrainingModel> trainingModels = new ArrayList<EmployeeTrainingModel>();
		List<EmployeeTrainingDTO> trainingDTOs = new ArrayList<EmployeeTrainingDTO>();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String employeeTrainingName = request.getParameter("employeeTrainingName");
			
			trainingModels =  employeeTrainingDAO.returnAllEmployeeTrainingModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, employeeTrainingName);
			Long records = employeeTrainingDAO.returnAllEmployeeTrainingModelForGridCount(employeeTrainingName);
			EmployeeTrainingDTO employeeTrainingDTO = null;
			EmployeeDTO employeeDTO = new EmployeeDTO();
			for(int i=0; i<trainingModels.size(); i++)
			{
				employeeTrainingDTO = new EmployeeTrainingDTO();
				EmployeeTrainingModel employeeTrainingModel = trainingModels.get(i);
				EmployeeModel employeeModel =  employeeTrainingModel.getEmployee();
				if(employeeModel != null)
				{
					employeeDTO.setEmployeeId(employeeModel.getEmployeeId());
					employeeDTO.setFullName(employeeModel.getFullName());
				}
				employeeTrainingDTO.setEmployeeTrainingsId(employeeTrainingModel.getEmpTrainingsId());
				employeeTrainingDTO.setEmployee(employeeDTO);
				employeeTrainingDTO.setDateof(String.valueOf(employeeTrainingModel.getDateof()));
				employeeTrainingDTO.setEmployeeId(employeeModel.getEmployeeId());
				employeeTrainingDTO.setFundingDetail(employeeTrainingModel.getFundingDetail());
				employeeTrainingDTO.setInstituteName(employeeTrainingModel.getInstituteName());
				employeeTrainingDTO.setLocality(employeeTrainingModel.getLocality());
				employeeTrainingDTO.setName(employeeTrainingModel.getName());
				employeeTrainingDTO.setPlace(employeeTrainingModel.getPlace());
				employeeTrainingDTO.setTrainingCondition(employeeTrainingModel.getTrainingCondition());
				trainingDTOs.add(employeeTrainingDTO);
				/*Class tClass = employeeTrainingModel.getClass();
				Method[] methods = tClass.getMethods();
				for (int j = 0; j < methods.length; j++) {
					System.out.println("public method: " + methods[j].);
				}*/
			}
			//trainingDTOs.addAll(trainingModels);
			
			jqGridDTO.setRows(trainingDTOs);
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
	public EmployeeTrainingDTO returnEmpTrainingsById(Long EmpTrainingsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String saveEmployeeTraining(MultipartHttpServletRequest request) 
	{
		try {
			
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
		}
		return null;
	}

	@Override
	@Transactional
	public String deleteEmployeesTraining(Long employeeTrainingsId) 
	{
		try
		{
			EmployeeTrainingModel employeeTrainingModel = employeeTrainingDAO.returnEmployeeTrainingModelById(employeeTrainingsId);
			employeeTrainingModel.setIsDeleted(true);
			genericDAO.update(employeeTrainingModel);
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
	public EmployeeTrainingDTO returnEmployeesTrainingById(Long employeesTrainingId) 
	{
		EmployeeTrainingDTO employeeTrainingDTO = new EmployeeTrainingDTO();
		try
		{
			EmployeeTrainingModel  employeeTrainingModel = employeeTrainingDAO.returnEmployeeTrainingModelById(employeesTrainingId);
			EmployeeModel employeeModel = employeeTrainingModel.getEmployee();
			employeeTrainingDTO.setEmployeeTrainingsId(employeeTrainingModel.getEmpTrainingsId());
			employeeTrainingDTO.setInstituteName(employeeTrainingModel.getInstituteName());
			employeeTrainingDTO.setLocality(employeeTrainingModel.getLocality());
			employeeTrainingDTO.setDateof(String.valueOf(employeeTrainingModel.getDateof()));
			employeeTrainingDTO.setEmployeeId(employeeModel.getEmployeeId());
			employeeTrainingDTO.setName(employeeTrainingModel.getName());
			employeeTrainingDTO.setTrainingCondition(employeeTrainingModel.getTrainingCondition());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return employeeTrainingDTO;
	}

	@Override
	@Transactional
	public List<EmployeeTrainingDTO> returnAllEmployeeTrainingModels() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
