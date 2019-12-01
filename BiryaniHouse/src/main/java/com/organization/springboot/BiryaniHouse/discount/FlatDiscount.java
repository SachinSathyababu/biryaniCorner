package com.organization.springboot.BiryaniHouse.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.organization.springboot.BiryaniHouse.model.ItemRequest;

@Component
public class FlatDiscount implements Discount{
	
	@Value("${item.Flat}")
	private double flatDiscountPercentage=20;

	@Override
	public double discount(List<ItemRequest> requests) {
		// TODO Auto-generated method stub
		double finalDiscount=0;
		
		for(ItemRequest request: requests) {
			if(request!=null && request.getItem()!=null &&
					request.getCount()<2) {
				finalDiscount=finalDiscount+((request.getItem().getCost() * flatDiscountPercentage
						* request.getCount())/100);
			}
		}
		
		return finalDiscount;
	}

}
