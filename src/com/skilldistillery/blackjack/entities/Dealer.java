package com.skilldistillery.blackjack.entities;

public class Dealer extends Person {

	private Deck deck = new Deck();
	private BlackjackHand bjHand = new BlackjackHand();

	public Dealer(String name) {
		super(name);
	}

	public Card deal() {
		return deck.dealCard();
	}

	public void assessCards(int val) {
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
//			if (dealerCards > 17) {
//				bjA.winnersLosers();
//			}
		}
	}

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


	public void showCards() {
		int dealerCards = 0;
		System.out.println("Dealer flips card...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dealerCards = getBjHand().getHandValue();
		System.out.println(dealerCards);
		assessCards(dealerCards);
	}

	public int hitTillQuit() {
		Card newCard = deal();
		getBjHand().addCard(newCard);
		int dHandVal = getBjHand().getHandValue();
		System.out.println(newCard + "| Dealers Hand: " + dHandVal);
		return dHandVal;
	}

	public void shuffleDeck() {
		deck.shuffle();
	}

	public void resetDeck() {
		deck.getCards();
	}

	public BlackjackHand getBjHand() {
		return bjHand;
	}
}
