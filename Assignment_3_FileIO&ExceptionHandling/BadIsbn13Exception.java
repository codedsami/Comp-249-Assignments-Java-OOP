/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */


/**

This exception is thrown when an invalid ISBN-13 number is detected.
*/
public class BadIsbn13Exception extends Exception {

/**

Constructs a new BadIsbn13Exception with the specified detail message.
@param message the detail message (which is saved for later retrieval by the getMessage() method)
*/
public BadIsbn13Exception(String message) {
super(message);
}
}