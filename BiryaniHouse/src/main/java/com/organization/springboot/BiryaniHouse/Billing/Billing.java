package com.organization.springboot.BiryaniHouse.Billing;

import java.util.List;

import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.Price;

public interface Billing {
	
	public Price Bill(List<ItemRequest> requests);

}
