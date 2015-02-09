package com.entities.impl;

import java.util.List;

import com.entities.ShoppingCartEntry;

public interface ShoppingCartEntryDAO {

	public void addItem(int idUser, int idItem, int quantity);

	public void updateItemQuantity(int idUser, int idItem, int quantity);

	public void clearCart(int idUser);

	public void deleteItem(int idUser, int idItem);

	public List<ShoppingCartEntry> getShoppingCart(int idUser);

}
