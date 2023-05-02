/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */


/**

An exception that is thrown when a record or line of data has too few fields.
*/
public class TooFewFieldsException extends Exception {

/**

Constructs a new TooFewFieldsException with the specified detail message.
@param message the detail message (which is saved for later retrieval by the getMessage() method)
*/
public TooFewFieldsException(String message) {
super(message);
}
}