package com.organization.springboot.BiryaniHouse.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.organization.springboot.BiryaniHouse.model.Item;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;

public class BuyTwoGetOneDiscountTest {

private BuyTwoGetOneDiscount discount;
	
	@BeforeEach
	public void init() {
		discount= new BuyTwoGetOneDiscount();
	}
	
	@Test
	public void test_BuyTwoGetOneDiscount() {
		
		
		ItemRequest request = new ItemRequest();
		request.setCount(2);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		assertEquals(0, discount.discount(requests));
		
		for(ItemRequest request1: requests) {
			assertEquals(3, request1.getCount());
		}
		
	}
	
	@Test
	public void test_BuyTwoGetOneDiscount_NullRequest() {
		
		ItemRequest request = null;
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		assertEquals(0, discount.discount(requests));
		
	}
	
	@Test
	public void test_BuyTwoGetOne_LessThan2Items() {
		Item item= new Item();
		item.setCost(200);
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		assertEquals(0, discount.discount(requests));
	
		for(ItemRequest request1: requests) {
			assertEquals(1, request1.getCount());
		}
	}
}
