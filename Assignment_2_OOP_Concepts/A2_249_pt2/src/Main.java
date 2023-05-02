import air.Aircraft;
import air.World_War_II_Airplane;
import ferry.Ferry;
import metro.Metro;
import mono.Monowheel;
import traintram.Train;
import traintram.Tram;
import wheeledtrans.WheeledTransportation;

/**
 * Assignment 02 Part 2
 * COMP-249
 * Written by:
 * @author Yan Pilon (40246124)
 * @author Miskat Mahmud (40250110)
 * Due Date: 04 March 2023
 */
public class Main {
    public static void main(String[] args) {

        WheeledTransportation wheel1 = new WheeledTransportation(4,100.0);
        WheeledTransportation wheel2 = new WheeledTransportation(6,140.0);
        Train train1 = new Train(4,200.0,5,"Vaudreuil","Lucien-L'Allier");
        Train train2 = new Train(8,200.0,3,"Kingston","Montreal");
        Metro metro1 = new Metro(5,80.0,12,"Cote-Vertu","Montmorency",10);
        Metro metro2 = new Metro(5,80.0,12,"Cote-Vertu","Montmorency",10);
        Tram tram1 = new Tram(8,200.0,5,"Vaudreuil","Lucien-L'Allier",12,1998);
        Tram tram2 = new Tram(10,170.0,5,"Vaudreuil","Lucien-L'Allier",10,1987);
        Monowheel monowheel1 = new Monowheel(2,300.0,5000.0);
        Monowheel monowheel2 = new Monowheel(4,400.0,7000.0);
        Ferry ferry1 = new Ferry(250.0,3000.0);
        Ferry ferry2 = new Ferry(150.0,5000.0);
        Aircraft aircraft1 = new Aircraft(1000000.0,40000.0);
        Aircraft aircraft2 = new Aircraft(1000000.0,40000.0);
        World_War_II_Airplane worldWarIiAirplane1 = new World_War_II_Airplane(1000000.0,40000.0,true);
        World_War_II_Airplane worldWarIiAirplane2 = new World_War_II_Airplane(10000000.0,100000.0,false);

        System.out.println(wheel1.toString()+"\n");
        System.out.println(wheel2.toString()+"\n");
        System.out.println(train1.toString()+"\n");
        System.out.println(train2.toString()+"\n");
        System.out.println(metro1.toString()+"\n");
        System.out.println(metro2.toString()+"\n");
        System.out.println(tram1.toString()+"\n");
        System.out.println(tram2.toString()+"\n");
        System.out.println(monowheel1.toString()+"\n");
        System.out.println(monowheel2.toString()+"\n");
        System.out.println(ferry1.toString()+"\n");
        System.out.println(ferry2.toString()+"\n");
        System.out.println(aircraft1.toString()+"\n");
        System.out.println(aircraft2.toString()+"\n");
        System.out.println(worldWarIiAirplane1.toString()+"\n");
        System.out.println(worldWarIiAirplane2.toString()+"\n");

        System.out.println(metro1.equals(metro2));
        System.out.println(train2.equals(tram1));
        System.out.println(aircraft1.equals(aircraft2));
        System.out.println(aircraft1.equals(worldWarIiAirplane1));
        System.out.println(ferry1.equals(ferry2));

        Object [] array1 = new Object[15];
        Object [] array2 = new Object[15];


        array1[0] = new Aircraft(100000.0,40000.0);
        array1[1] = new Train();
        array1[2] = new Tram();
        array1[3] = new WheeledTransportation();
        array1[4] = new World_War_II_Airplane(2000000.0,40000.0,true);
        array1[5] = new Ferry();
        array1[6] = new World_War_II_Airplane(3000000.0,40000.0,true);
        array1[7] = new Metro();
        array1[8] = new Aircraft(300000.0,40000.0);
        array1[9] = new Aircraft(20000.0,40000.0);
        array1[10] = new Monowheel();
        array1[11] = new Metro();
        array1[12] = new WheeledTransportation();
        array1[13] = new Train();
        array1[14] = new Aircraft(120000.0,40000.0);

        array2[0] = new Tram();
        array2[1] = new Metro();
        array2[2] = new Ferry();
        array2[3] = new WheeledTransportation();
        array2[4] = new Monowheel();
        array2[5] = new Train();
        array2[6] = new Metro();
        array2[7] = new WheeledTransportation();
        array2[8] = new Metro();
        array2[9] = new Tram();
        array2[10] = new WheeledTransportation();
        array2[11] = new Tram();
        array2[12] = new Monowheel();
        array2[13] = new Ferry();
        array2[14] = new Ferry();

        for (int i=0;i< array1.length;i++){
            System.out.println(array1[i].toString());
        }

        Object [] copyArray1 = copyTheObjects(array1);
        System.out.println("");

        for (int i=0;i< copyArray1.length;i++){
            System.out.println(copyArray1[i].toString());
        }


    }

    public static Object[] copyTheObjects(Object[] yes){
        Object [] newYes = new Object[yes.length];
        for (int i=0;i< yes.length;i++){
            newYes[i]= yes[i];
        }
        return newYes;
    }


}