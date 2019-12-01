package com.organization.springboot.BiryaniHouse.Store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.organization.springboot.BiryaniHouse.model.Item;

public class StoreServiceTest{
	
	private StoreService store;
	
	@BeforeEach
	public void init() {
		store= new StoreService();
	}

	@Test
	public void test_addItem() {
		
		Item item= new Item();
		item.setName("Chicken Biryani");
		item.setDescription("Spicy Chicken Biryani");
		item.setCost(450);
		
		Item item1= null;
		
		Item item2= new Item();
		
		Item item3= new Item();
		item3.setName(null);
		item3.setDescription("Spicy Chicken Biryani");
		item3.setCost(450);
		
		Item item4= new Item();
		item4.setName("    ");
		item4.setDescription("Spicy Chicken Biryani");
		item4.setCost(450);
		
		Item item5= new Item();
		item5.setName("Chicken Biryani");
		item5.setDescription(null);
		item5.setCost(450);
		
		Item item6= new Item();
		item6.setName("Chicken Biryani");
		item6.setDescription("   ");
		item6.setCost(450);
		
		Item item7= new Item();
		item7.setName("Chicken Biryani");
		item7.setDescription("Spicy Chicken Biryani");
		item7.setCost(0);
		
		store.addItem(item);
		store.addItem(item1);
		store.addItem(item2);
		store.addItem(item3);
		store.addItem(item4);
		store.addItem(item5);
		store.addItem(item6);
		store.addItem(item7);
		
		store.deleteItem(item7);
		store.updateItem(item7);
		assertEquals(1, store.getAllItems().size());
	}

}
