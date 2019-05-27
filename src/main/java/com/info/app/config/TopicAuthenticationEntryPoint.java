package com.info.app.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class TopicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	//If some errors occues then some message should be displayed	
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException ) throws IOException,ServletException{
		
		response.addHeader("WWW-Authenticate", "Basic ralm=\""+getRealmName());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
	}
	
	public void afterPropertiesSet() throws Exception{
		setRealmName("Topic security application Realm");
	}
}
