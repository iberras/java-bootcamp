package com.entities.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entities.Item;
import com.entities.User;

@Repository
public class ItemDAOMySQLImp implements ItemDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Item> getItemsByCategory(String name) {
		Query q1 = (Query) entityManager.createQuery("SELECT i  "
				+ "from Item i, Category c "
				+ "where  (i.category = c.idCategory) and (c.name = "+ name + ") ");
				
		List<Item> queryResult = q1.getResultList();
		return queryResult;
	}

	@Override
	public List<Item> getItemsByName(String name) {
		Query q1 = (Query) entityManager.createQuery("SELECT i  "
				+ "from Item i "
				+ "where  (i.name = "+ name + ") ");
				
		List<Item> queryResult = q1.getResultList();
		return queryResult;
	}

}
