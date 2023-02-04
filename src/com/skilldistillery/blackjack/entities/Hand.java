package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();

	public Hand() {

	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clear() {

	}

	public abstract int getHandValue();

}
