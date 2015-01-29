package com.Ex4.api.tests;

import static org.junit.Assert.*;

import com.Ex4.api.tdd.DBSingleton;
import com.Ex4.api.tdd.Photo;
import com.Ex4.api.tdd.User;
import com.Ex4.api.tdd.UserService;
import com.Ex4.api.tdd.UserServiceImp;
import com.Ex4.api.tdd.UserServiceProxy;

public class TestUserService {

	@org.junit.Test
	public void testAddToDB() {
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		User user2 = new User(2);
		user2.setName("Perry");
		user2.setPassword("password");
		

		UserService serviceproxy = new UserServiceProxy(new UserServiceImp());
		serviceproxy.addUser(user1);
		serviceproxy.addUser(user2);
		
		assertEquals(user1, serviceproxy.getUser(1));
		assertEquals(user2, serviceproxy.getUser(2));
	}
	
	@org.junit.Test
	public void testRemoveUser() {
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		User user2 = new User(2);
		user2.setName("Perry");
		user2.setPassword("password");
		
		UserService serviceproxy = new UserServiceProxy(new UserServiceImp());
		
		serviceproxy.addUser(user1);
		serviceproxy.addUser(user2);
		
		serviceproxy.deleteUser(user1.getId());
		serviceproxy.deleteUser(user2.getId());
		
		assertEquals(null, serviceproxy.getUser(1));
		assertEquals(null, serviceproxy.getUser(2));
	}
	
	@org.junit.Test
	public void testModifyDB() {
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		
		UserService serviceproxy = new UserServiceProxy(new UserServiceImp());

		
		serviceproxy.addUser(user1);
		
		user1.setName("Iñaki");
		serviceproxy.updateUser(user1);
		
		assertEquals("Iñaki", serviceproxy.getUser(user1.getId()).getName());
	}
	
	@org.junit.Test
	public void testAddPhoto(){
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		Photo p = new Photo("path", user1);
		
		UserService serviceproxy = new UserServiceProxy(new UserServiceImp());
		
		serviceproxy.addUser(user1);
		serviceproxy.uploadPhoto(user1, p);
		
		user1.setName("Iñaki");
		serviceproxy.updateUser(user1);
		
		assertEquals(p.getPath(), serviceproxy.getPhotos(user1).get(0).getPath());
	}
	
	@org.junit.Test
	public void testAddFriend(){
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		User user2 = new User(2);
		user2.setName("Perry");
		user2.setPassword("password");
		
		UserService serviceproxy = new UserServiceProxy(new UserServiceImp());
		
		serviceproxy.addUser(user1);
		serviceproxy.addFriend(user1, user2);
		
		assertEquals(user2, serviceproxy.getUser(user1.getId()).getAllFriends().iterator().next());
	}
	
	@org.junit.Test
	public void testLikePhoto(){
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		Photo p = new Photo("path", user1);
		
		UserService serviceproxy = new UserServiceProxy(new UserServiceImp());
		
		serviceproxy.addUser(user1);
		serviceproxy.uploadPhoto(user1, p);
		serviceproxy.likePhoto(user1, p);
		
		user1.setName("Iñaki");
		serviceproxy.updateUser(user1);
		
		assertEquals(1, serviceproxy.getPhotos(user1).size());
	}
}
