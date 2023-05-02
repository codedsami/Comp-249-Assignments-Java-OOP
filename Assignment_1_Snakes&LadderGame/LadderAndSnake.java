/**
 * Assignment 01
 * COMP-249
 * Snakes And Ladders Game
 * Written by: 
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 06 February 2023
 */
//This is snake and ladder game. It has multiple snakes and ladders where players change positions. There is also a rule that 
//two players can not stay in the same square. If it arrives then lastly arrived player kicks out the other player.
//A player needs to reach exactly the position 100 in order to win the game.

/**
 * Importing scanner class
 */
import java.util.Scanner;

/**
 * @author Yan Pilon
 * @author Miskat Mahmud
 * @version 06 February 2023
 */
public class LadderAndSnake { 	
//attributes	
/**
 * An array of players of type Players (from Players class)
 * A 2D string array that is used to set up the board	
 */
private Players [] players;
private String [][] board = new String [10][10];
Scanner scan = new Scanner(System.in);


//constructor
/**
 * The constructor that sets the player number. If it is less than 2, the program terminates, else the player number is set to two.
 * @param numPlay; this parameter takes the player's number from user input, if the entered number is more than 0
 * user gets a warning message and the player's number is automatically set to 2,
 * However, if the entered number is less than 2, the program terminates following a message.
 * This constructor also sets the length for the players array which is used later in the program.
 */
public LadderAndSnake(int numPlay) {	
	players = new Players[numPlay];
	for(int i=0; i<numPlay ;i++) {
		players[i]= new Players("Player "+(i+1));
	}
}


/**
 * This method takes the first player's
 *  name through a scanner.
 */
public void takeName1() {
	System.out.print("\nPlease enter player 1's name: ");
    String newname = scan.nextLine();
    players[0].setName(newname);
   
}

/**
 * This method takes the seconds player's 
 * name through a scanner.
 */
public void takeName2() {
	System.out.print("Please enter player 2's name: ");
    String newname = scan.nextLine();
    players[1].setName(newname);
   
    System.out.println();
}




//Game engine/loop
/**
 * This method initiates the core engine of the game. At first it determines the order of play based on players
 * rolling a higher number. An array is created where each index is looped in order to give both players a chance to roll the dice.
 * Then it displays the number of attempts it took the determining the order of play through an use of counter.
 * Then the program prompts user to press ENTER in order to roll the dice and continue playing.
 * 
 * The integer value from the flipdice() method is taken and both player's position are updated in the 2D array accordingly.
 * The method also verifies if a player has reached the bottom of a ladder or the head a snake.
 * Arrays of Ladders and Snakes were created and the loop iterates to verify if a player reached the position of a ladder or snake.
 * If that's the case then the players' positions are changed according to the board given in the assignment.
 * 
 * The method also checks if two players occupies the same position, and if this occurs, then the player who reach the position last
 * kicks out the other player back to 0. The other player will then restart the game from that position.
 * 
 * The program also checks if a player has gone over 100, if that occurs then the player goes back the excessive amount and player's position
 * is updated accordingly in the board array. 
 * 
 * The playing board is printed after every move and it displays the players' position on the board.
 * 
 */
public void play() {
	
initBoard();
	
//choosing player	
System.out.println("Let The Game Begin!!\n\nLet's first roll a dice to determine \nthe order in which the players will play:\n");

int []turnp= new int[players.length];

for(int i=0; i<players.length; i++) {
	System.out.print("Press enter to roll a dice: ");
	scan.nextLine();
	turnp[i] = flipdice();
	if(i==0) {
	System.out.println(players[0].getName() + " rolled a " + turnp[0]);}
	else if(i==1) {
    System.out.println(players[1].getName() + " rolled a " + turnp[1]);}
	System.out.println();
}


int count = 1;
while(turnp[0]==turnp[1]) {
	System.out.println("A tie was achieved between " +  players[0].getName() + " and "  + players[1].getName() +  ". Attempting to break the tie..\nPlease roll again");

	for(int i=0; i<players.length; i++) {
		System.out.print("press enter to continue: ");
		scan.nextLine();
		turnp[i] = flipdice();
		if(i==0) {
		System.out.println(players[0].getName() + " rolled a " + turnp[0]);}
		else if(i==1) {
		System.out.println(players[1].getName() + " rolled a " + turnp[1]);}	
	}
	count++;

}

System.out.println(players[0].getName()+" rolled a "+turnp[0] +" and "+players[1].getName()+" rolled a " + turnp[1]);
int turn;
System.out.println("\nReached final decision on order of playing: ");
if(turnp[0]>turnp[1]) {
	System.out.print(players[0].getName()+" then " +players[1].getName() );
	
	turn=1;
}
else {
	System.out.print(players[1].getName()+" then " +players[0].getName());
	turn=2;
}

System.out.println( ". It took " + count + " attempt(s)\r\nbefore a "
		+ "decision could be made.\n");
System.out.println("You can check your positions on the printed board.");
//end of choosing player


boolean win = false;
int playerplaying = 0;
int diceflip;
int goBack;


//start of game loop 
while(win==false){	

	if((turn%2)==0) {
	playerplaying=1;
	}
	
	else {
	playerplaying=0;
	}
	
	board[players[playerplaying].positiony][players[playerplaying].positionx]=Integer.toString(players[playerplaying].position);
	
	//prompting the user
	System.out.print("Press enter to continue: ");
	scan.nextLine();
	diceflip = flipdice();
	
	//reset boards position number
	//update position of the player
	if(players[playerplaying].position==0) {
		players[playerplaying].positionx-=1;
		
	}
	
	//to go back excessive amount
	int extra1 = 100 - players[playerplaying].position;

	
	players[playerplaying].position+=diceflip;
	players[playerplaying].positionx+=diceflip;
	
	
	//print out result
    System.out.println(players[playerplaying].getName() + " rolled a "+diceflip);
    
    if(players[playerplaying].position>100) {
		int extra2 = players[playerplaying].position-100;
		System.out.println("Oops! You only needed a " + extra1 + " to win the game.\n"
				+          "but, you rolled a " + diceflip 
				+          "\nSo, you will go back " + diceflip + "-" + extra1 + " = " + extra2 + " square(s) from 100.");
		}
	
	
	
	
	//Checks if player went over 100
	if(players[playerplaying].position>100) {
	    goBack= (players[playerplaying].position-100)*2;
		players[playerplaying].position-=goBack;
		players[playerplaying].positionx-=goBack;
	}
	
	//prints the updated position
	System.out.println("\nYour position is now "+ players[playerplaying].position +"\n");

	
	//change y position if x is > 10
	if(players[playerplaying].positionx>9) {
		players[playerplaying].positionx=players[playerplaying].positionx-10;
		players[playerplaying].positiony+=1;
	}
	

    
	
	//checks for Ladders
 	 int [] LadderPos    = {1,4,9,21,28,36,51,71,80}    ; //position array
	 int [] LadderPosX   = {7,3,0,1,3,3,6,0,9}          ; //x-axis array
	 int [] LadderPosY   = {3,1,3,4,8,4,6,9,9}          ; //y-axis array
	 int [] LadderPosNew = {38,14,31,42,84,44,67,91,100}; //new position array
	 
	 for(int i = 0; i<LadderPos.length; i++) {
		 if(players[playerplaying].position == LadderPos[i]) {
				players[playerplaying].positionx = LadderPosX[i];
				players[playerplaying].positiony = LadderPosY[i];
				players[playerplaying].position = LadderPosNew[i];
	    		System.out.println("YAY! Climbed a ladder :)\nYour new position is : " + players[playerplaying].position );
	    		
				} 
		 if(players[playerplaying].position == 100) {
	    		
	    		System.out.println(players[playerplaying].getName() + " won the Game!!");
	    		System.exit(0);}
	    	}

	 //checks for Snakes
	 int [] SnakePos    = {16,48,64,79,93,95,97,98};  //position array
	 int [] SnakePosX   = {6,9,9,8,7,3,5,7};          //x-axis array
	 int [] SnakePosY   = {5,2,5,1,6,2,7,7};          //y-axis array
	 int [] SnakePosNew = {0,30,60,19,68,24,76,78};   //new position array
	 
	 for(int i = 0; i<SnakePos.length; i++) {
		 if(players[playerplaying].position == SnakePos[i]) {
				players[playerplaying].positionx = SnakePosX[i];
				players[playerplaying].positiony = SnakePosY[i];
				players[playerplaying].position = SnakePosNew[i];
		   	   System.out.println("Oops! Got bitten by a snake :(\nYour new position is : " + players[playerplaying].position );
				}
	 }
    
    
  //check if players are on the same place
    if(players[0].position==players[1].position&&(turn%2==0)) { //player 2 kicks outs player 1
    	players[0].position = 1;
    	players[0].positionx = 0;
    	players[0].positiony = 0;
  	    System.out.println(players[0].getName()+" got kicked back to square 1!");
    }
    else if(players[0].position==players[1].position&&(turn%2!=0)) { //player 1 kicks outs player 2
    	players[1].position = 1;
    	players[1].positionx = 0;
    	players[1].positiony = 0;
  	    System.out.println(players[1].getName()+" got kicked back to square 1!");
    }
    
    //Displays position on the printed board
    board[players[playerplaying].positiony][players[playerplaying].positionx]=players[playerplaying].playerToken();

    //check if a player won
    if(CheckWin()) {
    break;
    	}
    
    //switching turns
	turn+=1;
	
	//calling the method that prints the board
	printboard();
	
}

//final result
System.out.println(players[playerplaying].getName()+" won the Game!!");

//closing the scanner
scan.close();

}
//end of game loop



//initialize the board array
private void initBoard() {
	int b = 1;
	for(int i=0; i<10; i++) {
		for(int j=0; j<10; j++) {
			board[i][j]= Integer.toString(b);
			b++;
		}
	}
	
}


//dice method

/**
 * The value between 1-6 are generated by using Math.random
 * @return this method flips the dice and return the obtained value
 */
public int flipdice() {	
	int diceflip=0;
	while(diceflip==0){
		diceflip = (int) (Math.random()*7);
	}
	return diceflip;
}




//Checks if a player has reached position 100

/***
 * 
 * This method verifies when a player has reached the winning position if yes conditions are executed in the play method
 * @return whether a player reached the winning position
 */
public boolean CheckWin() {
	if (players[0].position==100||players[1].position==100){
		return true;
	}
	else return false;
}




/***
 * 
 * This method is called to print the board after every turn
 */
public void printboard() {
	System.out.println("\n-------------------------------");
	for(int i=9;i>=0;i--)	{
		System.out.print("|");
		if(i%2==0) {
			for(int j = 0; j<=9;j++) {
				if(j<9&&i==0) 
				{System.out.print("0");}
				 System.out.print(board[i][j]+"|");
			}
		}
		
		else {
			for(int j = 9; j>=0;j--) {
				System.out.print(board[i][j]+"|");
			}
		}
		System.out.println("\n-------------------------------");
	}	
}

	
}
	

