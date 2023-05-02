/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */
public class MissingFieldException extends Exception{
/**
 * missing index
 */
    int missingIndex;
    /**
     * helper method to check for missing field
     * @param a retruns a message
     * @param j verifies which field is missing
     */
    public MissingFieldException(String a,int j){
        super(a);
        missingIndex=j;
    }

    /**
     * method to check missing field
     * @return a message depending on the missing field
     */
    public String missingIndexName(){
        switch (missingIndex){
            case 0: return ("Missing Title");

            case 1: return ("Missing Author");

            case 2: return ("Missing Price");

            case 3: return ("Missing ISBN");

            case 4: return ("Missing Genre");

            case 5: return ("Missing Year");

            default: return ("error");

        }
    }






}
