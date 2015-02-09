package com.entities.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entities.ShoppingCartEntry;

@Repository
public class ShoppingCartEntryDAOMySQLImp implements ShoppingCartEntryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void addItem(int idUser, int idItem, int quantity) {
		ShoppingCartEntry entry = new ShoppingCartEntry();
		entry.setIdUser(idUser);
		entry.setIdItem(idItem);
		entry.setQuantity(quantity);
		entityManager.getTransaction().begin();
		entityManager.persist(entry);
		entityManager.getTransaction().commit();

	}

	@Override
	public void updateItemQuantity(int idUser, int idItem, int quantity) {
		ShoppingCartEntry entry = entityManager.find(ShoppingCartEntry.class, idUser);
		entityManager.getTransaction().begin();
		entry.setQuantity(quantity);
		entityManager.getTransaction().commit();
	}

	@Override
	public void clearCart(int idUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteItem(int idUser, int idItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ShoppingCartEntry> getShoppingCart(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
