package com.entities;

import java.util.List;

public interface UserDAO {
	public User getUser(int id);
	public List<User> getAllUsers();
	public User getUser(String nickName);
}
