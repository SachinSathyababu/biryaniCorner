package com.organization.springboot.BiryaniHouse.Billing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.organization.springboot.BiryaniHouse.discount.Discount;
import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.Price;

@Component
public class BillingService implements Billing{

	@Value("${item.Tax}")
	private double tax;
	
	@Autowired
	private List<Discount> discounts;
	
	@Override
	public Price Bill(List<ItemRequest> requests) {
		
		Price price= new Price();
		double finalCost, finalDiscount=0;
		double totalCost=0;
		
		if(requests!= null && requests.size()>0)
		{
		for(ItemRequest request: requests) {
			
			totalCost=totalCost+(request.getItem().getCost() * request.getCount());
		}
		
		for(Discount discount : discounts) {
		finalDiscount= finalDiscount+discount.discount(requests);
		}
		totalCost=totalCost-finalDiscount;
		tax=(tax * totalCost)/100;
		finalCost= totalCost+tax;
		
		price.setCostPrice(totalCost);
		price.setTax(tax);
		price.setDiscount(finalDiscount);
		price.setFinalPrice(finalCost);
		}
		else {
			price.setCostPrice(0);
			price.setTax(0);
			price.setDiscount(0);
			price.setFinalPrice(0);
		}
		return price;
	}

}
