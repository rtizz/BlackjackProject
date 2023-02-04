package com.skilldistillery.blackjack.entities;

import java.util.List;

public abstract class Hand {
	
	private int cardValue;

	public Hand() {

		
	}
	
	
	public void addCard(Card card) {
		
	}
	
	public void clear() {
		
	}
	
	public abstract int getHandValue(List<Integer> c);
	
	
}
