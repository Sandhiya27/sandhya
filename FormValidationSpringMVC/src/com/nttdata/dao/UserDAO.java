package com.nttdata.dao;

import com.nttdata.model.User;

public interface UserDAO {
	public abstract boolean saveUser(User User);
	public User getUserDetailsByEmailAndPassword(String email,String password);
}

