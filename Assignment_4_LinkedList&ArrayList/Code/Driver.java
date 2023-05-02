// -----------------------------------------------------
 /**
 * Assignment 04
 * COMP-249
 * Written by: 
 * Miskat Mahmud (40250110)
 * Yan Pilon (40246124)
 * Due Date: 17 March 2023
 */
// -----------------------------------------------------
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Yan Pilon, Miskat Mahmud
 * @version 1
 */
public class Driver {
	
	/**
	 * create booklist and runs user interface which allows user to manipulate the booklist
	 * @param args .
	 */
	public static void main(String[] args) {
		
		ArrayList<Book> arrLst = new ArrayList<>();
		BookList bkLst = new BookList();
		bkLst.handlingBadYear(arrLst);
		
		
		//for case4
		//Book b1 = new Book("The Dark Road", "Jimin S.", 25.92, "1239009879", "FCN", 2019);
		
		
		
		// start of dealing with good book records
		Scanner kb = new Scanner(System.in);
		//int n = bkLst.size();
		//System.out.println(n);
		bkLst.displayContent();
		System.out.println();
		while(true) {
			//bkLst.displayContent();
		    System.out.println("Tell me what you want to do? Let's Chat since this is trending now! Here are the options:");
		    System.out.println("         1) Give me a year # and I would extract all records of that year and store them in a file for that year;\r\n"
		                     + "         2) Ask me to delete all consecutive repeated records;\r\n"
		                     + "         3) Give me an author name and I will create a new list with the records of this author and display them;\r\n"
		                     + "         4) Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN;\r\n"
		                     + "         5) Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them!\r\n"
		                     + "         6) Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist!\r\n"
		                     + "         7) Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books;\r\n"
		                     + "         8) Tell me to STOP TALKING. Remember, if you do not commit, I will not!");
		    System.out.print("Enter your selection: ");
		    
		    int userInput;

		    while(true) {
		        try {
		            userInput = kb.nextInt();  //userInput
		            break; // break out of the inner loop after successful input
		        }
		        catch(InputMismatchException e ) {
		            System.out.println("Please enter a valid input");
		            kb.next();  //userInput
		            continue;
		        }
		    }

		    switch(userInput) {
		        case 1:{
		            System.out.print("Enter a year: ");
		            String userInputYear = kb.next();
		            while(true) {
		                try {
		                    int year = Integer.parseInt(userInputYear);
		                    bkLst.storeRecordsByYear(year);
		                    break;
		                }
		                catch(NumberFormatException e) {
		                    System.out.println("Please enter a valid year(number value): ");
		                    userInputYear = kb.next();  //userInput
		                }
		            }
		            
		            bkLst.displayContent();
		            System.out.println();
		            break; // break out of the switch statement
		        }
		        case 2:{
		           bkLst.delConsecutiveRepeatedRecords();
		           bkLst.displayContent();
		            break; // break out of the switch statement
		        }
		        case 3:{
		            System.out.print("Enter a the name of the author to create an extracted list: ");
		            kb.nextLine();
		            String author = kb.nextLine();
		           bkLst.extractAuthList(author);
		            break; // break out of the switch statement
		        }
		        case 4:{
		    		
		        	 System.out.print("Enter a long isbn: ");
			            String userInputIsbn = kb.next();
			            String disp1 = kb.nextLine();//edit 1 yan
			            while(true) {
			                try {
			                    Long isbn = Long.parseLong(userInputIsbn);			                  
			                    System.out.print("Enter the title name of the book you wish to add: ");
			                    String title = kb.nextLine();			                 
			                    System.out.print("Enter the author's name: ");
			                    String author = kb.nextLine();
			                    System.out.print("Enter the price (must be a number value): ");
			                    while(!kb.hasNextDouble()) {//edit 2 yan
			            			System.out.println("Invalid price, please try again.");
			            			kb.next();
			            		}
			                    double price = kb.nextDouble();
			                    System.out.print("Enter the ISBN: ");
			                    String ISBN = kb.next();
			                    System.out.print("Enter the genre: ");
			                    String genre = kb.next();
			                    System.out.print("Enter the year (must be an integer value): ");
			                    while(!kb.hasNextInt()) {
			                    	System.out.println("Invalid year, please try again.");
			            			kb.next();
			                    }
			                    int year = kb.nextInt();
			                    Book b1 = new Book(title, author, price, ISBN, genre, year);
			                    bkLst.insertBefore(isbn, b1);
			                    
			                    break;
			                }
			                catch(NumberFormatException e) {
			                    System.out.println("Please enter a valid isbn(number value): ");
			                    userInputIsbn = kb.next();  //userInput
			                }
			            }
			            bkLst.displayContent();
			            System.out.println();
		            break; // break out of the switch statement
		        }
		        case 5:{
		        	System.out.print("Enter 1st long isbn: ");
		            String userInputIsbn1 = kb.next();
		        	System.out.print("Enter 2nd long isbn: ");
		            String userInputIsbn2 = kb.next();
		            String disp2 = kb.nextLine();//edit 3 yan
		            while(true) {
		                try {
		                    Long isbn1 = Long.parseLong(userInputIsbn1);
		                    Long isbn2 = Long.parseLong(userInputIsbn2);
		                    System.out.print("Enter the title name of the book you wish to add: ");
		                    String title = kb.nextLine();
		                    System.out.print("Enter the author's name: ");
		                    String author = kb.nextLine();
		                    System.out.print("Enter the price (must be a number value): ");
		                    while(!kb.hasNextDouble()) {
		            			System.out.println("Invalid price, please try again.");
		            			kb.next();
		            		}
		                    double price = kb.nextDouble();
		                    System.out.print("Enter the ISBN: ");
		                    String ISBN = kb.next();
		                    System.out.print("Enter the genre: ");
		                    String genre = kb.next();
		                    System.out.print("Enter the year (must be an integer value): ");
		                    while(!kb.hasNextInt()) {
		                    	System.out.println("Invalid year, please try again.");
		            			kb.next();
		                    }
		                    int year = kb.nextInt();
		                    Book b1 = new Book(title, author, price, ISBN, genre, year);
		                    bkLst.insertBetween(isbn1, isbn2, b1);
		                    
		                    break;
		                }
		                catch(NumberFormatException e) {
				        	System.out.print("Enter 1st valid long isbn: ");
		                    userInputIsbn1 = kb.next();  //userInput
				        	System.out.print("Enter 2nd valid long isbn: ");
		                    userInputIsbn2 = kb.next();
		                }
		            }
		            
		            bkLst.displayContent();
		            System.out.println();
		            break; // break out of the switch statement
		        }
		        case 6:{
		        	System.out.print("Enter 1st long isbn: ");
		            String userInputIsbn1 = kb.next();
		        	System.out.print("Enter 2nd long isbn: ");
		            String userInputIsbn2 = kb.next();
		            while(true) {
		                try {
		                    Long isbn1 = Long.parseLong(userInputIsbn1);
		                    Long isbn2 = Long.parseLong(userInputIsbn2);

		                    bkLst.swap(isbn1, isbn2);
		                    
		                    break;
		                }
		                catch(NumberFormatException e) {
				        	System.out.print("Enter 1st valid long isbn: ");
		                    userInputIsbn1 = kb.next();  //userInput
				        	System.out.print("Enter 2nd valid long isbn: ");
		                    userInputIsbn2 = kb.next();
		                }
		            }
		            
		            bkLst.displayContent();
		            System.out.println();
		            break; // break out of the switch statement
		        }
		        case 7:{
		            bkLst.commit();
		            bkLst.displayContent();
		            break; // break out of the switch statement
		        }
		        case 8: {
		            System.out.println("Thank you, program will exit now.");
		            System.exit(0);
		        }
		        default: {
		            System.out.println("Invalid input, please try again.");
		            break; // break out of the switch statement
		        }
		    }
		   // kb.close();
		}// exit the program after the outer loop
	}

}
