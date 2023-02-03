package com.skilldistillery.blackjack.testing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.skilldistillery.blackjack.entities.Rank;
import com.skilldistillery.blackjack.entities.Suit;

public class CardTest {
  public static void main(String[] args) {
	Map<Suit, Rank> cardDeck = new HashMap<>();
	
    Rank[] ranks = Rank.values();
    for(int i=0; i<ranks.length; i++) {
      System.out.println(ranks[i] + " " + ranks[i].getValue());
    }
    
    for(Suit s : Suit.values()){
      System.out.println(s);
    }
    
    Suit[] fourSuits = new Suit[4]; 
    for (Suit s : fourSuits) {
    		for (Rank allRanks : ranks) {
//    			cardDeck.put(s.toString(), allRanks.getValue());
    		}   	
    }
    System.out.println(cardDeck);
    
       
  }
}