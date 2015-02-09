package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.User;
import com.entities.UserDAO;
import com.rest.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public boolean login(String nickName, String password) {
		User u = userDAO.getUser(nickName);
		if(u.getPassword().equals(password))
			return true;
		else
			return false;
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

}
