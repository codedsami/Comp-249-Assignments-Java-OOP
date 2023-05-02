/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */


/**
 * Exception class for handling invalid price values.
 */
public class BadPriceException extends Exception {
    
    /**
     * Constructs a new BadPriceException with the specified detail message.
     *
     * @param message the detail message.
     */
    public BadPriceException(String message) {
        super(message);
    }
}
