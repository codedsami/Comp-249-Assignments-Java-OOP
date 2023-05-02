/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */



/**

The UnknownGenreException class is an Exception that is thrown when an unknown genre is encountered.
*/
public class UnknownGenreException extends Exception {

/**

Constructs a new UnknownGenreException with the specified detail message.
@param message the detail message
*/
public UnknownGenreException(String message) {
super(message);
}
}