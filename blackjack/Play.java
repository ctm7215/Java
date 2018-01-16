/*
 *@author Charles McCoy
 *@version 06/24/2015
 *This program can simulate a black jack card game.  The goal is to come as close to 21 without going over.
 *You will be dealt 2 cards.  At that point you decide to 'hit' or 'stay'.  After you decide to 'stay' the dealer
 *will be dealt cards until the dealer's value is greater than yours or the dealer busts by going over 21.  If you
 *go over 21, you bust and lose.
*/

import java.util.*;

public class Play{
	
	//Create a new instance of an input scanner.
	public static Scanner input = new Scanner (System.in);
	public static String playAnother = "";
	
	/*
	 *@author Charles McCoy
	 *This main method creates an instance of a Deck.  The deck is then shuffled and a game of black jack commences.
	*/
	public static void main (String [] args){
		
		Deck myDeck = new Deck ();

		while (!playAnother.equalsIgnoreCase("no")){
			myDeck.shuffle();
			System.out.println (blackJack (myDeck));
			System.out.print ("\nWould like to play another game of black jack? (type 'yes' or 'no') ");
			playAnother = input.next();
			while (!playAnother.equalsIgnoreCase("yes") && !playAnother.equalsIgnoreCase("no")){
				System.out.println ("Please type 'yes' or 'no'");
				playAnother = input.next();
			}
		}
	}

	/*
	 *@author Charles McCoy
	 *This method provides the rules and steps to play a game of black jack.
	 *@param playDeck - the shuffled deck created in the main class.
	 *@return String - a String announcing the winner of the game.
	*/
	public static String blackJack (Deck playDeck){

		//Declare some variables for counting, busting, and return Strings.
		int cardCount = 0;
		int currentVal = 0;
		int dealCurVal = 0;
		boolean busted = false;
		String winner = "You Win!!!!!";
		String loser = "You lose!!!";
		String keepPlaying = "hit";
			
		//Deal the first card and add its value to the player's current value.
		//Increase the cardCount to get the next card in the deck.
		playDeck.deck52[cardCount].printCard();
		currentVal += playDeck.deck52[cardCount].getValue();
		cardCount ++;

		//Declare a label for the player's turn.
		PlayerCycle:

		//This loop keeps going until the player decides to 'stay' or busts.
		while (!keepPlaying.equals("stay")){

			//This statement checks if it is necessary to lower Ace value from 11 to 1.  If so subtract 11 from currentVal and add 1.
			if (playDeck.deck52[cardCount].getName().equals("Ace") && (currentVal+11) > 21){
				playDeck.deck52[cardCount].setAceValue1 (playDeck.deck52[cardCount].getName());
				currentVal -= 11;
				currentVal += playDeck.deck52[cardCount].getValue();
			}

			//Deal the next card.
			playDeck.deck52[cardCount].printCard();
			currentVal += playDeck.deck52[cardCount].getValue();
			cardCount ++;
			
			//This statement checks if the player has busted by going over 21, if so it breaks PlayerCyle.
			if (currentVal > 21){
				busted = true;
				System.out.println ("Sorry, you busted!!!");
				break PlayerCycle;
			}
			
			//The following section allows a player to decide to 'hit' or 'stay', and checks for incorrect input and allows user to enter proper input.
			System.out.print ("You have " + currentVal + " do you want to hit or stay? (type 'hit' or 'stay'): ");
			keepPlaying = input.next();
			while (!keepPlaying.equals("hit") && !keepPlaying.equals("stay")){
				System.out.print ("Please enter 'hit' or 'stay': ");
				keepPlaying = input.next();
			}
		}

		//This statement checks if the player has busted.  If so it goes to the end to print out a loser message.
		if (!busted){

			//Command line print letting the user know that this is the dealer's hand.
			System.out.println ("Dealer's Hand");

			//This loop deals cards for the dealer until the dealer beats the player or busts.
			while (dealCurVal < 21 && dealCurVal <= currentVal){

				//This statement checks if it is necessary to lower Ace value from 11 to 1.  If so subtract 11 from dealCurVal and add 1.
				if (playDeck.deck52[cardCount].getName().equals("Ace") && (currentVal+11) > 21){
					playDeck.deck52[cardCount].setAceValue1 (playDeck.deck52[cardCount].getName());
					dealCurVal -= 11;
					dealCurVal += playDeck.deck52[cardCount].getValue();
				}

				//Deal the cards for the dealer's hand.
				playDeck.deck52[cardCount].printCard();
				dealCurVal += playDeck.deck52[cardCount].getValue();
				cardCount ++;
			}
		}

		//This statement checks if the dealer busted and the player has not.  It then prints a victory statement for the player.
		if (dealCurVal > 21 && !busted){
			System.out.println ("Dealer busted, you win!!!!!  Dealer had " + dealCurVal);

		//This statement checks if the user has busted, and if so prints a loser message for the player.
		}else if (busted){
			loser += " You had " + currentVal;
			return loser;

		//This statement checks if the dealer meets victory conditions, and if so prints a loser message for the player.
		 }else if (dealCurVal > currentVal && dealCurVal <= 21){
			System.out.println ("Dealer wins with " + dealCurVal);
			loser += " You had " + currentVal;
			return loser;
		 }
	
		//Set the victory message for the player and return it.
		winner += " You had " + currentVal + " Dealer had " + dealCurVal;
		return winner;
	}								
		
}
