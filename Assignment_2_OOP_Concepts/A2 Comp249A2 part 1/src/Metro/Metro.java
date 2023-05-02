/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */


package Metro;

import Train.Train;
import WheeledTransportation.WheeledTransportation;

import java.util.Objects;


/**
 * The Metro class represents a metro train with wheels, maximum speed, number of vehicles, starting and destination stations,
 * and total number of stops.
 *
 * This class extends the Train class and inherits its attributes and methods.
 */
public class Metro extends Train {

    /**
     * The total number of stops of this metro train.
     */
    protected int totalNumberOfStops;

    /**
     * Constructs a new Metro object with default values for all attributes. This constructor also calls the default constructor of the parent class.
     */
    public Metro() {
        super();
    }

    /**
     * Constructs a new Metro object with the given values for the attributes. This constructor also calls the parameterized constructor of the parent class.
     *
     * @param numberOfWheels the number of wheels of this metro train.
     * @param maximumSpeed the maximum speed of this metro train.
     * @param numberOfVehicles the number of vehicles of this metro train.
     * @param nameOfStartingStation the name of the starting station of this metro train.
     * @param nameOfDestinationStation the name of the destination station of this metro train.
     * @param totalNumberOfStops the total number of stops of this metro train.
     */
    public Metro(int numberOfWheels, double maximumSpeed, int numberOfVehicles, String nameOfStartingStation, String nameOfDestinationStation, int totalNumberOfStops) {
        super(numberOfWheels, maximumSpeed, numberOfVehicles, nameOfStartingStation, nameOfDestinationStation);
        this.totalNumberOfStops = totalNumberOfStops;
    }

    /**
     * Constructs a new Metro object by copying the values from another Metro object. This constructor also calls the copy constructor of the parent class.
     *
     * @param m the Metro object to copy from.
     */
    public Metro(Metro m) {
        super(m.numberOfWheels, m.maximumSpeed, m.numberOfVehicles, m.nameOfStartingStation, m.nameOfDestinationStation);
        this.totalNumberOfStops = m.totalNumberOfStops;
    }

    /**
     * Returns the total number of stops of this metro train.
     *
     * @return the total number of stops.
     */
    public int getTotalNumberOfStops() {
        return totalNumberOfStops;
    }

    /**
     * Sets the total number of stops of this metro train.
     *
     * @param totalNumberOfStops the total number of stops to set.
     */
    public void setTotalNumberOfStops(int totalNumberOfStops) {
        this.totalNumberOfStops = totalNumberOfStops;
    }

    /**
     * Returns a string representation of this Metro object.
     *
     * @return a string containing the number of wheels, maximum speed, number of vehicles, starting and destination stations,
     * and total number of stops of this metro train.
     */
    @Override
    public String toString() {
        return "This metro has " +
                + getNumberOfWheels() +
                " number of wheels, has a maximum speed of " + getMaximumSpeed() + " km/hr. It has " + getNumberOfVehicles() + " vehicles and its starting and destination stations are "
                + getNameOfStartingStation() + " and " + getNameOfDestinationStation() +", it has  " +
                + totalNumberOfStops + " number of stops.";
    }

    /**
     * Determines whether the specified object is equal to this Metro object.
     *
     * @param o the object to compare with this Metro object.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Metro metro = (Metro) o;
        return this.totalNumberOfStops == metro.totalNumberOfStops;
    }


}
