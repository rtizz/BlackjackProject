# BlackJack Project

# Description
BlackJack project creates a simple 1:1 interaction between a player and a dealer for a game of 21(BlackJack). This is a one off so every conclusion of a hand will result in the termination of the game. 

# Instructions & Expected Outcomes:
The rules are simple, first to 21 (or highest hand without going over 21) wins. Cards 2-10 have their respective value, faces cards(Jack, Queen, King) have a value of 10, and Aces have a value of 11. (In traditional Blackjack, aces can be 1 or 11 but the logic is hard coded at 11 for this project. A Blackjack is only achieved if player reveives 21 on the initial deal. 

1. When initiated, the user will be welcomed to the table a prompted for their name.
2. The dealer will then offer the user if they would wish to confirm the deck is shuffled. If user selects yes, a full list of the shuffled deck will be displayed prior to the hand. If user selects no, the dealer will continue to initial deal.
3. Each player will recieve two cards from the deck. Player will have both hands displayed, and the dealer will only have the second card displayed.
4. User is prompted for 3 options.<br>
>>>a. Hit - dealer will continue until user stays, busts (goes over 21) or gets 21.<br>
>>>b. Stay - Players hand value is final and dealer begins dealing themself.<br>
>>>c. Dealer Opinion - based on the value of the players cards<br>
5. When dealer flips, their total hand value will be displayed. The logic should follow blackjack rules, so if dealer is <17 they will continue to deal themself a new card until they either, a. bust, b. get 21, or c. are above 17 and less than 21. Once c happens the game will compare the players hand value with the dealer to determine the winner.

# Code breakdown:
The following classes are what encompasses the program. This README will provide a succinct overview of the purposes of the class' with exception for BlackJackApp. Additional notes can be found commented in the code. 

1. Suit - Enum
Creates final variables for the suits of the deck to be called on from card.
2. Rank - Enum
Creates final variables for the ranks of the deck to be called on from card.
3. Card - Class
Calls on Rank and Suit to add respective values to ctor. As a card has both a suit and rank, that is the value of the parameters.
4. Deck - Class
Creates the foundation for blackjack. and other card games to access a deck of cards. Making a new deck, checking deck size, dealing cards, and shuffling
5. Person - Abstract
Simple class to provide the naming value both the person and the dealer will take. Allowing the user to be assigned to that player once it starts. 
6. Player - Extends Person
Player has their own bjHand which allows the player to "hold" their own cards and call information on value as needed. Provides the logic a player would require to assess the cards. Two main methods to split up assessment on initially dealt cards, and cards after hitting. 
All are called via the switch held in main.
7. Dealer - Extends Person
As the dealer controls the table, much of the authority is controlled in this method. Dealer can be called on to shuffle/deal cards, show their cards once player stays, hit continuously if they are under 17, display deck if desired, and hold their own blackjack hand. 
8. Hand - Abstract
The hand which is the parent to BlackJackHand, provides the hand (List) which both player and dealer call on to add their card to their hand. 
9. BlackjackHand - Extends Hand
This class is particular to blackjack only with values to assess the values of the cards and assign logic for player and dealer to know what to do. i.e. get hand values, validate if cards = blackjack, bust or just 21. (NOTE: 21 is different than a BlackJack in that it is acheived after the initial deal).
10. BlackJackApp - Class with main. 
Where all above classes are called.<br>
***Note*** Sleep methods were added to provide some breakout during the game instead of just spitting everything out at once. 
a. run(); - initiates welcome, followed by intialDeal() which begins the dealing and assesses from there <br>
b. welcome(); Assigns the users name they enter to the parameters of the player ctor. and calls verifyDeck() should the user wish to see the shuffled deck before game begins. <br>
c. verifyDeck(); Whether the user decides to see the deck or not, this is where the initial shuffle takes place.  <br>
d. initialDeal(); Begins the sequence of dealing to the player followed by the dealer and the logic to only display the dealers second card. Following which it takes the value of the players card to assess (calling player) to determin if the game continues to hit or stay which is controlled via loop that can be broken backed on what the cards are assessed to be. 
e. hitOrStay(); Switch statement providing the three options to the user. Each hit will loop back for user to assess cards (assessPostHit)(<br>
e. sleep(); Method that takes in an int (milliseconds) that will delay the new println.<br>

# Technologies Used
1. Java
2. Eclipse
3. git

# Lessons Learned
1. In OOP, its as simple as thinking in real terms. I.e. both a dealer and the player would have their own blackjack hand, or a CARD goes in the hand.
2. Containing the respective logic under the required class is much simpler than throwing whatever you can to the wall and seeing what sticks.
3. Just because its functional doesnt mean its right. OOP has a structure for a reason, use it. 

