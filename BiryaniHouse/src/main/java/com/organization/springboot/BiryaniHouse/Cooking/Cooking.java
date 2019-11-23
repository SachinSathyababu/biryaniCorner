package com.organization.springboot.BiryaniHouse.Cooking;

import java.util.List;

import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.Order;

public interface Cooking {
	
	public Order Cook(List<ItemRequest> requests);
}
