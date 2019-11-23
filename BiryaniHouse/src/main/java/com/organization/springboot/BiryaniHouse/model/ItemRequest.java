package com.organization.springboot.BiryaniHouse.model;

public class ItemRequest {
	
	private Item item;
	public enum Size { HALF, FULL, FAMILYPACK};
	
	private Size size;
	private int count;
	
	public enum Stock { INSTOCK, OUTOFSTOCK }
	private Stock stock;
	
	public ItemRequest() {}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	

}
