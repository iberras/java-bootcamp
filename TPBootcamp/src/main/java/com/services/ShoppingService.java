package com.services;

import java.util.List;

import com.entities.Item;

public interface ShoppingService {
	public void addToCart(int idUser, int idItem, int quantity);
	public void updateItemFromCart(int idUser, int idItem, int quantity);
	public void clearCart(int idUser);
	public void deleteFromCart(int idUser, int idItem);
	public void checkOut(int idUser);
	public List<Item> getProductsByCategory(String name);
	public List<Item> getProductsByName(String name);
}
