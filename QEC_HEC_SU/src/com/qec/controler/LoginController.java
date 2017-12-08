/*package com.qec.controler;

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
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcomePage");
		System.out.println("WElcome Page in =========");
		return model;
	}

	@RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		System.out.println("Home Page in =========");
		ModelAndView model = new ModelAndView();
		model.setViewName("homepage");
		return model;
	}
	
	@RequestMapping(value = { "/dashboard"}, method = RequestMethod.GET)
	public ModelAndView sellproperty(HttpServletRequest req) {
		
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  String name = auth.getName(); //get logged in username
	  UserModel userModel  = new UserModel();
	  userModel.setUsername(name);
	  
		System.out.println("sellproperty in =========");
		ModelAndView model = new ModelAndView();
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	
		session.setAttribute("employee", userModel.getEmployee());
		model.setViewName("dashboard");
		return model;
	}
	
	@RequestMapping(value = "/login-user")
	public ModelAndView login(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		System.out.println("logout=========");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
			System.out.println("Invalid----");
		}

		if (logout != null) {
			model.addObject("message", "Logged out successfully.");
		}
		model.addObject("login", new UserDTO());
		model.setViewName("/LoginPage");
		return model;
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
*/