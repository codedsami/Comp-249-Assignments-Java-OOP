/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */

/**
 * from train package
 */
package Train;

/**
 * extends metro class
 */

import Metro.Metro;


/**
 * The Tram class represents a type of metro transportation that has a year of creation attribute
 * in addition to the attributes inherited from its parent class, Metro.
 */
public class Tram extends Metro {

    /**
     * The year of creation of the Tram object.
     */
    protected int yearOfCreation;

    /**
     * Constructs a Tram object with default values for its attributes.
     * Calls the default constructor of the parent class.
     */
    public Tram() {
        super();
    }

    /**
     * Constructs a Tram object with specified values for its attributes.
     * Calls the parameterized constructor of the parent class.
     *
     * @param numberOfWheels The number of wheels of the Tram object.
     * @param maximumSpeed The maximum speed of the Tram object in km/hr.
     * @param numberOfVehicles The number of vehicles in the Tram object.
     * @param nameOfStartingStation The name of the starting station for the Tram object.
     * @param nameOfDestinationStation The name of the destination station for the Tram object.
     * @param totalNumberOfStops The total number of stops for the Tram object.
     * @param yearOfCreation The year of creation for the Tram object.
     */
    public Tram(int numberOfWheels, double maximumSpeed, int numberOfVehicles, String nameOfStartingStation,
                String nameOfDestinationStation, int totalNumberOfStops, int yearOfCreation) {
        super(numberOfWheels, maximumSpeed, numberOfVehicles, nameOfStartingStation, nameOfDestinationStation, totalNumberOfStops);
        this.yearOfCreation = yearOfCreation;
    }

    /**
     * Constructs a copy of a Tram object.
     *
     * @param tm The Tram object to copy.
     */
    public Tram(Tram tm) {
        super(tm.numberOfWheels, tm.maximumSpeed, tm.numberOfVehicles, tm.nameOfStartingStation,
                tm.nameOfDestinationStation, tm.totalNumberOfStops);
        this.yearOfCreation = tm.yearOfCreation;
    }

    /**
     * Returns the year of creation of the Tram object.
     *
     * @return The year of creation.
     */
    public int getYearOfCreation() {
        return yearOfCreation;
    }

    /**
     * Sets the year of creation of the Tram object.
     *
     * @param yearOfCreation The year of creation to set.
     */
    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    /**
     * Returns a String representation of the Tram object.
     *
     * @return A String representation of the Tram object.
     */
    @Override
    public String toString() {
        return "This tram has " + getNumberOfWheels() + " number of wheels, has a maximum speed of " +
                getMaximumSpeed() + " km/hr. It has " + getNumberOfVehicles() + " vehicles and its starting and destination " +
                "stations are " + getNameOfStartingStation() + " and " + getNameOfDestinationStation() + ", it has " +
                getTotalNumberOfStops() + " number of stops, it's year of creation is " + yearOfCreation + ".";
    }

    /**
     * Compares the Tram object with another object.
     *
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tram tram = (Tram) o;
        return this.yearOfCreation == tram.yearOfCreation;
    }


}
