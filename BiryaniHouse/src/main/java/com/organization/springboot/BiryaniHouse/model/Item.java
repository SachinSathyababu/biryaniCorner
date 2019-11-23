package com.organization.springboot.BiryaniHouse.model;

public class Item {
	
	private String name;
	private String description;
	private double cost;
	
	public Item() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
