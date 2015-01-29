package com.Ex2.api.tdd;

public class Item {

	private final String name;
	private final double price;
	
	public Item(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}
	
	public String getName(){
		return name;
	}
	public String toString(){
		return "Producto "+ this.getName();
	}
}
