package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CleBay {

	public static void main(String[] args) {
		//creating an auction
		Auction bowlingBallAuction = new Auction ("Bowling Ball");
		
		BuyoutAuction indiansTickets = new BuyoutAuction("Indians Tickets", 1000);
		
		ReserveAuction superCars = new ReserveAuction("Super Cars", 750);
		
		List<Auction> allAuctions = new ArrayList<>();
		
		allAuctions.add(bowlingBallAuction);
		//upcasting.
		allAuctions.add(indiansTickets); //treating indiansTickets like an Auction not BuyoutAuction, is UpCasting
		allAuctions.add(superCars);
		
		for(Auction a : allAuctions){
			a.placeBid(new Bid("Joe", 500));
		}
		
		for(Auction a : allAuctions){
			System.out.println(a);
		}
		//this is upcasting! Do not need to explicitly say that your upcasting.
		Auction tickets = indiansTickets;
		//this is DOWNCASTING! NEED TO SAY you are Downcasting (with parenthesis).
		BuyoutAuction newVariable = (BuyoutAuction) tickets;
	}

}
