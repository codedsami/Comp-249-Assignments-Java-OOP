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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Yan Pilon, Miskat Mahmud
 * @version 1
 */
public class BookList {

	//handling the bad years
	/**
	 * purges list of all members with invalid year value
	 * @param arrList Book ArrayList to be cleared of all records with bad years
	 */
	public void handlingBadYear(ArrayList<Book> arrList) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("Books.txt"));
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				String[] bookArr = s.split(",");

				double price = Double.parseDouble(bookArr[2]);
				int year = Integer.parseInt(bookArr[5]);

				Book B = new Book(bookArr[0], bookArr[1], price, bookArr[3], bookArr[4], year);

				if(year > 2023) {
					arrList.add(B);
				}
				else {
					addToStart(B);

				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found. Will exit");
			System.exit(0);
		}
		finally {
			sc.close();
			readingArrayList(arrList); //this is the part where books get written into file
		}

	}

	//reading the arraylist and creating the file with bad years
	private void readingArrayList(ArrayList<Book> arrList) {
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileOutputStream("YearErr.txt"));
			System.out.println("YearError File Created");
			for(Book b: arrList) {
				pw.println(b);
			}
		}
		catch(Exception e) {
			System.out.println("Error writing to the file.");
		}
		finally {
			pw.close();
		}
	}

	//end of handling the bad years




	//start of inner class
	private class Node{
		private Book b;
		private Node next;

		//default constructor for Node Class
		public Node() {
			b = null;
			next = null;
		}

		//parameterized constructor
		public Node(Book book, Node xt) {
			b = book;
			next = xt;
		}

		// public Node(Book b) {
		// this.b = b;
		// this.next = head;
		// }

		//copy constructor
		public Node(Node n) {
			b = n.b.clone();
			next = n.next;
		}


	} // end if inner class

	private Node head;

	/**
	 * default constructor
	 */
	public BookList() {
		head = null;
	}


	// public boolean isEmpty() {
	//        return head == null;
	//    }

	/**
	 * Adds book at the start of the circular list
	 * @param b Book to be added
	 */
	public void addToStart(Book b) {
		Node n = new Node(b, head);
		if (head == null) {
			head = n;
			n.next = head;
		}

		Node t = head;
		while(t.next != head)
			t = t.next;


		t.next = n;
		n.next = head;
		//n = null;

	}

	private void addToEnd(Node n) {
		Node c = head;
		Node tail = head;

		if (c == null) {
			return;
		}

		while (c != n && c.next != head) {
			tail = c;
			c = c.next;
		}

		if (c == head) {
			tail = c;
			c = c.next;
		}

		tail.next = c;
		head = c.next;
		c.next = head;
	}



	// public void circularList() {
	// if(head == null) {
	// System.out.println("List is empty");
	// return;
	// }
	//
	// Node temp = head;
	// while(temp.next != null) {
	// temp = temp.next;
	// }
	// temp.next = head;
	// }

	/**
	 * Takes all record of same year and stores them in text file with the year as its name
	 * @param yr year of the records to be stored in a file
	 */
	public void storeRecordsByYear(int yr) {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}


		Node temp = head;
		boolean yearExists = false;
		do {
			if(yr == temp.b.getYear()) {
				yearExists = true;
				String year = String.valueOf(yr);
				try(PrintWriter pw = new PrintWriter(new FileOutputStream(year + ".txt", true))){
					pw.println(temp.b);

				}
				catch(Exception e) {
					System.out.println("error creating year file, nothing will be created");
					return;
				}
			}

			temp = temp.next;
		} while (temp != head);



		if(!yearExists) {
			System.out.println("No book exists from the year of " + yr +". No file will be created");
			return;}
		else {
			System.out.println("There are available books from " + yr + ". The file " + yr + ".txt has been created." );

		}

		System.out.println();
	}
	
/**
 * takes book object and inserts it before member of the list with corresponding ISBN 
 * @param isbn ISBN of the book where the new book should be inserted
 * @param b book to be added
 * @return true if everything went well and false if there was an error 
 */
	public boolean insertBefore(long isbn, Book b) {
		if(head == null) {
			System.out.println("List is empty.");
			return false;
		}


		if(Long.valueOf(head.b.getIsbn()) == isbn) {
			head = new Node(b, head);
			return true;
		}

		Node temp = head;
		while(temp.next != head && Long.valueOf(temp.next.b.getIsbn()) != isbn) {
			temp = temp.next;

			if(temp.next == head) {
				System.out.println("No book in the list has the given isbn.\n");
				return false;
			}
		}

		temp.next = new Node(b, temp.next);
		System.out.println("Insertion successful before the given isbn\n");
		return true;

	}

	
	/**
	 * Takes book object and inserts it in the list between two members of the list with corresponding ISBN
	 * @param isbn1 ISBN first book
	 * @param isbn2 ISBN second book
	 * @param b book to be inserted
	 * @return true if everything went well and error if there was an error
	 */
	public boolean insertBetween(long isbn1, long isbn2, Book b) {
		if(head == null) {
			System.out.println("The list is empty, no insertion");
			return false;
		}

		Node first = head;
		Node second = head.next;
		//Long nextIsbn1;
		while(first.next != head && Long.valueOf(first.next.b.getIsbn()) != isbn1 && Long.valueOf(second.next.b.getIsbn()) != isbn2) {
			first = first.next;
			second = first.next;

			if(second.next == head) {
				System.out.println("Atleast one of the isbn is not available in the book list.\n");
				return false;
			}
		}
		second.next = new Node(b, second.next);
		System.out.println("Insertion successful between the given isbns.\n");
		return true;
	}

	/**
	 * Return size of the circular list
	 * @return size of the list
	 */
	public int size() {
		int ctr = 1;
		Node N = head;
		if(N == null) {
			return 0;
		}
		while(N.next != head) {
			ctr++;
			N = N.next;
		}
		return ctr;

	}

	/**
	 * goes through the book circular list and prints each object
	 */
	public void displayContent() {
		Node temp = head;
		int ctr = 0;
		if(head == null) {
			System.out.println("There is nothing to display; list is empty.");
			return;
		}
		System.out.println("Here are the contents of the list"
				+        "\n=================================");

		do {
			ctr++;
			System.out.println(temp.b + "==>");
			temp = temp.next;
		} while(temp != head);

		System.out.println("===> head");
		System.out.println("Total number of books: " + ctr);
	}

/**
 * Deletes consecutive repeated records on the circular list
 * @return
 */
 boolean delConsecutiveRepeatedRecords() {
		if (head == null) {
			System.out.println("List is empty");
			return false;
		}

		Node first = head;
		Node second = head.next;
		boolean deleted = false;
		Node last = head;
		while (second != head) {
			if (first.b.getIsbn().equals(second.b.getIsbn())) {
				first.next = second.next;
				second = first.next;
				deleted = true;
			} else {
				first = second;
				second = second.next;
			}
			last = first;
		}
		
		
		if (head.b.getIsbn().equals(last.b.getIsbn())) {
	       if (!head.b.getIsbn().equals(head.next.b.getIsbn())) {
	            head = head.next;
	            last.next = head;
	            deleted = true;
	       }
	   }

		return deleted;
	}

	
	
	/**
	 * Goes through each list member and extracts the author String
	 * @param aut author of which the books should be extracted
	 * @return Booklist if everything went well Null if there was an error
	 */
	public BookList extractAuthList(String aut) {
		if(head == null) {
			System.out.println("List is empty.");
			return null;
		}


		Node temp = head;
		//boolean authorExists = false;
		int count = 0;
		BookList B = new BookList(); 
		do {
			if(aut.equals(temp.b.getAuthors())) {
				Book sameAuthorBooks = new Book(temp.b);
				B.addToStart(sameAuthorBooks);
				count++;
			}

			temp = temp.next;
		} while (temp != head);

		if(count > 0) {
		System.out.println("Here are the booklist of " + aut);
		B.displayContent();
		System.out.println();

		return B;
		}
		else {
			System.out.println("No book exists with this author name.");
			return null;
		}


	}
	
	
/**
 * takes two members of the list and swaps their positions on the list	
 * @param isbn1 ISBN of first book
 * @param isbn2 ISBN second book
 * @return false if there was a mistake or true if everything went well
 */
	public boolean swap(long isbn1, long isbn2) {
	    if (head == null) {
	        System.out.println("List is empty");
	        return false;
	    }
	    
	    if(isbn1 == isbn2) {
	    	System.out.println("Same isbn");
	    	return false;
	    }
	    

	    //checking if isbn1 is available in any of the book
	    Node prevIsbn1 = null; 
	    Node currIsbn1 = head;
	     do{
	    	 prevIsbn1 = currIsbn1;
	    	 currIsbn1 = currIsbn1.next;
	    	 
	    }while(currIsbn1 != head && Long.valueOf(currIsbn1.b.getIsbn()) != isbn1);
	     
	     
	     //checking if isbn2 is available in any of the book
		    Node prevIsbn2 = null; 
		    Node currIsbn2 = head;
		     do{
		    	 prevIsbn2 = currIsbn2;
		    	 currIsbn2 = currIsbn2.next;
		    	 
		    }while(currIsbn2 != head && Long.valueOf(currIsbn2.b.getIsbn()) != isbn2);
		     
		     
		     
		     //not found condition
		     if (Long.valueOf(currIsbn1.b.getIsbn()) != isbn1) {
		    	    System.out.println("ISBN " + isbn1 + " is not found in the book list.");
		    	    return false;
		    	}

		    	if (Long.valueOf(currIsbn2.b.getIsbn()) != isbn2) {
		    	    System.out.println("ISBN " + isbn2 + " is not found in the book list.");
		    	    return false;
		    	}
		     
		     
		        // If isbn1 is not head of linked list
		        if (prevIsbn1 != null)
		            prevIsbn1.next = currIsbn2;
		        else // make isbn2 the new head
		            head = currIsbn2;
		  
		        // If isbn2 is not head of linked list
		        if (prevIsbn2 != null)
		            prevIsbn2.next = currIsbn1;
		        else // make isbn1 the new head
		            head = currIsbn1;
		     
		     
		     //if this point is reached then both isbn are found
		     Node temp = currIsbn1.next;
		     currIsbn1.next = currIsbn2.next;
		     currIsbn2.next = temp;
		     System.out.println("The books with isbn " + isbn1 + " and the isbn " + isbn2 + " are swapped.");
 		     return true;


	}



	/**
	 * Commits the content of the circular list to output text file
	 */
	public void commit() {

		try (PrintWriter pw = new PrintWriter(new FileOutputStream("Updated_Books.txt", true)))
		{
			Node temp = head;
			do {
				pw.println(temp.b);
				temp = temp.next;
			}
			while(temp != head);
			pw.println();

		}
		catch (FileNotFoundException e){
			System.out.println("File not found :(s");
			
		}
		
		System.out.println("Updated_Books.text has been created.\n");
		
	}



}
