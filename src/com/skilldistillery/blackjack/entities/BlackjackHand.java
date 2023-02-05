package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {
	private boolean isTrue = true;

	public BlackjackHand() {
	
	}
//based on who calls (dealer or player) this method will spit out the respective hands value	
	public int getHandValue() {
		int sum = 0;
		for(Card card : hand) {
			sum += card.getRank().getValue();	
		}
		return sum;
	}
	
//boolean to assess if cards are blackjack(only on initial deal)	
	public boolean isBlackJack(int bj) {
		int win = bj;
		if (win == 21) {
			return isTrue;
		}
		return false;
	}
	
//boolean to assess if cards are 21(only after deal)	
	public boolean is21(int nextC) {
		boolean nextCard = nextC == 21;
		return nextCard;
	}
	
//boolean to assess if cards are over 21	
	public boolean isBust(int bust) {
		boolean buster = bust > 21;
		return buster;
	}
	
//NOT USED - STRETCH GOAL
	public boolean isHard() {//optional
		return true;
	}
	//NOT USED - STRETCH GOAL	
	public boolean isSoft() {//optional 
		return true;
	}
}
