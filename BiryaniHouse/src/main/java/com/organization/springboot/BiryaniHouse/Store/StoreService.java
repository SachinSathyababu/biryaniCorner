package com.organization.springboot.BiryaniHouse.Store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.organization.springboot.BiryaniHouse.model.Item;

@Component
public class StoreService implements Store{

	private List<Item> items= new ArrayList<Item>();
	
	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		items.add(item);
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return items;
	}

	@Override
	public void deleteItem(Item item) {
		// TODO Auto-generated method stub
		items.remove(item);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		
	}

}
