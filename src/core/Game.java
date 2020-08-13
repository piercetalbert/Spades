package core;

import constants.Constants;
import constants.Constants.Suit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Game {

    //member variables
    private Suit trump = Suit.SPADES;
    private Player lead;
    private Player dealer;
    private Player winningPlayer;
    private int round;
    private ArrayList<Team> teams;
    private Deck deck;
    private Scanner in;
    private ArrayList<Player> table;
    private int currentDealer;
    
    
    //custom constructor
    public Game() {
    
        createTeams();
        //outputTeams();
        generateDeck();
        setTable();
        dealHand();
        //displayHands();
        //play();

    }
    
    /**
     * @return the trump
     */
    public Suit getTrump() {
        
        return trump;
        
    }

    /**
     * @param trump the trump to set
     */
    public void setTrump(Suit trump) {
        
        this.trump = trump;
        
    }

    /**
     * @return the lead
     */
    public Player getLead() {
        
        return lead;
        
    }

    /**
     * @param lead the lead to set
     */
    public void setLead(Player lead) {
        
        this.lead = lead;
        
    }

    /**
     * @return the dealer
     */
    public Player getDealer() {
        
        return dealer;
        
    }

    /**
     * @param dealer the dealer to set
     */
    public void setDealer(Player dealer) {
        
        this.dealer = dealer;
        
    }

    /**
     * @return the winningPlayer
     */
    public Player getWinningPlayer() {
        
        return winningPlayer;
        
    }

    /**
     * @param winningPlayer the winningPlayer to set
     */
    public void setWinningPlayer(Player winningPlayer) {
        
        this.winningPlayer = winningPlayer;
        
    }

    /**
     * @return the round
     */
    public int getRound() {
        
        return round;
        
    }

    /**
     * @param round the round to set
     */
    public void setRound(int round) {
        
        this.round = round;
        
    }

    /**
     * @return the teams
     */
    public ArrayList<Team> getTeams() {
        
        return teams;
        
    }

    /**
     * @param teams the teams to set
     */
    public void setTeams(ArrayList<Team> teams) {
        
        this.teams = teams;
        
    }

    /**
     * @return the deck
     */
    public Deck getDeck() {
        
        return deck;
        
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(Deck deck) {
        
        this.deck = deck;
        
    }

    /**
     * @return the in
     */
    public Scanner getIn() {
        
        return in;
        
    }

    /**
     * @param in the in to set
     */
    public void setIn(Scanner in) {
        
        this.in = in;
        
    }
    
    //create teams
    private void createTeams() {
        
        teams = new ArrayList();
        
        //create team one - set name and add to arraylist
        Team teamOne = new Team();
        teamOne.setTeamName("Team One");
        teams.add(teamOne);
        
        //create team two - set name and add to arraylist
        Team teamTwo = new Team();
        teamTwo.setTeamName("Team Two");
        teams.add(teamTwo);
        
        //in = new Scanner(System.in);
        
        //set user name
        //System.out.print("\nPlease enter your name: ");
        String name = (String) JOptionPane.showInputDialog("Please enter your name: ");
        
        HumanPlayer hPlayer = new HumanPlayer();
        hPlayer.setName(name);
        
        //add user to team
        //System.out.println("User added to Team One");
        teamOne.getTeam().add(hPlayer);
        
        for(int i = 1; i <= Constants.AI_PLAYERS; i++) {
            
            //set ai player names
            AIPlayer aiPlayer = new AIPlayer();
            aiPlayer.setName("AI " + i);
            
            //add ai players to teams
            if(teamOne.getTeam().size() < 2) {
                
                teamOne.getTeam().add(aiPlayer);
                
            }
            
            else {
                
                teamTwo.getTeam().add(aiPlayer);
                
            }
            
        }
      
    }
    
    //output teams
    private void outputTeams() {
        
        //System.out.println("");
        
        //prints current teams
        for(Team team : teams) {
            
            //System.out.println(team.getTeamName() + " has players: ");
            
            for(Player player : team.getTeam()) {
                
                //System.out.println(player.getName());
                
            }
            
            //System.out.println("");
            
        }
        
    }
    
    //Generate the deck from the deck class
    private void generateDeck() {
        
        //Instantiate deck
        deck = new Deck();
        
    }
    
    public ArrayList<Player> getTable() {
        
        return table;
        
    }
    
    //Set the positions around the table
    private void setTable() {
        
        //Create table for four players
        table = new ArrayList();
        
        //Create team member variables
        Team teamOne = teams.get(Constants.TEAM_ONE);
        Team teamTwo = teams.get(Constants.TEAM_TWO);
        
        //Assign players to teams
        Player teamOnePlayerOne = teamOne.getTeam().get(Constants.TEAM_ONE);
        Player teamOnePlayerTwo = teamOne.getTeam().get(Constants.TEAM_TWO);
        Player teamTwoPlayerOne = teamTwo.getTeam().get(Constants.TEAM_ONE);
        Player teamTwoPlayerTwo = teamTwo.getTeam().get(Constants.TEAM_TWO);
        
        //Add each team to arraylist table
        table.add(0, teamOnePlayerOne);
        table.add(1, teamTwoPlayerOne);
        table.add(2, teamOnePlayerTwo);
        table.add(3, teamTwoPlayerTwo);
        
        //Assign dealer based on random number between 1-4
        Random rand = new Random();
        currentDealer = rand.nextInt(Constants.NUMBER_OF_PLAYERS);
        dealer = table.get(currentDealer);
        
        //Print current players
        //System.out.println("Players at the table are:");
        
        for(Player cPlayer : table) {
            
            //System.out.println("" + cPlayer.getName());
            
        }
        
    }
    
    //Deal the hand
    private void dealHand() {
        
        //System.out.println("\nPlayer " + dealer.getName() + " will deal.\n");
        
        //Set currentPlayer to next player around table
        int currentPlayer;
        
        if(currentDealer < 3) {
            
            currentPlayer = currentDealer++;
            
        }
        
        else {
            
            currentPlayer = 0;
            
        }
        
        //Assign each player 13 cards using iterator
        for(Iterator<Card> currentCard = deck.getCardDeck().iterator(); currentCard.hasNext(); ) {
            
            Card cCard = currentCard.next();
            
            //System.out.println("Dealing " + cCard.getFace() + " of " + cCard.getSuit());
            
            //System.out.println("Adding to " + table.get(currentPlayer).getName() + "'s hand.");
            
            table.get(currentPlayer).getHand().add(cCard);
            
            if(currentPlayer == 3) {
                
                currentPlayer = 0;
                
            }
            
            else {
                
                currentPlayer++;
                
            }
            
            currentCard.remove();
            
        }
        
    }
    
    //Print the player hand
    private void displayHands() {
        
        //Display teams, players, cards
        for(Team cTeam : teams) {
            
            /*System.out.println("---------");
            System.out.println("" + cTeam.getTeamName().toUpperCase());
            System.out.println("---------");*/
            
            for(Player cPlayer : cTeam.getTeam()) {
                
                //System.out.println("Sorting hand by suit and face.");
                cPlayer.sortCardsBySuit();
                
                if(cPlayer instanceof HumanPlayer) {
                    
                    cPlayer.displayHand();
                    
                }
                
            }
                    
        }
        
    }
    
    //Play the game
    private void play() {
        
        /*System.out.println("\n--------------");
        System.out.println("Play the game!");
        System.out.println("--------------\n");
        System.out.println("---------------");
        System.out.println("Get player bids");
        System.out.println("---------------\n");*/
        
        //Method call to get bids for all four players
        getBids();
        
    }
    
    //Get bids from players
    private void getBids() {
        
        int bidsPlaced = 0;
        
        int currentLead;
        
        //Define the lead player
        if(currentDealer < 3) {
            
            currentLead = ++currentDealer;
            
        }
        
        else {
            
            currentLead = 0;
            
        }
        
        lead = table.get(currentLead);
        
        //System.out.println("Lead player is " + lead.getName());
        
        //Allow the lead player to make their first bid if they are a human
        if(lead instanceof HumanPlayer) {
            
            HumanPlayer hp = (HumanPlayer)lead;
            hp.placeBid();
            
        }
        
        //Else allow the lead AI to make a bid
        else {
            
            AIPlayer ai = (AIPlayer)lead;
            ai.placeBid();
            
        }
        
        ++bidsPlaced;
        
        //Define the current player
        int currentPlayer;
        
        if(currentLead < 3) {
            
            currentPlayer = ++currentLead;
            
        }
        
        else {
            
            currentPlayer = 0;
            
        }
        
        //Define the next player to make a bid
        Player nextPlayer = table.get(currentPlayer);
        
        //Get remaining three player's bids
        while(bidsPlaced < Constants.NUMBER_OF_PLAYERS) {
            
            //System.out.println("\nGetting bid from " + nextPlayer.getName());
            
            if(nextPlayer instanceof HumanPlayer) {
                
                HumanPlayer hp = (HumanPlayer)nextPlayer;
                hp.placeBid();
                
            }
            
            else {
                
                AIPlayer ai = (AIPlayer)nextPlayer;
                ai.placeBid();
                
            }
            
            bidsPlaced++;
        
            if(currentPlayer < 3) {
            
                currentPlayer++;
            
            }
        
            else {
            
                currentPlayer = 0;
            
            }
            
            nextPlayer = table.get(currentPlayer);
            
        }
        
    }
    
    //Play hand
    private void playHand() {
        
    }
   
}
