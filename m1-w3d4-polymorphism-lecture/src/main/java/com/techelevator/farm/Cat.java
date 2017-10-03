package com.techelevator.farm;

public class Cat extends Animal {

	public Cat(String name, int price) {
		super(name, price);
	}

	@Override
	protected String makeSound() {
		return "meow!";
	}

}
