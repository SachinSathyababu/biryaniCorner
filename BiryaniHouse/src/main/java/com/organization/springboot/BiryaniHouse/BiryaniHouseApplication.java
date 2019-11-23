package com.organization.springboot.BiryaniHouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.organization.springboot.BiryaniHouse.BiryaniReceipt.Receipt;
import com.organization.springboot.BiryaniHouse.BiryaniReceipt.ReceiptService;
import com.organization.springboot.BiryaniHouse.Store.Store;
import com.organization.springboot.BiryaniHouse.Store.StoreService;
import com.organization.springboot.BiryaniHouse.model.Item;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.ItemRequest.Size;
import com.organization.springboot.BiryaniHouse.model.Order;

@SpringBootApplication
public class BiryaniHouseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BiryaniHouseApplication.class, args);
		
		Receipt receipt= (Receipt) ctx.getBean(Receipt.class);
		Store store= (Store) ctx.getBean(Store.class);
		double BasePrice=0;
		
		Item item1= new Item();
		item1.setName("Chicken Biryani");
		item1.setCost(300);
		item1.setDescription("Spicy Biryani");
		
		Item item2= new Item();
		item2.setName("Paneer Biryani");
		item2.setCost(150);
		item2.setDescription("Spicy Veg Biryani");
		
		Item item3= new Item();
		item3.setName("Chicken Kebab");
		item3.setCost(300);
		item3.setDescription("Spicy Kebab");
		
		store.addItem(item1);
		store.addItem(item2);
		store.addItem(item3);
		
		ItemRequest requestPlaced=new ItemRequest();
		requestPlaced.setItem(item1);
		requestPlaced.setCount(7);
		requestPlaced.setSize(Size.FULL);
		
		ItemRequest requestPlaced2=new ItemRequest();
		requestPlaced2.setItem(item2);
		requestPlaced2.setCount(7);
		requestPlaced2.setSize(Size.HALF);
		
		ItemRequest requestPlaced3=new ItemRequest();
		requestPlaced3.setItem(item3);
		requestPlaced3.setCount(1);
		requestPlaced3.setSize(Size.HALF);
		
		
		List<ItemRequest> requestsPlaced= new ArrayList<ItemRequest>();
		requestsPlaced.add(requestPlaced);
		requestsPlaced.add(requestPlaced2);
		requestsPlaced.add(requestPlaced3);
		
		Order order= receipt.getOrderDetails(requestsPlaced);
		
		List<ItemRequest> requests= order.getRequests();
		
		if(requests!=null && requests.size()>0) {
		for(ItemRequest request: requests) {
			if(request.getItem()!=null && request.getItem().getName()!=null && !request.getItem().getName().trim().isEmpty())
			{//System.out.println("Biryani Name is "+request.getBiryani().getName());
			}else {
				System.out.println("Raised an order without selecting any Item, so Please add an Food Item!!!");
				//return;
			}
		}
		
		System.out.println(" ");
		System.out.println("ORDER DETAILS");
		System.out.println(" ");
		for(String message: order.getMessage()) {
			
			System.out.println(message);
			System.out.println(" ");
		}
		
		for(ItemRequest request: order.getRequests()) {
			
			System.out.println(request.getSize()+" - "+request.getItem().getName()+" - "
					+request.getCount());
			
		}
		
		if(order.getPrice().getCostPrice()>0) {
			BasePrice=order.getPrice().getCostPrice()+order.getPrice().getDiscount();
		System.out.println("Cost Price is "+BasePrice);
		System.out.println("Total Discount is "+order.getPrice().getDiscount());
		System.out.println("Cost Price with deducted discount is "+order.getPrice().getCostPrice());
		System.out.println("Tax is "+order.getPrice().getTax());
		System.out.println("Final Price with tax is "+order.getPrice().getFinalPrice());
		
		}
		
		System.out.println("Order status is "+order.getStatus());
		
		}
	else {System.out.println("Please order Food Item!!!");}
	}
}
