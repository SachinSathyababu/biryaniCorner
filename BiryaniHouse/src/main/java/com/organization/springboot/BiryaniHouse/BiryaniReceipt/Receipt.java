package com.organization.springboot.BiryaniHouse.BiryaniReceipt;

import java.util.List;

import com.organization.springboot.BiryaniHouse.model.ItemRequest;
import com.organization.springboot.BiryaniHouse.model.Order;

public interface Receipt {
	
	public Order getOrderDetails(List<ItemRequest> requests);

}
