package com.qec.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qec.dto.UserDTO;
import com.qec.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
 
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	//Login Method
	@RequestMapping(value="/login-user", method=RequestMethod.POST)
	//@ResponseBody
	public String login(HttpServletRequest request, Model model, @ModelAttribute("login") UserDTO userDTO ) {
		model.addAttribute("error", "error");
		String page = loginService.loginUser(request, userDTO);
		return page;
	}

}
