package com.organization.springboot.BiryaniHouse.Cooking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organization.springboot.BiryaniHouse.Store.Store;
import com.organization.springboot.BiryaniHouse.model.Item;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.ItemRequest.Stock;
import com.organization.springboot.BiryaniHouse.model.Order;
import com.organization.springboot.BiryaniHouse.model.Order.Status;

@Component
public class CookingService implements Cooking{
	
	@Autowired
	private Store store;

	@Override
	public Order Cook(List<ItemRequest> requests) {

		Order order= new Order();
		if(requests!=null && requests.size()>0) {
		for(ItemRequest request: requests) {
			
		if(request!=null) {	
			request.setStock(Stock.OUTOFSTOCK);
			
			for(Item item: store.getAllItems()) {
				
				if(request.getItem()!=null && 
					 request.getItem().getName()!=null &&
						!request.getItem().getName().trim().isEmpty() && 
						item!=null && item.getName()!=null && !item.getName().trim().isEmpty() &&
						request.getItem().getName().equalsIgnoreCase(item.getName())) {
					
					request.setStock(Stock.INSTOCK);
					request.setItem(item);
				}
				
			}
			
		}
			
		}
		}else {
			String message="Empty Requests are passed";
			List<String> messages= new ArrayList<String>();
			messages.add(message);
			order.setMessage(messages);
			order.setStatus(Status.CANCELLED);
			order.setRequests(requests);
			return order;
		}
		
		
		order.setRequests(requests);
		return order;
	}

}
