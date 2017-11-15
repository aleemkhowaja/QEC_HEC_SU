package com.qec.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.UserDTO;

public interface UsersService
{
    /**
     * return all user models for grid
     * @param request
     * @return
     */
    public JQGridDTO<UserDTO> returnAllUsersForGrid(HttpServletRequest request);
	
    /**
     * save userMode in user table
     * @param userDTO
     * @return
     */
	public String saveUserModel(UserDTO userDTO);
	
	/**
	 *  delete user model by id
	 * @param userDTO
	 * @return
	 */
	public String deleteUserModel(UserDTO userDTO);
	
	/**
	 * get userModel by userId
	 * @param userId
	 * @return
	 */
	public UserDTO getUserModelById(Long userId);
	
	/**
	 * return all usermodels
	 * @return
	 */
	public List<UserDTO> returnAllUserModel();
}
