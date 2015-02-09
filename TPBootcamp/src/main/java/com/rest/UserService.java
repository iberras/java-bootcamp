package com.rest;

import java.util.List;

import com.entities.User;

public interface UserService {
	public boolean login(String nickName, String password);
	public List<User> getAllUsers();
}
