package com.Ex4.api.tdd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBSingleton {
	
	private Map<Integer, User> users;
	private Map<User, List<Photo>> photos;
	private static DBSingleton instance = new DBSingleton();
	
	private  DBSingleton(){
		users = new HashMap<Integer, User>();
		photos = new HashMap<User, List<Photo>>();
	}
	
	public void addFriend(User u1, User u2){
		u1.addFriend(u2);
	}
	
	public List<User> getFriends(User u){
		return (List<User>) u.getAllFriends();
	}
	
	public void likePhoto(User u, Photo p){
		p.like(u);
	}
	
	public static DBSingleton getinstance(){
		return instance;
	}
	
	public void addUser(User u){
		users.put(u.getId(), u);
	}

	public User getUser(int id) {
		return users.get(id);
	}

	public void deleteUser(User user) {
		users.remove(user.getId());
	}
	
	public void modifyUser(User u){
		users.remove(u.getId());
		users.put(u.getId(), u);
	}
	
	public List<User> getAllUsers() {
		return (List<User>) users.values();
	}

	public void addPhoto(User u, Photo p) {
		List<Photo> photosUser = photos.get(u);
		if(photosUser != null)
			photosUser.add(p);
		else{
			List<Photo> photosaux = new ArrayList<Photo>();
			photosaux.add(p);
			photos.put(u, photosaux);
		}
	}
	
	public List<Photo> getUserPhotos(User u){
		return photos.get(u);
	}
	
}
