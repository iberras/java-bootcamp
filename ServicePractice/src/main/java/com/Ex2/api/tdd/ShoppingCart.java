package com.Ex2.api.tdd;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Item> items;
	private Payment payment;
	
	public ShoppingCart(){
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public Item getItemAt(int index){
		try{
			return items.get(index);
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
		
	}

	public void removeItem(int index) {
		try{
			items.remove(index);
        }
        catch(IndexOutOfBoundsException e){
            return;
        }
	}
	
	public void emptyCart() {
		items.clear();
	}

	public void setPayment(Payment p) {
		payment = p;
	}

	public Payment getPayment(){
		return payment;
	}

	public synchronized boolean checkOut(){
		double amount = sumAllItems();
		if(payment != null){
			payment.pay(amount);
			emptyCart();
			return true;
		}
		return false;
	}

	private double sumAllItems() {
		double amount = 0;
		for(Item i:items){
			amount += i.getPrice();
		}
		return amount;
	}

	
}
