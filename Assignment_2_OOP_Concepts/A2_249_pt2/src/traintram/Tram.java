package traintram;
import metro.Metro;
/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */
public class Tram extends Metro {

    private int year_creation;

    public Tram(){
        super();
        year_creation=0;
    }

    public Tram(int a, double b, int c,String d, String e,int f,int g){
        super(a,b,c,d,e,f);
        year_creation=g;
    }

    public Tram(Tram otherTram){
        super(otherTram);
        year_creation=otherTram.getYear_creation();
    }

    public int getYear_creation(){
        int a = year_creation;
        return a;
    }

    public void setYear_creation(int a){
        year_creation=a;
    }

    public  String toString(){
        return (super.toString()+" this Tram what made in "+year_creation);
    }

    public boolean equals(Tram otherTram){
        if(otherTram.getClass()==this.getClass()&&otherTram!=null&&super.equals(otherTram)&&(year_creation==otherTram.getYear_creation())){
            return true;
        }
        else{
            return false;
        }
    }




}
