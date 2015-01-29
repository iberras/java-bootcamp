package com.Ex2.api.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Ex2.api.tdd.CashPayment;
import com.Ex2.api.tdd.Item;
import com.Ex2.api.tdd.Payment;
import com.Ex2.api.tdd.ShoppingCart;


public class ShoppingCartTest {

	@Test
	public void testInsert() {
		ShoppingCart cart = new ShoppingCart(); 
		Item item = new Item("Televisor", 1000);
		cart.addItem(item);
		assertEquals(cart.getItemAt(0), item);
	}
	
	@Test
	public void testDelete() {
		ShoppingCart cart = new ShoppingCart(); 
		Item item = new Item("Televisor", 1000);
		cart.addItem(item);
		cart.removeItem(0);
		assertEquals(cart.getItemAt(0), null);
	}
	
	@org.junit.Test
	public void testEmptyCart() {
		ShoppingCart cart = new ShoppingCart(); 
		Item item = new Item("Televisor", 1000);
		cart.addItem(item);
		cart.emptyCart();
		assertEquals(cart.getItemAt(0), null);
	}
	
	@org.junit.Test
	public void testPayment() {
		ShoppingCart cart = new ShoppingCart(); 
		Item item = new Item("Televisor", 1000);
		cart.addItem(item);
		Payment payment = new CashPayment();
		cart.setPayment(payment);
		assertEquals(cart.getPayment(), payment);
	}
	
	@org.junit.Test
	public void testCheckOut() {
		ShoppingCart cart = new ShoppingCart(); 
		Item item = new Item("Televisor", 1000);
		cart.addItem(item);
		cart.addItem(item);
		Payment payment = new CashPayment();
		cart.setPayment(payment);
		assertEquals(cart.checkOut(), true);
	}
	
	@org.junit.Test
	public void testCheckOutWithNoPayment() {
		ShoppingCart cart = new ShoppingCart(); 
		Item item = new Item("Televisor", 1000);
		cart.addItem(item);
		cart.addItem(item);
		assertEquals(cart.checkOut(), false);
	}

}
