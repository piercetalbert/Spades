package core;

import constants.Constants.Color;
import constants.Constants.Suit;
import constants.Constants.Face;

public class Card {
    
    // member variables
    private Face Face;
    private Suit Suit;
    private Color Color;
    
    //Creating variable hashCode for use in hash function
    @Override
    public int hashCode() {
        
        int hashCode = 0;
        
        return hashCode;
        
    }
    
    //Check if object parameter is an instanceof class Card
    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof Card) {
            
           Card card = (Card) obj; 
            
           return (card.Face.equals(this.Face) && 
                   card.Color.equals(this.Color) &&  
                   card.Suit.equals(this.Suit)); 
            
        }
        
        else {
            
            return false;
            
        }
        
    }
    
    /**
     * @return the Face
     */
    public Face getFace() {
        
        return Face;
        
    }

    /**
     * @param Face the Face to set
     */
    public void setFace(Face Face) {
        
        this.Face = Face;
        
    }

    /**
     * @return the Suit
     */
    public Suit getSuit() {
        
        return Suit;
        
    }

    /**
     * @param Suit the Suit to set
     */
    public void setSuit(Suit Suit) {
        
        this.Suit = Suit;
        
    }

    /**
     * @return the Color
     */
    public Color getColor() {
        
        return Color;
        
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(Color Color) {
        
        this.Color = Color;
        
    }
    
}