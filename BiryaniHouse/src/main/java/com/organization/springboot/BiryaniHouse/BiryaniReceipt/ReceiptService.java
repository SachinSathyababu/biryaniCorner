package com.organization.springboot.BiryaniHouse.BiryaniReceipt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organization.springboot.BiryaniHouse.Billing.Billing;
import com.organization.springboot.BiryaniHouse.Cooking.Cooking;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.ItemRequest.Stock;
import com.organization.springboot.BiryaniHouse.model.Order;
import com.organization.springboot.BiryaniHouse.model.Order.Status;
import com.organization.springboot.BiryaniHouse.model.Price;

@Component
public class ReceiptService implements Receipt{
	
	@Autowired
	private Cooking cooking;
	
	@Autowired
	private Billing billing;

	@Override
	public Order getOrderDetails(List<ItemRequest> requests) {
		// TODO Auto-generated method stub
		
		Order order= new Order();
		Price price= new Price();
		order.setStatus(Status.CANCELLED);
		List<ItemRequest> actualRequests= new ArrayList<ItemRequest>();
		List<String> messages= new ArrayList<String>();
		
		order= cooking.Cook(requests);
		
		requests= order.getRequests();
		
		
		if(requests!=null && requests.size()>0) {
		for(ItemRequest request: requests) {
			
			if(request.getStock().equals(Stock.INSTOCK)) {
				
				actualRequests.add(request);
				//messages.add(request.getSize()+"-"+request.getItem().getName()+"-"+request.getCount()+" Plate");
				order.setStatus(Status.PROCESSING);
				
			}else
			{
				if(request.getItem()!=null && request.getItem().getName()!=null && !request.getItem().getName().trim().isEmpty())
				messages.add(request.getItem().getName()+"-"+request.getSize()+" is not available");
				order.setStatus(Status.CANCELLED);
			}
			
		}
		}
		
		
		price= billing.Bill(actualRequests);
		 order.setPrice(price);
		 order.setRequests(requests);
		 order.setMessage(messages);
		 
		 
		return order;
	}

	
	
}
