package wheeledtrans;

/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */

public class WheeledTransportation{

    private int nb_Wheels;
    private double max_Speed;

    public WheeledTransportation(){
        nb_Wheels = 0;
        max_Speed = 0.0;
    }
    public WheeledTransportation(int a,double b){
        nb_Wheels = a;
        max_Speed = b;
    }

    public WheeledTransportation(WheeledTransportation otherWheel){
        this.nb_Wheels = otherWheel.getNb_Wheels();
        this.max_Speed = otherWheel.getMax_speed();
    }

    public int getNb_Wheels(){
        int a = nb_Wheels;
        return a;
    }

    public double getMax_speed(){
        double a = max_Speed;
        return a;
    }

    public void setNb_Wheels(int a){
        nb_Wheels = a;
    }

    public void setMax_Speed(double a){
        max_Speed = a;
    }

    public String toString(){
        return("This wheeled transportation vehicle has "+nb_Wheels+" wheels and has a max speed of "+max_Speed);
    }

    public boolean equals(WheeledTransportation otherWheel) {
        if(nb_Wheels==otherWheel.getNb_Wheels()&&max_Speed==otherWheel.getMax_speed()&&otherWheel!=null&&otherWheel.getClass()==this.getClass()){
            return true;
        }
        else{
            return false;
        }
    }

}
