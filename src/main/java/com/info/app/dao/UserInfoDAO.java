package com.info.app.dao;

import com.info.app.entities.UserInfo;

public interface UserInfoDAO {

	public abstract UserInfo getActiveUser(String userName);
	
}
