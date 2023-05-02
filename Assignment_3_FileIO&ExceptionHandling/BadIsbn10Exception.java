/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */


/**
 * This exception class is used to represent an invalid ISBN-10 number.
 */
public class BadIsbn10Exception extends Exception {
    
    /**
     * Constructs a new BadIsbn10Exception with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public BadIsbn10Exception(String message) {
        super(message);
    }
} 
