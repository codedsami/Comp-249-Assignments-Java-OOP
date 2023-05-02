package mono;
import wheeledtrans.WheeledTransportation;

/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */
public class Monowheel extends WheeledTransportation {
    private double max_weight;

    public Monowheel(){
        super();
        max_weight=0.0;
    }

    public Monowheel(int a,double b,double c){
        super(a,b);
        max_weight=c;
    }

    public Monowheel(Monowheel otherMonowheel){
        super(otherMonowheel);
        max_weight=otherMonowheel.getMax_weight();
    }

    public double getMax_weight(){
        double a = max_weight;
        return a;
    }

    public void setMax_weight(double a){
        max_weight=a;
    }

    public String toString(){
        return (super.toString()+" this monowheel can handle a max weigth of "+max_weight);
    }

    public boolean equals(Monowheel otherMonowheel){
        if(otherMonowheel.getClass()==this.getClass()&&otherMonowheel!=null&&super.equals(otherMonowheel)&&(max_weight==otherMonowheel.getMax_weight())){
            return true;
        }
        else{
            return false;
        }
    }
}
