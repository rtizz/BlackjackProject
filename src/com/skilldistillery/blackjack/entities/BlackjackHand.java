package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {
	private boolean isTrue = true;

	public BlackjackHand() {
	
	}
	
	public int getHandValue() {
		int sum = 0;
		for(Card card : hand) {
			sum += card.getRank().getValue();	
		}
		return sum;
	}
	
	
	public boolean isBlackJack(int bj) {
		int win = bj;
		if (win == 21) {
			return isTrue;
		}
		return false;
	}
	
	public boolean is21(int nextC) {
		boolean nextCard = nextC == 21;
		return nextCard;
	}
	
	public boolean isBust(int bust) {
		boolean buster = bust > 21;
		return buster;
	}
	
	public boolean isHard() {//optional- stretch
		return true;
	}
	
	public boolean isSoft() {//optional - stretch
		return true;
	}
}
