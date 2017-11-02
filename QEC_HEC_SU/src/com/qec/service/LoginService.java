package com.qec.service;

import javax.servlet.http.HttpServletRequest;

import com.qec.dto.OnlineDTO;
import com.qec.dto.UserDTO;
import com.qec.model.UserModel;

public interface LoginService {
	
	public String loginUser(HttpServletRequest request, UserDTO userDTO);
	
	public String logout(HttpServletRequest  request);

}
