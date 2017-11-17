package com.qec.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qec.common.JQGridDTO;
import com.qec.dto.UserDTO;
import com.qec.service.UsersService;

@Controller
public class CoordinatorController {

	@Autowired
	private UsersService usersService;
	
	/**
	 * return all coordinators for Grid
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="qec/coordinator/returnAllCoordinatorsForGrid", produces = "application/json")
	@ResponseBody
	public JQGridDTO<UserDTO> returnAllCoordinatorsForGrid(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) 
	{
		return usersService.returnAllUsersForGrid(request);
	}
	
	/**
	 * save record
	 * @param userDTO
	 * @return
	 */
	@RequestMapping(value="qec/coordinator/save.htm", method = RequestMethod.POST )
	@ResponseBody
	public String saveCoordinator(@RequestBody UserDTO userDTO, HttpServletRequest request) 
	{
	    String result = usersService.saveUserModel(userDTO); 
		return result; 
	}
	
	/**
	 * return Coordinator by id
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="qec/coordinator/returnCoordinatorById", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public UserDTO  returnCoordinatorById(@RequestParam("userId") Integer userId) 
	{
		UserDTO userDTO = usersService.getUserModelById(Long.valueOf(userId)); 
		return userDTO;
	}
	
	/**
	 * delete coordinator by id
	 * @param userDTO
	 * @return
	 */
	@RequestMapping(value="qec/coordinator/deleteCoordinatorById", method = RequestMethod.POST)
	@ResponseBody
	public String  deleteCoordinatorById(@RequestBody UserDTO userDTO) 
	{
		String result = usersService.deleteUserModel(userDTO);
		return result;
	}

}
