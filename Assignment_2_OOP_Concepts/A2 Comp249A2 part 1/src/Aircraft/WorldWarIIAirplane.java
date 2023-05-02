/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */


package Aircraft;

import java.util.Objects;
/**
 * WorldWarIIAirplane class with 1 attribute, accessor and mutator, toString and equals method
 */
public class WorldWarIIAirplane extends Aircraft {

    /**
     * boolean value indicating if the airplane has twin engines or not
     */
    protected boolean twinEngine;

    /**
     * default constructor that also calls the default constructor of the parent class
     */
    public WorldWarIIAirplane() {
        super();
    }

    /**
     * parameterized constructor of the class also calls the parameterized constructor of the parent class
     * @param price price of the airplane
     * @param maximumElevation maximum elevation of the airplane
     * @param twinEngine boolean value indicating if the airplane has twin engines or not
     */
    public WorldWarIIAirplane(double price, double maximumElevation, boolean twinEngine) {
        super(price, maximumElevation);
        this.twinEngine = twinEngine;
    }

    /**
     * copy constructor of the class
     * @param wwII WorldWarIIAirplane object to be copied
     */
    public WorldWarIIAirplane(WorldWarIIAirplane wwII) {
        super(wwII.price, wwII.maximumElevation);
        this.twinEngine = wwII.twinEngine;
    }

    /**
     * accessor method for the twinEngine attribute
     * @return boolean value indicating if the airplane has twin engines or not
     */
    public boolean isTwinEngine() {
        return twinEngine;
    }

    /**
     * mutator method for the twinEngine attribute
     * @param twinEngine boolean value indicating if the airplane has twin engines or not
     */
    public void setTwinEngine(boolean twinEngine) {
        this.twinEngine = twinEngine;
    }

    /**
     * toString method that returns information about the class
     * @return String statement of the class
     */
    @Override
    public String toString() {
        return "The price of this world war airplane is " + getPrice() +
                "$ and it has a maximumElevation of " + getMaximumElevation() +
                " unit. It has a twin engine, this statement is " + twinEngine +".";
    }

    /**
     * equals method that takes another object from any other class and then compares it with the calling object.
     * @param o that takes an object to compare with the calling object
     * @return true if both objects are equals, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorldWarIIAirplane WWII = (WorldWarIIAirplane) o;
        return this.twinEngine == WWII.twinEngine;
    }
}
