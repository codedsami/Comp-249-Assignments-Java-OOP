/**
 * Assignment 01
 * COMP-249
 * Snakes And Ladders Game
 * Written by: 
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 06 February 2023
 */



public class Players {
	
	/**
	 * @author Yan Pilon
	 * @author Miskat Mahmud
	 * @version 06 February 2023
	 */	

	//attributes that are used in board array
	/**
	 * Attribute for the x-axis for a player's position in the board array
	 */
	public int positionx=0;
	
	/**
	 * Attribute for the y-axis for a player's position in the board array
	 */
	public int positiony=0;
	
	/**
	 * Attribute for the  player's position in the board array
	 */
	public int position=0;
	
	/**
	 * Attribute the players's name
	 */
	public String PlayerName;
	
	
	/**
	 * This method is used to set the player's name
	 * @param name, This parameterized constructor is used in the class LadderAndSnake that sets the name in the players array
	 */
	public Players(String name) {
		this.PlayerName= name;
	}
	
	//accessors
	
	/**
	 * In order to get the name of each player
	 * @return the players' name when needed
	 */
	public String getName() {
		return this.PlayerName;
	}
	
	
	/**
	 * to get the position of a player in x axis
	 * @return returns the players' position on x-axis
	 */
	public int getx() {
		return this.positionx;
	}
	
	/**
	 * to get the position of a player in y axis
	 * @return returns the players' position on y-axis
	 */
	public int gety() {
		return this.positiony;
	}
	
	/**
	 * to get the position of the player in the board
	 * @return returns the players' position 
	 */
	public int getPosition() {
		return this.position;
	}
	
	/**
	 * This method helps to print the first two letters of a player's name on printed board
	 * @return the first two letter of the players' names that is displayed on the printed board
	 */
	public String playerToken() {
		return(PlayerName.substring(0, 2).toUpperCase());
	}
	
	//mutators
	
	/**
	 * It is used to set each player's name
	 * @param name, that take the players' name and set it up in LadderAndSnake class
	 */
	public void setName(String name) {
		this.PlayerName = name;
	}

	
}
