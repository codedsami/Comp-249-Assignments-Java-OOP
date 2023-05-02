/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */


/**

The BadYearException class is an exception that is thrown when an invalid year value is provided.

This exception extends the built-in Java Exception class.

*/
public class BadYearException extends Exception{

/**

Constructs a new BadYearException object with the specified detail message.
@param message the detail message (which is saved for later retrieval by the getMessage() method)
*/
public BadYearException(String message){
super(message);
}
}