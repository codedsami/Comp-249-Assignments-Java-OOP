package air;

/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */
public class World_War_II_Airplane extends Aircraft{

    private boolean twin_engine;

    public World_War_II_Airplane(){
        super();
        twin_engine=false;
    }

    public World_War_II_Airplane(double a,double b,boolean c){
        super(a,b);
        twin_engine=c;
    }

    public World_War_II_Airplane(World_War_II_Airplane otherWWairplane){
        super(otherWWairplane);
        twin_engine= otherWWairplane.getEngine();
    }

    public boolean getEngine(){
        return twin_engine;
    }

    public void setEngine(boolean a){
        twin_engine=a;
    }

    public String toString(){
        return (super.toString()+" the fact that this world war II airplane has a twin engine is "+twin_engine);
    }

    public boolean equals(World_War_II_Airplane otherWarair){
        if(otherWarair.getClass()==this.getClass()&&otherWarair!=null&&super.equals(otherWarair)&&(twin_engine== otherWarair.getEngine())){
            return true;
        }
        else{
            return false;
        }
    }
}
