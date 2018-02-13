package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dao.CitationChapterDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.CitationChapterDTO;
import com.qec.model.CitationChapterModel;
import com.qec.model.EmployeeModel;
import com.qec.service.CitationChapterService;

@Service
public class CitationChapterServiceImpl implements CitationChapterService  {

	@Autowired
	private  CitationChapterDAO citationChapterDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	@Transactional
	public JQGridDTO<CitationChapterDTO> returnAllCitationChapterForGrid(HttpServletRequest request) 
	{
		JQGridDTO<CitationChapterDTO> jqGridDTO = new JQGridDTO<CitationChapterDTO>();
		List<CitationChapterDTO> citationChapterDTOs = new ArrayList<CitationChapterDTO>();
		CitationChapterDTO citationChapterDTO = new CitationChapterDTO();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String citationChapter = request.getParameter("title");
			List<CitationChapterModel> citationChapterModels  =  citationChapterDAO.returnAllCitationChapterModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, citationChapter);
			for(int i=0; i<citationChapterModels.size(); i++)
			{
				CitationChapterModel citationChapterModel = citationChapterModels.get(i);
				citationChapterDTO = new CitationChapterDTO();
				citationChapterDTO.setCitationChapterId(citationChapterModel.getCitationChapterId());
				citationChapterDTO.setAuthors(citationChapterModel.getAuthors());
				citationChapterDTO.setDescription(citationChapterModel.getDescription());
				citationChapterDTO.setTitle(citationChapterModel.getTitle());
				citationChapterDTO.setUrl(citationChapterModel.getUrl());
				citationChapterDTO.setPublicationDate(citationChapterModel.getPublicationDate());
				citationChapterDTO.setVolume(citationChapterModel.getVolume());
				citationChapterDTO.setIssue(citationChapterModel.getIssue());
				citationChapterDTO.setPages(citationChapterModel.getPages());
				citationChapterDTO.setBook(citationChapterModel.getBook());
				citationChapterDTOs.add(citationChapterDTO);
			}
			Long records = citationChapterDAO.returnAllCitationChapterModelForGridCount(citationChapter);
			jqGridDTO.setRows(citationChapterDTOs);
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
	public CitationChapterDTO returnCitationChapterById(Integer citationChapterId) 
	{
		CitationChapterDTO citationChapterDTO = new CitationChapterDTO();
		try
		{
			CitationChapterModel citationChapterModel =  citationChapterDAO.returnCitationChapterModelById(Long.valueOf(citationChapterId));
			citationChapterDTO.setCitationChapterId(citationChapterModel.getCitationChapterId());
			citationChapterDTO.setAuthors(citationChapterModel.getAuthors());
			citationChapterDTO.setDescription(citationChapterModel.getDescription());
			if(citationChapterModel.getEmployeeModel() != null)
			{
				citationChapterDTO.setEmployeeId(Long.valueOf(citationChapterModel.getEmployeeModel().getEmployeeId().toString()));
			}
			citationChapterDTO.setIssue(citationChapterModel.getIssue());
			citationChapterDTO.setPages(citationChapterModel.getPages());
			citationChapterDTO.setPages(citationChapterModel.getPages());
			citationChapterDTO.setPublicationDate(citationChapterModel.getPublicationDate());
			citationChapterDTO.setTitle(citationChapterModel.getTitle());
			citationChapterDTO.setUrl(citationChapterModel.getUrl());
			citationChapterDTO.setVolume(citationChapterModel.getVolume());
			citationChapterDTO.setBook(citationChapterModel.getBook());
			citationChapterDTO.setPublisher(citationChapterModel.getPublisher());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return citationChapterDTO;
	}

	@Override
	@Transactional
	public String saveCitationChapter(CitationChapterDTO citationChapterDTO) 
	{
		CitationChapterModel citationChapterModel = new CitationChapterModel();
		try {
			
			if(citationChapterDTO != null && citationChapterDTO.getCitationChapterId() == null)
			{
				citationChapterModel = setChapterDTOToChapterModel(citationChapterDTO, citationChapterModel);
				genericDAO.save(citationChapterModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				citationChapterModel = citationChapterDAO.returnCitationChapterModelById(citationChapterDTO.getCitationChapterId());
				citationChapterModel = setChapterDTOToChapterModel(citationChapterDTO, citationChapterModel);
				genericDAO.update(citationChapterModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private CitationChapterModel setChapterDTOToChapterModel(CitationChapterDTO citationChapterDTO, CitationChapterModel citationChapterModel) throws Exception
	{
		EmployeeModel employeeModel = new EmployeeModel();
		if(citationChapterDTO != null && citationChapterDTO.getEmployeeId() != null )
		{
			employeeModel = employeeDAO.returnEmployeesById(citationChapterDTO.getEmployeeId());
		}
		citationChapterModel.setEmployeeModel(employeeModel);
		citationChapterModel.setCitationChapterId(citationChapterDTO.getCitationChapterId());
		citationChapterModel.setTitle(citationChapterDTO.getTitle());
		citationChapterModel.setAuthors(citationChapterDTO.getAuthors());
		citationChapterModel.setDescription(citationChapterDTO.getDescription());
		citationChapterModel.setIssue(citationChapterDTO.getIssue());
		citationChapterModel.setPages(citationChapterDTO.getPages());
		citationChapterModel.setPublicationDate(citationChapterDTO.getPublicationDate());
		citationChapterModel.setPublisher(citationChapterDTO.getPublisher());
		citationChapterModel.setUrl(citationChapterDTO.getUrl());
		citationChapterModel.setVolume(citationChapterDTO.getVolume());
		citationChapterModel.setBook(citationChapterDTO.getBook());
		citationChapterModel.setIsDeleted(false);
		return citationChapterModel;
	}
	
	@Override
	@Transactional
	public String deleteCitationChapter(Integer citationChapterId) 
	{
		try
		{
			CitationChapterModel citationChapterModel = citationChapterDAO.returnCitationChapterModelById(Long.valueOf(citationChapterId));
			citationChapterModel.setIsDeleted(true);
			genericDAO.update(citationChapterModel);
			return CommonConstants.DELETE_SUCCESS_MSG;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}