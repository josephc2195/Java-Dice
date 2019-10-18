/**
 * Write a description of class Sequences here.
 * 
 * @author (Joseph Chica) 
 * @version (7-27-2016)
 * Lab 9
 */
import java.util.*;

public class Sequences
{
    
    Die[] dice;
    String[] playerNames;
    int[] playerScores;
    Scanner kb = new Scanner(System.in);
    public Sequences(String[] names)
    {
        playerNames = names;                    // Assign the parameter name array to the field
        playerScores = new int[names.length];   // Instantiate an array to store total scores for each player
        dice = new Die[6];                      // Instantiate an array of 6 Die
        for (int d = 0; d < 6; d++)
        {
            dice[d] = new Die();
        }
    }
    
    public void rollDice(int playerIndex)
    {
        // Roll the dice and print the result of the roll
        for (int d = 0; d < 6; d++)
        {
            dice[d].roll();
            System.out.println(dice[d]);
        }
        
        // Determine the roll score:
        int rollScore;
        
        /* Check to see if the player rolled 3 or more ones, and if so, reset the player's
         * total score to 0. */
        if (hasThreeOnes())
        {
            rollScore = 0;
            playerScores[playerIndex] = 0;
        }
        // If the player did not roll 3 ones, get the score from the number of dice in sequence
        else
        {
            switch (getSequence())
            {
                case 1: rollScore = 5; break;
                case 2: rollScore = 10; break;
                case 3: rollScore = 15; break;
                case 4: rollScore = 20; break;
                case 5: rollScore = 25; break;
                case 6: rollScore = 35; break;
                default: rollScore = 0; 
            }
        }
        
        // Add the roll score to the player's total score
        playerScores[playerIndex] += rollScore;
        
        // Print the player's roll score
        System.out.println(getPlayerName(playerIndex) + " scored " + rollScore + " points.");
        kb.nextLine();
        
    }
    
    private boolean hasThreeOnes()
    {
        int numOnes = 0;    // Counter for the number of 1s in the roll
        
        /* Check the value of each Die in the roll using the getFace() method in the Die class.
         * For each 1 that is found, increment the counter */
        for (int i = 0; i < dice.length; i++)
        {
            if (dice[i].getFace() == 1)
                numOnes++;
        }
        
        if (numOnes >= 3)   // If there are 3 or more ones in the roll, returns true
            return true;
        else                // Otherwise, returns false
            return false;
    }
    
    private int getSequence()
    {
        int numInSequence = 0;      // Counter for the number of Die in sequence
        boolean foundNumber = true; // Flag to store if the number to look for is found
        
        /* Check the Die for each number in the sequence starting with 1. If a 1 is found,
         * then check for 2 and so on until a number in the sequence is not found. Once a
         * number is not found, the loop will end. */
        for (int num = 1; num <= 6 && foundNumber; num++)
        {
            foundNumber = false;    // Set the flag to false
            for (int i = 0; i < dice.length; i++)
            {
                // Check to see if the number is found in the Die array
                if (dice[i].getFace() == num)
                {
                    foundNumber = true;
                }
            }
            // If the number was found, increment the counter
            if (foundNumber)
            {
                numInSequence++;
            }
        }
        
        return numInSequence;
    }
    
    public boolean gameWon()
    {
        boolean winner = false; // Set the winner flag to false
        
        // Check all the player scores for a score of 100 or more
        for (int i = 0; i < playerScores.length; i++)
        {
            if (playerScores[i] >= 100)
                winner = true;
        }
        
        return winner;
    }
    
    public String getPlayerName(int playerIndex)
    {
        return playerNames[playerIndex];
    }
    
    public int getPlayerScore(int playerIndex)
    {
        return playerScores[playerIndex];
    }
}
