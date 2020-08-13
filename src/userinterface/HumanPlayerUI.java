package userinterface;

import core.HumanPlayer;
import core.Player;
import constants.Constants;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HumanPlayerUI extends JPanel {
    
    private HumanPlayer human;
    private ArrayList<JButton> cards;
    CardUI cardUI;
    
    //human player constructor
    public HumanPlayerUI(Player player) {
    
        human = (HumanPlayer)player;
        
        initComponents();
    
    }
    
    //initialize components
    private void initComponents() {
        
        //get player name and set size
        this.setBorder(BorderFactory.createTitledBorder(human.getName()));
        this.setMinimumSize(new Dimension(200, 180));
        this.setPreferredSize(new Dimension(200, 180));
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        displayCards();
        
    }
    
    //display player cards
    private void displayCards() {
        
        cards = new ArrayList<JButton>();
        
        for(int c = 0; c < Constants.CARDS_DEALT; c++) {
            
            JButton card = new JButton();
            
            cardUI = new CardUI(human.getHand().get(c), card);
            
            card = cardUI.getButton();
            card.setMinimumSize(new Dimension(50, 200));
            card.setPreferredSize(new Dimension(50, 200));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            cards.add(card);
            
            this.add(card);
            
        }
        
    }
    
    private static final Logger LOG = Logger.getLogger(HumanPlayerUI.class.getName());
    
}
