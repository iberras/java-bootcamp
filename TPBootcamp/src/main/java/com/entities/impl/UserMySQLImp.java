package com.entities.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entities.User;
import com.entities.UserDAO;

@Repository
public class UserMySQLImp implements UserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User getUser(int id) {
		Query q1 = (Query) entityManager.createQuery("SELECT u  "
				+ "from User u "
				+ "where  (u.id = "+ Integer.toString(id) + ") ");
				
		User queryResult = (User) q1.getSingleResult();
		return queryResult;
	}
	
	@Override
	public List<User> getAllUsers() {
		Query q1 = (Query) entityManager.createQuery("SELECT u "
				+ "from User u");
				
		List<User> queryResult = q1.getResultList();
		return queryResult;
	}
	
	@Override
	public User getUser(String nickName) {
		Query q1 = (Query) entityManager.createQuery("SELECT u  "
				+ "from User u "
				+ "where  (u.nickName = '"+ nickName + "') ");
				
		User queryResult = (User) q1.getSingleResult();
		return queryResult;
	}
	
}
