package com.techelevator.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	//my deck of cards. Cards is type because we created a card class already. It has suit and rank
	private List<Card> cards= new ArrayList<>();
	
	public Deck() {
		for(String suit : Card.POSSIBLE_SUITS){
			for(String rank : Card.POSSIBLE_RANKS){
				cards.add(new Card(suit, rank));
			}
		}
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	//dealing a card. Need to remover the card from the List
	public Card draw(){
		return cards.remove(0);
	}
	//flipping whole deck. calls flip method from card class.
	public void flip(){
		for(Card playingCard : cards){
			playingCard.flip();
		}
	}
	//size of card list. Delegating method. calling size of List.
	public int size(){
		return cards.size();
	}
	
	public String toString(){
		String result = "";
		for(Card playingCard : cards){
			result += playingCard + " ";
		} return result;
	}	


}
