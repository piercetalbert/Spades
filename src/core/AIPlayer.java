package core;

import constants.Constants.Face;
import constants.Constants.Suit;

public class AIPlayer extends Player {
    
    public Card playCard() {
        
        return null;
        
    }
    
    //AIPlayer place bid
    public int placeBid() {
        
        //System.out.println(super.getName() + " please place your bid.");
        
        int aiBid = 0;
        
        //aiBid increases based on cards in hand
        for(Card card : super.getHand()) {
            
            if(card.getFace() == Face.ACE || card.getFace() == Face.KING) {
                
                aiBid++;
                
            }
            
            else if(card.getSuit() == Suit.SPADES && 
                    card.getFace().getValue() > Face.TEN.getValue()) {
                
                aiBid++;
                
            }
            
        }
        
        //Default condition aiBid is 1
        if(aiBid == 0) {
            
            aiBid = 1;
            
        }
        
        super.setBid(aiBid);
        
        //System.out.println("" + this.getName() + " bid " + aiBid);
        
        return super.getBid();
        
    }
      
}
