package air;

/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */
public class Aircraft {

    private double price;
    private double max_elevation;

    public Aircraft(){
        price=0;
        max_elevation=0;
    }

    public Aircraft(double a,double b){
        price=a;
        max_elevation=b;
    }

    public Aircraft(Aircraft otherAircraft){
        price=otherAircraft.getPrice();
        max_elevation=otherAircraft.getMax_elevation();
    }

    public double getPrice(){
        double a = price;
        return a;
    }

    public  double getMax_elevation(){
        double a = max_elevation;
        return a;
    }

    public void setPrice(double a){
        price = a;
    }

    public void setMax_elevation(double a){
        max_elevation = a;
    }

    public String toString(){
        return ("This aircraft costs "+price+" and has a max elevation of "+max_elevation);
    }

    public boolean equals(Aircraft otherAircraft){
        if(otherAircraft.getClass()==this.getClass()&&otherAircraft!=null&&price==otherAircraft.getPrice()&&max_elevation==otherAircraft.getMax_elevation()){
            return true;
        }
        else{
            return false;
        }
    }
}
