package userinterface;

import constants.Constants;
import constants.Constants.Face;
import constants.Constants.Suit;
import core.Card;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CardUI {
    
    Card card;
    ImageIcon imageIcon;
    private JButton button;
    private JLabel label;
    int position;
    
    //custom constructor
    public CardUI(Card card, JButton button) {
        
       this.card = card;
       this.button = button;
       
       selectFrontImage();
        
    }
    
    //custom constructor
    public CardUI(Card card, JLabel label, int position) { 
        
        this.card = card;
        this.label = label;
        this.position = position;
        
        if(position == Constants.POSITION_2 || position == Constants.POSITION_4) {
            
            selectVerticalBackImage();
            
        }
        
        else {
            
            selectHorizontalBackImage();
            
        }
        
    }
    
    //custom contructor
    public CardUI(JLabel label) {
        
        this.label = label;
        
        selectHorizontalBackImage();
        
    }
    
    //front image for user
    private void selectFrontImage() {
        
        String fileName = "../images/";
        
        //add faces
        switch(card.getFace()) {
            
            case ACE:
                fileName += "Ace";
                break;
            
            case TWO:
                fileName += "Two";
                break;
                
            case THREE:
                fileName += "Three";
                break;
                
            case FOUR:
                fileName += "Four";
                break;
                
            case FIVE:
                fileName += "Five";
                break;
                
            case SIX:
                fileName += "Six";
                break;
                
            case SEVEN:
                fileName += "Seven";
                break;
                
            case EIGHT:
                fileName += "Eight";
                break;
                        
            case NINE:
                fileName += "Nine";
                break;
                
            case TEN:
                fileName += "Ten";
                break;
                
            case JACK:
                fileName += "Jack";
                break;
            
            case QUEEN:
                fileName += "Queen";
                break;
                
            case KING:
                fileName += "King";
                
        }
        
        //add suits
        switch(card.getSuit()) {
            
            case CLUBS:
                fileName += "Clubs";
                break;
                
            case DIAMONDS:
                fileName += "Hearts";
                break;
                
            case HEARTS:
                fileName += "Hearts";
                break;
                
            case SPADES:
                fileName += "Spades";
                break;
            
        }
        
        fileName += ".png";
        
        URL imgURL = getClass().getResource(fileName);
        
        if(imgURL != null) {
            
            imageIcon = new ImageIcon(imgURL);
            //imageIcon = imageResizeHorizontal(imageIcon);
            button = new JButton(imageIcon);
            
        }
        
        else {
            
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
            
        }
        
    }
    
    //select vertical img from package
    private void selectVerticalBackImage() {
        
        String fileName = "../images/backVertical.jpg";
        URL imgURL = getClass().getResource(fileName);
        
        //select vertical img
        if(imgURL != null) {
            
            imageIcon = new ImageIcon(imgURL);
            imageIcon = imageResizeVertical(imageIcon);
            label = new JLabel(imageIcon);
            
        }
        
        //error
        else {
            
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
            
        }
        
    }
    
    //select horizontal img from package
    private void selectHorizontalBackImage() {
        
        String fileName = "../images/backHorizontal.jpg";
        URL imgURL = getClass().getResource(fileName);
        
        //select horizontal img
        if(imgURL != null) {
            
            imageIcon = new ImageIcon(imgURL);
            imageIcon = imageResizeHorizontal(imageIcon);
            label = new JLabel(imageIcon);
            
        }
        
        //error
        else {
            
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
            
        }
        
    }
    
    //resize card images for vertucal cards
    private ImageIcon imageResizeVertical(ImageIcon icon) {
        
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(75, 50, java.awt.Image.SCALE_SMOOTH);
        
        icon = new ImageIcon(newImage);
        
        return icon;
        
    }
    
    //resize card images for horizontal cards
    private ImageIcon imageResizeHorizontal(ImageIcon icon) {
        
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(50, 75, java.awt.Image.SCALE_SMOOTH);
        
        icon = new ImageIcon(newImage);
        
        return icon;
        
    }  
    
    /**
     * @return the button
     */
    public JButton getButton() {
        
        return button;
        
    }

    /**
     * @param button the button to set
     */
    public void setButton(JButton button) {
        
        this.button = button;
        
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        
        return label;
        
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        
        this.label = label;
        
    }

}
