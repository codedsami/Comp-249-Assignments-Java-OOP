/**
 * Assignment 02 Part 1
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */



/**
 * importing different packages
 */

import Aircraft.*;
import Ferry.Ferry;
import Metro.Metro;
import Monowheel.Monowheel;
import Train.*;

import WheeledTransportation.*;



/**
 *  * This class imports different packages to access the classes inside them.
 *  * The main method uses toString(), equals() and FindleastAndMostExpensiveAircraft() methods.
 *  * The FindleastAndMostExpensiveAircraft() method takes an array of objects
 *  * and verifies the elements to find the cheapest and priciest Aircraft objects in the array.
 */


public class Main {



    /**
     * this method takes an array and then verifies the elements and give the toString representation of the cheapest and priciest airplane
     * @param arr take takes an array of object
     */
    static void FindleastAndMostExpensiveAircraft(Object [] arr){
        /**
         * using default constructor to create two new aircraft objects
         */
        Aircraft priciest = new Aircraft();  //new aircraft
        Aircraft cheapest = new Aircraft();  //new aircraft

        double max = 0;
        double min = 0;

        for(int i=0; i< arr.length; i++){
            if(!(arr[i] instanceof Aircraft) & (arr[i].getClass() != Aircraft.class)){
                continue;
            }
            if(arr[i] instanceof Aircraft | arr[i].getClass() == Aircraft.class){

                Aircraft A = (Aircraft)  arr[i];
                if (max == 0){
                    priciest = A;
                    max = A.getPrice();
                }
               else if(max<A.getPrice()){
                    priciest = A;
                    max = A.getPrice();
                }

               if (min == 0){
                   cheapest = A;
                   min = A.getPrice();
               }
               else if(min>A.getPrice()){
                   cheapest=A;
                   min=A.getPrice();
               }

            }

        }

        //print statements
        if (max == 0  | min == 0 ){
            System.out.println("There are no aeroplane in this list.");
        return;
        }

        if(cheapest == priciest){
            System.out.println("There exist only one airplane which is the cheapest and the priciest. Here is the information about this airplane.\n" + cheapest.toString());
        }
        else {
        System.out.println("The least expensive aircraft is a " + cheapest.getClass().getSimpleName()+". Here are the information about it: " + cheapest.toString() + "\nThe most expensive aircraft is a "  + priciest.getClass().getSimpleName() +". Here are the information about it: "+ priciest.toString());}

}




    /**
     * The main method creates different objects of the classes from the imported packages and calls the methods from the classes.
     * It also uses FindleastAndMostExpensiveAircraft() method to find the cheapest and priciest Aircraft objects from the created objects.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WheeledTransportation WT1 = new WheeledTransportation(24, 140);
        WheeledTransportation WT2 = new WheeledTransportation(WT1);
        Train                 T1  = new Train(144, 120, 12, "Montreal" , "Toronto");
        Train                 T2  = new Train(T1);
        Metro                 M1  = new Metro(100, 70, 10, "Cote-Vertu", "Guy-Concordia", 13);
        Metro                 M2  = new Metro(100, 70, 10, "Cote-Vertu", "Guy-Concordia", 13);
        Tram                 TM1  = new Tram(8, 60, 2, "York", "Waterloo", 10, 1973);
        Tram                 TM2  = new Tram(TM1);
        Monowheel            MW1  = new Monowheel(1, 15, 80);
        Monowheel            MW2  = new Monowheel(MW1);
        Ferry                 F1  = new Ferry();
        Ferry                 F2  = new Ferry(50, 1400);
        Aircraft             AC1  = new Aircraft(1000000, 36000);
        Aircraft             AC2  = new Aircraft(2000000, 36500);
        WorldWarIIAirplane   WW1  = new WorldWarIIAirplane(15000, 2000, false);
        WorldWarIIAirplane   WW2  = new WorldWarIIAirplane(50000, 5000, true);

        System.out.println(WT1.toString());
        System.out.println(WT2.toString());
        System.out.println(T1.toString());
        System.out.println(T2.toString());
        System.out.println(M1.toString());
        System.out.println(M2.toString());
        System.out.println(TM1.toString());
        System.out.println(TM2.toString());
        System.out.println(MW1.toString());
        System.out.println(MW2.toString());
        System.out.println(F1.toString());
        System.out.println(F2.toString());
        System.out.println(AC1.toString());
        System.out.println(AC2.toString());
        System.out.println(WW1.toString());
        System.out.println(WW2.toString());

        System.out.println("\nComparing objects from different class:");
        if(WT1.equals(WW2)){
            System.out.println("This wheeled transportation object is same as the compared world war plane object.");
        }
        else{
            System.out.println("This wheeled transportation object is not same as the compared world war plane object.");
        }

        System.out.println("\nComparing objects from same class with different value:");
        if(F1.equals(F2)){
            System.out.println("This ferry object is same as the compared ferry object.");
        }
        else{
            System.out.println("This ferry object is not the same as the compared ferry object.");
        }

        System.out.println("\nComparing objects from same class with same value:");
        if(T1.equals(T2)){
            System.out.println("This train object is same as the compared train object.");
        }
        else{
            System.out.println("This train object is not the same as the compared train object.");
        }
        if(M1.equals(M2)){
            System.out.println("This metro object is same as the compared metro object.");
        }
        else{
            System.out.println("This metro object is not same as the compared metro object.");
        }



        System.out.println();
        Object [] arr0 = {WT1, WT2, T1, T2, M1, M2, TM1, MW1, MW2, F1, F2, WT1, M2, TM1, F2};
        Object [] arr1 = {WT1, WT2, T1, T2, M1, M2, TM1, TM2, MW1, MW2, F1, F2, WW1, M1, T1, WT2, F2, M1};
        Object [] arr2 = {WT1, WW1, T1, T2, M1, AC1, M2, TM1, TM2, MW1, MW2, F1, F2, AC1, AC2, WW2, AC2 };

        System.out.println("Execution of the 'FindleastAndMostExpensiveAircraft()' method with 3 arrays with no airplane, one airplane and multiple airplanes");
        FindleastAndMostExpensiveAircraft(arr0);
        System.out.println("");
        FindleastAndMostExpensiveAircraft(arr1);
        System.out.println("");
        FindleastAndMostExpensiveAircraft(arr2);






























    }
}