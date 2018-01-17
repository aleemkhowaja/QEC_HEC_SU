package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.JQGridDTO;
import com.qec.dao.CitationJournalDAO;
import com.qec.dao.DepartmentDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.CitationJournalDTO;
import com.qec.dto.EmployeeDTO;
import com.qec.model.CitationJournalModel;
import com.qec.model.DepartmentsModel;
import com.qec.service.CitationJournalService;

@Service
public class CitationJournalServiceImpl implements CitationJournalService  {

	@Autowired
	private  CitationJournalDAO citationJournalDAO;
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	public JQGridDTO<CitationJournalDTO> returnAllCitationJournalForGrid(HttpServletRequest request) 
	{
		JQGridDTO<CitationJournalModel> jqGridDTO = new JQGridDTO<CitationJournalModel>();
		List<CitationJournalDTO> citationJournalDTOs = new ArrayList<CitationJournalDTO>();
		EmployeeDTO employeeDTO = new EmployeeDTO();
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
				employeeDTO = new EmployeeDTO();
				
			}
			Long records = citationJournalDAO.returnAllCitationJournalModelForGridCount(citationJournal);
			jqGridDTO.setRows(citationJournalModels);
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
	public String saveCitationJournal(CitationJournalModel citationJournalModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCitationJournal(
			CitationJournalModel citationJournalModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
