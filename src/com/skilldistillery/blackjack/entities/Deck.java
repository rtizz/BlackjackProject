package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> cards;
	private List<Card> discard;
	
	public Deck() {
	cards = makeDeck();
	}

	
	public List<Card> getCards() {
		return cards;
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
		discard = new ArrayList<>();
		Card latest = cards.get(0);
		discard.add(cards.remove(0));
		return latest;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	

	
}


