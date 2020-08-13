package core;

import java.util.ArrayList;

public class Team {
    
    //member variables
    private ArrayList<Player> team;
    private int bid;
    private int score;
    private int tricks;
    private int bags;
    private String teamName;
    
    //custom constructor
    public Team() {
        
        team = new ArrayList();
        
    }
    
    /**
     * @return the team
     */
    public ArrayList<Player> getTeam() {
        
        return team;
        
    }

    /**
     * @param team the team to set
     */
    public void setTeam(ArrayList<Player> team) {
        
        this.team = team;
        
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
     * @return the tricks
     */
    public int getTricks() {
        
        return tricks;
        
    }

    /**
     * @param tricks the tricks to set
     */
    public void setTricks(int tricks) {
        
        this.tricks = tricks;
        
    }

    /**
     * @return the bags
     */
    public int getBags() {
        
        return bags;
        
    }

    /**
     * @param bags the bags to set
     */
    public void setBags(int bags) {
        
        this.bags = bags;
        
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        
        return teamName;
        
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        
        this.teamName = teamName;
        
    }

}
