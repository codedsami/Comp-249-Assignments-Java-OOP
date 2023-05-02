/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */


package Ferry;

import java.util.Objects;
/**
 * Ferry class with 2 attributes and normal methods
 */
public class Ferry {
    private double maximumSpeed;
    private double maximumLoad;

    /**
     * Default constructor of the class
     */
    public Ferry() {
    }

    /**
     * Parameterized constructor of the class also calls the parameterized constructor of the parent class
     * @param maximumSpeed Maximum speed of the object
     * @param maximumLoad Maximum load capacity of the object
     */
    public Ferry(double maximumSpeed, double maximumLoad) {
        this.maximumSpeed = maximumSpeed;
        this.maximumLoad = maximumLoad;
    }

    /**
     * Copy constructor copying another object
     * @param f Takes another Ferry and copy it
     */
    public Ferry(Ferry f){
        this.maximumSpeed = f.maximumSpeed;
        this.maximumLoad = f.maximumSpeed;
    }

    /**
     * Accessor method
     * @return Maximum speed of the object
     */
    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    /**
     * Mutator method
     * @param maximumSpeed Takes a double value and sets the maximum speed
     */
    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Accessor method
     * @return Maximum load of the object
     */
    public double getMaximumLoad() {
        return maximumLoad;
    }

    /**
     * Mutator method
     * @param maximumLoad Takes a double value and sets the maximum load
     */
    public void setMaximumLoad(double maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    /**
     * toString method that returns information about the class
     * @return String statement of the class
     */
    @Override
    public String toString() {
        return "This ferry has a maximum speed of " + maximumSpeed + " km/hr, its maximum load is " + maximumLoad +
                " pounds.";
    }

    /**
     * equals method that takes another object from any other class and then compares it with the calling object.
     * @param o Takes an object to compare with the calling object
     * @return true if both objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ferry ferry = (Ferry) o;
        return  this.maximumLoad == ferry.maximumLoad &&
                this.maximumSpeed == ferry.maximumSpeed;
    }
}
