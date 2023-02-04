package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Dealer extends Person {

	private Deck deck = new Deck();
	private BlackjackHand bjHand;
	private Card card;
	
	public Dealer(String name) {
		super(name);

	}

	public Card deal() {
		return deck.dealCard();
	}
	
	public void discardCards() {
		
	}
	
	public void assessCards(int pVal) {
		System.out.println("You're currently sitting at " + pVal);
		
		if (pVal < 10) {
			System.out.println("You might want to hit");
		} else if (pVal > 12 && pVal < 18) {
			System.out.println("Hmmm...Go with your heart");
		} else if (pVal > 18 && pVal < 21) {
			System.out.println("Might want to stay...just my professional opinion");
		} else if (bjHand.isBlackJack(pVal)) {
			System.out.println("BLACKJACK!!! Winner Winner Chicken Dinner");
		} else {
			System.out.println("Tough call");
		}
	}
	
	public void opinion() {
		
	}
	
	public void showCards() {
		
	}

	public void hitTillQuit() {

	}

	public void shuffleDeck() {
		deck.shuffle();
	}


	public void resetDeck() {
		deck.getCards();
	}

}
