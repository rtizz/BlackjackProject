package com.skilldistillery.blackjack.entities;

public class Player extends Person {
	
	public Player(String name) {
		super(name);
	}
		
	public void hit() {
		System.out.println("Hit me");
	}
	
	public void stay() {
		System.out.println("Stay");
	}
	

	
}
