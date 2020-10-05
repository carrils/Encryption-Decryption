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
        long tempPop = 0; //tempPop variable to hold previous population
        long previousPopulation = 0;
        try {
            Scanner input = new Scanner(populationData);

            while (input.hasNext()) {
                try {
                    //System.out.println(Arrays.toString(input.nextLine().split("\t")));
                    //int population = Integer.parseInt(fileLine[1].replaceAll(",",""));//NFE
                    String[] fileLine = input.nextLine().split("\t");
                    long tempDiff = 0;
                    long diff = 0;
                    if (i >= 1) {
                        //skip header of file
                        tempPop = (long) NumberFormat.getNumberInstance(Locale.US).parse(fileLine[1]);
                        System.out.println(tempPop);
                        if (previousPopulation != 0) {
                            //start calculating population increases
                            tempDiff = tempPop - previousPopulation;
                            if(tempDiff > diff){
                                //find the biggest population increase
                                diff = tempDiff;
                            }
                        }
                    }
                } catch (ParseException e) {
                    System.out.println("<Unparseable line>");
                }
                i++;
                previousPopulation = tempPop;
            }
        } catch (FileNotFoundException e) {
            //every time you pass Scanner a File you must handle FNFE
            System.out.println("File not found: " + populationData.getName());
        }

    }
}
