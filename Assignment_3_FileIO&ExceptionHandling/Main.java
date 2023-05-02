import java.io.*;
import java.util.Scanner;
/**
 * Assignment 03 
 * COMP-249
 * Written by:
 * Yan Pilon (40246124)
 * Miskat Mahmud (40250110)
 * Due Date: 29 March 2023
 */

/**
 * Main class
 * @author Yan Pilon
 * @author Miskat Mahmud
 *
 */
public class Main {
	
/**
 * Main method that executes the program with all three methods in it	
 * @param args  parameter args
 * parameter args
 */
    public static void main(String[] args) {

            do_part1(); // validating syntax, partition book records based on genre.
            do_part2(); // validating semantics, read the genre files each into arrays of Book objects,
                        // then serialize the arrays of Book objects each into binary files.
            do_part3(); // reading the binary files, deserialize the array objects in each file, and
                        // then provide an interacive program to allow the user to navigate the arrays.
    }
/**
 * This method reads the names of all the book files from the file "part1_input_file_names.txt". 
 * Then it reads each book and validates each record. Valid records are written to corresponding output files based on their genre code in the record.
 * Invalid records are written to the file "syntax_error_file.txt".
 * FileNotFoundException if the input file or any of the output files cannot be found.
 */
    public static void do_part1(){

        String [] knownGenre = {"CCB", "HCB", "MTV", "MRB", "NEB", "OTR", "SSM", "TPA"};
        int [] counter = new int[9];
        for (int i = 0; i < counter.length; i++) {
            counter[i]=0;
        }

        //Input stream for part1_input_file_names
        Scanner scan = null;
        try{
            scan = new Scanner(new FileInputStream("part1_input_file_names.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find the file!");
            System.exit(0);
        }

        //String array containing the names of all the book files
        int nbooks = scan.nextInt();
        String throwaway = scan.nextLine();
        String [] book = new String[nbooks];

        for (int i = 0; i<nbooks;++i){
           book[i] = scan.nextLine();
        }
        scan.close();

        //Create the output streams for all the output files
        PrintWriter pCart = null;
        PrintWriter pHobb = null;
        PrintWriter pMovies = null;
        PrintWriter pMusic = null;
        PrintWriter pNost = null;
        PrintWriter pOldt = null;
        PrintWriter pSport = null;
        PrintWriter pTrains = null;
        PrintWriter pSerror = null;

        try{
            pCart= new PrintWriter(new FileOutputStream("Cartoons_Comics.csv"));
            pHobb= new PrintWriter(new FileOutputStream("Hobbies_Collectibles.csv"));
            pMusic= new PrintWriter(new FileOutputStream("Music_Radio_Books.csv"));
            pNost= new PrintWriter(new FileOutputStream("Nostalgia_Eclectic_Books.csv"));
            pOldt= new PrintWriter(new FileOutputStream("Old_Time_Radio_Books.csv"));
            pSport= new PrintWriter(new FileOutputStream("Sports_Sports_Memorabilia.csv"));
            pTrains= new PrintWriter(new FileOutputStream("Trains_Planes_Automobiles.csv"));
            pSerror= new PrintWriter(new FileOutputStream("syntax_error_file.txt"));
            pMovies= new PrintWriter(new FileOutputStream("Movies_TV_Books.csv"));
        }
        catch(FileNotFoundException e){
            System.out.println("Could not find one of the files!");
            System.exit(0);
        }
        //Start analyzing all the books
        Scanner scan1 = null;
        //Input Stream from a specific book.
        for (int i = 0; i <book.length ; i++) {

            try {
                scan1 = new Scanner(new FileInputStream(book[i]));
            } catch (FileNotFoundException e) {
                System.out.println("Could not find the file!2");
                System.exit(0);
            }

            //Scan and validate each book
            String record;
            while (scan1.hasNextLine()) {

                String fhalf;
                String shalf;
                record = scan1.nextLine();
                String[] recordVal;
                if (record.charAt(0) == '\"') {
                    fhalf = record.substring(record.indexOf('\"'), record.lastIndexOf('\"') + 1);
                    String[] recordTemp = record.substring(record.lastIndexOf('\"') + 2, record.length()).split(",");
                    recordVal = new String[recordTemp.length + 1];
                    recordVal[0] = fhalf;
                    for (int j = 1; j < recordVal.length; j++) {
                        recordVal[j] = recordTemp[j - 1];
                    }
                } else {
                    recordVal = record.split(",");
                }

                try {
                    if (recordVal.length > 6) {
                        throw new TooManyFieldsException("Too many fields");
                    } else if (recordVal.length < 6) {
                        throw new TooFewFieldsException("Too few fields");
                    }
                    boolean yes;
                    for (int j = 0; j < recordVal.length; j++) {
                        if (recordVal[j] == "") throw new MissingFieldException("Missing field",j);
                    }
                    for (int j = 0; j < knownGenre.length+1; j++) {
                        if (j==knownGenre.length){throw new UnknownGenreException("Unkown field");};
                        if (knownGenre[j].equals(recordVal[4])){break;};
                    }
                    //write valid books to corresponding file
                    switch (recordVal[4]) {

                        case "CCB":
                            counter[0]++;
                            pCart.print(record + "\n");
                            break;
                        case "HCB":
                            counter[1]++;
                            pHobb.print(record + "\n");
                            break;
                        case "MTV":
                            counter[2]++;
                            pMovies.print(record + "\n");
                            break;
                        case "MRB":
                            counter[3]++;
                            pMusic.print(record + "\n");
                            break;
                        case "NEB":
                            counter[4]++;
                            pNost.print(record + "\n");
                            break;
                        case "OTR":
                            counter[5]++;
                            pOldt.print(record + "\n");
                            break;
                        case "SSM":
                            counter[6]++;
                            pSport.print(record + "\n");
                            break;
                        case "TPA":
                            counter[7]++;
                            pTrains.print(record + "\n");
                            break;
                    }
                } catch (TooManyFieldsException e) { counter[8]++;
                    pSerror.println("Syntax error in file: " + book[i] + "\n==================\n" + "Error: " + e.getMessage() + "\nRecord: " + record);
                } catch (MissingFieldException e) { counter[8]++;
                    pSerror.println("Syntax error in file: " + book[i] + "\n==================\n" + "Error: " + e.missingIndexName() + "\nRecord: " + record);
                } catch (TooFewFieldsException e) { counter[8]++;
                    pSerror.println("Syntax error in file: " + book[i] + "\n==================\n" + "Error: " + e.getMessage() + "\nRecord: " + record);
                } catch (UnknownGenreException e) { counter[8]++;
                    pSerror.println("Syntax error in file: " + book[i] + "\n==================\n" + "Error: " + e.getMessage() + "\nRecord: " + record);
                }
            }
        }
        //error checking
        // for (int i = 0; i < counter.length; i++) {
        //     System.out.println(counter[i]);
        // }
        pMovies.close();
        pMusic.close();
        pHobb.close();
        pNost.close();
        pOldt.close();
        pCart.close();
        pSerror.close();
        pSport.close();
        pTrains.close();
        scan1.close();
    }
    
    
    
    
/**
 *This method reads data from text files containing book records, validates the records, creates
 *Book objects and then serializes the objects into binary files.
 * BadIsbn10Exception when ISBN-10 is invalid
 * BadIsbn13Exception when ISBN-13 is invalid
 * BadPriceException when price is negative
 * BadYearException when publication year is not within the range 1995-2010        
 */
    public static void do_part2(){

        //Array of text file references
        String [] inputFileNames = {"Cartoons_Comics.csv",  "Hobbies_Collectibles.csv",  "Movies_TV_Books.csv",  "Music_Radio_Books.csv",  "Nostalgia_Eclectic_Books.csv",  "Old_Time_Radio_Books.csv",  "Sports_Sports_Memorabilia.csv",  "Trains_Planes_Automobiles.csv"};
        String [] outputFileNames = {"Cartoons_Comics.csv.ser",  "Hobbies_Collectibles.csv.ser",  "Movies_TV_Books.csv.ser",  "Music_Radio_Books.csv.ser",  "Nostalgia_Eclectic_Books.csv.ser",  "Old_Time_Radio_Books.csv.ser",  "Sports_Sports_Memorabilia.csv.ser",  "Trains_Planes_Automobiles.csv.ser"};

        //start of loop
        for (int z = 0; z < inputFileNames.length; z++) {

            //create input and output streams for correct files
            Scanner scan2 = null;
            ObjectOutputStream print2 = null;
            PrintWriter pError = null;
            try {
                scan2 = new Scanner(new FileInputStream(inputFileNames[z]));
            } catch (FileNotFoundException e) {
                System.out.println("File not opened, part 2 ");
            }

            //First run to determine array size
            int vcounter=0;
            int icounter=0;
            while (scan2.hasNextLine()) {

                try {
                    String fhalf;
                    String shalf;
                    String temp;
                    temp = scan2.nextLine();
                   // System.out.println(temp);
                    String[] tempVal;
                    if (temp.charAt(0) == '\"') {
                        fhalf = temp.substring(temp.indexOf('\"'), temp.lastIndexOf('\"') + 1);
                        String[] recordTemp = temp.substring(temp.lastIndexOf('\"') + 2, temp.length()).split(",");
                        tempVal = new String[recordTemp.length + 1];
                        tempVal[0] = fhalf;
                        for (int j = 1; j < recordTemp.length + 1; j++) {
                            tempVal[j] = recordTemp[j - 1];
                        }
                    } else {
                        tempVal = temp.split(",");
                    }
                    for (int i = 0; i < tempVal.length; i++) {
                       // System.out.println(tempVal[i]);
                    }


                    if (Double.parseDouble(tempVal[2]) < 0) {
                        throw new BadPriceException("");
                    } else if (Integer.parseInt(tempVal[5]) < 1995 || Integer.parseInt(tempVal[5]) > 2010) {
                        throw new BadYearException("");
                    } else if (tempVal[3].length() == 10) {
                        if (!validateISBN10(tempVal[3])) throw new BadIsbn10Exception("");
                    } else if (tempVal[3].length() == 13) {
                        if (!validateISBN13(tempVal[3])) throw new BadIsbn13Exception("");
                    }
                    vcounter++;
                } catch (BadIsbn10Exception e) {
                    icounter++;
                    //System.out.println("er1");
                } catch (BadIsbn13Exception e) {
                    icounter++;
                   // System.out.println("er2");
                } catch (BadPriceException e) {
                    icounter++;
                   // System.out.println("er3");
                } catch (BadYearException e) {
                    icounter++;
                   // System.out.println("er4");
                }
            }

            scan2.close();

            try {
                scan2 = new Scanner(new FileInputStream(inputFileNames[z]));
                print2 = new ObjectOutputStream(new FileOutputStream(outputFileNames[z]));
                if (z==0){pError = new PrintWriter(new FileOutputStream("semantic_error_file.txt"));}
                else {pError = new PrintWriter(new FileOutputStream("semantic_error_file.txt",true));}
            } catch (IOException e) {
                System.out.println("File not opened, part 2 ");
            }

            //error checking part 2
            //System.out.println("\n" + vcounter);
            // System.out.println(icounter);

            Book[] books = new Book[vcounter];
            int booksindex = 0;

            //Second run to create the book objects
            while (scan2.hasNextLine()) {

                String temp = null;
                try {
                    String fhalf;
                    String shalf;
                    temp = scan2.nextLine();
                    //System.out.println(temp);
                    String[] tempVal;
                    if (temp.charAt(0) == '\"') {
                        fhalf = temp.substring(temp.indexOf('\"'), temp.lastIndexOf('\"') + 1);
                        String[] recordTemp = temp.substring(temp.lastIndexOf('\"') + 2, temp.length()).split(",");
                        tempVal = new String[recordTemp.length + 1];
                        tempVal[0] = fhalf;
                        for (int j = 1; j < recordTemp.length + 1; j++) {
                            tempVal[j] = recordTemp[j - 1];
                        }
                    } else {
                        tempVal = temp.split(",");
                    }

                    //error checking
                    //for (int i = 0; i < tempVal.length; i++) {
                        //System.out.println(tempVal[i]);
                    //}


                    if (Double.parseDouble(tempVal[2]) < 0) {
                        throw new BadPriceException("");
                    } else if (Integer.parseInt(tempVal[5]) < 1995 || Integer.parseInt(tempVal[5]) > 2010) {
                        throw new BadYearException("");
                    } else if (tempVal[3].length() == 10) {
                        if (!validateISBN10(tempVal[3])) throw new BadIsbn10Exception("");
                    } else if (tempVal[3].length() == 13) {
                        if (!validateISBN13(tempVal[3])) throw new BadIsbn13Exception("");
                    }
                    books[booksindex] = new Book(tempVal);
                    print2.writeObject(books[booksindex]);
                    booksindex++;
                } catch (BadIsbn10Exception e) {
                    pError.println(temp);
                    //System.out.println("er1");
                } catch (BadIsbn13Exception e) {
                    pError.println(temp);
                    //System.out.println("er2");
                } catch (BadPriceException e) {
                    pError.println(temp);
                    //System.out.println("er3");
                } catch (BadYearException e) {
                    pError.println(temp);
                   // System.out.println("er4");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                scan2.close();
                print2.flush();
                print2.close();
                pError.close();
            } catch (IOException e) {
                System.out.println("erx");
            }


            //End of loop
        }
    }


    /**
     * This method performs part 3 of the assignment, which includes reading serialized Book objects from multiple
binary files, storing them in arrays, and allowing the user to interactively view the contents of the arrays.
    */   
    
    public static void do_part3(){
        String [] inputFileNames = {"Cartoons_Comics.csv.ser",  "Hobbies_Collectibles.csv.ser",  "Movies_TV_Books.csv.ser",  "Music_Radio_Books.csv.ser",  "Nostalgia_Eclectic_Books.csv.ser",  "Old_Time_Radio_Books.csv.ser",  "Sports_Sports_Memorabilia.csv.ser",  "Trains_Planes_Automobiles.csv.ser"};
        Book [][] unsBooks = new Book[8][];
        unsBooks[0]= new Book[21];
        unsBooks[1]= new Book[33];
        unsBooks[2]= new Book[700];
        unsBooks[3]= new Book[465];
        unsBooks[4]= new Book[49];
        unsBooks[5]= new Book[7];
        unsBooks[6]= new Book[179];
        unsBooks[7]= new Book[34];
        ObjectInputStream read3= null;

        for (int j = 0; j < inputFileNames.length; j++) {

            //Open binary file
            try {
                read3 = new ObjectInputStream(new FileInputStream(inputFileNames[j]));
            } catch (IOException e) {
                System.out.println("error p3");
            }

            //Read Book objects and assign them to array
            for (int i = 0; i < unsBooks[j].length; i++) {
                try {
                    unsBooks[j][i] = (Book) read3.readObject();
                    //error checking
                    //if (j==0||j==1){
                    //System.out.println(unsBooks[j][i].toString());
                    // }
                } catch (Exception e) {
                    System.out.println("error converting to object" + unsBooks[j][i]);
                }

            }
            try {
                read3.close();
            } catch (IOException e) {

            }
        }
            Scanner scan3 = new Scanner(System.in);
            boolean running = true;
            String menuI = "m";
            int fileV = 0;
            while(running){
                switch (menuI.toLowerCase()){
                    case "m":
                        System.out.println("-----------------------------\n" +
                                "Main Menu\n" +
                                "-----------------------------\n" +
                                "v View the selected file: "+inputFileNames[fileV]+" ("+unsBooks[fileV].length+" records)\n" +
                                "s Select a file to view\n" +
                                "x Exit\n" +
                                "-----------------------------\n");
                        System.out.println("Enter Your Choice:");
                        menuI=scan3.next();
                        break;
                    case "x":
                        System.exit(0);
                        break;
                    case "v":
                        System.out.println("viewing: "+inputFileNames[fileV]+" ("+unsBooks[fileV].length+" records)\n" );
                        boolean runningV = true;
                        String index;
                        int intIndex;
                        int currentFile=0;
                        while (runningV){
                            index=scan3.next();

                            try {
                                intIndex = Integer.parseInt(index);
                            }
                            catch (NumberFormatException e){
                                System.out.println("Did not enter an integer, going back to menu.");
                                break;
                            }
                            if (intIndex==0){break;}
                            else if (intIndex<0) {
                                for (int h = 0; h>intIndex ; h--) {
                                    try {
                                        System.out.println(unsBooks[fileV][currentFile + h].toString());
                                    }
                                    catch (ArrayIndexOutOfBoundsException e){
                                        currentFile=0;
                                        System.out.println("BOF has been reached");
                                        break;
                                    }
                                    if (h==intIndex+1){currentFile+=h;}

                                }
                            }
                            else if (intIndex>0) {
                                for (int h = 0; h<intIndex ; h++) {
                                    try {
                                        System.out.println(unsBooks[fileV][currentFile + h].toString());
                                    }
                                    catch (ArrayIndexOutOfBoundsException e){
                                        currentFile=unsBooks[fileV].length-1;
                                        System.out.println("EOF has been reached");
                                        break;
                                    }
                                    if (h==intIndex-1){currentFile+=h;}

                                }
                            }
                        }
                        menuI="m";
                        break;
                    case "s":
                        System.out.println("------------------------------\n" +
                                "File Sub-Menu\n" +
                                "------------------------------\n" +
                                "1 Cartoons_Comics_Books.csv.ser ("+unsBooks[0].length+" records)\n" +
                                "2 Hobbies_Collectibles_Books.csv.ser ("+unsBooks[1].length+" records)\n" +
                                "3 Movies_TV.csv.ser ("+unsBooks[2].length+" records)\n" +
                                "4 Music_Radio_Books.csv.ser ("+unsBooks[3].length+" records)\n" +
                                "5 Nostalgia_Eclectic_Books.csv.ser ("+unsBooks[4].length+" records)\n" +
                                "6 Old_Time_Radio.csv.ser ("+unsBooks[5].length+" records)\n" +
                                "7 Sports_Sports_Memorabilia.csv.ser ("+unsBooks[6].length+" records)\n" +
                                "8 Trains_Planes_Automobiles.csv.ser ("+unsBooks[7].length+" records)\n" +
                                "9 Exit\n" +
                                "------------------------------");

                            System.out.println("Enter Your Choice:");
                            while (!scan3.hasNextInt()) {
                                System.out.println("Invalid choice please try again: ");
                                scan3.next(); // this is important!
                            }
                            int verif = scan3.nextInt()-1;
                            if (verif!=8&&(verif<10)&&(verif>=0)){
                                fileV = verif;
                            }
                            else {System.out.println("Invalid Input Going Back To Menu");}


                        menuI="m";
                        break;
                    default:
                        System.out.println("Invalid input please try again");
                        menuI="m";
                        break;
                }
            }



        }



/**
 * method to check if isbn 10 is valid
 * @param a take a string that takes the isbn 10
 * @return true if the isbn is valid
 */
    public static boolean validateISBN10(String a){
        if (a.length()>10||a.lastIndexOf("X")==a.length()-1){return false;}
        int t=0;
        int v=10;
        for (int k =0; k<a.length();k++){
            t+=v*Integer.parseInt(a.substring(k,k+1));
            v--;
        }
        if (t%11==0){return true;}
        else {return false;}

    }

    /**
     * method to check if isbn 13 is valid
     * @param a take a string that takes the isbn 13
     * @return true if the isbn is valid
     */
    public static boolean validateISBN13(String a){
        if (a.length()>13||a.lastIndexOf("X")==a.length()-1){return false;}
        int t=0;

        for (int k =0; k<a.length();k++){
           if (k==0||k%2==0){t+=Integer.parseInt(a.substring(k,k+1));}
           else {t+=3*Integer.parseInt(a.substring(k,k+1));}
        }
        if (t%10==0){return true;}
        else {return false;}
    }
}


