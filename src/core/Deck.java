package core;

import constants.Constants;
import constants.Constants.Color;
import constants.Constants.Face;
import constants.Constants.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Deck {
    
    private Set<Card> deck;
    
    //Custom constructor
    public Deck() {
        
        generateDeck();
        //displayDeck();
        shuffleDeck();
        //displayDeck();
        
    }
    
    /**
     * @return the cardDeck
     */
    public Set<Card> getCardDeck() {
        
        return deck;
        
    }

    /**
     * @param cardDeck the cardDeck to set
     */
    public void setCardDeck(Set<Card> cardDeck) {
        
        this.deck = deck;
        
    }
    
    //Generating the deck
    private void generateDeck() {
        
        deck = new HashSet<>(Constants.DECK_CARDS);
        
        //Looping through assigning each card a face
        for(Face newFace : Face.values()) {
            
            //Assign suit
            for(Suit newSuit : Suit.values()) {
            
                Card newCard = new Card();
                
                newCard.setFace(newFace);
                newCard.setSuit(newSuit);
                
                //Assign color
                if(newSuit == Suit.DIAMONDS || newSuit == Suit.HEARTS) {
                
                    newCard.setColor(Color.RED);
                
                }
            
                else {
            
                    newCard.setColor(Color.BLACK); 
            
                }
            
                boolean success;
                
                //Add card to deck
                if(!deck.contains(newCard)) {
                
                    success = deck.add(newCard);
                
                }
            
            }
             
        }
        
    }
    
    //Print the deck
    private void displayDeck() {
        
        /*System.out.println("---------\nCard deck\n---------");
        
        System.out.println("\nDeck size: " + deck.size() + " cards");
        System.out.println("\nThis deck consists of: \n");*/
        
        for(Card card : deck) {
            
            //System.out.println("" + card.getFace() + " of " + card.getSuit() 
            //        + " is " + card.getColor());
            
        }
        
    }
    
    //Shuffle the deck
    private void shuffleDeck() {
        
        //System.out.println("\n------------------\nShuffling the deck"
        //        + "\n------------------\n");
        
        //Create arraylist from class Card
        List<Card> cardList = new ArrayList<>(deck);
        
        //Collections method to shuffle arraylist
        Collections.shuffle(cardList);
        
        //New member variable deck from shuffled arraylist
        deck = new HashSet<>(cardList);
        
    }
    
}
