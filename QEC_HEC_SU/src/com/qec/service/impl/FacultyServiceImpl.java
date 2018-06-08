package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dto.FacultyDTO;
import com.qec.model.FacultyModel;
import com.qec.repository.FacultyRepository;
import com.qec.repository.GenericRepository;
import com.qec.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyDAO;
	
	@Autowired
	private GenericRepository genericDAO;
	

	@Transactional
	@Override
	public JQGridDTO<FacultyModel> returnAllFacultyForGrid(HttpServletRequest request) 
	{
		JQGridDTO<FacultyModel> jqGridDTO = new JQGridDTO<FacultyModel>();
		List<FacultyModel> facultyModels = new ArrayList<FacultyModel>();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String facultyName = request.getParameter("facultyName");
			
			facultyModels =  facultyDAO.returnAllFacultyForGrid(jtStartIndex, jtPageSize, sortingProperty, order, facultyName);
			Long records = facultyDAO.returnAllFacultyForGridCount(facultyName);
			jqGridDTO.setRows(facultyModels);
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
	public String saveFaculty(FacultyDTO facultyDTO) {
		try {
			FacultyModel facultyModel = new FacultyModel(); 
			if(facultyDTO != null && facultyDTO.getFacultyId() == null)
			{
				facultyModel.setFacultyName(facultyDTO.getFacultyName());
				facultyModel.setIsDeleted(false);
				genericDAO.save(facultyModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				facultyModel = facultyDAO.returnFacultyById(Long.valueOf(facultyDTO.getFacultyId()));
				facultyModel.setFacultyName(facultyDTO.getFacultyName());
				facultyModel.setFacultyId(facultyDTO.getFacultyId());
				genericDAO.update(facultyModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public String deleteFaculty(Integer facultyId) {
		try
		{
			FacultyModel facultyModel = facultyDAO.returnFacultyById(Long.valueOf(facultyId));
			facultyModel.setIsDeleted(true);
			genericDAO.update(facultyModel);
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
	public FacultyModel returnFacultyById(Long facultyId) {
		FacultyModel facultyModel = null;
		try 
		{
			facultyModel = facultyDAO.returnFacultyById(facultyId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return facultyModel;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<FacultyDTO> returnAllFaculty() {
		List facultyDTOs = new ArrayList<>();
		try
		{
			List facultyModels = facultyDAO.returnAllFaculty();
			FacultyDTO facultyDTO = new FacultyDTO();
			facultyDTOs.addAll(facultyModels);
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		return facultyDTOs ;
	}
	
	
	public FacultyRepository getFacultyDAO() {
		return facultyDAO;
	}

	public void setFacultyDAO(FacultyRepository facultyDAO) {
		this.facultyDAO = facultyDAO;
	}

	public GenericRepository getGenericDAO() {
		return genericDAO;
	}

	public void setGenericDAO(GenericRepository genericDAO) {
		this.genericDAO = genericDAO;
	}

}
