package com.entities.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entities.ShoppingCartEntry;
import com.entities.ShoppingCartEntryPK;
import com.entities.User;

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
		ShoppingCartEntryPK pk = new ShoppingCartEntryPK();
		pk.setIdUser(idUser);
		pk.setIdItem(idItem);
		ShoppingCartEntry entry = entityManager.find(ShoppingCartEntry.class, pk);
		entityManager.getTransaction().begin();
		entry.setQuantity(quantity);
		entityManager.getTransaction().commit();
	}

	@Override
	public void clearCart(int idUser) {
		Query query = (Query) entityManager.createQuery(
			      "delete from ShoppingCartEntry where idUser = "+ idUser + ") ");
		query.executeUpdate();
	}

	@Override
	public void deleteItem(int idUser, int idItem) {
		ShoppingCartEntryPK pk = new ShoppingCartEntryPK();
		pk.setIdUser(idUser);
		pk.setIdItem(idItem);
		ShoppingCartEntry entry = entityManager.find(ShoppingCartEntry.class, pk);
		entityManager.getTransaction().begin();
		entityManager.remove(entry);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<ShoppingCartEntry> getShoppingCart(int idUser) {
		Query q1 = (Query) entityManager.createQuery("SELECT e "
				+ "from ShoppingCartEntry e "
				+ "where  (e.idUser = "+ idUser + ") ");
				
		List<ShoppingCartEntry> queryResult = q1.getResultList();
		return queryResult;
	}

}
