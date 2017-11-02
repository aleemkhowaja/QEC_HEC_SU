package com.qec.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.htm","*.jsp"}) 
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			// ************************ If User Is Already Login Redirect To
			// Home Page ************************ //
			/*if (ses.getAttribute("employee") == null)
			{
				resp.sendRedirect(reqt.getContextPath() + "/index.jsp");
			}
			else*/ 
			if (reqURI.indexOf("/login.htm") >= 0 && (ses != null && ses.getAttribute("employee") != null))
			{
				resp.sendRedirect(reqt.getContextPath() + "/views/dashboard.jsp");
			}
			else if (reqURI.indexOf("/login.htm") >= 0
					|| (ses != null && ses.getAttribute("employee") != null))
			{
				chain.doFilter(request, response);
			}
			else
			{
				resp.sendRedirect(reqt.getContextPath() + "/login.htm");
			}
			
		} catch (Exception e) {
			/*System.out.println(e.getMessage());*/
		}
	}

	@Override
	public void destroy() {

	}
}
