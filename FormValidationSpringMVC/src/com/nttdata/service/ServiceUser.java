package com.nttdata.service;

import com.nttdata.model.User;

public interface ServiceUser {
	public abstract User validateUserCredential(String email,	String password);
	public abstract boolean registerUser(User User);

}







	
