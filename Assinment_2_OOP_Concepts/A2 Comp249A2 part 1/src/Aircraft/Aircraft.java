/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */


/**
 * package aircraft that has aircraft and world war airplane
 */
package Aircraft;

import java.util.Objects;

/**
 * Aircraft class from aircraft package.
 */
public class Aircraft {
    /**
     * price of the aircraft
     */
    protected double price;

    /**
     * maximum elevation of the aircraft
     */
    protected double maximumElevation;



    /**
     * default constructor for the aircraft class
     */
    public Aircraft() {
    }



    /**
     * Parameterized constructor that takes two values to set the attributes
     * @param price price of the aircraft
     * @param maximumElevation maximum elevation of the aircraft
     */
    public Aircraft(double price, double maximumElevation) {
        this.price = price;
        this.maximumElevation = maximumElevation;
    }



    /**
     * copy constructor for Aircraft
     * @param ac that takes another Aircraft object
     */
    public Aircraft(Aircraft ac){
        this.price = ac.price;
        this.maximumElevation = ac.maximumElevation;
    }



    /**
     * accessor method for price attribute
     * @return value of the price attribute of the calling object
     */
    public double getPrice() {
        return price;
    }


    /**
     * mutator method for price attribute
     * @param price set the value of the attribute of the calling object
     */
    public void setPrice(double price) {
        this.price = price;
    }



    /**
     * accessor method for maximumElevation attribute
     * @return maximumElevation value of the calling object
     */
    public double getMaximumElevation() {
        return maximumElevation;
    }



    /**
     * mutator method for maximumElevation attribute
     * @param maximumElevation that set the value for the attribute
     */
    public void setMaximumElevation(double maximumElevation) {
        this.maximumElevation = maximumElevation;
    }

    /**
     * toString method that returns information about the class
     * @return String statement of the class
     */
    @Override
    public String toString() {
        return "The price of this aircraft is " + price +
                "$ and it has a maximumElevation of " + maximumElevation +
                " feet.";

    }

    /**
     *
     * @param o that takes object from any other class, and is being compared with the calling object
     * @return return true if calling and parameter object has the same class and values for the attributes, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return  this.price == aircraft.price &&
                this.maximumElevation == aircraft.maximumElevation;
    }


}
