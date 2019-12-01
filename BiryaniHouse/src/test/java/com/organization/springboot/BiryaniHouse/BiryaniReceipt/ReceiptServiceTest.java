package com.organization.springboot.BiryaniHouse.BiryaniReceipt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.organization.springboot.BiryaniHouse.Billing.Billing;
import com.organization.springboot.BiryaniHouse.Cooking.Cooking;
import com.organization.springboot.BiryaniHouse.model.Item;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.ItemRequest.Size;
import com.organization.springboot.BiryaniHouse.model.ItemRequest.Stock;
import com.organization.springboot.BiryaniHouse.model.Order;
import com.organization.springboot.BiryaniHouse.model.Order.Status;
import com.organization.springboot.BiryaniHouse.model.Price;

@ExtendWith(MockitoExtension.class)
public class ReceiptServiceTest {
	
	@Mock
	private Cooking cook;
	
	@Mock
	private Billing bill;
	
	@InjectMocks
	private ReceiptService receipt;
	
	@Test
	public void test_ReceiptService() {
		
		ItemRequest request = new ItemRequest();
		request.setCount(1);
		request.setStock(Stock.INSTOCK);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Order order= new Order();
		order.setRequests(requests);
		
		Mockito.when(cook.Cook(requests)).thenReturn(order);
		
		Price price= new Price();
		price.setCostPrice(100);
		price.setDiscount(20);
		price.setTax(16);
		price.setFinalPrice(96);
		
		Mockito.when(bill.Bill(requests)).thenReturn(price);
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(100, finalOrder.getPrice().getCostPrice());
		assertEquals(Status.PROCESSING, finalOrder.getStatus());
		assertEquals(1, finalOrder.getMessage().size());
	}
	
	@Test
	public void test_ReceiptService_NullRequests() {
		
		
		List<ItemRequest> requests= null;
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
	@Test
	public void test_ReceiptService_EmptyRequests() {
		
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
	@Test
	public void test_ReceiptService_MockNullRequests() {
		
		ItemRequest request = new ItemRequest();
		request.setCount(1);
		request.setStock(Stock.INSTOCK);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		List<ItemRequest> requests1= null;
		
		Order order= new Order();
		order.setRequests(requests1);
		
		Mockito.lenient().when(cook.Cook(requests)).thenReturn(order);
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
	@Test
	public void test_ReceiptService_MockEmptyRequests() {
		
		ItemRequest request = new ItemRequest();
		request.setCount(1);
		request.setStock(Stock.INSTOCK);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		List<ItemRequest> requests1= new ArrayList<ItemRequest>();
		
		Order order= new Order();
		order.setRequests(requests1);
		
		Mockito.lenient().when(cook.Cook(requests)).thenReturn(order);
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
	@Test
	public void test_ReceiptService_OutOfStock() {
		
		Item item= new Item();
		item.setCost(200);
		item.setName("Chicken Biryani");
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		request.setStock(Stock.OUTOFSTOCK);
		request.setSize(Size.FULL);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Order order= new Order();
		order.setRequests(requests);
		
		Mockito.lenient().when(cook.Cook(requests)).thenReturn(order);
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
	@Test
	public void test_ReceiptService_NullRequest() {
		
		
		ItemRequest request = null;
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
	@Test
	public void test_ReceiptService_OutOfStock_ItemNull() {
		
		Item item= null;
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		request.setStock(Stock.OUTOFSTOCK);
		request.setSize(Size.FULL);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Order order= new Order();
		order.setRequests(requests);
		
		Mockito.lenient().when(cook.Cook(requests)).thenReturn(order);
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
	@Test
	public void test_ReceiptService_OutOfStock_ItemNameNull() {
		
		Item item= new Item();
		item.setCost(200);
		item.setName(null);
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		request.setStock(Stock.OUTOFSTOCK);
		request.setSize(Size.FULL);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Order order= new Order();
		order.setRequests(requests);
		
		Mockito.lenient().when(cook.Cook(requests)).thenReturn(order);
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
	@Test
	public void test_ReceiptService_OutOfStock_ItemNameEmpty() {
		
		Item item= new Item();
		item.setCost(200);
		item.setName("  ");
		
		ItemRequest request = new ItemRequest();
		request.setItem(item);
		request.setCount(1);
		request.setStock(Stock.OUTOFSTOCK);
		request.setSize(Size.FULL);
		
		List<ItemRequest> requests= new ArrayList<ItemRequest>();
		requests.add(request);
		
		Order order= new Order();
		order.setRequests(requests);
		
		Mockito.lenient().when(cook.Cook(requests)).thenReturn(order);
		
		Order finalOrder= receipt.getOrderDetails(requests);
		
		assertEquals(null, finalOrder.getPrice());
	}
	
}
