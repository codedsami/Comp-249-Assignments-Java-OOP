/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */




/**

TooManyFieldsException is an Exception class that is thrown when an object or data structure has too many fields.

This class extends the Exception class.
*/
public class TooManyFieldsException extends Exception{

/**

Constructs a new TooManyFieldsException with the specified detail message.
@param a the detail message. The detail message is saved for later retrieval by the getMessage() method.
*/
public TooManyFieldsException(String a){
super(a);
}
}