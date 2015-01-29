package com.Ex4.api.tests;

import static org.junit.Assert.*;

import com.Ex4.api.tdd.DBSingleton;
import com.Ex4.api.tdd.Photo;
import com.Ex4.api.tdd.User;

public class TestDB {

	@org.junit.Test
	public void testCreationUser() {
		User user = new User(1);
		user.setName("John");
		user.setPassword("123456");
		assertEquals("John", user.getName());
		assertEquals("123456", user.getPassword());
	}
	
	@org.junit.Test
	public void testAddFriend() {
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		User user2 = new User(2);
		user2.setName("Perry");
		user2.setPassword("password");
		
		user1.addFriend(user2);
		
		assertEquals("Perry", user1.getAllFriends().iterator().next().getName());
		
	}
	
	@org.junit.Test
	public void testAddToDB() {
		User user1 = new User(1);
		user1.setName("John");
		user1.setPassword("123456");
		User user2 = new User(2);
		user2.setName("Perry");
		user2.setPassword("password");
		
		DBSingleton db = DBSingleton.getinstance();
		db.addUser(user1);
		db.addUser(user2);
		
		assertEquals(user1, db.getUser(1));
		assertEquals(user2, db.getUser(2));
	}
	
	@org.junit.Test
	public void testRemoveDB() {
		User user3 = new User(3);
		user3.setName("Johnn");
		user3.setPassword("1234567");
		User user4 = new User(4);
		user4.setName("Perry");
		user4.setPassword("password");
		
		DBSingleton db = DBSingleton.getinstance();
		db.addUser(user3);
		db.addUser(user4);
		
		db.deleteUser(user3);
		db.deleteUser(user4);
		
		assertEquals(null, db.getUser(3));
		assertEquals(null, db.getUser(4));
	}
	
	@org.junit.Test
	public void testModifyDB() {
		User user4 = new User(4);
		user4.setName("Perry");
		user4.setPassword("password");
		
		DBSingleton db = DBSingleton.getinstance();
		db.addUser(user4);
		
		user4.setName("Iñaki");
		db.modifyUser(user4);
		
		assertEquals("Iñaki", db.getUser(user4.getId()).getName());
	}
	
	@org.junit.Test
	public void testPhotoCreation(){
		User user = new User(1);
		user.setName("John");
		user.setPassword("123456");
		Photo photo = new Photo("Foto", user);
		photo.like(user);
	
		DBSingleton db = DBSingleton.getinstance();
		db.addUser(user);
		
		db.addPhoto(user, photo);
		
		assertEquals(db.getUserPhotos(user).get(0), photo);
	}

}
