package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dao.CitationBookDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.CitationBookDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.model.CitationBookModel;
import com.qec.model.EmployeeModel;
import com.qec.service.CitationBookService;

@Service
public class CitationBookServiceImpl implements CitationBookService  {

	@Autowired
	private  CitationBookDAO citationBookDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	@Transactional
	public JQGridDTO<CitationBookDTO> returnAllCitationBookForGrid(HttpServletRequest request) 
	{
		JQGridDTO<CitationBookDTO> jqGridDTO = new JQGridDTO<CitationBookDTO>();
		List<CitationBookDTO> citationBookDTOs = new ArrayList<CitationBookDTO>();
		CitationBookDTO citationBookDTO = new CitationBookDTO();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String citationBook = request.getParameter("title");
			List<CitationBookModel> citationBookModels  =  citationBookDAO.returnAllCitationBookModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, citationBook);
			for(int i=0; i<citationBookModels.size(); i++)
			{
				CitationBookModel citationBookModel = citationBookModels.get(i);
				citationBookDTO = new CitationBookDTO();
				//set Employee Details
				employeeDTO = new EmployeeDTO();
				if(citationBookModel.getEmployeeModel() != null )
				{
					employeeDTO.setFullName(citationBookModel.getEmployeeModel().getFullName());
					citationBookDTO.setEmployee(employeeDTO);
				}
				citationBookDTO.setCitationBookId(citationBookModel.getCitationBookId());
				citationBookDTO.setAuthors(citationBookModel.getAuthors());
				citationBookDTO.setDescription(citationBookModel.getDescription());
				citationBookDTO.setTitle(citationBookModel.getTitle());
				citationBookDTO.setUrl(citationBookModel.getUrl());
				citationBookDTO.setPublicationDate(citationBookModel.getPublicationDate());
				citationBookDTO.setVolume(citationBookModel.getVolume());
				citationBookDTO.setIssue(citationBookModel.getIssue());
				citationBookDTO.setPages(citationBookModel.getPages());
				citationBookDTOs.add(citationBookDTO);
			}
			Long records = citationBookDAO.returnAllCitationBookModelForGridCount(citationBook);
			jqGridDTO.setRows(citationBookDTOs);
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
	public CitationBookDTO returnCitationBookById(Integer citationBookId) 
	{
		CitationBookDTO citationBookDTO = new CitationBookDTO();
		try
		{
			CitationBookModel citationBookModel =  citationBookDAO.returnCitationBookModelById(Long.valueOf(citationBookId));
			citationBookDTO.setCitationBookId(citationBookModel.getCitationBookId());
			citationBookDTO.setAuthors(citationBookModel.getAuthors());
			citationBookDTO.setDescription(citationBookModel.getDescription());
			if(citationBookModel.getEmployeeModel() != null)
			{
				citationBookDTO.setEmployeeId(Long.valueOf(citationBookModel.getEmployeeModel().getEmployeeId().toString()));
			}
			citationBookDTO.setIssue(citationBookModel.getIssue());
			citationBookDTO.setPages(citationBookModel.getPages());
			citationBookDTO.setPages(citationBookModel.getPages());
			citationBookDTO.setPublicationDate(citationBookModel.getPublicationDate());
			citationBookDTO.setTitle(citationBookModel.getTitle());
			citationBookDTO.setUrl(citationBookModel.getUrl());
			citationBookDTO.setVolume(citationBookModel.getVolume());
			citationBookDTO.setPublisher(citationBookModel.getPublisher());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return citationBookDTO;
	}

	@Override
	@Transactional
	public String saveCitationBook(CitationBookDTO citationBookDTO) 
	{
		CitationBookModel citationBookModel = new CitationBookModel();
		try {
			
			if(citationBookDTO != null && citationBookDTO.getCitationBookId() == null)
			{
				citationBookModel = setBookDTOToBookModel(citationBookDTO, citationBookModel);
				genericDAO.save(citationBookModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				citationBookModel = citationBookDAO.returnCitationBookModelById(citationBookDTO.getCitationBookId());
				citationBookModel = setBookDTOToBookModel(citationBookDTO, citationBookModel);
				genericDAO.update(citationBookModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private CitationBookModel setBookDTOToBookModel(CitationBookDTO citationBookDTO, CitationBookModel citationBookModel) throws Exception
	{
		EmployeeModel employeeModel = new EmployeeModel();
		if(citationBookDTO != null && citationBookDTO.getEmployeeId() != null )
		{
			employeeModel = employeeDAO.returnEmployeesById(citationBookDTO.getEmployeeId());
		}
		citationBookModel.setEmployeeModel(employeeModel);
		citationBookModel.setCitationBookId(citationBookDTO.getCitationBookId());
		citationBookModel.setTitle(citationBookDTO.getTitle());
		citationBookModel.setAuthors(citationBookDTO.getAuthors());
		citationBookModel.setDescription(citationBookDTO.getDescription());
		citationBookModel.setIssue(citationBookDTO.getIssue());
		citationBookModel.setPages(citationBookDTO.getPages());
		citationBookModel.setPublicationDate(citationBookDTO.getPublicationDate());
		citationBookModel.setPublisher(citationBookDTO.getPublisher());
		citationBookModel.setUrl(citationBookDTO.getUrl());
		citationBookModel.setVolume(citationBookDTO.getVolume());
		citationBookModel.setIsDeleted(false);
		return citationBookModel;
	}
	
	@Override
	@Transactional
	public String deleteCitationBook(Integer citationBookId) 
	{
		try
		{
			CitationBookModel citationBookModel = citationBookDAO.returnCitationBookModelById(Long.valueOf(citationBookId));
			citationBookModel.setIsDeleted(true);
			genericDAO.update(citationBookModel);
			return CommonConstants.DELETE_SUCCESS_MSG;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}