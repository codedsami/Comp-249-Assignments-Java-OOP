/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */

/**
 * Wheeled transportation package contains wheeled transportation class
 */
package WheeledTransportation;

import java.util.Objects;
/**
 * The WheeledTransportation class represents a type of transportation that has wheels and a maximum speed.
 */
public class WheeledTransportation {

    /**
     * The number of wheels of the transportation.
     */
    protected int numberOfWheels;

    /**
     * The maximum speed of the transportation.
     */
    protected double maximumSpeed;

    /**
     * Creates a new WheeledTransportation object with default values (0 wheels and 0 maximum speed).
     */
    public WheeledTransportation() {}

    /**
     * Creates a new WheeledTransportation object with the specified number of wheels and maximum speed.
     *
     * @param numberOfWheels the number of wheels of the transportation
     * @param maximumSpeed the maximum speed of the transportation
     */
    public WheeledTransportation(int numberOfWheels, double maximumSpeed) {
        this.numberOfWheels = numberOfWheels;
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Creates a new WheeledTransportation object with the same values as another WheeledTransportation object.
     *
     * @param wt the WheeledTransportation object to copy
     */
    public WheeledTransportation(WheeledTransportation wt) {
        this.numberOfWheels = wt.numberOfWheels;
        this.maximumSpeed = wt.maximumSpeed;
    }

    /**
     * Gets the number of wheels of the transportation.
     *
     * @return the number of wheels of the transportation
     */
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    /**
     * Sets the number of wheels of the transportation.
     *
     * @param numberOfWheels the number of wheels of the transportation
     */
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    /**
     * Gets the maximum speed of the transportation.
     *
     * @return the maximum speed of the transportation
     */
    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    /**
     * Sets the maximum speed of the transportation.
     *
     * @param maximumSpeed the maximum speed of the transportation
     */
    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Returns a String representation of the WheeledTransportation object.
     *
     * @return a String representation of the WheeledTransportation object
     */
    @Override
    public String toString() {
        return "This WheeledTransportation has " + numberOfWheels + " number of wheels, has a maximumSpeed of " + maximumSpeed + " km/h.";
    }

    /**
     * Compares the WheeledTransportation object with another object to check if they are equal.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WheeledTransportation e = (WheeledTransportation) o;
        return this.numberOfWheels == e.numberOfWheels && this.maximumSpeed == e.maximumSpeed;
    }
}
