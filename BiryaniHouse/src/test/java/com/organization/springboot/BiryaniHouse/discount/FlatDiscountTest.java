package com.organization.springboot.BiryaniHouse.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.organization.springboot.BiryaniHouse.model.Item;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;

public class FlatDiscountTest {
	
	private FlatDiscount discount;
	
	@BeforeEach
	public void init() {
		discount= new FlatDiscount();
	}
	
	@Test
	public void test_FlatDiscount() {
		Item item= new Item();
		item.setCost(200);
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		assertEquals(40, discount.discount(requests));
		
	}
	
	@Test
	public void test_FlatDiscount_NullRequest() {
		
		ItemRequest request = null;
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		assertEquals(0, discount.discount(requests));
		
	}
	
	@Test
	public void test_FlatDiscount_NullItem() {
		Item item= null;
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		assertEquals(0, discount.discount(requests));
		
	}
	
	@Test
	public void test_FlatDiscount_EmptyItem() {
		Item item= new Item();;
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		assertEquals(0, discount.discount(requests));
		
	}
	
	@Test
	public void test_FlatDiscount_MoreTham2Items() {
		Item item= new Item();
		item.setCost(200);
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(3);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		assertEquals(0, discount.discount(requests));
		
	}
}
