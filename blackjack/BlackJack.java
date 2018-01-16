import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
public class BlackJack extends JFrame{
	public Deck myDeck = new Deck ();
	public playerImagePanel playerPane;
	public dealerImagePanel dealerPane;
	public int cardCount = 0;
	public int currentVal = 0;
	public int dealCurVal = 0;
	public boolean busted = false;
	public String winner = "You Win!!!!!";
	public String loser = "You lose!!!";

	public static void main (String [] args){
		BlackJack mainFrame = new BlackJack ();
		mainFrame.setVisible (true);
	}

	public BlackJack (){
		setTitle ("Black Jack");
		setSize (700, 800);
		setLayout (new GridLayout(0,1));

		JPanel thisPanel = new JPanel (new GridLayout (3,2));
		JPanel rulesPanel = new JPanel (new GridLayout (0,1));
		playerPane = new playerImagePanel ("deckBack.jpg");
		dealerPane = new dealerImagePanel ("deckBack.jpg");

		JLabel rules = new JLabel ("<html>Welcome to Black Jack!!!!!<br>To start click Play.<br>This will shuffle the deck and deal a card.<br>Select hit or stay.<br>Click play to reshuffle the deck after each hand.<br>Click quit to close the program.</html>");
		JLabel player = new JLabel ("Player Hand");
		JLabel dealer = new JLabel ("Dealer Hand");

		JButton hitButton = new JButton ("Hit");
		JButton stayButton = new JButton ("Stay");
		JButton startButton = new JButton ("Play");
		JButton quitButton = new JButton ("Quit");
		hitButton.addActionListener(new buttonListener());
		stayButton.addActionListener(new buttonListener());
		startButton.addActionListener(new buttonListener());
		quitButton.addActionListener(new buttonListener());
		
		rulesPanel.add (rules);
		thisPanel.add (startButton);
		thisPanel.add (quitButton);
		thisPanel.add (hitButton);
		thisPanel.add (stayButton);
		
		add (rulesPanel);
		add (thisPanel);
		add (player);
		add (playerPane);
		add (dealer);
		add (dealerPane);

		setDefaultCloseOperation (EXIT_ON_CLOSE);
	}
	public class buttonListener implements ActionListener{

		public void actionPerformed (ActionEvent e){
			if (e.getActionCommand().equals ("Play")){
				myDeck.shuffle ();
				//Deal the first card and add its value to the player's current value.
				//Increase the cardCount to get the next card in the deck.
				playerPane.add (myDeck.deck52[cardCount].getSource());
				repaint();
				currentVal += myDeck.deck52[cardCount].getValue();
				cardCount ++;
			}
			if (e.getActionCommand().equals ("Hit")){
				//This statement checks if it is necessary to lower Ace value from 11 to 1.  If so subtract 11 from currentVal and add 1.
				if (myDeck.deck52[cardCount].getName().equals("Ace") && (currentVal+11) > 21){
					myDeck.deck52[cardCount].setAceValue1 (myDeck.deck52[cardCount].getName());
					playerPane.add (myDeck.deck52[cardCount].getSource());
					//System.out.println ("Checking for Aces. " + currentVal);
					//myDeck.deck52[cardCount].printCard();
					currentVal += myDeck.deck52[cardCount].getValue();
					myDeck.deck52[cardCount].setAceValue11 (myDeck.deck52[cardCount].getName());
					cardCount ++;
				}

				//Deal the next card.
				playerPane.add (myDeck.deck52[cardCount].getSource());
				repaint();
				currentVal += myDeck.deck52[cardCount].getValue();
				cardCount ++;
			
				//This statement checks if the player has busted by going over 21, if so it breaks PlayerCyle.
				if (currentVal > 21){
					busted = true;
					JOptionPane.showMessageDialog (null, "Sorry, you busted!!! With " + currentVal);
					endGame ();
				}
			}
			if (e.getActionCommand().equals ("Stay")){		
				if (!busted){
	
					//Command line print letting the user know that this is the dealer's hand.
					//System.out.println ("Dealer's Hand");

					//This loop deals cards for the dealer until the dealer beats the player or busts.
					while (dealCurVal < 21 && dealCurVal <= currentVal){

						//This statement checks if it is necessary to lower Ace value from 11 to 1.  If so subtract 11 from dealCurVal and add 1.
						if (myDeck.deck52[cardCount].getName().equals("Ace") && (dealCurVal+11) > 21){
							myDeck.deck52[cardCount].setAceValue1 (myDeck.deck52[cardCount].getName());
							dealerPane.add (myDeck.deck52[cardCount].getSource());
							//System.out.println ("Checking for Aces. " + currentVal);
							//myDeck.deck52[cardCount].printCard();
							dealCurVal += myDeck.deck52[cardCount].getValue();
							myDeck.deck52[cardCount].setAceValue11 (myDeck.deck52[cardCount].getName());
							cardCount ++;
						}

						//Deal the cards for the dealer's hand.
						dealerPane.add (myDeck.deck52[cardCount].getSource());
						repaint();
						dealCurVal += myDeck.deck52[cardCount].getValue();
						cardCount ++;
					}
				}		

				//This statement checks if the dealer busted and the player has not.  It then prints a victory statement for the player.
				if (dealCurVal > 21 && !busted){
					JOptionPane.showMessageDialog (null, "Dealer busted, you win!!!!!  Dealer had " + dealCurVal);

				//This statement checks if the user has busted, and if so prints a loser message for the player.
				//}else if (busted){
					//loser += " You had " + currentVal;
					//JOptionPane.showMessageDialog (null, loser);

				//This statement checks if the dealer meets victory conditions, and if so prints a loser message for the player.
		 		 }else if (dealCurVal > currentVal && dealCurVal < 21 && !busted){
					loser += " You had " + currentVal;
					JOptionPane.showMessageDialog (null, "Dealer wins with " + dealCurVal + " " + loser);
		 		  }else if (!busted && currentVal > dealCurVal){
					winner += " You had " + currentVal + " Dealer had " + dealCurVal; 
					JOptionPane.showMessageDialog (null, winner);
				   }
				//System.out.println ("Player: " + currentVal + " Dealer: " + dealCurVal);
				//myDeck.deck52[cardCount].printCard();
				endGame();
			}
		
			if (e.getActionCommand().equals ("Quit")){
				dispose();
			}
		}
	}

	private BufferedImage img = null;
	private BufferedImage playerCardPic = null;
	private BufferedImage dealerCardPic = null;
	private int x = 0;
	private int y = 0;
	private ArrayList<BufferedImage> playerHand = new ArrayList<BufferedImage> ();
	private ArrayList<BufferedImage> dealerHand = new ArrayList<BufferedImage> ();
	public class playerImagePanel extends JPanel{
		public playerImagePanel (String path){
			try {
    				img = ImageIO.read(new File(path));
			} catch (IOException e) {
			 }
		}

		public BufferedImage add (String source){
			try {
    				playerCardPic = ImageIO.read(new File(source));
			} catch (IOException e) {
			 }
			playerHand.add (playerCardPic);
			return playerCardPic;
		}

		protected void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		g.drawImage(img, x, y, null);
			x += 90;
			if (playerCardPic != null){
				for (int i = 0; i < playerHand.size(); i ++){
					g.drawImage (playerHand.get(i), x, y, null);
					x += 90;
				}
			}
			x = 0;
		}
	}  

	public class dealerImagePanel extends JPanel{
		public dealerImagePanel (String path){
			try {
    				img = ImageIO.read(new File(path));
			} catch (IOException e) {
			 }
		}

		public BufferedImage add (String source){
			try {
    				dealerCardPic = ImageIO.read(new File(source));
			} catch (IOException e) {
			 }
			dealerHand.add (dealerCardPic);
			return dealerCardPic;
		}

		protected void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		g.drawImage(img, x, y, null);
			x += 90;
			if (dealerCardPic != null){
				for (int i = 0; i < dealerHand.size(); i ++){
					g.drawImage (dealerHand.get(i), x, y, null);
					x += 90;
				}
			}
			x = 0;
		}
	} 

	public void endGame (){
		playerHand.clear();
		dealerHand.clear();
		currentVal = 0;
		dealCurVal = 0;
		cardCount = 0;
		winner = "You win!!!";
		loser = "You lose!!!";
		busted = false;
		repaint();
	}	         	
}