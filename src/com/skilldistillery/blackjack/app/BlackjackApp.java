package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp { // game Logic
	private Player player;
	private Scanner sc = new Scanner(System.in);
	private Dealer dealer = new Dealer("Dealer");
	private boolean isTrue = true;
	
	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();
		bj.run();
	}

	public void run() {
		welcome();
		dealer.shuffleDeck();
		gameOn();

	}

	public void welcome() {
		System.out.println("Welcome to the table! Whats your name?");
		String name = sc.next();
		player = new Player(name);
		System.out.println("Nice to meet you " + player.getName() + "!! Are you ready to play.....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("BlackJack!!!");
		sc.nextLine();

	}

	public void gameOn() {

		Card play1 = dealer.deal();
		System.out.println(player.getName() + "'s 1st Card: " + play1);
		player.getBjHand().addCard(play1);
		Card deal1 = dealer.deal();
		System.out.println("Dealer's first card face down");
		dealer.getBjHand().addCard(deal1);
		Card play2 = dealer.deal();
		System.out.println(player.getName() + "'s 2nd Card: " + play2);
		player.getBjHand().addCard(play2);
		Card deal2 = dealer.deal();
		System.out.println("Dealer's top card: " + deal2);
		dealer.getBjHand().addCard(deal2);
		
		int playerVal = player.getBjHand().getHandValue();
		isTrue = player.assessDealtCards(playerVal);
			while(isTrue) {
				hitOrStay();
			}
	}

	public boolean hitOrStay() {
			System.out.println("Select an option:\n1.Hit\n2.Stay");
			int selection = sc.nextInt();
			sc.nextLine();

			switch (selection) {

			case 1:
				player.hit();
				Card newCard = dealer.deal();
				System.out.println(newCard);
				player.getBjHand().addCard(newCard);
				isTrue = player.assessPostHit(player.getBjHand().getHandValue());
				break;
			case 2:
				player.stay();
				dealer.evaluateWinner(player);
				dealer.showCards();
				isTrue = false;
				break;
			default:
				System.out.println("Not an option. Try again");
				break;
			}
			
			return isTrue;
	}
//	public void determineWinner() {
//	int playerHand = player.getBjHand().getHandValue();
//	int houseHand = dealer.getBjHand().getHandValue();
//	dealer.getPlayerHand(player);
//	System.out.println("Dealer: " + houseHand + "|" + player.getName() + playerHand);
//	if (playerHand > houseHand) {
//		dealer.getWinningHand(player.getName() + " wins!");
//	} else if (houseHand > playerHand) {
//		dealer.getWinningHand("Dealer wins!");
//	} else {
//		dealer.getWinningHand("Push!...Live to fight another day");
//	}
//}

	public Player getPlayer() {
		return player;
	}

	
}
