package com.Ex4.api.tests;

import static org.junit.Assert.*;

import com.Ex4.api.tdd.Photo;
import com.Ex4.api.tdd.User;
import com.Ex4.api.tdd.UserService;
import com.Ex4.api.tdd.UserServiceFactory;
import com.Ex4.api.tdd.UserServiceImp;
import com.service.meeting.DBSingleton;

public class TestWithFactory {

	@org.junit.Test
	public void testAddToDB() {
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		User user2 = new User(2);
		user2.setName("Perry");
		user2.setPassword("password");
		
		UserService service = UserServiceFactory.getLocalService();
		
		service.addUser(user1);
		service.addUser(user2);
		
		assertEquals(user1, service.getUser(1));
		assertEquals(user2, service.getUser(2));
	}
	
	@org.junit.Test
	public void testRemoveUser() {
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		User user2 = new User(2);
		user2.setName("Perry");
		user2.setPassword("password");
		
		UserService service = UserServiceFactory.getLocalService();
		
		service.addUser(user1);
		service.addUser(user2);
		
		service.deleteUser(user1.getId());
		service.deleteUser(user2.getId());
		
		assertEquals(null, service.getUser(1));
		assertEquals(null, service.getUser(2));
	}
	
	@org.junit.Test
	public void testModifyDB() {
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		
		UserService service = UserServiceFactory.getLocalService();
		
		service.addUser(user1);
		
		user1.setName("Iñaki");
		service.updateUser(user1);
		
		assertEquals("Iñaki", service.getUser(user1.getId()).getName());
	}
	
	@org.junit.Test
	public void testAddPhoto(){
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		Photo p = new Photo("path", user1);
		
		
		UserService service = UserServiceFactory.getLocalService();
		
		service.addUser(user1);
		service.uploadPhoto(user1, p);
		
		user1.setName("Iñaki");
		service.updateUser(user1);
		
		assertEquals(p.getPath(), service.getPhotos(user1).get(0).getPath());
	}
	
	@org.junit.Test
	public void testAddFriend(){
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		User user2 = new User(2);
		user2.setName("Perry");
		user2.setPassword("password");
		
		UserService service = UserServiceFactory.getLocalService();
		
		service.addUser(user1);
		service.addFriend(user1, user2);
		
		assertEquals(user2, service.getUser(user1.getId()).getAllFriends().iterator().next());
	}
	
	@org.junit.Test
	public void testLikePhoto(){
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		Photo p = new Photo("path", user1);
		
		UserService service = UserServiceFactory.getLocalService();
		
		service.addUser(user1);
		service.uploadPhoto(user1, p);
		service.likePhoto(user1, p);
		
		user1.setName("Iñaki");
		service.updateUser(user1);
		
		assertEquals(1, service.getPhotos(user1).size());
	}
	
	
}
