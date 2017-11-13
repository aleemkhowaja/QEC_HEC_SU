package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.JQGridDTO;
import com.qec.common.JTableList;
import com.qec.dao.DepartmentDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.DepartmentsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.service.DepartmentsService;

@Service
public class DepartmentServiceImpl implements DepartmentsService {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private GenericDAO genericDAO;
	

	@Transactional
	@Override
	public JQGridDTO<DepartmentsModel> returnAllDepartmentsForGrid(HttpServletRequest request) {

		JQGridDTO<DepartmentsModel> jqGridDTO = new JQGridDTO<DepartmentsModel>();
		List<DepartmentsModel> departmentsModels = new ArrayList<DepartmentsModel>();
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			/*Integer jtStartIndex = 0;*/ /*request.getParameter("jtStartIndex") == null ? null : Integer.parseInt(request.getParameter("jtStartIndex"));*/
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String departmentName = request.getParameter("departmentName");
			
			departmentsModels =  departmentDAO.returnAllDepartmentForGrid(jtStartIndex, jtPageSize, sortingProperty, order, departmentName);
			Long records = departmentDAO.returnAllDepartmentForGridCount(departmentName);
			jqGridDTO.setRows(departmentsModels);
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
	public String saveDepartment(DepartmentsModel departmentsModel) {
		try {
			if(departmentsModel != null && departmentsModel.getDepartmentId() == null)
			{
				genericDAO.save(departmentsModel);
				return "Record Inserted Successfully";
			}
			else
			{
				genericDAO.update(departmentsModel);
				return "Record Updated Successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public String deleteDepartment(DepartmentsModel departmentsModel) {
		try
		{
			departmentsModel.setIsDeleted(true);
			genericDAO.update(departmentsModel);
			return "Record Deleted Successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public DepartmentsModel getDepartmentById(Long departmentId) {
		DepartmentsModel departmentsModel = null;
		try 
		{
			departmentsModel = departmentDAO.returnDepartmentById(departmentId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return departmentsModel;
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
	
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public GenericDAO getGenericDAO() {
		return genericDAO;
	}

	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

}
