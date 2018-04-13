package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dao.CitationThesisDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.CitationThesisDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.model.CitationThesisModel;
import com.qec.model.EmployeeModel;
import com.qec.service.CitationThesisService;

@Service
public class CitationThesisServiceImpl implements CitationThesisService  {

	@Autowired
	private  CitationThesisDAO citationThesisDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	@Transactional
	public JQGridDTO<CitationThesisDTO> returnAllCitationThesisForGrid(HttpServletRequest request) 
	{
		JQGridDTO<CitationThesisDTO> jqGridDTO = new JQGridDTO<CitationThesisDTO>();
		List<CitationThesisDTO> citationThesisDTOs = new ArrayList<CitationThesisDTO>();
		CitationThesisDTO citationThesisDTO = new CitationThesisDTO();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String citationThesis = request.getParameter("title");
			List<CitationThesisModel> citationThesisModels  =  citationThesisDAO.returnAllCitationThesisModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, citationThesis);
			for(int i=0; i<citationThesisModels.size(); i++)
			{
				CitationThesisModel citationThesisModel = citationThesisModels.get(i);
				citationThesisDTO = new CitationThesisDTO();
				//set Employee Details
				employeeDTO = new EmployeeDTO();
				if(citationThesisModel.getEmployeeModel() != null )
				{
					employeeDTO.setFullName(citationThesisModel.getEmployeeModel().getFullName());
					citationThesisDTO.setEmployee(employeeDTO);
				}
				
				citationThesisDTO.setCitationThesisId(citationThesisModel.getCitationThesisId());
				citationThesisDTO.setAuthors(citationThesisModel.getAuthors());
				citationThesisDTO.setDescription(citationThesisModel.getDescription());
				citationThesisDTO.setTitle(citationThesisModel.getTitle());
				citationThesisDTO.setUrl(citationThesisModel.getUrl());
				citationThesisDTO.setPublicationDate(citationThesisModel.getPublicationDate());
				citationThesisDTO.setInstitution(citationThesisModel.getInstitution());
				citationThesisDTOs.add(citationThesisDTO);
			}
			Long records = citationThesisDAO.returnAllCitationThesisModelForGridCount(citationThesis);
			jqGridDTO.setRows(citationThesisDTOs);
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
	public CitationThesisDTO returnCitationThesisById(Integer citationThesisId) 
	{
		CitationThesisDTO citationThesisDTO = new CitationThesisDTO();
		try
		{
			CitationThesisModel citationThesisModel =  citationThesisDAO.returnCitationThesisModelById(Long.valueOf(citationThesisId));
			citationThesisDTO.setCitationThesisId(citationThesisModel.getCitationThesisId());
			citationThesisDTO.setAuthors(citationThesisModel.getAuthors());
			citationThesisDTO.setDescription(citationThesisModel.getDescription());
			if(citationThesisModel.getEmployeeModel() != null)
			{
				citationThesisDTO.setEmployeeId(Long.valueOf(citationThesisModel.getEmployeeModel().getEmployeeId().toString()));
			}
			citationThesisDTO.setPublicationDate(citationThesisModel.getPublicationDate());
			citationThesisDTO.setTitle(citationThesisModel.getTitle());
			citationThesisDTO.setUrl(citationThesisModel.getUrl());
			citationThesisDTO.setInstitution(citationThesisModel.getInstitution());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return citationThesisDTO;
	}

	@Override
	@Transactional
	public String saveCitationThesis(CitationThesisDTO citationThesisDTO) 
	{
		CitationThesisModel citationThesisModel = new CitationThesisModel();
		try {
			
			if(citationThesisDTO != null && citationThesisDTO.getCitationThesisId() == null)
			{
				citationThesisModel = setThesisDTOToThesisModel(citationThesisDTO, citationThesisModel);
				genericDAO.save(citationThesisModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				citationThesisModel = citationThesisDAO.returnCitationThesisModelById(citationThesisDTO.getCitationThesisId());
				citationThesisModel = setThesisDTOToThesisModel(citationThesisDTO, citationThesisModel);
				genericDAO.update(citationThesisModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private CitationThesisModel setThesisDTOToThesisModel(CitationThesisDTO citationThesisDTO, CitationThesisModel citationThesisModel) throws Exception
	{
		EmployeeModel employeeModel = new EmployeeModel();
		if(citationThesisDTO != null && citationThesisDTO.getEmployeeId() != null )
		{
			employeeModel = employeeDAO.returnEmployeesById(citationThesisDTO.getEmployeeId());
		}
		citationThesisModel.setEmployeeModel(employeeModel);
		citationThesisModel.setCitationThesisId(citationThesisDTO.getCitationThesisId());
		citationThesisModel.setTitle(citationThesisDTO.getTitle());
		citationThesisModel.setAuthors(citationThesisDTO.getAuthors());
		citationThesisModel.setDescription(citationThesisDTO.getDescription());
		citationThesisModel.setPublicationDate(citationThesisDTO.getPublicationDate());
		citationThesisModel.setUrl(citationThesisDTO.getUrl());
		citationThesisModel.setInstitution(citationThesisDTO.getInstitution());
		citationThesisModel.setIsDeleted(false);
		return citationThesisModel;
	}
	
	@Override
	@Transactional
	public String deleteCitationThesis(Integer citationThesisId) 
	{
		try
		{
			CitationThesisModel citationThesisModel = citationThesisDAO.returnCitationThesisModelById(Long.valueOf(citationThesisId));
			citationThesisModel.setIsDeleted(true);
			genericDAO.update(citationThesisModel);
			return CommonConstants.DELETE_SUCCESS_MSG;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}