package com.organization.springboot.BiryaniHouse.discount;

import java.util.List;

import com.organization.springboot.BiryaniHouse.model.ItemRequest;

public interface Discount {

	public double discount(List<ItemRequest> requests);
}
