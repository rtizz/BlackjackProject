package com.skilldistillery.blackjack.entities;

public class Player extends Person {
	private BlackjackHand bjHand = new BlackjackHand();
	public Player() {
		
	}
	
	public Player(String name) {
		super(name);
	}
		
	
	public void hit() {
		System.out.println("Hit me");
	}
	
	public void stay() {
		System.out.println("Stay");
	}
	
//called only after initialDeal() to assess if given Blackjack on first hand to end the game or continue on. 
	public boolean assessDealtCards(int val) { 
		int pVal = val;
	 if (bjHand.isBlackJack(pVal)) {
		System.out.println("BLACKJACK!!! Winner Winner Chicken Dinner");
		return false;
	 }else {
		 System.out.println("You're currently sitting at " + pVal);	
	 }
	 return true;
	}
	
// called only after user "hits" to reassess and provide logic to end game or keep going.	
	public boolean assessPostHit(int val) {
		int pVal = val;
	 if (bjHand.is21(pVal)) {
		System.out.println("Twenty One! Player Wins!");
		return false;
	 } else if ((bjHand.isBust(pVal))){
		 System.out.println(pVal + "\nBUST! House wins. Hate to see it!");
		 return false;
	 }else {
		 System.out.println("You're currently sitting at " + pVal);	 
	 }
	 return true;
	}

//called in main to get value of hand or add to hand
	public BlackjackHand getBjHand() {
		return bjHand;
	}


	public void setBjHand(BlackjackHand bjHand) {
		this.bjHand = bjHand;
	}


	@Override
	public String toString() {
		return "Player [bjHand=" + bjHand + "]";
	}
	

	
}
