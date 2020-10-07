/*
Sam Carrillo
10.06.20
-------------
This program takes in a file with
a specific data set and format and
finds the year in that data set with
the highest population growth
 */
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FindLargestPopulationIncrease {
    public static void main(String[] args) {
        File populationData = new File("dataset_91069.txt");
        int i = 0;
        long population = 0; //population variable to hold previous population
        long previousPopulation = 0;
        long populationDiff = 0;
        int year = 0;
        try {
            Scanner input = new Scanner(populationData);

            while (input.hasNext()) {
                try {
                    //System.out.println(Arrays.toString(input.nextLine().split("\t")));
                    //int population = Integer.parseInt(fileLine[1].replaceAll(",",""));//NFE
                    String[] fileLine = input.nextLine().split("\t");
                    long tempDiff = 0;

                    if (i >= 1) {
                        //skip header of file
                        population = (long) NumberFormat.getNumberInstance(Locale.US).parse(fileLine[1]);
                        //System.out.println(population);
                        if (previousPopulation != 0) {
                            //start calculating population increases
                            tempDiff = population - previousPopulation;
                            if(tempDiff > populationDiff){
                                //find the biggest population increase and which year
                                populationDiff = tempDiff;
                                year = Integer.parseInt(fileLine[0]);
                            }
                        }
                    }
                } catch (ParseException e) {
                    System.out.println("<Unparseable line>");
                }
                i++;
                previousPopulation = population;
            }
        } catch (FileNotFoundException e) {
            //every time you pass Scanner a File you must handle File not found exception
            System.out.println("File not found: " + populationData.getName());
        }finally{
            System.out.println("Biggest population jump: "+ year + ", by " + populationDiff);
        }
    }
}
