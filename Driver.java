import java.util.*;
/**
 * Write a description of class Driver here.
 * 
 * @author (Joseph Chica) 
 * @version (7-27-2016)
 * Lab 9
 */
public class Driver
{
 public static void main (String[]args)
    {
        Scanner kb = new Scanner(System.in);    // Scanner for keyboard input
        Sequences seq;                          // Game object
        int numPlayers;                         // The number of players for the game
        String[] players;                       // Array of player names to pass to constructor
        int[] numWins;                          // Array to store the number of times each player has won
        char newGame = 'Y';                     // Character to store if a new game should be started
        int numGamesPlayed = 0;                 // Counter to store the number of games played
        
        // Get the number of players for the game
        System.out.print("Enter the number of players: ");
        numPlayers = kb.nextInt();
        kb.nextLine();              // Clear the input stream
        
        // Instantiate the player arrays based on the number of players
        players = new String[numPlayers];
        numWins = new int[numPlayers];
        
        // Get the player names
        for (int i = 0; i < players.length; i++)
        {
            System.out.print("Enter Player " + (i+1) + "'s Name: ");
            players[i] = kb.nextLine();
        }
        
        // Play the game
        while (newGame == 'y' || newGame == 'Y')
        {
            seq = new Sequences(players);   // Instantiate a new game
            
            // Roll the dice for each player until a player wins
            while (!seq.gameWon())
            {
                for (int p = 0; p < players.length; p++)
                {
                    System.out.println(seq.getPlayerName(p) + "'s Roll:");
                    seq.rollDice(p);
                    
                    // If the current player won the game, print a winner message, tally the win, and break from the loop
                    if (seq.gameWon())
                    {
                        System.out.println(seq.getPlayerName(p) + " won the game!");
                        numWins[p]++;
                        break;
                    }
                }
               // System.out.println();   // Line break
                
                // Print the total scores
                for (int p = 0; p < players.length; p++)
                {
                    System.out.println(seq.getPlayerName(p) + "'s Total Score: " + seq.getPlayerScore(p));
                }
                
                System.out.println();   // Line break
            }
            
            // Increment the number of games played and print it
            numGamesPlayed++;
            System.out.println("Number of games played: " + numGamesPlayed);
            
            // Print each player's total wins
            for (int p = 0; p < players.length; p++)
            {
                System.out.println(seq.getPlayerName(p) + " has won " + numWins[p] + " games.");
            }
            
            // Get if the user would like to play another game
            System.out.println();   // Line break             
            System.out.print("Would you like to play again? [Y/N]: ");
            newGame = kb.next().charAt(0);
        }
    }
}
