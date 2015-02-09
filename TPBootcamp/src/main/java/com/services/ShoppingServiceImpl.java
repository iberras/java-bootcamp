package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Item;
import com.entities.Order;
import com.entities.ShoppingCartEntry;
import com.entities.impl.ItemDAO;
import com.entities.impl.OrderDAO;
import com.entities.impl.OrderEntryDAO;
import com.entities.impl.ShoppingCartEntryDAO;
import com.entities.impl.StockDAO;

@Service
public class ShoppingServiceImpl implements ShoppingService{
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderEntryDAO orderEntryDAO;
	
	@Autowired
	private ShoppingCartEntryDAO shoppingCartEntryDAO;
	
	@Autowired
	private StockDAO stockDAO;
	

	
	@Override
	public void addToCart(int idUser, int idItem, int quantity) {
		shoppingCartEntryDAO.addItem(idUser,idItem, quantity);
		
	}

	@Override
	public void updateItemFromCart(int idUser, int idItem, int quantity) {
		shoppingCartEntryDAO.updateItemQuantity(idUser,idItem, quantity);
		
	}

	@Override
	public void clearCart(int idUser) {
		shoppingCartEntryDAO.clearCart(idUser);
		
	}

	@Override
	public void deleteFromCart(int idUser, int idItem) {
		shoppingCartEntryDAO.deleteItem(idUser, idItem);
		
	}
	
	//Transaction complexity avoided
	@Override
	public void checkOut(int idUser) {
		List<ShoppingCartEntry> items = shoppingCartEntryDAO.getShoppingCart(idUser);
		
		shoppingCartEntryDAO.clearCart(idUser);
		
		Order order = orderDAO.createOrder(idUser);
		
		for(ShoppingCartEntry entry: items){
			orderEntryDAO.addEntry(order.getId(), entry.getIdItem(), entry.getQuantity());
		}
	}

	@Override
	public List<Item> getProductsByCategory(String name) {
		return itemDAO.getItemsByCategory(name);
	}

	@Override
	public List<Item> getProductsByName(String name) {
		return itemDAO.getItemsByName(name);
	}

}
