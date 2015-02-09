package com.entities.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entities.Order;

@Repository
public class OrderDAOMySQLImp implements OrderDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Order createOrder(int idUser) {
		Order order = new Order();
		entityManager.getTransaction().begin();
		entityManager.persist(order);
		entityManager.getTransaction().commit();
		
		return order;
	}

}
