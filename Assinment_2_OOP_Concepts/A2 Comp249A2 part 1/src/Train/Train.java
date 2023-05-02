
/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */

/**
 * Train package contains train and tram
 */
package Train;

/**
 * importing wheeled transportation since it's a descendent of that class
 */
import WheeledTransportation.WheeledTransportation;

/**
 * Train class with 3 attributes, accessor and mutator, toString and equals method
 */
public class Train extends WheeledTransportation {
   /**
    * number of vehicles
    */
   protected int numberOfVehicles;

   /**
    * name of starting station
    */
   protected String nameOfStartingStation;

   /**
    * name of destination station
    */
   protected String nameOfDestinationStation;


   /**
    * default constructor that also calls the default constructor of the parent class
    */
   public Train() {
      super();
   }


   /**
    * parameterized constructor of the class also calls the parameterized constructor of the parent class
    * @param numberOfWheels takes  number of wheels
    * @param maximumSpeed takes maximum speed
    * @param numberOfVehicles takes number of vehicles
    * @param nameOfStartingStation name of starting station
    * @param nameOfDestinationStation name of destination station
    */
   public Train(int numberOfWheels, double maximumSpeed, int numberOfVehicles, String nameOfStartingStation, String nameOfDestinationStation) {
      super(numberOfWheels, maximumSpeed);
      this.numberOfVehicles = numberOfVehicles;
      this.nameOfStartingStation = nameOfStartingStation;
      this.nameOfDestinationStation = nameOfDestinationStation;
   }


   /**
    * copy constructor
    * @param t takes another train object
    */
   public Train(Train t) {
      super(t.numberOfWheels, t.maximumSpeed);
      this.numberOfVehicles = t.numberOfVehicles;
      this.nameOfStartingStation = t.nameOfStartingStation;
      this.nameOfDestinationStation = t.nameOfDestinationStation;
   }

   /**
    * accessor method
    * @return numberOfvehicles of the calling object
    */
   public int getNumberOfVehicles() {
      return numberOfVehicles;
   }

   /**
    * mutator method
    * @param numberOfVehicles set the attribute value
    */
   public void setNumberOfVehicles(int numberOfVehicles) {
      this.numberOfVehicles = numberOfVehicles;
   }

   /**
    * accessor of the attributes
    * @return string type of the starting station
    */
   public String getNameOfStartingStation() {
      return nameOfStartingStation;
   }

   /**
    * mutator of the aattribute
    * @param nameOfStartingStation takes string value of starting station
    */
   public void setNameOfStartingStation(String nameOfStartingStation) {
      this.nameOfStartingStation = nameOfStartingStation;
   }

   /**
    *returns name of destination station
    * @return string value of destination station
    */
   public String getNameOfDestinationStation() {
      return nameOfDestinationStation;
   }


   /**
    * mutator method that set the destination station
    * @param nameOfDestinationStation takes the name
    */
   public void setNameOfDestinationStation(String nameOfDestinationStation) {
      this.nameOfDestinationStation = nameOfDestinationStation;
   }

   /**
    * toString method that returns information about the class
    * @return String statement of the class
    */
   @Override
   public String toString() {
      return "This train has " +
              +getNumberOfWheels() +
              " number of wheels, has a maximum speed of " + getMaximumSpeed() + " km/hr. It has " + numberOfVehicles + " vehicles and its starting and destination stations are "
              + nameOfStartingStation + " and " + nameOfDestinationStation + ".";
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

      Train train = (Train) o;
      return this.numberOfVehicles == train.numberOfVehicles &&
              this.nameOfStartingStation.equals(train.nameOfStartingStation) &&
              this.nameOfDestinationStation.equals(train.nameOfDestinationStation);

   }
}