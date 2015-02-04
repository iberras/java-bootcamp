package com.Ex4.api.tdd;

import java.util.List;

import com.service.meeting.DBSingleton;

/**
 * 
 * Teh local implementation of the service
 *
 */

public class UserServiceImp implements UserService{

	private DBSingleton db = DBSingleton.getinstance();
	
	public void addUser(User u) {
		db.addUser(u);
	}

	public void deleteUser(int id) {
		db.deleteUser(db.getUser(id));
		
	}

	public User getUser(int id) {
		return db.getUser(id);
	}

	public void updateUser(User u) {
		db.modifyUser(u);
		
	}

	public List<User> getAllUsers() {
		return db.getAllUsers();
	}

	public void uploadPhoto(User u, Photo p) {
		db.addPhoto(u, p);
		
	}

	public void addFriend(User u1, User u2) {
		db.addFriend(u1, u2);
		
	}

	public void likePhoto(User u, Photo p) {
		db.likePhoto(u, p);
		
	}

	public List<Photo> getPhotos(User u){
		// TODO Auto-generated method stub
		return db.getUserPhotos(u);
	}

}
