package com.techelevator.farm;

public class Apple implements Sellable {

	private String name = "Mr. Fuji";
	private int price = 1;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
