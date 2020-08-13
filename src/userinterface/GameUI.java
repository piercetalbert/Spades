package userinterface;

import constants.Constants;
import core.Card;
import core.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameUI {
    
    private Game game;
    
    private JFrame frame;
    
    private JPanel aiOnePanel;
    private JPanel tablePanel;
    private JPanel aiTwoPanel;
    private JPanel hpPanel;
    private JPanel aiThreePanel;
    private JPanel northPanel;
    private JPanel scorePanel;
    private JPanel bidPanel;
    
    private JMenuBar menuBar;
    
    private JMenu gameMenu;
    private JMenu helpMenu;
    
    private JMenuItem newGameMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;
    private JMenuItem rulesMenuItem;
    
    private ArrayList<Card> cardsPlayed;
    private ArrayList<JLabel> cardsPlayedLbl;
    
    //GameUI constructor
    public GameUI (Game game) {
        
        this.game = game;
            
        initComponents();
            
    }
    
    //initialize menu and table
    private void initComponents() {
        
        initMenuBar();
        layoutTable();
        
    }
    
    //initialize menu
    private void initMenuBar() {
        
        menuBar = new JMenuBar();
        
        //Game menu
        gameMenu = new JMenu("Game");
        newGameMenuItem = new JMenuItem("New Game");
        newGameMenuItem.addActionListener(new NewGameListener());
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitListener());
        
        //help and rules
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new AboutListener());
        rulesMenuItem = new JMenuItem("Rules");
        rulesMenuItem.addActionListener(new RulesListener());
        
        //add to menu
        gameMenu.add(newGameMenuItem);
        gameMenu.add(exitMenuItem);
        
        helpMenu.add(aboutMenuItem);
        helpMenu.add(rulesMenuItem);
        
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        
    }
    
    //create layout
    private void layoutTable() {
        
        //initialize JFrame
        frame = new JFrame("Spades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        
        initMenuBar();
        
        //create panels for four players
        aiOnePanel = new AIPlayerUI(game.getTable().get(1), 1);
        aiTwoPanel = new AIPlayerUI(game.getTable().get(2), 2);
        aiThreePanel = new AIPlayerUI(game.getTable().get(3), 3);
        hpPanel = new HumanPlayerUI(game.getTable().get(0));
        
        initNorthPanel();
        initTablePanel();
        
        //assign player positions
        frame.add(aiOnePanel, BorderLayout.WEST);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(aiThreePanel, BorderLayout.EAST);
        frame.add(hpPanel, BorderLayout.SOUTH);
        frame.add(tablePanel, BorderLayout.CENTER);
        
        frame.setJMenuBar(menuBar);
        
        frame.setVisible(true);
        
    }
    
    //create top panel
    private void initNorthPanel() {
        
        northPanel = new JPanel();
        northPanel.setMinimumSize(new Dimension(980, 150));
        northPanel.setPreferredSize(new Dimension(980, 150));
        
        //bids
        bidPanel = new JPanel();
        bidPanel.setBorder(BorderFactory.createTitledBorder("Bids"));
        bidPanel.setMinimumSize(new Dimension(90, 140));
        bidPanel.setPreferredSize(new Dimension(90, 140));
        
        //score
        scorePanel = new JPanel();
        scorePanel.setBorder(BorderFactory.createTitledBorder("Score"));
        scorePanel.setMinimumSize(new Dimension(90, 140));
        scorePanel.setPreferredSize(new Dimension(90, 140));
        
        aiTwoPanel.setMinimumSize(new Dimension(700, 140));
        aiTwoPanel.setPreferredSize(new Dimension(700, 140));
        
        northPanel.add(scorePanel);
        northPanel.add(aiTwoPanel);
        northPanel.add(bidPanel);
        
    }
    
    //initialize table
    private void initTablePanel() {
        
        //spades
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("SPADES"));
        tablePanel.setMaximumSize(new Dimension(200, 200));
        tablePanel.setMinimumSize(new Dimension(200, 200));
        tablePanel.setPreferredSize(new Dimension(200, 200));
        
        cardsPlayedLbl = new ArrayList();
        
        
        for(int c = 0; c < Constants.NUMBER_OF_PLAYERS; c++) {
            
            JLabel card = new JLabel();
            
            if(c == Constants.POSITION_1 || c == Constants.POSITION_3) {
                
                card.setMinimumSize(new Dimension(100, 150));
                card.setPreferredSize(new Dimension(100, 150));
                card.setMaximumSize(new Dimension(100, 150));
                
            }
            
            else {
                
                card.setMinimumSize(new Dimension(150, 100));
                card.setPreferredSize(new Dimension(150, 100));
                card.setMaximumSize(new Dimension(150, 100));
                
            }
            
            CardUI cardUI = new CardUI(card);
            
            card = cardUI.getLabel();
            
            cardsPlayedLbl.add(card);
            
        }
        
        //add card played to cardinal position of table
        tablePanel.add(cardsPlayedLbl.get(Constants.POSITION_1), BorderLayout.SOUTH);
        tablePanel.add(cardsPlayedLbl.get(Constants.POSITION_2), BorderLayout.WEST);
        tablePanel.add(cardsPlayedLbl.get(Constants.POSITION_3), BorderLayout.NORTH);
        tablePanel.add(cardsPlayedLbl.get(Constants.POSITION_4), BorderLayout.EAST);
        
    }
    
    //new game
    private class NewGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    //exit game
    private class ExitListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            int response = JOptionPane.showConfirmDialog(frame, "Confirm to exit Spades?",
                    "Exit?", JOptionPane.YES_NO_OPTION);
            
            if(response == JOptionPane.YES_OPTION) {
                
                System.exit(0);
                
            }
            
        }
        
    }
    
    //about page
    private class AboutListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            String message = "Spades version 1.0\nPierce Talbert\nSpring 2018";
            JOptionPane.showMessageDialog(frame, message);
            
        }
        
    }
    
    //display rules
    private class RulesListener implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent ae) {
        
            String playersAndCards = "Players and Cards\nThe flour players are "
                    + "in fixed partnerships, with partners sitting opposite each "
                    + "other.\nDeal and play are clockwise.\nA standard pack of "
                    + "52 cards is used. \nThe cards, in each suit, rank from highest"
                    + " to lowest.";
            String theDeal = "\n\nThe Deal\nThe first dealer is chosen at random, and "
                    + "the turn to deal rotates clockwise.\nThe cards are shuffled"
                    + "and then dealt singly, in clockwise order beginning with "
                    + "the player on dealer's left, until all 52 cards have been "
                    + "dealt and everyone has 13.";
            String theBidding = "\n\nThe Bidding\nin Spades, all four players bid a "
                    + "number of tricks.\nEach team adds together the bids of the "
                    + "two partners, and the total is the number of tricks that "
                    + "team must try to win in order to get a positive score.\n"
                    + "The bidding begins with the player to the dealer's left "
                    + "and continues clockwise around the table.\nEveryone must "
                    + "bid a number, and in theory any number from 1 to 13 is"
                    + "allowed.\nUnlike other games with bidding, there is no "
                    + "requirement for each bid to be higher than the last one, "
                    + "and players are not allowed to pass.";
            String thePlayOfTheHand = "\n\nThe Play of the Hand\nThe player to dealer's left leads any "
                    + "card except a spade to the first trick. \nEach player, in "
                    + "turn, clockwise, must follow suit if able; if unable to "
                    + "follow suit, the player may play any card.\n"
                    + "A trick containing a spade is won by the highest spade "
                    + "played; if no spade is played, the trick is won by the "
                    + "highest card of the suit led. \nThe winner of each trick "
                    + "leads to the next. \nSpades may not be led until either "
                    + "some player has played a spade (on the lead of another "
                    + "suit, of course), or "
                    + "the leader has nothing but spades left in hand.\n"
                    + "Playing the first spade is known as \"breaking\" spades.";
            String scoring = "\n\nScoring\nA side that takes at least as many tricks as its "
                    + "bid calls for receives a score equal to 10 times its bid. "
                    + "Additional tricks (overtricks) are worth an extra one point "
                    + "each.\n"
                    + "Sandbagging rule: Overtricks are colloquially known as bags. "
                    + "\nA side which (over several deals) accumulates ten or more "
                    + "bags has 100 points deducted from its score. \nAny bags beyond "
                    + "ten are carried over to the next cycle of ten overtricks - "
                    + "that is if they reached twenty overtricks they would lose "
                    + "another 100 points and so on.";
            
            JOptionPane.showMessageDialog(frame, playersAndCards + theDeal 
                    + theBidding + thePlayOfTheHand + scoring);
        
        }
    
    }   
    
}
