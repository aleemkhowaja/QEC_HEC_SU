package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qec.common.JQGridDTO;
import com.qec.dao.DepartmentDAO;
import com.qec.dao.GenericDAO;
import com.qec.dao.UniProgramsDAO;
import com.qec.dto.UniProgramsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.UniProgramsModel;
import com.qec.service.UniProgramsService;

@Service
public class UniProgramsServiceImpl implements UniProgramsService {

	@Autowired
	private UniProgramsDAO uniProgramDAO;
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO; 
	
	public UniProgramsDAO getUniProgramDAO() 
	{
		return uniProgramDAO;
	}

	public void setUniProgramDAO(UniProgramsDAO uniProgramDAO) 
	{
		this.uniProgramDAO = uniProgramDAO;
	}

	@Override
	@Transactional
	public JQGridDTO<UniProgramsDTO> returnAllUniProgramsModelForGrid(HttpServletRequest request) 
	{
		JQGridDTO<UniProgramsDTO> jqGridDTO = new JQGridDTO<UniProgramsDTO>();
		List<UniProgramsModel> uniProgramsModels = new ArrayList<UniProgramsModel>();
		List<UniProgramsDTO> uniProgramsDTOs = new ArrayList<UniProgramsDTO>();
		UniProgramsModel uniProgramsModel = new UniProgramsModel();
		UniProgramsDTO uniProgramsDTO = new UniProgramsDTO();
		
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtStartIndex = 0;
			Integer jtPageSize = request.getParameter("rows") == null ? null : Integer.parseInt(request.getParameter("rows"));
			
			String uniProgramName = request.getParameter("uniProgramName");
			
			uniProgramsModels =  uniProgramDAO.returnAllUniProgramsModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, uniProgramName);
			for(int i=0; i<uniProgramsModels.size(); i++)
			{
				uniProgramsModel = uniProgramsModels.get(i);
				uniProgramsDTO = new UniProgramsDTO();
				uniProgramsDTO.setName(uniProgramsModel.getName());
				uniProgramsDTO.setCode(uniProgramsModel.getCode());
				uniProgramsDTO.setUniProgramsId(uniProgramsModel.getUniProgramsId());
				uniProgramsDTOs.add(uniProgramsDTO);
			}
			jqGridDTO.setRows(uniProgramsDTOs);
			jqGridDTO.setTotal(String.valueOf(Math.ceil((double) uniProgramsModels.size() / jtPageSize)));
			jqGridDTO.setRecords(String.valueOf(uniProgramsModels.size()));
			jqGridDTO.setPage(page);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return jqGridDTO;
	}

	@Override
	@Transactional
	public String saveUniProgramsModel(UniProgramsDTO uniProgramsDTO ) 
	{
		UniProgramsModel uniProgramsModel = new UniProgramsModel();
		try 
		{
			DepartmentsModel departmentsModel = new DepartmentsModel();
			if(uniProgramsDTO.getDepartmentId() != null)
			{
				departmentsModel = departmentDAO.returnDepartmentById(Long.valueOf(uniProgramsDTO.getDepartmentId()));
			}
			
			if(uniProgramsDTO.getUniProgramsId() == null)
			{
				uniProgramsModel.setDepartmentsModel(departmentsModel);
				uniProgramsModel.setName(uniProgramsDTO.getName());
				uniProgramsModel.setCode(uniProgramsDTO.getCode());
				uniProgramsModel.setIsDeleted(false);
				genericDAO.save(uniProgramsModel);
				return "Record Inserted Successfully";
			}
			else
			{
				uniProgramsModel = uniProgramDAO.returnUniProgramsModelById(uniProgramsDTO.getUniProgramsId());
				uniProgramsModel.setDepartmentsModel(departmentsModel);
				uniProgramsModel.setName(uniProgramsDTO.getName());
				uniProgramsModel.setCode(uniProgramsDTO.getCode());
				genericDAO.update(uniProgramsModel);
				return "Record Updated Successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@Transactional
	public UniProgramsDTO getUniProgramsModelById(Long uniProgramsId) {
		UniProgramsModel uniProgramsModel = new UniProgramsModel();
		UniProgramsDTO uniProgramsDTO = new UniProgramsDTO();
		try 
		{
			uniProgramsModel = uniProgramDAO.returnUniProgramsModelById(uniProgramsId);
			uniProgramsDTO.setDepartmentId(String.valueOf(uniProgramsModel.getDepartmentsModel().getDepartmentId()));
			uniProgramsDTO.setCode(uniProgramsModel.getCode());
			uniProgramsDTO.setName(uniProgramsModel.getName());
			uniProgramsDTO.setUniProgramsId(uniProgramsModel.getUniProgramsId());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return uniProgramsDTO;
	}


	@Override
	@Transactional
	public String deleteUniProgramsModel(UniProgramsDTO uniProgramsDTO) {
		UniProgramsModel uniProgramsModels = new UniProgramsModel();
		try 
		{
			if(uniProgramsDTO.getUniProgramsId() != null)
			{
				uniProgramsModels = uniProgramDAO.returnUniProgramsModelById(uniProgramsDTO.getUniProgramsId());
				uniProgramsModels.setIsDeleted(true);
				genericDAO.update(uniProgramsModels);
				return "Record Delete Successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public UniProgramsModel returnUniProgramsModelById(Integer programId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UniProgramsModel> returnAllUniProgramsModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
