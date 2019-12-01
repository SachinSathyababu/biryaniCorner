package com.organization.springboot.BiryaniHouse.Billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.organization.springboot.BiryaniHouse.discount.Discount;
import com.organization.springboot.BiryaniHouse.model.Item;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.Price;

@ExtendWith(MockitoExtension.class)
public class BillingServiceTest {

	@Mock
	private Discount dis;
	
	@Spy
	private List<Discount> discs= new ArrayList<Discount>();

	@InjectMocks
	private BillingService billing;
	
	@BeforeEach
	public void init() {
		
		discs.add(dis);
	}
	
	@Test
	public void test_billing() {
		Item item= new Item();
		item.setCost(200);
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Mockito.when(dis.discount(requests)).thenReturn(40.0);
		
		Price price=billing.Bill(requests);
		
		assertEquals(192.0, price.getFinalPrice());
		assertEquals(32.0, price.getTax());
		assertEquals(200.0, price.getCostPrice());
		assertEquals(40.0, price.getDiscount());
	}
	
	@Test
	public void test_billing_NullRequests() {
		
		
		List<ItemRequest> requests= null;
		
		Price price=billing.Bill(requests);
		
		assertEquals(0.0, price.getFinalPrice());
		assertEquals(0.0, price.getTax());
		assertEquals(0, price.getCostPrice());
		assertEquals(0, price.getDiscount());
	}
	
	@Test
	public void test_billing_EmptyRequests() {
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		
		
		Price price=billing.Bill(requests);
		
		assertEquals(0, price.getFinalPrice());
		assertEquals(0, price.getTax());
		assertEquals(0, price.getCostPrice());
		assertEquals(0, price.getDiscount());
	}
	
	@Test
	public void test_billing_NullItem() {
		Item item= null;
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);

		
		Price price=billing.Bill(requests);
		
		assertEquals(0, price.getFinalPrice());
		assertEquals(0, price.getTax());
		assertEquals(0, price.getCostPrice());
		assertEquals(0, price.getDiscount());
	}
	
	@Test
	public void test_billing_ZeroCostItem() {
		Item item= new Item();
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Price price=billing.Bill(requests);
		
		assertEquals(0.0, price.getFinalPrice());
		assertEquals(0, price.getTax());
		assertEquals(0, price.getCostPrice());
		assertEquals(0, price.getDiscount());
	}
	
	@Test
	public void test_billing_NullRequest() {
		
		ItemRequest request = null;
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Price price=billing.Bill(requests);
		
		assertEquals(0, price.getFinalPrice());
		assertEquals(0, price.getTax());
		assertEquals(0, price.getCostPrice());
		assertEquals(0, price.getDiscount());
	}
	
	@Test
	public void test_billing_EmptyRequest() {
		
		ItemRequest request = new ItemRequest();
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Price price=billing.Bill(requests);
		
		assertEquals(0, price.getFinalPrice());
		assertEquals(0, price.getTax());
		assertEquals(0, price.getCostPrice());
		assertEquals(0, price.getDiscount());
	}
}
