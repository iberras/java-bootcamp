package com.entities.impl;

import java.util.List;

import com.entities.Item;

public interface ItemDAO {

	public List<Item> getItemsByCategory(String name);

	public List<Item> getItemsByName(String name);
}
