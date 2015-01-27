package com.Ex4.api.tdd;

import java.util.List;
/**
* Interface for User Service
*/
public interface UserService {
	public void addUser(User u); // Add a user to the database
	public void deleteUser(int id); // delete a user from the database
	public User getUser(int id); // get a user from the database
	public void updateUser(User u); // update the data of a certain user
	public List<User> getAllUsers(); // update the data of a certain user get all the user from the database
	public void uploadPhoto(User u, Photo p); // let a user upload a photo
	public List<Photo> getPhotos(User u); // get all the photos from a user
	public void addFriend(User u1, User u2);// add a friend to a user
	public void likePhoto(User u, Photo p);// let a user like a photo
}
