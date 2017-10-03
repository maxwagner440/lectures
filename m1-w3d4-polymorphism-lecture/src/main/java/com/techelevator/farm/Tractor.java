package com.techelevator.farm;

public class Tractor implements Singable {
	private String name;
	private String sound;
	
	public Tractor(){
		setName("Mr. Biggles");
		setSound("Vroom!");
	}

	
	
	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
