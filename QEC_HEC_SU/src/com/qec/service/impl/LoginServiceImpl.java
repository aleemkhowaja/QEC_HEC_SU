package com.qec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qec.dao.LoginDAO;
import com.qec.model.UserModel;

@Service("loginServiceImpl")
public class LoginServiceImpl implements /*LoginService*/ UserDetailsService {

	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

/*	@Override
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
	}*/
	
	
	/*@Override
	public String logout(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}*/
	

	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("-------------------"+passwordEncoder.encode("y"));
/*		System.out.println("----------------"+username);
		UserModel userMode = new UserModel();
		userMode.setUsername("a");
		userMode.setPassword("b");
		return new org.springframework.security.core.userdetails.User(userMode.getUsername(), userMode.getPassword(), 
                true, true, true, true);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_coordinator"));
		
		return new org.springframework.security.core.userdetails.User(userMode.getUsername(), userMode.getPassword(), true, true, true, true, grantedAuthorities); 
	*/	
		System.out.println("username :"+username);
		UserModel  userInfo = loginDAO.findByUserName(username);
		if(userInfo == null){
			throw new UsernameNotFoundException("Username was not found in the databse");
		}
		
		List<String> roles = new ArrayList<String>();
		roles.add(userInfo.getRole());
		
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if(roles!=null){
			for(String role: roles){
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role);
				grantList.add(grantedAuthority);
			}
		}
		return new org.springframework.security.core.userdetails.User(userInfo.getUsername(), userInfo.getPassword(), true, true, true, true, grantList);
	}

}
