package com.entities.impl;

import java.util.List;

import com.entities.User;

public interface UserDAO {
	public User getUser(int id);
	public List<User> getAllUsers();
	public User getUser(String nickName);
}
