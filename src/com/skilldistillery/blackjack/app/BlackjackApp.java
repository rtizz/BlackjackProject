package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp { //game Logic
	private Player hustler;
	private Scanner sc = new Scanner(System.in);
	private Dealer dealer = new Dealer("Dealer");
	private BlackjackHand bjHand = new BlackjackHand();
	private Deck deck = new Deck();
	private List<Integer> player = new ArrayList<>();
	private List<Integer> theHouse = new ArrayList<>();

	public static void main(String[] args) {
	      	BlackjackApp bj = new BlackjackApp();
	      	bj.run();
	}   

	public void run() {
		welcome();
		dealer.shuffleDeck();
		initialDeal();
		hitOrStay();
	}
	
	public void welcome()  {
		System.out.println("Welcome to the table! Whats your name?");
		String name = sc.next();
		hustler = new Player(name);
		System.out.println("Nice to meet you " + hustler.getName() + "!! Are you ready to play.....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("BlackJack!!!");
		sc.nextLine();

	}
	
	public void initialDeal() {
		
		// individually dealing one at a time and sending them to respective array for each
		Card play1 = dealer.deal();
		int pCard1Value = play1.getRank().getValue();
		System.out.println(hustler.getName() + "'s Card 1: " + play1);
		player.add(pCard1Value);
		Card deal1 = dealer.deal();
		int dCard1Value = deal1.getRank().getValue();
		System.out.println("Dealer's first hand face down");
		theHouse.add(dCard1Value);
		Card play2 = dealer.deal();
		int pCard2Value = play2.getRank().getValue();
		System.out.println(hustler.getName() + "'s Card 2: " + play2);
		player.add(pCard2Value);
		Card deal2 = dealer.deal();
		int dCard2Value = deal2.getRank().getValue();
		System.out.println("Dealer's top card: " + deal2);
		theHouse.add(dCard2Value);	
		
	
	}
	
	public void hitOrStay() {
		int playerVal = bjHand.getHandValue(player);
		dealer.assessCards(playerVal);
		
		System.out.println("Select an option:\n1.Hit\n2.Stay");
		int selection = sc.nextInt();
		sc.nextLine();
		
		switch (selection) {
			
		case 1 :
			//code/method
			break;
		case 2 :
			//code/method
			break;
		default:
			System.out.println("Not an option. Try again");
			break;
		}
	}
	

}
