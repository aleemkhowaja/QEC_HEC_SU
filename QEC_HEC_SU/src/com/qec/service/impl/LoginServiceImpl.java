package com.qec.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qec.common.SecurityUtil;
import com.qec.dao.LoginDAO;
import com.qec.dto.UserDTO;
import com.qec.model.UserModel;
import com.qec.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService /*UserDetailsService*/ {

	@Autowired
	private LoginDAO loginDAO;

	@Override
	@Transactional
	public String loginUser(HttpServletRequest request, UserDTO userDTO) 
	{
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
				session.setAttribute("employee", userModel.getEmployeeModel());
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

/*	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username :"+username);
		UserModel  userInfo = loginDAO.findByUserName(username);
		if(userInfo ==null){
			throw new UsernameNotFoundException("Username was not found in the databse");
		}
		
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_USER");
		
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if(roles!=null){
			for(String role: roles){
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
				grantList.add(grantedAuthority);
			}
		}
		
		
		return null;
	}*/

}
