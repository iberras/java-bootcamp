package com.Ex4.api.tdd;

import java.util.List;
/**
* Interface for User Service
*/
public interface UserService {
	/**
	 * Add a user to the database
	 * @param u
	 */
	public void addUser(User u);
	/**
	 * delete a user from the database
	 * @param id
	 */
	public void deleteUser(int id); 
	/**
	 * get a user from the database
	 * @param id
	 * @return
	 */
	public User getUser(int id); 
	/**
	 * update the data of a certain user
	 * @param u
	 */
	public void updateUser(User u); 
	/**
	 * update the data of a certain user get all the user from the database
	 * @return
	 */
	public List<User> getAllUsers();
	/**
	 * vlet a user upload a photo
	 * @param u
	 * @param p
	 */
	public void uploadPhoto(User u, Photo p);
	/**
	 * get all the photos from a user
	 * @param u
	 * @return
	 */
	public List<Photo> getPhotos(User u);
	/**
	 * add a friend to a user
	 * @param u1
	 * @param u2
	 */
	public void addFriend(User u1, User u2);
	/**
	 * let a user like a photo
	 * @param u
	 * @param p
	 */
	public void likePhoto(User u, Photo p);
}
