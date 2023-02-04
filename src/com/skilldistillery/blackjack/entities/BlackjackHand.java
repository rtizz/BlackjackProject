package com.skilldistillery.blackjack.entities;

import java.util.List;

public class BlackjackHand extends Hand {

	
	public BlackjackHand() {
	
	}
	
	public int getHandValue(List<Integer> c) {
		int hand = 0;
		for(int val = 0; val < c.size(); val++) {
			hand += c.get(val);		
		}
		return hand;
	}
	
	public boolean isBlackJack(int bj) {
		boolean wwcd = bj > 21;	
		return wwcd;
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
