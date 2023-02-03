package com.skilldistillery.blackjack.testing;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Deck;

public class DealingCards {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		//deal five cards from the deck, displaying each of the dealt cards.
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println("How many cards would you like?");
		int cardCount = sc.nextInt();
		sc.nextLine();
		
		for (int c = 0; c < cardCount;c++) {
			System.out.println(deck.dealCard());
		}	

	}

}
