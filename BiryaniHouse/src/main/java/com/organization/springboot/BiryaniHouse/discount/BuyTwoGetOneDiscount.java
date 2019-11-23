package com.organization.springboot.BiryaniHouse.discount;

import java.util.List;

import org.springframework.stereotype.Component;

import com.organization.springboot.BiryaniHouse.model.ItemRequest;

@Component
public class BuyTwoGetOneDiscount implements Discount{

	@Override
	public double discount(List<ItemRequest> requests) {
		// TODO Auto-generated method stub
		
		for(ItemRequest request: requests) {
			if(request.getCount()>=2) {
				int count= request.getCount();
				count=count+(count/2);
				request.setCount(count);
			}
		}
		return 0;
	}

}
