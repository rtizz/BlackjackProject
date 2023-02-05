package com.skilldistillery.blackjack.entities;

public enum Suit { //added unicode (suit) option to display the actual symbol.
	HEARTS("Hearts", '\u2665'),
	SPADES("Spades", '\u2660'),
	CLUBS("Clubs", '\u2663'),
	DIAMONDS("Diamonds", '\u2666' );
	
	final private String name;
	final private char suit;
	
	Suit(String s, char c) {
		this.name = s;
		this.suit = c;
	}
	
	@Override
	public String toString() {
		return "" + suit; //toString mirrors the above display choice
	}
}
