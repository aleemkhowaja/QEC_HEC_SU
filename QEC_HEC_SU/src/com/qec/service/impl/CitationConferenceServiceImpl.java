package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dao.CitationConferenceDAO;
import com.qec.dao.CitationConferenceDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.CitationConferenceDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.model.CitationConferenceModel;
import com.qec.model.EmployeeModel;
import com.qec.service.CitationConferenceService;
import com.qec.service.CitationConferenceService;

@Service
public class CitationConferenceServiceImpl implements CitationConferenceService  {

	@Autowired
	private  CitationConferenceDAO citationConferenceDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	@Transactional
	public JQGridDTO<CitationConferenceDTO> returnAllCitationConferenceForGrid(HttpServletRequest request) 
	{
		JQGridDTO<CitationConferenceDTO> jqGridDTO = new JQGridDTO<CitationConferenceDTO>();
		List<CitationConferenceDTO> citationConferenceDTOs = new ArrayList<CitationConferenceDTO>();
		CitationConferenceDTO citationConferenceDTO = new CitationConferenceDTO();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String citationConference = request.getParameter("title");
			
			List<CitationConferenceModel> citationConferenceModels  =  citationConferenceDAO.returnAllCitationConferenceModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, citationConference);
			
			for(int i=0; i<citationConferenceModels.size(); i++)
			{
				CitationConferenceModel citationConferenceModel = citationConferenceModels.get(i);
				citationConferenceDTO = new CitationConferenceDTO();
				employeeDTO = new EmployeeDTO();
				if(citationConferenceModel.getEmployeeModel() != null )
				{
					employeeDTO.setFullName(citationConferenceModel.getEmployeeModel().getFullName());
					citationConferenceDTO.setEmployee(employeeDTO);
				}
				citationConferenceDTO.setCitationConferenceId(citationConferenceModel.getCitationConferenceId());
				citationConferenceDTO.setAuthors(citationConferenceModel.getAuthors());
				citationConferenceDTO.setDescription(citationConferenceModel.getDescription());
				citationConferenceDTO.setTitle(citationConferenceModel.getTitle());
				citationConferenceDTO.setUrl(citationConferenceModel.getUrl());
				citationConferenceDTO.setPublicationDate(citationConferenceModel.getPublicationDate());
				citationConferenceDTO.setConference(citationConferenceModel.getConference());
				citationConferenceDTO.setVolume(citationConferenceModel.getVolume());
				citationConferenceDTO.setIssue(citationConferenceModel.getIssue());
				citationConferenceDTO.setPages(citationConferenceModel.getPages());
				citationConferenceDTOs.add(citationConferenceDTO);
			}
			Long records = citationConferenceDAO.returnAllCitationConferenceModelForGridCount(citationConference);
			jqGridDTO.setRows(citationConferenceDTOs);
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
	public CitationConferenceDTO returnCitationConferenceById(Integer citationConferenceId) 
	{
		CitationConferenceDTO citationConferenceDTO = new CitationConferenceDTO();
		try
		{
			CitationConferenceModel citationConferenceModel =  citationConferenceDAO.returnCitationConferenceModelById(Long.valueOf(citationConferenceId));
			citationConferenceDTO.setCitationConferenceId(citationConferenceModel.getCitationConferenceId());
			citationConferenceDTO.setAuthors(citationConferenceModel.getAuthors());
			citationConferenceDTO.setDescription(citationConferenceModel.getDescription());
			if(citationConferenceModel.getEmployeeModel() != null)
			{
				citationConferenceDTO.setEmployeeId(Long.valueOf(citationConferenceModel.getEmployeeModel().getEmployeeId().toString()));
			}
			citationConferenceDTO.setHecRecognize(citationConferenceModel.getHecRecognize());
			citationConferenceDTO.setImpactFactor(citationConferenceModel.getImpactFactor());
			citationConferenceDTO.setImpactFactorValue(citationConferenceModel.getImpactFactorValue());
			citationConferenceDTO.setIssue(citationConferenceModel.getIssue());
			citationConferenceDTO.setConference(citationConferenceModel.getConference());
			citationConferenceDTO.setPages(citationConferenceModel.getPages());
			citationConferenceDTO.setConference(citationConferenceModel.getConference());
			citationConferenceDTO.setPages(citationConferenceModel.getPages());
			citationConferenceDTO.setPublicationDate(citationConferenceModel.getPublicationDate());
			citationConferenceDTO.setTitle(citationConferenceModel.getTitle());
			citationConferenceDTO.setUrl(citationConferenceModel.getUrl());
			citationConferenceDTO.setVolume(citationConferenceModel.getVolume());
			citationConferenceDTO.setPublisher(citationConferenceModel.getPublisher());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return citationConferenceDTO;
	}

	@Override
	@Transactional
	public String saveCitationConference(CitationConferenceDTO citationConferenceDTO) 
	{
		EmployeeModel employeeModel = new EmployeeModel();
		CitationConferenceModel citationConferenceModel = new CitationConferenceModel();
		try {
			if(citationConferenceDTO != null && citationConferenceDTO.getEmployeeId() != null )
			{
				employeeModel = employeeDAO.returnEmployeesById(citationConferenceDTO.getEmployeeId());
			}
			if(citationConferenceDTO != null && citationConferenceDTO.getCitationConferenceId() == null)
			{
				citationConferenceModel.setEmployeeModel(employeeModel);
				citationConferenceModel.setCitationConferenceId(citationConferenceDTO.getCitationConferenceId());
				citationConferenceModel.setTitle(citationConferenceDTO.getTitle());
				citationConferenceModel.setAuthors(citationConferenceDTO.getAuthors());
				citationConferenceModel.setDescription(citationConferenceDTO.getDescription());
				citationConferenceModel.setHecRecognize(citationConferenceDTO.getHecRecognize());
				citationConferenceModel.setImpactFactor(citationConferenceDTO.getImpactFactor());
				citationConferenceModel.setImpactFactorValue(citationConferenceDTO.getImpactFactorValue());
				citationConferenceModel.setIssue(citationConferenceDTO.getIssue());
				citationConferenceModel.setConference(citationConferenceDTO.getConference());
				citationConferenceModel.setPages(citationConferenceDTO.getPages());
				citationConferenceModel.setPublicationDate(citationConferenceDTO.getPublicationDate());
				citationConferenceModel.setPublisher(citationConferenceDTO.getPublisher());
				citationConferenceModel.setUrl(citationConferenceDTO.getUrl());
				citationConferenceModel.setVolume(citationConferenceDTO.getVolume());
				citationConferenceModel.setIsDeleted(false);
				genericDAO.save(citationConferenceModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				citationConferenceModel = citationConferenceDAO.returnCitationConferenceModelById(citationConferenceDTO.getCitationConferenceId());
				citationConferenceModel.setEmployeeModel(employeeModel);
				citationConferenceModel.setCitationConferenceId(citationConferenceDTO.getCitationConferenceId());
				citationConferenceModel.setTitle(citationConferenceDTO.getTitle());
				citationConferenceModel.setAuthors(citationConferenceDTO.getAuthors());
				citationConferenceModel.setDescription(citationConferenceDTO.getDescription());
				citationConferenceModel.setHecRecognize(citationConferenceDTO.getHecRecognize());
				citationConferenceModel.setImpactFactor(citationConferenceDTO.getImpactFactor());
				citationConferenceModel.setImpactFactorValue(citationConferenceDTO.getImpactFactorValue());
				citationConferenceModel.setIssue(citationConferenceDTO.getIssue());
				citationConferenceModel.setConference(citationConferenceDTO.getConference());
				citationConferenceModel.setPages(citationConferenceDTO.getPages());
				citationConferenceModel.setPublicationDate(citationConferenceDTO.getPublicationDate());
				citationConferenceModel.setPublisher(citationConferenceDTO.getPublisher());
				citationConferenceModel.setUrl(citationConferenceDTO.getUrl());
				citationConferenceModel.setVolume(citationConferenceDTO.getVolume());
				genericDAO.update(citationConferenceModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public String deleteCitationConference(Integer citationConferenceId) 
	{
		try
		{
			CitationConferenceModel citationConferenceModel = citationConferenceDAO.returnCitationConferenceModelById(Long.valueOf(citationConferenceId));
			citationConferenceModel.setIsDeleted(true);
			genericDAO.update(citationConferenceModel);
			return CommonConstants.DELETE_SUCCESS_MSG;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}