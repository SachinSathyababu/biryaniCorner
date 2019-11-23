package com.organization.springboot.BiryaniHouse.Store;

import java.util.List;

import com.organization.springboot.BiryaniHouse.model.Item;

public interface Store {

	public void addItem(Item item);
	
	public List<Item> getAllItems();
	
	public void deleteItem(Item item);
	
	public void updateItem(Item item);
}
