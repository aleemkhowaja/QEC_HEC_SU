package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dto.DepartmentsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.FacultyModel;
import com.qec.repository.DepartmentRepository;
import com.qec.repository.FacultyRepository;
import com.qec.repository.GenericRepository;
import com.qec.service.DepartmentsService;

@Service
public class DepartmentServiceImpl implements DepartmentsService {

	@Autowired
	private DepartmentRepository departmentDAO;
	
	@Autowired
	private FacultyRepository facultyDAO;
	
	@Autowired
	private GenericRepository genericDAO;
	

	@Transactional
	@Override
	public JQGridDTO <DepartmentsDTO> returnAllDepartmentsForGrid(HttpServletRequest request) 
	{
		JQGridDTO<DepartmentsDTO> jqGridDTO = new JQGridDTO<DepartmentsDTO>();
		
		List departmentsModels = new ArrayList<>();
		List<DepartmentsDTO> departmentsDTOs = new ArrayList<DepartmentsDTO>();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String departmentName = request.getParameter("departmentName");
			
			departmentsModels =  departmentDAO.returnAllDepartmentForGrid(jtStartIndex, jtPageSize, sortingProperty, order, departmentName);
			departmentsDTOs.addAll(departmentsModels);
			Long records = departmentDAO.returnAllDepartmentForGridCount(departmentName);
			jqGridDTO.setRows(departmentsDTOs);
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
	public String saveDepartment(DepartmentsDTO departmentsDTO) {
		DepartmentsModel departmentsModel = new DepartmentsModel();
		try {
			if(departmentsDTO != null && departmentsDTO.getDepartmentId() == null)
			{
				FacultyModel facultyModel = facultyDAO.returnFacultyById(departmentsDTO.getFacultyId());
				departmentsModel.setDepartmentId(departmentsDTO.getDepartmentId());
				departmentsModel.setName(departmentsDTO.getName());
				departmentsModel.setDetail(departmentsDTO.getDetail());
				departmentsModel.setFaculty(facultyModel);
				departmentsModel.setIsDeleted(false);
				genericDAO.save(departmentsModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				departmentsModel = departmentDAO.returnDepartmentById(departmentsDTO.getDepartmentId());
				FacultyModel facultyModel = facultyDAO.returnFacultyById(departmentsDTO.getFacultyId());
				departmentsModel.setDepartmentId(departmentsDTO.getDepartmentId());
				departmentsModel.setName(departmentsDTO.getName());
				departmentsModel.setDetail(departmentsDTO.getDetail());
				departmentsModel.setFaculty(facultyModel);
				genericDAO.update(departmentsModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public String deleteDepartment(Integer departmentId) {
		try
		{
			DepartmentsModel departmentsModel = departmentDAO.returnDepartmentById(Long.valueOf(departmentId));
			departmentsModel.setIsDeleted(true);
			genericDAO.update(departmentsModel);
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
	public DepartmentsDTO returnDepartmentById(Long departmentId) {
		DepartmentsModel departmentsModel = null;
		DepartmentsDTO departmentsDTO = new DepartmentsDTO();
		try 
		{
			departmentsModel = departmentDAO.returnDepartmentById(departmentId);
			departmentsDTO.setDepartmentId(departmentsModel.getDepartmentId());
			departmentsDTO.setName(departmentsModel.getName());
			departmentsDTO.setDetail(departmentsModel.getDetail());
			departmentsDTO.setFacultyId(departmentsModel.getFaculty().getFacultyId());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return departmentsDTO;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<DepartmentsDTO> returnAllDepartments() {
		List departmentDTOs = new ArrayList<>();
		try
		{
			List departmentsModels = departmentDAO.returnAllDepartments();
			DepartmentsDTO departmentsDTO = new DepartmentsDTO();
			departmentsDTO.setName("Seelct department");
			departmentDTOs.add(departmentsDTO);
			departmentDTOs.addAll(departmentsModels);
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		return departmentDTOs ;
	}
	
	
	public DepartmentRepository getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentRepository departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public GenericRepository getGenericDAO() {
		return genericDAO;
	}

	public void setGenericDAO(GenericRepository genericDAO) {
		this.genericDAO = genericDAO;
	}

}
