/**
 * Assignment 01
 * COMP-249
 * Snakes And Ladders Game
 * Written by: 
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 06 February 2023
 */

/**
 * Importing Scanner Class
 */
import java.util.Scanner;

/**
 * @author Yan Pilon
 * @author Miskat Mahmud
 * @version 04 February 2023
 */	
public class PlayLadderAndSnake {
	
	

	//Driver file
	/**
	 * Driver file that runs the game
	 * @param args initializing main method
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Welcome message
		System.out.println("$$ Welcome to the Yan Pilon and Miskat Mahmud's Snakes and Ladders game! $$\n\n"+
	    "Please enter amount of players:"); //asking for input
		
		/**
		 * Verifies whether right input is entered
		 */
		while(!scan.hasNextInt()) {
			System.out.println("Invalid input, please try again.");
			scan.next();
		}
		
		/**
		 * variable that is used for the constructor of LadderAndSnake class
		 * It sets the players' number
		 */
		int numPlay = scan.nextInt();
		
		if (numPlay<2) {
			System.out.println("Error: Cannot execute the game with less than 2 players!\nWill exit");			
			System.exit(0);
		}
		else if(numPlay>2) {
			System.out.println("Initialization was attempted for " + numPlay +" member of players; however, this is only\r\n"
					+ "expected for an extended version the game. Value will be set to 2");	
			numPlay = 2;
		}
		
		//creating a LadderAndSnake object
		LadderAndSnake game = new LadderAndSnake(numPlay);
		
		//Taking the names of the players
		game.takeName1();
		game.takeName2();
		
		//Initiates the game 
		game.play();
		scan.close();
		
		
		
	}

}
