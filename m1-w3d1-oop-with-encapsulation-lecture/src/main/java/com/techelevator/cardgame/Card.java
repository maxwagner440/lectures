package com.techelevator.cardgame;

import java.util.Arrays;

public class Card {
	//a constant variable. static means its going to be on the suit class. public cuz its a constand
	final static public String[] POSSIBLE_SUITS = { "♠", "♣", "♡", "♢" };
	final static public String[] POSSIBLE_RANKS = { "A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
	
	//INSTANCE VARIABLES
	//final means once you set it, its locked and CANNOT change it.
	final private String suit;
	final private String rank;
	
	private boolean showing = false;
	
	//method of Card?
	public Card(String suit, String rank){
		if(Arrays.asList(POSSIBLE_SUITS).contains(suit) && Arrays.asList(POSSIBLE_RANKS).contains(rank)){
			this.suit = suit;
			this.rank = rank;
		}else{
			throw new IllegalArgumentException();
		}  //IllegalArgumentExcetion() = Class created by Java. Throw means "Throwing an exception".
		
	}	
	
	public String toString(){
		if(showing){
		return rank + suit;
		}else{
			return "##";
		}
	}
	//method for flipping. THis says if showing is false, return true. also vice versa.
	public boolean flip(){
		showing = ! showing;
		return showing;
	}
	
	public String getSuit() {
		return suit;
	}
	//no setter because you don't want anyone changing the card type
	public String getRank() {
		return rank;
	}

	public boolean isShowing() {
		return showing;
	}

	public void setShowing(boolean showing) {
		this.showing = showing;
	}
	
}
