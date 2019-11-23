package com.organization.springboot.BiryaniHouse.model;

import java.util.List;

public class Order {
	
	private List<ItemRequest> requests;
	private Price price;
	private List<String> message;
	public enum Status { PROCESSING, CANCELLED, DELIVERED }
	
	private Status status;
	
	public Order(){}

	public List<ItemRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<ItemRequest> requests) {
		this.requests = requests;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}
