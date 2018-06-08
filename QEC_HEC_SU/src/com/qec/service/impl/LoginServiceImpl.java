package com.qec.service.impl;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
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

import com.qec.model.UserModel;
import com.qec.repository.LoginRepository;

@Service("loginServiceImpl")
public class LoginServiceImpl implements /*LoginService*/ UserDetailsService {

	@Autowired
	private LoginRepository loginDAO;
	
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		UserModel  userInfo = loginDAO.findByUserName(username);
		if(userInfo == null){
			throw new UsernameNotFoundException("Username was not found in the databse");
		}
		
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			String hostAddress = ip.getHostAddress();
			String hostName = ip.getHostName();
			System.out.println("Current Host address : " + hostAddress);
			System.out.println("Current Host Name : " + hostAddress);
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();

			System.out.print("Current MAC address : ");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			System.out.println(sb.toString());
		} catch (UnknownHostException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
