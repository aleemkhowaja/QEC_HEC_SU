package com.qec.service.impl;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qec.common.JQGridDTO;
import com.qec.dao.DepartmentDAO;
import com.qec.dao.EventsDAO;
import com.qec.dao.GenericDAO;
import com.qec.dto.EventsDTO;
import com.qec.dto.UniProgramsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.EventsModel;
import com.qec.model.UniProgramsModel;
import com.qec.service.EventsService;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private EventsDAO eventsDAO;
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO; 
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Override
	@Transactional
	public JQGridDTO<EventsDTO> returnAllEventsModelForGrid(HttpServletRequest request) 
	{
		
		JQGridDTO<EventsDTO> jqGridDTO = new JQGridDTO<EventsDTO>();
		List<EventsModel> eventsModels = new ArrayList<EventsModel>();
		List<EventsDTO> eventsDTOs = new ArrayList<EventsDTO>();
		EventsModel eventsModel = new EventsModel();
		EventsDTO eventsDTO = new EventsDTO();
		
		try {
			String order = request.getParameter("sord");
			String sortingProperty = request.getParameter("sidx");
			int page = Integer.valueOf(request.getParameter("page")).intValue();
			Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
			Integer jtStartIndex = (page-1)*jtPageSize;
			String eventTitle = request.getParameter("eventTitle");
			eventsModels =  eventsDAO.returnAllEventsModelForGrid(jtStartIndex, jtPageSize, sortingProperty, order, eventTitle);
			Long records = eventsDAO.returnAllEventsModelForGridCount(eventTitle);
			//eventsDTOs.addAll(eventsModels);
			for(int i=0; i<eventsModels.size(); i++) 
			{
				eventsModel = eventsModels.get(i);
				eventsDTO = new EventsDTO();
				//uniProgramsDTO.setDepartmentId(Long.valueOf(uniProgramsModel.getDepartmentsModel().getDepartmentId()));
				eventsDTO.setDepartmentName(eventsModel.getDepartmentsModel().getName());;
				eventsDTO.setEventTitle(eventsModel.getEventTitle());
				eventsDTO.setEventDetail(eventsModel.getEventDetail());
				eventsDTO.setColor(eventsModel.getColor());
				eventsDTO.setEventsId(eventsModel.getEventsId());
				eventsDTO.setEndDate(eventsModel.getEndDate());
				eventsDTO.setDateof(eventsModel.getDateof());
				eventsDTO.setQuota(eventsModel.getQuota());
				eventsDTOs.add(eventsDTO);
			}
			jqGridDTO.setRows(eventsDTOs);
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
	public String saveEventsModelModel(EventsDTO eventsDTO) 
	{
		// TODO Auto-generated method stub
		EventsModel eventsModel = new EventsModel();
		try 
		{
			DepartmentsModel departmentsModel = new DepartmentsModel();
			if(eventsDTO.getDepartmentId() != null)
			{
				departmentsModel = departmentDAO.returnDepartmentById(Long.valueOf(eventsDTO.getDepartmentId()));
			}
			
			if(eventsDTO.getEventsId() == null)
			{
				
				eventsModel.setDepartmentsModel(departmentsModel);
				eventsModel.setEventTitle(eventsDTO.getEventTitle());
				eventsModel.setDateof(eventsDTO.getDateof());
				eventsModel.setEndDate(eventsDTO.getEndDate());
				eventsModel.setQuota(eventsDTO.getQuota());
				eventsModel.setEventDetail(eventsDTO.getEventDetail());
				eventsModel.setIsDeleted(false);
				genericDAO.save(eventsModel);
				return "Record Inserted Successfully";
			}
			else
			{
				eventsModel = eventsDAO.returnEventsModelById(eventsDTO.getEventsId());
				eventsModel.setDepartmentsModel(departmentsModel);
				eventsModel.setEventTitle(eventsDTO.getEventTitle());
				eventsModel.setEventDetail(eventsDTO.getEventDetail());
				eventsModel.setDateof(eventsDTO.getDateof());
				eventsModel.setEndDate(eventsDTO.getEndDate());
				eventsModel.setQuota(eventsDTO.getQuota());
				genericDAO.update(eventsModel);
				return "Record Updated Successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EventsDTO returnEventsModelById(Integer eventsId) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventsDTO> returnAllEventsModelModel() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public EventsDTO getEventsModelById(Long eventsId) 
	{
		// TODO Auto-generated method stub
		EventsModel eventsModel = new EventsModel();
		EventsDTO eventsDTO = new EventsDTO();
		try 
		{
			eventsModel = eventsDAO.returnEventsModelById(eventsId);
			eventsDTO.setDepartmentId(Long.valueOf(eventsModel.getDepartmentsModel().getDepartmentId()));
			eventsDTO.setEndDate(eventsModel.getEndDate());;
			eventsDTO.setDateof(eventsModel.getDateof());
			eventsDTO.setEventTitle(eventsModel.getEventTitle());
			eventsDTO.setQuota(eventsModel.getQuota());
			eventsDTO.setEventDetail(eventsModel.getEventDetail());
			eventsDTO.setEventsId(eventsModel.getEventsId());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return eventsDTO;
	}

	@Override
	@Transactional
	public String deleteEventsModel(EventsDTO eventsDTO) 
	{
		// TODO Auto-generated method stub
		EventsModel eventsModels = new EventsModel();
		try 
		{
			if(eventsDTO.getEventsId() != null)
			{
				eventsModels = eventsDAO.returnEventsModelById(eventsDTO.getEventsId());
				eventsModels.setIsDeleted(true);
				genericDAO.update(eventsModels);
				return "Record Delete Successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
