package core;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public Card playCard() {
        
        return null;
        
    }
    
    //Place bid user
    public int placeBid() {
        
        //System.out.println(super.getName() + " please place your bid");
        
        Scanner in = new Scanner(System.in);
        
        int userBid = in.nextInt();
        
        if(userBid < 1) {
            
            //System.out.println("You must bid at least one trick.");
            userBid = 1;
            
        }
        
        super.setBid(userBid);
        
        return super.getBid();
        
    }
    
}
