/*
 *@author Charles McCoy
 *@version 06/24/2015
 *This class represents a card object from a standard 52 card deck for making card games.
*/
public class Card{

	//Claim private class variables
	private String cardName = "";
	private int cardValue = 0;
	private String cardSuit = "";
	private String imgSrc = "";

	/*
	 *@author Charles McCoy
	 *This is the constructor for the card object.  It sets the title, value, and suit of the card.
	 *@param title - name of the card.
	 *@param value - integer value of the card.
	 *@param suit - the suit of the card.
	*/
	public Card (String title, int value, String suit, String source){
		cardName = title;
		cardValue = value;
		cardSuit = suit;
		imgSrc = source;
	}

	public String getSource (){
		return imgSrc;
	}

	/*
	 *@author Charles McCoy
	 *This method allows a user to use the suit of a card.
	 *@return String - the suit of the card.
	*/
	public String getSuit (){
		return cardSuit;
	}

	/*
	 *@author Charles McCoy
	 *This method allows a user to use the value of a card.
	 *@return int - the integer value of the card.
	*/
	public int getValue (){
		return cardValue;
	}

	/*
	 *@author Charles McCoy
	 *This method allows a user to use the name of a card.
	 *@return String - the name of the card.
	*/
	public String getName (){
		return cardName;
	}

	/*
	 *@author Charles McCoy
	 *This method allows the value of an Ace card to change from 11 to 1.
	 *@param cardTitle - the title of the card.  Should only be Ace.
	*/
	public void setAceValue1 (String cardTitle){
		cardValue = 1;
	}

	/*
	 *@author Charles McCoy
	 *This method allows the value of an Ace card to change from 1 to 11.
	 *@param cardTitle - the title of the card.  Should only be Ace.
	*/
	public void setAceValue11 (String cardTitle){
		cardValue = 11;
	}

	/*
	 *@author Charles McCoy
	 *This method prints out the title, value, and suit of a card.
	*/
	public void printCard (){
		System.out.println (cardName + " " + cardValue + " " + cardSuit);
	}
}
		