package com.Ex4.api.tdd;

import java.util.ArrayList;
import java.util.List;


/**
* Class containing photo data
*path = path of the photo
*properary = the user that is owner of the photo
*likes = all the users that liked the photo
*/
public class Photo {
	private final String path;
	private final User propetary;
	private final List<User> likes;
	
	public Photo(String path, User propetary){
		this.path = path;
		this.propetary = propetary;
		likes = new ArrayList<User>();
	}
	
	public void like(User user){
		likes.add(user);
	}
	
	public void unLike(User user){
		likes.remove(user);
	}
	
	public User getPropetary(){
		return propetary;
	}
	
	public String getPath(){
		return path;
	}

	public int getNumberOfLikes() {
		return likes.size();
	}
	
}
