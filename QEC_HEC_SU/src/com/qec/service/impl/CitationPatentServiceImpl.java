package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dao.CitationPatentDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.CitationPatentDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.model.CitationPatentModel;
import com.qec.model.EmployeeModel;
import com.qec.service.CitationPatentService;

@Service
public class CitationPatentServiceImpl implements CitationPatentService  {

	@Autowired
	private  CitationPatentDAO citationPatentDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	@Transactional
	public JQGridDTO<CitationPatentDTO> returnAllCitationPatentForGrid(HttpServletRequest request) 
	{
		JQGridDTO<CitationPatentDTO> jqGridDTO = new JQGridDTO<CitationPatentDTO>();
		List<CitationPatentDTO> citationPatentDTOs = new ArrayList<CitationPatentDTO>();
		CitationPatentDTO citationPatentDTO = new CitationPatentDTO();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String citationPatent = request.getParameter("title");
			List<CitationPatentModel> citationPatentModels  =  citationPatentDAO.returnAllCitationPatentModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, citationPatent);
			for(int i=0; i<citationPatentModels.size(); i++)
			{
				CitationPatentModel citationPatentModel = citationPatentModels.get(i);
				citationPatentDTO = new CitationPatentDTO();
				//set Employee Details
				employeeDTO = new EmployeeDTO();
				if(citationPatentModel.getEmployeeModel() != null )
				{
					employeeDTO.setFullName(citationPatentModel.getEmployeeModel().getFullName());
					citationPatentDTO.setEmployee(employeeDTO);
				}
				citationPatentDTO.setCitationPatentId(citationPatentModel.getCitationPatentId());
				citationPatentDTO.setInventors(citationPatentModel.getInventors());
				citationPatentDTO.setDescription(citationPatentModel.getDescription());
				citationPatentDTO.setTitle(citationPatentModel.getTitle());
				citationPatentDTO.setUrl(citationPatentModel.getUrl());
				citationPatentDTO.setPublicationDate(citationPatentModel.getPublicationDate());
				citationPatentDTO.setPatentOffice(citationPatentModel.getPatentOffice());
				citationPatentDTO.setPatentNumber(citationPatentModel.getPatentNumber());
				citationPatentDTO.setApplicationNumber(citationPatentModel.getApplicationNumber());
				citationPatentDTOs.add(citationPatentDTO);
			}
			Long records = citationPatentDAO.returnAllCitationPatentModelForGridCount(citationPatent);
			jqGridDTO.setRows(citationPatentDTOs);
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
	public CitationPatentDTO returnCitationPatentById(Integer citationPatentId) 
	{
		CitationPatentDTO citationPatentDTO = new CitationPatentDTO();
		try
		{
			CitationPatentModel citationPatentModel =  citationPatentDAO.returnCitationPatentModelById(Long.valueOf(citationPatentId));
			citationPatentDTO.setCitationPatentId(citationPatentModel.getCitationPatentId());
			citationPatentDTO.setInventors(citationPatentModel.getInventors());
			citationPatentDTO.setDescription(citationPatentModel.getDescription());
			if(citationPatentModel.getEmployeeModel() != null)
			{
				citationPatentDTO.setEmployeeId(Long.valueOf(citationPatentModel.getEmployeeModel().getEmployeeId().toString()));
			}
			citationPatentDTO.setPublicationDate(citationPatentModel.getPublicationDate());
			citationPatentDTO.setTitle(citationPatentModel.getTitle());
			citationPatentDTO.setUrl(citationPatentModel.getUrl());
			citationPatentDTO.setPatentOffice(citationPatentModel.getPatentOffice());
			citationPatentDTO.setPatentNumber(citationPatentModel.getPatentNumber());
			citationPatentDTO.setApplicationNumber(citationPatentModel.getApplicationNumber());

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return citationPatentDTO;
	}

	@Override
	@Transactional
	public String saveCitationPatent(CitationPatentDTO citationPatentDTO) 
	{
		CitationPatentModel citationPatentModel = new CitationPatentModel();
		try {
			
			if(citationPatentDTO != null && citationPatentDTO.getCitationPatentId() == null)
			{
				citationPatentModel = setPatentDTOToPatentModel(citationPatentDTO, citationPatentModel);
				genericDAO.save(citationPatentModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				citationPatentModel = citationPatentDAO.returnCitationPatentModelById(citationPatentDTO.getCitationPatentId());
				citationPatentModel = setPatentDTOToPatentModel(citationPatentDTO, citationPatentModel);
				genericDAO.update(citationPatentModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private CitationPatentModel setPatentDTOToPatentModel(CitationPatentDTO citationPatentDTO, CitationPatentModel citationPatentModel) throws Exception
	{
		EmployeeModel employeeModel = new EmployeeModel();
		if(citationPatentDTO != null && citationPatentDTO.getEmployeeId() != null )
		{
			employeeModel = employeeDAO.returnEmployeesById(citationPatentDTO.getEmployeeId());
		}
		citationPatentModel.setEmployeeModel(employeeModel);
		citationPatentModel.setCitationPatentId(citationPatentDTO.getCitationPatentId());
		citationPatentModel.setTitle(citationPatentDTO.getTitle());
		citationPatentModel.setInventors(citationPatentDTO.getInventors());
		citationPatentModel.setDescription(citationPatentDTO.getDescription());
		citationPatentModel.setPublicationDate(citationPatentDTO.getPublicationDate());
		citationPatentModel.setUrl(citationPatentDTO.getUrl());
		citationPatentModel.setPatentOffice(citationPatentDTO.getPatentOffice());
		citationPatentModel.setPatentNumber(citationPatentDTO.getPatentNumber());
		citationPatentModel.setApplicationNumber(citationPatentDTO.getApplicationNumber());
		citationPatentModel.setIsDeleted(false);
		return citationPatentModel;
	}
	
	@Override
	@Transactional
	public String deleteCitationPatent(Integer citationPatentId) 
	{
		try
		{
			CitationPatentModel citationPatentModel = citationPatentDAO.returnCitationPatentModelById(Long.valueOf(citationPatentId));
			citationPatentModel.setIsDeleted(true);
			genericDAO.update(citationPatentModel);
			return CommonConstants.DELETE_SUCCESS_MSG;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}