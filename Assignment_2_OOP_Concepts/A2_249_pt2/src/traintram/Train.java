package traintram;
import wheeledtrans.WheeledTransportation;

/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */

public class Train extends  WheeledTransportation{

    private int nb_vehicles;
    private String start_station;
    private String end_station;

    public Train(){
        super();
        nb_vehicles = 0;
        start_station = "";
        end_station = "";
    }

    public Train(int a, double b, int c,String d, String e){
        super(a,b);
        nb_vehicles = c;
        start_station = d;
        end_station = e;
    }

    public Train(Train otherTrain){
        super(otherTrain);
        nb_vehicles = otherTrain.getNb_vehicles();
        start_station = otherTrain.getStart_station();
        end_station = otherTrain.getEnd_station();
    }

    public int getNb_vehicles(){
        int a = nb_vehicles;
        return a;
    }

    public String getStart_station(){
        return start_station;
    }

    public String getEnd_station(){
        return end_station;
    }

    public void setNb_vehicles(int a){
        nb_vehicles = a;
    }

    public void setStart_station(String a){
        start_station = a;
    }

    public void setEnd_station(String a){
        end_station = a;
    }

    public String toString(){
        return (super.toString()+", this train also has "+nb_vehicles+" vehicles and goes from "+start_station+ " to "+end_station);
    }

    public boolean equals(Train otherTrain){
        if(otherTrain.getClass()==this.getClass()&&otherTrain!=null&&super.equals(otherTrain)&&(nb_vehicles==otherTrain.getNb_vehicles())&&(end_station==otherTrain.getEnd_station()&&(end_station==otherTrain.getEnd_station()))){
            return true;
        }
        else{
            return false;
        }
    }

}
