package com.entities.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entities.OrderEntry;

@Repository
public class OrderEntryDAOMySQLImp implements OrderEntryDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addEntry(int id, int idItem, int quantity) {
		OrderEntry orderEntry = new OrderEntry();
		orderEntry.setIdOrder(id);
		orderEntry.setIdItem(idItem);
		orderEntry.setQuantity(quantity);
		entityManager.getTransaction().begin();
		entityManager.persist(orderEntry);
		entityManager.getTransaction().commit();
	}

}
