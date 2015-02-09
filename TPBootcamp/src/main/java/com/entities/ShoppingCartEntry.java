package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class ShoppingCartEntry implements Serializable{

	private int idUser;
	private int idItem;
	private int quantity;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
