package com.techelevator.farm;

public class Chicken extends Animal {
	
	public Chicken() {
		setName("Chicken");
		setSound("cluck!");

	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}