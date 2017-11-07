package com.qec.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.qec.common.JQGridDTO;
import com.qec.dto.UserDTO;
import com.qec.model.UserModel;

public interface UsersService
{
    
    public JQGridDTO<UserDTO> returnAllUsersForGrid(HttpServletRequest request);
	
	public String saveUserModel(UserDTO userDTO);
	
	public String deleteUserModel(UserDTO userDTO);
	
	public UserDTO getUserModelById(Long userId);
	
	public List<UserDTO> returnAllUserModel();
}
