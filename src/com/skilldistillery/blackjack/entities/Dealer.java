package com.skilldistillery.blackjack.entities;


import java.util.List;

public class Dealer extends Person {

	private Deck deck = new Deck();
	private BlackjackHand bjHand = new BlackjackHand();
	private Player player; // required at the end to access players final hand value and compare to dealer

	public Dealer(String name) {
		super(name);
		
	}
//calls the deck to deal card
	public Card deal() {
		return deck.dealCard();
	}
	
//As soon as dealer flips cards, this method takes over and determines outcome based on if dealer busts or not. 
	public void assessCards(int val) {
		int playerCards = player.getBjHand().getHandValue();
		int dealerCards = val;
		while (dealerCards < 17) {
			dealerCards = hitTillQuit();
			if (bjHand.is21(dealerCards)) {
				System.out.println("Twenty One!");
			} else if (bjHand.isBust(dealerCards)) {
				System.out.println("Dealer Busts! Player wins!!");
			} 
			if (bjHand.isBlackJack(dealerCards)) {
				System.out.println("Oooh tough luck, house take it");
			}
		} 
//additional logic if both dealer and player are in the sweetspot and values need to be assessed. This method calls the value of the players hand(int)
		if (dealerCards >=17 && dealerCards < 21) {
			System.out.println("Dealer: " + dealerCards + "|" + player.getName() + playerCards);
			if (playerCards > dealerCards) {
				System.out.println(player.getName() + " wins!");
			} else if (dealerCards > playerCards) {
				System.out.println("Dealer wins!");
			} else {
				System.out.println("Push!...Live to fight another day");
			}
		}
	}

//Extra flare added for those who don't know the rules and need a hint
	public void opinion(int val) {
		if (val < 10) {
			System.out.println("You might want to hit");
		} else if (val > 12 && val < 18) {
			System.out.println("Hmmm...Go with your heart");
		} else if (val > 18 && val < 21) {
			System.out.println("Might want to stay...just my professional opinion");
		} else {
			System.out.println("Tough call");
		}

	}

//called once player stays and initiates dealers play
	public void showCards() {
		int dealerCards = 0;
		System.out.println("Dealer flips card...");
		sleep(1200);
		dealerCards = getBjHand().getHandValue();
		System.out.println("\nDealers Hand: " + dealerCards);
		sleep(1200);
		assessCards(dealerCards);
	}
//continually adds new cards to dealers hand and assesses value to keep dealing and print out respective responses
	public int hitTillQuit() {
		Card newCard = deal();
		getBjHand().addCard(newCard);
		int dHandVal = getBjHand().getHandValue();
		System.out.println(newCard + "\nDealers Hand: " + dHandVal);
		return dHandVal;
	}
	
//displays contents of deck. If called before shuffle, cards will be in order. Used in the verifyDeck method 
	public void displayDeck() {
		 List<Card> newDeck = deck.getCards();
		 for (Card card : newDeck) {
			 System.out.println(card + ", ");
		}
	}

//shuffles deck	
	public void shuffleDeck() {
		deck.shuffle();
	}
//NOT USED. Stretch goal if I ended up extending the game
	public void resetDeck() {
		deck.getCards();
	}
//Called to assign blackjack cards to dealers hand
	public BlackjackHand getBjHand() {
		return bjHand;
	}
//called in the switch statement in main to send Players hand value to compare in dealer logic
	public void evaluateWinner(Player p) {
		this.player = p;

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
