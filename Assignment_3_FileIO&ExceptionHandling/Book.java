/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */

import java.io.Serializable;

/**
 * A class representing a book.
 */
public class Book implements Serializable {

    //attributes
	/**
	 * title
	 */
    private String title;
    /**
     * author
     */
    private String author;
    /**
     * price
     */
    private double price;
    /**
     * ISBN
     */
    private String ISBN;
    /**
     * genre
     */
    private String genre;
    /**
     * year
     */
    private int year;

    /**
     * Constructs a book object with the given attributes.
     * @param a an array of Strings containing the title, author, price, ISBN, genre, and year of publication.
     */
    public Book(String [] a){
        title = a[0];
        author = a[1];
        price = Double.parseDouble(a[2]);
        ISBN = a[3];
        genre = a[4];
        year = Integer.parseInt(a[5]);
    }

    //setters
    public void setGenre(String a){
        genre=a;
    }
    public void setPrice(double a){
        price=a;
    }
    public void setTitle(String a){
        title=a;
    }
    public void setAuthor(String a){
        title=a;
    }
    public void setISBN(String a){
        ISBN=a;
    }
    public void setYear(int a){
        year=a;
    }
    //getters
    public int getYear(){
        return year;
    }
    public String getTitle(){
        String a = title;
        return a;
    }
    public String getAuthor(){
        String a = author;
        return a;
    }
    public String getISBN(){
        String a = ISBN;
        return a;
    }
    public String getGenre(){
        String a = genre;
        return a;
    }
    public double getPrice(){
        return price;
    }

    /**
     * Checks if this book is equal to the given object.
     * @param o the object to compare to this book.
     * @return true if the given object is a Book and has the same attributes as this book, false otherwise.
     */
    public boolean equals(Object o){
        if (o==null){return false;}
        if (o.getClass()!=this.getClass()){return false;}
        Book no = (Book)o;
        if (no.getPrice()==this.getPrice()&&no.getAuthor()==this.getAuthor()&&no.getGenre()==this.getGenre()&&no.getISBN()==this.getISBN()&&no.getTitle()==this.getTitle()&&no.getYear()==this.getYear()){return true;}
        else{return false;}
    }

    /**
     * Returns a string representation of this book.
     * @return a string containing the title, author, price, ISBN, genre, and year of publication of this book.
     */
    public String toString(){
        return (title+" "+author+" "+price+" "+ISBN+" "+genre+" "+year);
    }
}
