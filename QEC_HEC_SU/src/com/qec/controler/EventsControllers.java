package com.qec.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.io.Files;
import com.qec.common.CommonConstants;
import com.qec.common.JQGridDTO;
import com.qec.dto.EventsDTO;
import com.qec.service.EventsService;

@Controller
public class EventsControllers {

	@Autowired
	private EventsService eventsService;
	
	@Autowired
	private ServletContext servletContext;
	
	/**
	 * return employee models from grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/events/returnAllEventsForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<EventsDTO> returnAllEventsForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return eventsService.returnAllEventsModelForGrid(request);
	}
	
	/**
	 * save record
	 * @param eventsDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value="qec/events/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveEvents(MultipartHttpServletRequest request, HttpServletResponse respons) 
	{
		String result = eventsService.saveEvents(request); 
		return result;
	}
	
	/**
	 * retrun event DTO by event id
	 * @param eventsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="qec/events/returnEventByEventId", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public EventsDTO returnEventByEventId(@RequestParam("eventsId") Integer eventsId, Model model) 
	{
		EventsDTO eventsDTO = eventsService.getEventsModelById(Long.valueOf(eventsId)); 
		return eventsDTO;
	}
	
	/**
	 * delete event by event id
	 * @param eventsDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value="qec/events/deleteEventByEventId", method = RequestMethod.POST)
	@ResponseBody
	public String deleteEventByEventId(@RequestBody EventsDTO eventsDTO, HttpServletRequest request) {
		String result = eventsService.deleteEventsModel(eventsDTO);
		return result;
	}
	
	/*
	@RequestMapping(value="/faculty/deleteFacultyById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteFacultyById(@RequestParam("facultyId") Integer facultyId, HttpServletRequest request) 
	{
		String result = facultyService.deleteFaculty(facultyId);
		return result;
	}*/
	
	
	@RequestMapping(value="qec/events/downloadEvent" , method = RequestMethod.GET)
	public void downloader(HttpServletRequest request, HttpServletResponse response,@RequestParam("fileName") String fileName) {
		int BUFFER_SIZE = 4096;
		try {
			String filePath = CommonConstants.uploadFileUrl+"eventFile/"+fileName;
			System.out.println("----------------"+filePath);
	        File file = new File(filePath);
	        FileInputStream inputStream = new FileInputStream(file);
	        if (file.exists()) {
	        	String mimeType = servletContext.getMimeType(file.getPath());
	        	
	        	if(mimeType == null)
	        	{
	        		mimeType = "application/octet-stream";
	        	}
	        	
	        	response.setContentType(mimeType);
	        	response.setContentLength((int) file.length());
	        	
	        	  String headerKey = "Content-Disposition";
	              String headerValue = String.format("attachment; filename=\"%s\"",file.getName());
	              response.setHeader(headerKey, headerValue);
	              
	           // get output stream of the response
	              OutputStream outStream = response.getOutputStream();
	       
	              byte[] buffer = new byte[BUFFER_SIZE];
	              int bytesRead = -1;
	       
	              // write bytes read from the input stream into the output stream
	              while ((bytesRead = inputStream.read(buffer)) != -1) {
	                  outStream.write(buffer, 0, bytesRead);
	              }
	       
	              inputStream.close();
	              outStream.close();
	              
	        	//response.addHeader("content-disposition", "attachment; filename=\"" + fileName+"\"");
	        	//response.setHeader("Set-Cookie", "fileDownload=true; path=/");
	          //  response.setContentLength((int) file.length());
	            
	            
	          //  OutputStream os = response.getOutputStream();
	          //  FileInputStream fis = new FileInputStream(file);
	           // byte[] buffer = Files.toByteArray(file);
	            
	          //  System.out.println(buffer.length);
	            //response.addHeader("content-disposition", "attachment;filename=\"" + fileName);
	    	    //response.setHeader("Set-Cookie", "fileDownload=true; path=/");
	    	  //  response.getOutputStream().write(buffer);
	    	 //   response.getOutputStream().flush();
	    	 //   response.getOutputStream().close();
	    	    
	    	    
	            /*int b = -1;
	            while((b = fis.read(buffer)) != -1)
	            {
	            	os.write(buffer, 0, b);
	            }
	            System.out.println("======="+buffer);*/
	            
	            //FileCopyUtils.copy(fis, response.getOutputStream());
	           // response.flushBuffer();
	            /*
	            byte[] buffer = new byte[4096];
	            int b = -1;
	            while((b = fis.read(buffer)) != -1)
	            {
	            	os.write(buffer, 0, b);
	            }
	            
	            fis.close();
	            os.close();*/
	        	/*// here I use Commons IO API to copy this file to the response output stream, I don't know which API you use.
	            FileUtils.copyFile(file, response.getOutputStream());

	            // here we define the content of this file to tell the browser how to handle it
	            response.setContentType("text/plain");
	            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
	            ServletOutputStream outputStream = response.getOutputStream();
	            outputStream.println
	            response.flushBuffer();*/
	        } else {
	            System.out.println("Contract Not Found");
	        }
	    } catch (IOException exception) {
	        System.out.println("Contract Not Found");
	        System.out.println(exception.getMessage());
	    }
	 }

}
