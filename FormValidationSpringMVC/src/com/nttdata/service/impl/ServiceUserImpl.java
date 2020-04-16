package com.nttdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dao.UserDAO;
import com.nttdata.model.User;
import com.nttdata.service.ServiceUser;

@Service("UserService")
public class ServiceUserImpl implements ServiceUser {
	
	@Autowired
	private UserDAO UserDAO;
	
	public void setUserDAO(UserDAO UserDAO) {
		this.UserDAO = UserDAO;
	}
	
	public UserDAO getUserDAO() {
		return UserDAO;
	}
	
	@Override
	public boolean registerUser(User User) {
		boolean isRegister=false;
		boolean saveUser = getUserDAO().saveUser(User);
		if(saveUser)
			isRegister=true;
		return isRegister;
	}

	@Override
	public User validateUserCredential(String email, String pwd) {
		User User = getUserDAO().getUserDetailsByEmailAndPassword(email, pwd);
		return User;
	}
}
