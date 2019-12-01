package com.organization.springboot.BiryaniHouse.Cooking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.organization.springboot.BiryaniHouse.Store.Store;
import com.organization.springboot.BiryaniHouse.model.Item;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.ItemRequest.Stock;
import com.organization.springboot.BiryaniHouse.model.Order;

@ExtendWith(MockitoExtension.class)
public class CookingServiceTest {
	
	@Mock
	private Store store;
	
	@InjectMocks
	CookingService cook;
	
	@Test
	public void test_Cooking() {
		
		Item item= new Item();
		item.setName("Chicken Biryani");
		item.setDescription("Spicy Chicken Biryani");
		item.setCost(450);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(store.getAllItems()).thenReturn(items);
		
		Item item1= new Item();
		item1.setName("Chicken Biryani");
		
		ItemRequest request = new ItemRequest();
		request.setItem(item1);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		cook.Cook(requests);
		
		for(ItemRequest request1: requests) {
			assertEquals(Stock.INSTOCK, request1.getStock());
		}
	}
	
	@Test
	public void test_Cooking_NullRequests() {
		
		List<ItemRequest> requests= null;
		
		Order order=cook.Cook(requests);
				
		assertEquals(null, order.getRequests());
		
	}
	
	@Test
	public void test_Cooking_EmptyRequests() {
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();;
		
		Order order=cook.Cook(requests);
				
		assertEquals(0, order.getRequests().size());
		
	}
	
	@Test
	public void test_CookingNullRequest() {
		
		ItemRequest request = null;
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Order order=cook.Cook(requests);
		
		assertEquals(1, order.getRequests().size());
	}
	
	@Test
	public void test_CookingEmptyRequest() {
		
		ItemRequest request = new ItemRequest();;
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Order order=cook.Cook(requests);
		
		assertEquals(1, order.getRequests().size());
	}
	
	@Test
	public void test_Cooking_NullItem() {
		
		Item item= new Item();
		item.setName("Chicken Biryani");
		item.setDescription("Spicy Chicken Biryani");
		item.setCost(450);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(store.getAllItems()).thenReturn(items);
		
		Item item1= null;
		
		ItemRequest request = new ItemRequest();
		request.setItem(item1);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		cook.Cook(requests);
		
		for(ItemRequest request1: requests) {
			assertEquals(Stock.OUTOFSTOCK, request1.getStock());
		}
	}
	
	@Test
	public void test_Cooking_NullItemName() {
		
		Item item= new Item();
		item.setName("Chicken Biryani");
		item.setDescription("Spicy Chicken Biryani");
		item.setCost(450);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(store.getAllItems()).thenReturn(items);
		
		Item item1= new Item();
		item1.setName(null);
		
		ItemRequest request = new ItemRequest();
		request.setItem(item1);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		cook.Cook(requests);
		
		for(ItemRequest request1: requests) {
			assertEquals(Stock.OUTOFSTOCK, request1.getStock());
		}
	}
	
	@Test
	public void test_Cooking_EmptyItemName() {
		
		Item item= new Item();
		item.setName("Chicken Biryani");
		item.setDescription("Spicy Chicken Biryani");
		item.setCost(450);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(store.getAllItems()).thenReturn(items);
		
		Item item1= new Item();
		item1.setName("");
		
		ItemRequest request = new ItemRequest();
		request.setItem(item1);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		cook.Cook(requests);
		
		for(ItemRequest request1: requests) {
			assertEquals(Stock.OUTOFSTOCK, request1.getStock());
		}
	}
	
	@Test
	public void test_Cooking_NullItemMock() {
		
		Item item= null;
		
		List<Item> items= new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(store.getAllItems()).thenReturn(items);
		
		Item item1= new Item();
		item1.setName("Chicken Biryani");
		
		ItemRequest request = new ItemRequest();
		request.setItem(item1);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		cook.Cook(requests);
		
		for(ItemRequest request1: requests) {
			assertEquals(Stock.OUTOFSTOCK, request1.getStock());
		}
	}
	
	@Test
	public void test_Cooking_NullItemNameMock() {
		
		Item item= new Item();
		item.setName(null);
		item.setDescription("Spicy Chicken Biryani");
		item.setCost(450);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(store.getAllItems()).thenReturn(items);
		
		Item item1= new Item();
		item1.setName("Chicken Biryani");
		
		ItemRequest request = new ItemRequest();
		request.setItem(item1);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		cook.Cook(requests);
		
		for(ItemRequest request1: requests) {
			assertEquals(Stock.OUTOFSTOCK, request1.getStock());
		}
	}
	
	@Test
	public void test_Cooking_EmptyItemNameMock() {
		
		Item item= new Item();
		item.setName("  ");
		item.setDescription("Spicy Chicken Biryani");
		item.setCost(450);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(store.getAllItems()).thenReturn(items);
		
		Item item1= new Item();
		item1.setName("Chicken Biryani");
		
		ItemRequest request = new ItemRequest();
		request.setItem(item1);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		cook.Cook(requests);
		
		for(ItemRequest request1: requests) {
			assertEquals(Stock.OUTOFSTOCK, request1.getStock());
		}
	}
	
	@Test
	public void test_Cooking_NotinStore() {
		
		Item item= new Item();
		item.setName("Biryani");
		item.setDescription("Spicy Chicken Biryani");
		item.setCost(450);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item);
		
		Mockito.when(store.getAllItems()).thenReturn(items);
		
		Item item1= new Item();
		item1.setName("Chicken Biryani");
		
		ItemRequest request = new ItemRequest();
		request.setItem(item1);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		cook.Cook(requests);
		
		for(ItemRequest request1: requests) {
			assertEquals(Stock.OUTOFSTOCK, request1.getStock());
		}
	}

}
