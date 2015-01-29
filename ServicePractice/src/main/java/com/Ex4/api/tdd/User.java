package com.Ex4.api.tdd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Class containing user data
* id = identification
* name = name of the user
* password = passoword of the user
* friends = all the friends that this user has
*
*/
public class User {
	private final int id;
	private String name;
	private String password;
	private Set<User> friends;
	
	public User(int id){
		friends = new HashSet<User>();
		this.id = id;
	}

	public int getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addFriend(User friend){
		friends.add(friend);
	}
	
	public void deleteFriend(User friend){
		friends.remove(friend);
	}
	
	public Set<User> getAllFriends(){
		return friends;
	}
	
	
}
