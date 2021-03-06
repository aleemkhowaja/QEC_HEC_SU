package com.qec.service.impl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qec.common.CommonConstants;
import com.qec.common.DateUtil;
import com.qec.common.JQGridDTO;
import com.qec.dto.EventsDTO;
import com.qec.model.DepartmentsModel;
import com.qec.model.EventsModel;
import com.qec.repository.DepartmentRepository;
import com.qec.repository.EventsRepository;
import com.qec.repository.GenericRepository;
import com.qec.service.EventsService;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private EventsRepository eventsDAO;
	
	@Autowired
	private GenericRepository genericDAO;
	
	@Autowired
	private DepartmentRepository departmentDAO; 
	
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
				eventsDTO.setEndDate(String.valueOf(eventsModel.getEndDate()));
				eventsDTO.setDateof(String.valueOf(eventsModel.getDateof()));
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
	public String saveEvents(MultipartHttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		EventsModel eventsModel = new EventsModel();
		try 
		{
			
			MultipartFile multipartFile = request.getFile("events_file");
			String startDate = request.getParameter("dateof");
			String endDate = request.getParameter("endDate");
			String quota = request.getParameter("quota");
			String eventTitle = request.getParameter("eventTitle");
			String department = request.getParameter("departmentId");
			String eventId = request.getParameter("eventsId");
			String eventDetail = request.getParameter("eventDetail");
			Long size = multipartFile.getSize();
			String fileName = "eventFile"+System.currentTimeMillis()+".txt";
		    String contentType = multipartFile.getContentType();
		    InputStream stream;
		    byte[] bytes;
			stream = multipartFile.getInputStream();
			bytes = IOUtils.toByteArray(stream);
			File path = new File(CommonConstants.uploadFileUrl+"eventFile/"+fileName);
			if(!path.exists())
			{
				path.createNewFile();
			}
			FileOutputStream out = new FileOutputStream (path);
			try {
				out.write(bytes);
			} finally {
				stream.close();
			}
			DepartmentsModel departmentsModel = new DepartmentsModel();
			if(department != null || !department.equals(""))
			{
				departmentsModel = departmentDAO.returnDepartmentById(Long.valueOf(department));
			}
			
			if(eventId == null || eventId.equals(""))
			{
				
				eventsModel.setDepartmentsModel(departmentsModel);
				eventsModel.setEventTitle(eventTitle);
				eventsModel.setDateof(DateUtil.stringToDate(startDate));
				eventsModel.setEndDate(DateUtil.stringToDate(endDate));
				eventsModel.setQuota(Double.valueOf(quota));
				eventsModel.setEventDetail(eventDetail);
				eventsModel.setFileName(fileName);
				eventsModel.setIsDeleted(false);
				genericDAO.save(eventsModel);
				return CommonConstants.SAVE_SUCCESS_MSG;
			}
			else
			{
				eventsModel = eventsDAO.returnEventsModelById(Long.valueOf(eventId));
				eventsModel.setDepartmentsModel(departmentsModel);
				eventsModel.setEventTitle(eventTitle);
				eventsModel.setEventDetail(eventDetail);
				eventsModel.setDateof(DateUtil.stringToDate(startDate));
				eventsModel.setEndDate(DateUtil.stringToDate(endDate));
				eventsModel.setQuota(Double.valueOf(quota));
				eventsModel.setFileName(fileName);
				genericDAO.update(eventsModel);
				return CommonConstants.UPLDATE_SUCCESS_MSG;
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
			eventsDTO.setEndDate(String.valueOf(eventsModel.getEndDate()));
			eventsDTO.setDateof(String.valueOf(eventsModel.getDateof()));
			eventsDTO.setEventTitle(eventsModel.getEventTitle());
			eventsDTO.setQuota(eventsModel.getQuota());
			eventsDTO.setEventDetail(eventsModel.getEventDetail());
			eventsDTO.setEventsId(eventsModel.getEventsId());
			eventsDTO.setFileName(eventsModel.getFileName());
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
				return CommonConstants.DELETE_SUCCESS_MSG;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
