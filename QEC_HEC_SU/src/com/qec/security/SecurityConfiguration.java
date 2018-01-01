package com.qec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	 
	@Autowired
	@Qualifier("loginServiceImpl")
	UserDetailsService userDetailsService;
	 
	 @Autowired
	 public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		 System.out.println("configureGlobalSecurity Method Call--------------");
	 }
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	/* @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	     authenticationProvider.setUserDetailsService(userDetailsService);
	     authenticationProvider.setPasswordEncoder(passwordEncoder());
	     return authenticationProvider;
	 }*/
	     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//http.addFilterAfter(new AuthorizationFilter(), BasicAuthenticationFilter.class);
    	http.authorizeRequests()
		    .antMatchers("/qec/**").access("hasRole('admin') or hasRole('coordinator')")
		    .antMatchers("/views/**").access("hasRole('admin') or hasRole('coordinator')")
			.antMatchers("/login.htm").permitAll()
			.and()
			    .formLogin().loginPage("/login.htm").loginProcessingUrl("/login.htm").failureUrl("/login.htm?error")
			    .defaultSuccessUrl("/qec/dashboard.htm")
			    .usernameParameter("username").passwordParameter("password")
			    .and().logout().logoutSuccessUrl("/login.htm?logout")
			    .and().csrf();
	    }

}