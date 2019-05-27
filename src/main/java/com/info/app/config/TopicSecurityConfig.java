package com.info.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.info.app.service.impl.UserServiceDetailsImpl;

@EnableWebSecurity // Enable security for web application
@EnableGlobalMethodSecurity(securedEnabled=true) // to apply Method level annotation
public class TopicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceDetailsImpl userServiceDetailsImpl;
	
	@Autowired
	private TopicAuthenticationEntryPoint topicAuthenticationEntryPoint;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.csrf().disable()
			.authorizeRequests()
			  	.antMatchers("/user/**").hasAnyRole("ADMIN","USER")
			  	.and().httpBasic().realmName("Topic security application Realm")
			  		.authenticationEntryPoint(topicAuthenticationEntryPoint);
			
		}
		
	//To get password to authenticate from database
	@Autowired
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userServiceDetailsImpl).passwordEncoder(bCryptPasswordEncoder);
	}

}