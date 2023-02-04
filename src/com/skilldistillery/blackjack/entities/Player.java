package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class Player extends Person {
	private BlackjackHand bjHand = new BlackjackHand();
	public Player(String name) {
		super(name);
	}
		
	
	public void hit() {
		System.out.println("Hit me");
	}
	
	public void stay() {
		System.out.println("Stay");
	}

	public boolean accessDealtCards(int val) {
		int pVal = val;
	 if (bjHand.isBlackJack(pVal)) {
		System.out.println("BLACKJACK!!! Winner Winner Chicken Dinner");
		return false;
//	 } else if ((bjHand.isBust(pVal))){
//		 System.out.println("BUST! House wins. Hate to see it!");
	 }else {
		 System.out.println("You're currently sitting at " + pVal);	 
	 }
	 return true;
	}
	
	public boolean assessPostHit(int val) {
		int pVal = val;
	 if (bjHand.is21(pVal)) {
		System.out.println("Twenty One! Player Wins!");
		return false;
	 } else if ((bjHand.isBust(pVal))){
		 System.out.println("BUST! House wins. Hate to see it!");
		 return false;
	 }else {
		 System.out.println("You're currently sitting at " + pVal);	 
	 }
	 return true;
	}

	
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
