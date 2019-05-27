package com.info.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info.app.dao.UserInfoDAO;
import com.info.app.entities.UserInfo;

@Repository
@Transactional
public class UserInfoDaoImpl implements UserInfoDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public UserInfo getActiveUser(String userName) {
		UserInfo userInfo=new UserInfo();
			short ENABLED=1;
			List<?> list=entityManager.createQuery("select u from UserInfo u where userName=?1 and enabled=?2").setParameter(1, userName).setParameter(2,ENABLED).getResultList();
		    
			if(!list.isEmpty()) {
				userInfo = (UserInfo)list.get(0);
			}
			return userInfo;
		
		
		
	}
	
	

}
