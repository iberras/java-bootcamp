package com.Ex4.api.tdd;

import java.util.List;

/**
 * 
 * Proxy Patter to use locally the service
 *
 */

public class UserServiceProxy implements UserService {  
    UserService implementation;  
  
    public UserServiceProxy(UserService imp) {  
        this.implementation = imp;  
    }  

	public void addUser(User u) {
		implementation.addUser(u);
		
	}

	public void deleteUser(int id) {
		implementation.deleteUser(id);
		
	}

	public User getUser(int id) {
		return implementation.getUser(id);
	}

	public void updateUser(User u) {
		implementation.updateUser(u);
		
	}

	public List<User> getAllUsers() {
		return implementation.getAllUsers();
	}

	public void uploadPhoto(User u, Photo p) {
		implementation.uploadPhoto(u, p);
		
	}

	public void addFriend(User u1, User u2) {
		implementation.addFriend(u1, u2);
		
	}

	public void likePhoto(User u, Photo p) {
		implementation.likePhoto(u, p);
		
	}

	public List<Photo> getPhotos(User u) {
		return implementation.getPhotos(u);
	}  
}  
