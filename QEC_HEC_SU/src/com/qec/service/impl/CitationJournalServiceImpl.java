package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dao.CitationJournalDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.CitationJournalDTO;
import com.qec.model.CitationJournalModel;
import com.qec.model.EmployeeModel;
import com.qec.service.CitationJournalService;

@Service
public class CitationJournalServiceImpl implements CitationJournalService  {

	@Autowired
	private  CitationJournalDAO citationJournalDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	@Transactional
	public JQGridDTO<CitationJournalDTO> returnAllCitationJournalForGrid(HttpServletRequest request) 
	{
		JQGridDTO<CitationJournalDTO> jqGridDTO = new JQGridDTO<CitationJournalDTO>();
		List<CitationJournalDTO> citationJournalDTOs = new ArrayList<CitationJournalDTO>();
		CitationJournalDTO citationJournalDTO = new CitationJournalDTO();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String citationJournal = request.getParameter("title");
			
			List<CitationJournalModel> citationJournalModels  =  citationJournalDAO.returnAllCitationJournalModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, citationJournal);
			for(int i=0; i<citationJournalModels.size(); i++)
			{
				CitationJournalModel citationJournalModel = citationJournalModels.get(i);
				citationJournalDTO = new CitationJournalDTO();
				citationJournalDTO.setCitationJournalId(citationJournalModel.getCitationJournalId());
				citationJournalDTO.setAuthors(citationJournalModel.getAuthors());
				citationJournalDTO.setDateof(citationJournalModel.getDateof());
				citationJournalDTO.setDescription(citationJournalModel.getDescription());
				citationJournalDTO.setTitle(citationJournalModel.getTitle());
				citationJournalDTO.setUrl(citationJournalModel.getUrl());
				citationJournalDTO.setPublicationDate(citationJournalModel.getPublicationDate());
				citationJournalDTO.setJournal(citationJournalModel.getJournal());
				citationJournalDTO.setVolume(citationJournalModel.getVolume());
				citationJournalDTO.setIssue(citationJournalModel.getIssue());
				citationJournalDTO.setPages(citationJournalModel.getPages());
				citationJournalDTOs.add(citationJournalDTO);
			}
			Long records = citationJournalDAO.returnAllCitationJournalModelForGridCount(citationJournal);
			jqGridDTO.setRows(citationJournalDTOs);
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
	public CitationJournalModel returnCitationJournalById(
			Integer CitationJournalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveCitationJournal(CitationJournalDTO citationJournalDTO) 
	{
		EmployeeModel employeeModel = new EmployeeModel();
		CitationJournalModel citationJournalModel = new CitationJournalModel();
		try {
			if(citationJournalDTO != null && citationJournalDTO.getEmployeeId() != null )
			{
				employeeModel = employeeDAO.returnEmployeesById(citationJournalDTO.getEmployeeId());
			}
			if(citationJournalDTO != null && citationJournalDTO.getCitationJournalId() == null)
			{
				citationJournalModel.setCitationJournalId(citationJournalDTO.getCitationJournalId());
				citationJournalModel.setTitle(citationJournalDTO.getTitle());
				citationJournalModel.setAuthors(citationJournalDTO.getAuthors());
				citationJournalModel.setDateof(citationJournalDTO.getDateof());
				citationJournalModel.setDescription(citationJournalDTO.getDescription());
				citationJournalModel.setHecRecognize(citationJournalDTO.getHecRecognize());
				citationJournalModel.setImpactFactor(citationJournalDTO.getImpactFactor());
				citationJournalModel.setImpactFactorValue(citationJournalDTO.getImpactFactorValue());
				citationJournalModel.setIssue(citationJournalDTO.getIssue());
				citationJournalModel.setJournal(citationJournalDTO.getJournal());
				citationJournalModel.setPages(citationJournalDTO.getPages());
				citationJournalModel.setPublicationDate(citationJournalDTO.getPublicationDate());
				citationJournalModel.setPublisher(citationJournalDTO.getPublisher());
				citationJournalModel.setUrl(citationJournalDTO.getUrl());
				citationJournalModel.setVolume(citationJournalDTO.getVolume());
				
				genericDAO.save(citationJournalModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				citationJournalModel = citationJournalDAO.returnCitationJournalModelById(citationJournalDTO.getCitationJournalId());
				citationJournalModel.setCitationJournalId(citationJournalDTO.getCitationJournalId());
				citationJournalModel.setTitle(citationJournalDTO.getTitle());
				citationJournalModel.setAuthors(citationJournalDTO.getAuthors());
				citationJournalModel.setDateof(citationJournalDTO.getDateof());
				citationJournalModel.setDescription(citationJournalDTO.getDescription());
				citationJournalModel.setHecRecognize(citationJournalDTO.getHecRecognize());
				citationJournalModel.setImpactFactor(citationJournalDTO.getImpactFactor());
				citationJournalModel.setImpactFactorValue(citationJournalDTO.getImpactFactorValue());
				citationJournalModel.setIssue(citationJournalDTO.getIssue());
				citationJournalModel.setJournal(citationJournalDTO.getJournal());
				citationJournalModel.setPages(citationJournalDTO.getPages());
				citationJournalModel.setPublicationDate(citationJournalDTO.getPublicationDate());
				citationJournalModel.setPublisher(citationJournalDTO.getPublisher());
				citationJournalModel.setUrl(citationJournalDTO.getUrl());
				citationJournalModel.setVolume(citationJournalDTO.getVolume());
				genericDAO.update(citationJournalModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteCitationJournal(
			CitationJournalDTO citationJournalDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
