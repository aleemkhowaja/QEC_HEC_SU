package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dao.CitationGoogleDAO;
import com.qec.dao.EmployeeDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.CitationGoogleDTO;
import com.qec.model.CitationGoogleModel;
import com.qec.model.EmployeeModel;
import com.qec.service.CitationGoogleService;

@Service
public class CitationGoogleServiceImpl implements CitationGoogleService  {

	@Autowired
	private  CitationGoogleDAO citationGoogleDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	@Transactional
	public JQGridDTO<CitationGoogleDTO> returnAllCitationGoogleForGrid(HttpServletRequest request) 
	{
		JQGridDTO<CitationGoogleDTO> jqGridDTO = new JQGridDTO<CitationGoogleDTO>();
		List<CitationGoogleDTO> citationGoogleDTOs = new ArrayList<CitationGoogleDTO>();
		CitationGoogleDTO citationGoogleDTO = new CitationGoogleDTO();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String googleUrl = request.getParameter("url");
			List<CitationGoogleModel> citationGoogleModels  =  citationGoogleDAO.returnAllCitationGoogleModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, googleUrl);
			for(int i=0; i<citationGoogleModels.size(); i++)
			{
				CitationGoogleModel citationGoogleModel = citationGoogleModels.get(i);
				citationGoogleDTO = new CitationGoogleDTO();
				citationGoogleDTO.setCitationGoogleId(citationGoogleModel.getCitationGoogleId());
				citationGoogleDTO.setUrl(citationGoogleModel.getUrl());
				if(citationGoogleModel.getEmployeeModel() != null)
				{
					citationGoogleDTO.setEmployeeName(citationGoogleModel.getEmployeeModel().getFullName());				
				}
				citationGoogleDTOs.add(citationGoogleDTO);
			}
			Long records = citationGoogleDAO.returnAllCitationGoogleModelForGridCount(googleUrl);
			jqGridDTO.setRows(citationGoogleDTOs);
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
	public CitationGoogleDTO returnCitationGoogleById(Integer citationGoogleId) 
	{
		CitationGoogleDTO citationGoogleDTO = new CitationGoogleDTO();
		try
		{
			CitationGoogleModel citationGoogleModel =  citationGoogleDAO.returnCitationGoogleModelById(Long.valueOf(citationGoogleId));
			citationGoogleDTO.setCitationGoogleId(citationGoogleModel.getCitationGoogleId());
			if(citationGoogleModel.getEmployeeModel() != null)
			{
				citationGoogleDTO.setEmployeeId(Long.valueOf(citationGoogleModel.getEmployeeModel().getEmployeeId().toString()));
			}
			citationGoogleDTO.setUrl(citationGoogleModel.getUrl());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return citationGoogleDTO;
	}

	@Override
	@Transactional
	public String saveCitationGoogle(CitationGoogleDTO citationGoogleDTO) 
	{
		CitationGoogleModel citationGoogleModel = new CitationGoogleModel();
		try {
			
			if(citationGoogleDTO != null && citationGoogleDTO.getCitationGoogleId() == null)
			{
				citationGoogleModel = setGoogleDTOToGoogleModel(citationGoogleDTO, citationGoogleModel);
				genericDAO.save(citationGoogleModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				citationGoogleModel = citationGoogleDAO.returnCitationGoogleModelById(citationGoogleDTO.getCitationGoogleId());
				citationGoogleModel = setGoogleDTOToGoogleModel(citationGoogleDTO, citationGoogleModel);
				genericDAO.update(citationGoogleModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private CitationGoogleModel setGoogleDTOToGoogleModel(CitationGoogleDTO citationGoogleDTO, CitationGoogleModel citationGoogleModel) throws Exception
	{
		EmployeeModel employeeModel = new EmployeeModel();
		if(citationGoogleDTO != null && citationGoogleDTO.getEmployeeId() != null )
		{
			employeeModel = employeeDAO.returnEmployeesById(citationGoogleDTO.getEmployeeId());
		}
		citationGoogleModel.setEmployeeModel(employeeModel);
		citationGoogleModel.setCitationGoogleId(citationGoogleDTO.getCitationGoogleId());
		citationGoogleModel.setUrl(citationGoogleDTO.getUrl());
		citationGoogleModel.setIsDeleted(false);
		return citationGoogleModel;
	}
	
	@Override
	@Transactional
	public String deleteCitationGoogle(Integer citationGoogleId) 
	{
		try
		{
			CitationGoogleModel citationGoogleModel = citationGoogleDAO.returnCitationGoogleModelById(Long.valueOf(citationGoogleId));
			citationGoogleModel.setIsDeleted(true);
			genericDAO.update(citationGoogleModel);
			return CommonConstants.DELETE_SUCCESS_MSG;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}