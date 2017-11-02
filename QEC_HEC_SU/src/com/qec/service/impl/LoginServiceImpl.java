package com.qec.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qec.common.SecurityUtil;
import com.qec.dao.LoginDAO;
import com.qec.dto.OnlineDTO;
import com.qec.dto.UserDTO;
import com.qec.model.UserModel;
import com.qec.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDAO loginDAO;

	@Override
	@Transactional
	public String loginUser(HttpServletRequest request, UserDTO userDTO) {
		//OnlineDTO dto = OnlineDTO.initialize();
		try {
			String username = userDTO.getUsername();
			String password = userDTO.getPassword();
			password = SecurityUtil.encodePassword(password);
			UserModel userModel  = new UserModel();
			userModel.setUsername(username);
			userModel.setPassword(password);
			userModel = loginDAO.login(userModel);
			if (userModel != null) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
				session = request.getSession(true);
				session.setAttribute("employee", userModel.getEmployee());
				return "redirect:/views/dashboard.jsp";
			} else {
				return "LoginPage";
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "LoginPage";
	}

	@Override
	public String logout(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * @return the loginDAO
	 */
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	/**
	 * @param loginDAO the loginDAO to set
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

}
