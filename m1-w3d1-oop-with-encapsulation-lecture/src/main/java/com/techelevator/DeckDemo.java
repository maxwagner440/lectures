package com.techelevator;

import com.techelevator.cardgame.Card;
import com.techelevator.cardgame.Deck;

public class DeckDemo {
	public static void main(String[] args){
	
		//this "flips" the card.
		
		
		Deck myPlayingDeck = new Deck();
		//shuffling deck
		myPlayingDeck.shuffle();
		//flipping all cards
		myPlayingDeck.flip();
		
		System.out.println(myPlayingDeck);
		//this creates a new "card that is drawn from deck"
		Card drawnCard = myPlayingDeck.draw();
		//print out new card and deck WITHOUT the first card.
		System.out.println(drawnCard);
		System.out.println(myPlayingDeck);
		
		
	}
}
