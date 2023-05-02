/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */

package Monowheel;

import WheeledTransportation.WheeledTransportation;
/**
 * Represents a Monowheel, a type of wheeled transportation with a single wheel.
 * Inherits from the WheeledTransportation class.
 *
 * @author an Pilon (40246124) Miskat Mahmud (40250110)
 * @version 1.0
 * @since 2023-03-04
 */
public class Monowheel extends WheeledTransportation {
    private double maximumWeight;

    /**
     * Default constructor that creates a Monowheel with no wheels, no speed, and no weight.
     */
    public Monowheel(){
        super();
    }

    /**
     * Parameterized constructor that creates a Monowheel with the given number of wheels, maximum speed, and maximum weight.
     *
     * @param numberOfWheels the number of wheels on the Monowheel
     * @param maximumSpeed the maximum speed of the Monowheel in km/h
     * @param maximumWeight the maximum weight the Monowheel can carry
     */
    public Monowheel(int numberOfWheels, double maximumSpeed, double maximumWeight){
        super(numberOfWheels, maximumSpeed);
        this.maximumWeight = maximumWeight;
    }

    /**
     * Copy constructor that creates a Monowheel with the same number of wheels, maximum speed, and maximum weight as another Monowheel object.
     *
     * @param mw the Monowheel object to copy
     */
    public Monowheel(Monowheel mw){
        super(mw.numberOfWheels, mw.maximumSpeed);
        this.maximumWeight = mw.maximumWeight;
    }

    /**
     * Gets the maximum weight the Monowheel can carry.
     *
     * @return the maximum weight the Monowheel can carry
     */
    public double getMaximumWeight(){
        return maximumWeight;
    }

    /**
     * Sets the maximum weight the Monowheel can carry.
     *
     * @param maximumWeight the maximum weight the Monowheel can carry
     */
    public void setMaximumWeight(double maximumWeight){
        this.maximumWeight = maximumWeight;
    }

    /**
     * Returns a string representation of the Monowheel object, including the number of wheels, maximum speed, and maximum weight.
     *
     * @return a string representation of the Monowheel object
     */
    @Override
    public String toString(){
        return "This monowheel has " + getNumberOfWheels() +
                " number of wheels, has a  maximumSpeed of " + getMaximumSpeed() +
                " km/h, its maximum weight is " + maximumWeight;
    }

    /**
     * Compares the Monowheel object to another object to determine if they are equal.
     *
     * @param o the object to compare with the Monowheel object
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || this.getClass()==o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monowheel monowheel = (Monowheel) o;
        return this.maximumWeight == monowheel.maximumWeight;
    }
}




