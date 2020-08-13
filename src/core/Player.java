package core;

import java.util.ArrayList;

public abstract class Player implements IPlayer {

    //member variables
    private String name;
    private int tricksTaken;
    private int tricksBid;
    private int score;
    private int bid;
    private ArrayList<Card> hand;    
    public abstract Card playCard();
    public abstract int placeBid();
    
    public Player() {
    
        hand = new ArrayList<>();
    
    }
    
    /**
     * @return the name
     */
    public String getName() {
        
        return name;
        
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        
        this.name = name;
        
    }

    /**
     * @return the tricksTaken
     */
    public int getTricksTaken() {
        
        return tricksTaken;
        
    }

    /**
     * @param tricksTaken the tricksTaken to set
     */
    public void setTricksTaken(int tricksTaken) {
        
        this.tricksTaken = tricksTaken;
        
    }

    /**
     * @return the tricksBid
     */
    public int getTricksBid() {
        
        return tricksBid;
        
    }

    /**
     * @param tricksBid the tricksBid to set
     */
    public void setTricksBid(int tricksBid) {
        
        this.tricksBid = tricksBid;
        
    }

    /**
     * @return the score
     */
    public int getScore() {
        
        return score;
        
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        
        this.score = score;
        
    }
    
    /**
     * @return the hand
     */
    public ArrayList<Card> getHand() {
        
        return hand;
        
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(ArrayList<Card> hand) {
        
        this.hand = hand;
        
    }
    
    /**
     * @return the bid
     */
    public int getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(int bid) {
        this.bid = bid;
    }
    
    //Displays the hand
    public void displayHand() {
        
        //Display name, card hand
        /*System.out.println("---------------");
        System.out.println("" + name + "'s" + " hand is:");
        System.out.println("---------------");*/
        
        for(Card pCard : hand) {
            
            //System.out.println(pCard.getFace() + " of " + pCard.getSuit());
            
        }
        
    }
    
    //Sorts cards in order of increasing value
    public void sortCardsBySuit() {
        
        ArrayList<Card> sortedHand = new ArrayList<Card>();
        
        while (hand.size() > 0) {
            
            //Position of card of least value
            int cardPosition = 0;
            
            //Card of least value
            Card firstCard = hand.get(0);
            
            for(int i = 1; i < hand.size(); i++) {
                
                Card nextCard = hand.get(i);
                
                if(nextCard.getSuit().getRank() < firstCard.getSuit().getRank() ||
                  (nextCard.getSuit() == firstCard.getSuit() &&
                    nextCard.getFace().getValue() < firstCard.getFace().getValue())) {
                    
                    cardPosition = i;
                    firstCard = nextCard;
                    
                }
                
            }
            
            hand.remove(cardPosition);
            sortedHand.add(firstCard);
            
        }
        
        hand = sortedHand;
        
    }
    
}
