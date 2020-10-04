import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FindLargestPopulationIncrease {
    public static void main(String[] args) {
        File populationData = new File("dataset_91069.txt");

        try {
            Scanner input = new Scanner(populationData);

            while(input.hasNext()){
                try{
                    //System.out.println(Arrays.toString(input.nextLine().split("\t")));
                    //int population = Integer.parseInt(fileLine[1].replaceAll(",",""));//NFE
                    String [] fileLine = input.nextLine().split("\t");
                    long x = (long) NumberFormat.getNumberInstance(Locale.US).parse(fileLine[1]);//PE
                    System.out.println(x);
                }catch(ParseException e){
                    System.out.println("<Unparseable line>");
                }
            }
        } catch (FileNotFoundException e) {
            //every time you pass Scanner a File you must handle FNFE
            System.out.println("File not found: " + populationData.getName());
        }

    }
}
