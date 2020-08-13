package userinterface;

import core.Player;
import constants.Constants;
import core.AIPlayer;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AIPlayerUI extends JPanel {
    
    private AIPlayer ai;
    private int position;
    private ArrayList<JLabel> cards;
    private CardUI cardUI;
    private int width;
    private int height;
    
    //AIPlayerUI constructor
    public AIPlayerUI(Player player, int position) {
        
       ai = (AIPlayer)player;
       
       this.position = position;
       
       initComponents();
        
    }
    
    //initialize ui components
    private void initComponents() {
        
        //get ai name and set border size
        this.setBorder(BorderFactory.createTitledBorder(ai.getName()));
        this.setMinimumSize(new Dimension(250, 250));
        this.setPreferredSize(new Dimension(250, 250));
        
        cards = new ArrayList<JLabel>();
        
        //if left or right of table (vertical)
        if(position == 1 || position == 3) {
            
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.width = 100;
            this.height = 50;
            
        }
        
        //if top (horizontal)
        else {
            
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            this.width = 50;
            this.height = 100;
            
        }
        
        displayCards();
        
    }
    
    //display cards for AI
    private void displayCards() {
        
        cards = new ArrayList<JLabel>();
        
        for(int c = 0; c < Constants.CARDS_DEALT; c++) {
            
            JLabel card = new JLabel();
            
            cardUI = new CardUI(ai.getHand().get(c), card, position);
            
            card = cardUI.getLabel();
            card.setMinimumSize(new Dimension(width, height));
            card.setPreferredSize(new Dimension(width, height));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            cards.add(card);
            
            this.add(card);
            
        }
        
    }
    
    //display cards for players on left and right
    /*private void displayVerticalCards() {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        for(int c = 0; c < Constants.CARDS_DEALT; c++) {
            
            JLabel card = new JLabel();
            
            card.setMinimumSize(new Dimension(180, 30));
            card.setPreferredSize(new Dimension(180, 30));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            card.setText("CARD " + c);
            
            cards.add(card);
            
            this.add(card);
            
        }
        
    }*/
    
    //display cards for player on top
   /* private void displayHorizontalCards() {
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        for(int c = 0; c < Constants.CARDS_DEALT; c++) {
            
            JLabel card = new JLabel();
            
            card.setMinimumSize(new Dimension(50, 200));
            card.setPreferredSize(new Dimension(50, 200));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            card.setText("CARD " + c);
            
            cards.add(card);
            
            this.add(card);
            
        }
        
    }*/
    
}
