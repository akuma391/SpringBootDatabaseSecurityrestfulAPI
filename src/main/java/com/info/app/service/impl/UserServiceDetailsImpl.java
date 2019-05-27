package com.info.app.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.info.app.dao.UserInfoDAO;
import com.info.app.entities.UserInfo;

@Service
public class UserServiceDetailsImpl implements UserDetailsService{
	
	@Autowired 
	private UserInfoDAO userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	
		//Fetching the user by username form userinfo and providing granted access
		UserInfo userInfo = userInfoDAO.getActiveUser(userName);
		GrantedAuthority authority= new SimpleGrantedAuthority(userInfo.getRole());
		
		//creating user and passing ist of authorities.
		User user= new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
		
		//Typecasted to user details and returning the same
		UserDetails userDetails= (UserDetails)user;
		
		
		
		
		return userDetails;
	}

}
