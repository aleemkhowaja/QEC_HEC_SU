/*package com.qec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.qec.service.impl.LoginServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	 
	// @Qualifier("LoginServiceImpl")
	 //UserDetailsService userDetailsService;
	 
	 @Autowired
	 public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(myUserDetailsService);
		 System.out.println("configureGlobalSecurity Method Call--------------");
		 
	 }
	     
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
			 System.out.println("configure Method Call--------------");

	   aleem code   http.authorizeRequests()
	        .antMatchers("/", "/home").permitAll()
	      //  .antMatchers("/admin/**").access("hasRole('ADMIN')")
	      //  .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
	        .and().formLogin().loginPage("/login-user")
	        .usernameParameter("username").passwordParameter("password")
	        .and().csrf()
	        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
	
	
			 http.authorizeRequests()
				.antMatchers("/dashboard").access("hasRole('ROLE_USER')")
				.and()
					.formLogin().loginPage("/login-user")
					.defaultSuccessUrl("/dashboard")
					.failureUrl("/login-user?error")
					.usernameParameter("username").passwordParameter("password")					
					.and()
					.logout().logoutSuccessUrl("/login-use?logout");
			
			 
			 
	    }

}
*/