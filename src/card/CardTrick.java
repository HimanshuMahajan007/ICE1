/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();

            //c.setValue(insert call to random number generator here)
            c.setValue((int)(Math.random() * 13) + 1);
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            c.setSuit(Card.SUITS[(int)(Math.random() * 4)]);

            magicHand[i] = c;
        }
        
        //insert code to ask the user for Card value and suit, create their card
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a number between (1 - 13) to set the value of your card: ");
        int userValue = keyboard.nextInt();

        System.out.print("Enter a number between (0 - 3) corresponding to (Hearts, Diamonds, Spades, Clubs): ");
        int userSuitIndex = keyboard.nextInt();
        String userSuit = Card.getSuitFromIndex(userSuitIndex);
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        // and search magicHand here
        boolean search = false;
        for (int i = 0; i < magicHand.length; i++) {
            Card c = magicHand[i];
            if (c.getValue() == userCard.getValue() && c.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                search = true;
                break;
            }
        }
        //Then report the result here
        if (search == true) {
            System.out.println("Congratulations, You won!");
        }
        else {
            System.out.println("Sorry, You lost!");
        }
    }
    
}
