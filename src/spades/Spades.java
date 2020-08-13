package spades;

/**
 *
 * @author piercetalbert
 */
import core.Game;
import javax.swing.JOptionPane;
import userinterface.GameUI;

public class Spades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        System.out.println("Welcome to Spades!");
        
        JOptionPane.showMessageDialog(null, "Let's Play Spades");
        
        Game game = new Game();
        GameUI ui = new GameUI(game);
        
    }
    
}
