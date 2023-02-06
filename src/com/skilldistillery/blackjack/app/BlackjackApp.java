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

//runs following methods
	public void run() {
		welcome();
		sleep(2000);
		System.out.println("Dealing!");
		initialDeal();
		sc.close();
	}
//Welcome display and adds name to player
	public void welcome() {
		System.out.println("Welcome to the table! Whats your name?");
		String name = sc.next();
		sc.nextLine();
		player = new Player(name);//add name to player
		System.out.println("Nice to meet you " + player.getName() + "!!");
		verifyDeck();
		System.out.println("_______________________________________________________");  
		sleep(1500);
		System.out.println("Alright are you ready to play....");
		sleep(1500);
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("***  BLACKJACK!!! ***");
		System.out.println("*********************");
		System.out.println("*********************");
		

	}

//allows user to see the deck or continue on to the game
	public void verifyDeck() {
		System.out.println("Would you like to verify the deck is shuffled? Y/N");
		String answer = sc.next();
		sc.nextLine();
		//either way the deck is shuffled, the player can just choose not to see it
		if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
		System.out.println("Always trust but verify!");
		dealer.shuffleDeck();
		dealer.displayDeck();
		} else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
			System.out.println("No worries! You can trust me");
			dealer.shuffleDeck();
		}
	}

//Displays each players card on first deal
	public void initialDeal() {

		Card play1 = dealer.deal();
		sleep(1000);
		System.out.println(player.getName() + "'s 1st Card: " + play1);
		player.getBjHand().addCard(play1);
		Card deal1 = dealer.deal();
		sleep(1000);
		System.out.println("Dealer's 1st card face down"); //does not display dealers first card
		dealer.getBjHand().addCard(deal1);
		Card play2 = dealer.deal();
		sleep(1000);
		System.out.println(player.getName() + "'s 2nd Card: " + play2);
		player.getBjHand().addCard(play2);
		Card deal2 = dealer.deal();
		sleep(1000);
		System.out.println("Dealer's top card: " + deal2);
		dealer.getBjHand().addCard(deal2);
		System.out.println("_______________________________________________________");
		sleep(1000);
		System.out.println("Dealer's observable hand: " + deal2.getRank().getValue());
		int playerVal = player.getBjHand().getHandValue(); 
		isTrue = player.assessDealtCards(playerVal); //determines if game is over or continue to hitOrStay.
			while(isTrue) {
				hitOrStay(); //controlled by while loop which is killed if false is returned based on certain outcomes.
			}
	}

// prompts the user to hit, stay, or get advice from dealer. based on outcome of initial deal. 
	public boolean hitOrStay() {
			System.out.println("Select an option:\n1.Hit\n2.Stay\n3.Dealers Opinion");
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
				dealer.evaluateWinner(player); //sends player to dealer to be used on final assessment. 
				dealer.showCards();
				isTrue = false;
				break;
			case 3:
				dealer.opinion(player.getBjHand().getHandValue());
				break;
			default:
				System.out.println("Not an option. Try again");
				break;
			}
			
			return isTrue;
	}

//sleep method which takes in milliseconds to pause the println. Helps clean up the console some. 
	public void sleep(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	
}
