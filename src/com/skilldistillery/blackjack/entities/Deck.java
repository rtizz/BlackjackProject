package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> cards;
	
	public Deck() {
	cards = makeDeck();
	}

	
	public List<Card> makeDeck() {
	List<Card> cardDeck = new ArrayList<>(52);
	for (Suit s : Suit.values()) {
		for (Rank r : Rank.values()) {
			cardDeck.add(new Card(s,r));
		}
	}
	return cardDeck;
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	public Card dealCard() {
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}


