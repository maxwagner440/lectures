package com.techelevator.cardgame;

import java.util.Arrays;

public class ScoreCard {
	
	final static public int[] HOLES = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	private String name;
	private int scoreOnCurrentHole = 0;
	private int holeImOn;
	private int totalScoreF9 = 0;
	
	public ScoreCard(int currentHole, int scoreOnThisHole){
		if(Arrays.asList(HOLES).contains(currentHole)){
			this.scoreOnCurrentHole = scoreOnCurrentHole;
			this.holeImOn = currentHole;
		}
		
	}
	
	public String currentScore(){
		totalScoreF9 += scoreOnCurrentHole;
		return "Total score is: " + totalScoreF9;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScoreOnCurrentHole() {
		return scoreOnCurrentHole;
	}
	public void setScoreOnCurrentHole(int scoreOnCurrentHole) {
		this.scoreOnCurrentHole = scoreOnCurrentHole;
	}
	public int getTotalScoreF9() {
		return totalScoreF9;
	}
	
}
