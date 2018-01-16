/*
 *@author Charles McCoy
 *@version 06/24/2015
 *This class generates a deck object made of card objects.  The deck is ultimately an array called deck52.
*/
import java.util.*;
public class Deck{
	
	//Declare a Card array that holds 52 cards.
	public Card [] deck52 = new Card [52];
	public String imgSrc = "deckBack.jpg";

	/*
	 *@author Charles McCoy
	 *This is the constructor for the Deck class.
	*/
	public Deck (){
		int i = 0;
		for (i = 0; i <= 12; i++){
			if (i == 0){
				deck52 [i] = new Card ("Two", 2, "Hearts", "Cards/2OfHearts.png");
			}else if (i == 1){
				deck52 [i] = new Card ("Three", 3, "Hearts", "Cards/3OfHearts.png");
			}else if (i == 2){
				deck52 [i] = new Card ("Four", 4, "Hearts", "Cards/4OfHearts.png");
			}else if (i == 3){
				deck52 [i] = new Card ("Five", 5, "Hearts", "Cards/5OfHearts.png");
			}else if (i == 4){
				deck52 [i] = new Card ("Six", 6, "Hearts", "Cards/6OfHearts.png");
			}else if (i == 5){
				deck52 [i] = new Card ("Seven", 7, "Hearts", "Cards/7OfHearts.png");
			}else if (i == 6){
				deck52 [i] = new Card ("Eight", 8, "Hearts", "Cards/8OfHearts.png");
			}else if (i == 7){
				deck52 [i] = new Card ("Nine", 9, "Hearts", "Cards/9OfHearts.png");
			}else if (i == 8){
				deck52 [i] = new Card ("Ten", 10, "Hearts", "Cards/10OfHearts.png");
			}else if (i == 9){
				deck52 [i] = new Card ("Jack", 10, "Hearts", "Cards/JackOfHearts.png");
			}else if (i == 10){
				deck52 [i] = new Card ("Queen", 10, "Hearts", "Cards/QueenOfHearts.png");
			}else if (i == 11){
				deck52 [i] = new Card ("King", 10, "Hearts", "Cards/KingOfHearts.png");
			}else if (i == 12){
				deck52 [i] = new Card ("Ace", 11, "Hearts", "Cards/AceOfHearts.png");
			}
		} 

		for (i = 13; i <= 25; i ++){
			if (i == 13){
				deck52 [i] = new Card ("Two", 2, "Spades", "Cards/2OfSpades.png");
			}else if (i == 14){
				deck52 [i] = new Card ("Three", 3, "Spades", "Cards/3OfSpades.png");
			}else if (i == 15){
				deck52 [i] = new Card ("Four", 4, "Spades", "Cards/4OfSpades.png");
			}else if (i == 16){
				deck52 [i] = new Card ("Five", 5, "Spades", "Cards/5OfSpades.png");
			}else if (i == 17){
				deck52 [i] = new Card ("Six", 6, "Spades", "Cards/6OfSpades.png");
			}else if (i == 18){
				deck52 [i] = new Card ("Seven", 7, "Spades", "Cards/7OfSpades.png");
			}else if (i == 19){
				deck52 [i] = new Card ("Eight", 8, "Spades", "Cards/8OfSpades.png");
			}else if (i == 20){
				deck52 [i] = new Card ("Nine", 9, "Spades", "Cards/9OfSpades.png");
			}else if (i == 21){
				deck52 [i] = new Card ("Ten", 10, "Spades", "Cards/10OfSpades.png");
			}else if (i == 22){
				deck52 [i] = new Card ("Jack", 10, "Spades", "Cards/JackOfSpades.png");
			}else if (i == 23){
				deck52 [i] = new Card ("Queen", 10, "Spades", "Cards/QueenOfSpades.png");
			}else if (i == 24){
				deck52 [i] = new Card ("King", 10, "Spades", "Cards/KingOfSpades.png");
			}else if (i == 25){
				deck52 [i] = new Card ("Ace", 11, "Spades", "Cards/AceOfSpades.png");
			}
		} 

		for (i = 26; i <= 38; i ++){
			if (i == 26){
				deck52 [i] = new Card ("Two", 2, "Clubs", "Cards/2OfClubs.png");
			}else if (i == 27){
				deck52 [i] = new Card ("Three", 3, "Clubs", "Cards/3OfClubs.png");
			}else if (i == 28){
				deck52 [i] = new Card ("Four", 4, "Clubs", "Cards/4OfClubs.png");
			}else if (i == 29){
				deck52 [i] = new Card ("Five", 5, "Clubs", "Cards/5OfClubs.png");
			}else if (i == 30){
				deck52 [i] = new Card ("Six", 6, "Clubs", "Cards/6OfClubs.png");
			}else if (i == 31){
				deck52 [i] = new Card ("Seven", 7, "Clubs", "Cards/7OfClubs.png");
			}else if (i == 32){
				deck52 [i] = new Card ("Eight", 8, "Clubs", "Cards/8OfClubs.png");
			}else if (i == 33){
				deck52 [i] = new Card ("Nine", 9, "Clubs", "Cards/9OfClubs.png");
			}else if (i == 34){
				deck52 [i] = new Card ("Ten", 10, "Clubs", "Cards/10OfClubs.png");
			}else if (i == 35){
				deck52 [i] = new Card ("Jack", 10, "Clubs", "Cards/JackOfClubs.png");
			}else if (i == 36){
				deck52 [i] = new Card ("Queen", 10, "Clubs", "Cards/QueenOfClubs.png");
			}else if (i == 37){
				deck52 [i] = new Card ("King", 10, "Clubs", "Cards/KingOfClubs.png");
			}else if (i == 38){
				deck52 [i] = new Card ("Ace", 11, "Clubs", "Cards/AceOfClubs.png");
			}
		} 

		for (i = 39; i <= 52; i ++){
			if (i == 39){
				deck52 [i] = new Card ("Two", 2, "Diamonds", "Cards/2OfDiamonds.png");
			}else if (i == 40){
				deck52 [i] = new Card ("Three", 3, "Diamonds", "Cards/3OfDiamonds.png");
			}else if (i == 41){
				deck52 [i] = new Card ("Four", 4, "Diamonds", "Cards/4OfDiamonds.png");
			}else if (i == 42){
				deck52 [i] = new Card ("Five", 5, "Diamonds", "Cards/5OfDiamonds.png");
			}else if (i == 43){
				deck52 [i] = new Card ("Six", 6, "Diamonds", "Cards/6OfDiamonds.png");
			}else if (i == 44){
				deck52 [i] = new Card ("Seven", 7, "Diamonds", "Cards/7OfDiamonds.png");
			}else if (i == 45){
				deck52 [i] = new Card ("Eight", 8, "Diamonds", "Cards/8OfDiamonds.png");
			}else if (i == 46){
				deck52 [i] = new Card ("Nine", 9, "Diamonds", "Cards/9OfDiamonds.png");
			}else if (i == 47){
				deck52 [i] = new Card ("Ten", 10, "Diamonds", "Cards/10OfDiamonds.png");
			}else if (i == 48){
				deck52 [i] = new Card ("Jack", 10, "Diamonds", "Cards/JackOfDiamonds.png");
			}else if (i == 49){
				deck52 [i] = new Card ("Queen", 10, "Diamonds", "Cards/QueenOfDiamonds.png");
			}else if (i == 50){
				deck52 [i] = new Card ("King", 10, "Diamonds", "Cards/KingOfDiamonds.png");
			}else if (i == 51){
				deck52 [i] = new Card ("Ace", 11, "Diamonds", "Cards/AceOfDiamonds.png");
			}
		} 
	}

	/*
	 *@author Charles McCoy
	 *This method allows for deck52, and therefore the deck object, to be shuffled to ensure fair draws.
	 *@return Card [] - the shuffled deck of cards.
	*/
	public Card [] shuffle (){
		int shuffleCount = 0;
		
		Random ranNum = new Random ();

		while (shuffleCount < 52){
			int firstCard = ranNum.nextInt(51);
			int secondCard = ranNum.nextInt(51);
			Card tempCard = deck52 [firstCard];
			deck52 [firstCard] = deck52 [secondCard];
			deck52 [secondCard] = tempCard;
			shuffleCount ++;
		}
		return deck52;
	}

	/*
	 *@author Charles McCoy
	 *This method allows for the entire deck object to be printed out, card by card, mainly to test for proper shuffling.
	*/
	public void print (){
		for (int i = 0; i < deck52.length; i ++){
			deck52[i].printCard();
		}
	}    
}