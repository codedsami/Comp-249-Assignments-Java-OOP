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
import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @author Yan Pilon, Miskat Mahmud
 * @version 1
 */
public class Book implements Serializable {
	/**
	 * Title of the book
	 */
	private String title;
	/**
	 * Author of the book
	 */
	private String authors;
	/**
	 * Price of the book
	 */
	private double price;
	/**
	 * ISBN of the book
	 */
	private String isbn;
	/**
	 * Genre of the book
	 */
	private String genre;
	/**
	 * publishing year of the book
	 */
	private int year;
	
	/**
	 * Parameterized constructor for Book class
	 * @param title .
	 * @param authors .
	 * @param price .
	 * @param isbn .
	 * @param genre .
	 * @param year .
	 */
	public Book(String title, String authors, double price, String isbn, String genre, int year) {
		//System.out.println("Creating book with parameterized constructor");
		this.title = title;
		this.authors = authors;
		this.price = price;
		this.isbn = isbn;
		this.genre = genre;
		this.year = year;
	}

	/**
	 * Copy constructor 
	 * @param book object to be copied
	 */
	public Book(Book book) {
		//System.out.println("Creating book with copy constructor");
		this.title = book.title;
		this.authors = book.authors;
		this.price = book.price;
		this.isbn = book.isbn;
		this.genre = book.genre;
		this.year = book.year;
	}

	/**
	 * accessor
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * mutator
	 * @param title replacement
	 */
	public void setTitle(String title) {
		this.title = title;
	}
    /**
    * accessor
    * @return authors
    */
	public String getAuthors() {
		return authors;
	}

		
	/**
	 * mutator
	 * @param authors replacement
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * accessor
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
    /**
     * mutator
     * @param price replacement
     */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * accessor 
	 * @return price
	 */
	public String getIsbn() {
		return isbn;
	}
/**
 * mutator
 * @param isbn replacement
 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * accessor
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}
/**
 * mutator
 * @param genre replacement
 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * accessor
	 * @return year
	 */
	public int getYear() {
		return year;
	}
/**
 * mutator
 * @param year replacement
 */
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		if(!(title.startsWith("\""))) {
		return "\""+title + "\", " + authors + ", " + price + ", " + isbn + ", " + genre + ", " + year;
		}
		else return title + ", " + authors + ", " + price + ", " + isbn + ", " + genre + ", " + year;}	

	@Override
	public int hashCode() {
		return Objects.hash(authors, genre, isbn, price, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(authors, other.authors) && Objects.equals(genre, other.genre)
				&& Objects.equals(isbn, other.isbn)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title) && year == other.year;
	}
	
	
	
	
	public Book clone() {
		return new Book(this);
	}
	
	
	

}

