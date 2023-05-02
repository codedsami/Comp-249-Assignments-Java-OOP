package metro;
import traintram.Train;

/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */

public class Metro extends Train{
    private int nb_stops;

    public Metro(){
        super();
        nb_stops=0;
    }

    public Metro(int a, double b, int c,String d, String e,int f){
        super(a,b,c,d,e);
        nb_stops=f;
    }

    public Metro(Metro otherMetro){
        super(otherMetro);
        nb_stops=otherMetro.getNb_stops();
    }

    public int getNb_stops(){
        int a = nb_stops;
        return a;
    }

    public void setNb_stops(int a){
        nb_stops = a;
    }

    public String toString(){
        return(super.toString()+ ", this metro has "+nb_stops+" stops");
    }

    public boolean equals(Metro otherMetro){
        if(otherMetro.getClass()==this.getClass()&&otherMetro!=null&&super.equals(otherMetro)&&(nb_stops==otherMetro.getNb_stops())){
            return true;
        }
        else{
            return false;
        }
    }
}
