package ferry;

/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */

public class Ferry {
    private double max_speed;
    private double max_load;

    public Ferry(){
        max_load=0;
        max_speed=0;
    }

    public Ferry(double a, double b){
        max_speed=a;
        max_load=b;
    }

    public Ferry(Ferry otherFerry){
        max_load=otherFerry.getMax_load();
        max_speed=otherFerry.getMax_speed();
    }

    public double getMax_speed(){
        double a = max_speed;
        return a;
    }

    public double getMax_load(){
        double a = max_load;
        return a;
    }

    public void setMax_speed(double a){
        max_speed = a;
    }

    public void setMax_load(double a){
        max_load=a;
    }

    public String toString(){
        return ("This ferry has a max speed of "+max_speed+" and a max load of "+max_load);
    }

    public boolean equals(Ferry otherFerry){
        if(otherFerry.getClass()==this.getClass()&&otherFerry!=null&&max_load==otherFerry.getMax_load()&&max_speed==otherFerry.getMax_speed()){
            return true;
        }
        else{
            return false;
        }

    }

}
