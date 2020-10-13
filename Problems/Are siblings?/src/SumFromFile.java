import java.io.*;
import java.util.Scanner;

public class SumFromFile {
    public static void main(String[] args) throws IOException {
        /*This will only work if the .txt file is
        * in the root directory of your project!
        * otherwise is is necessary to specify the absolute path:
        * /Users/sam/IdeaProjects/Encryption-Decryption/Problems/Are siblings?/src/dataset_91033.txt */
        File dataset = new File("dataset_91033.txt");
        File output = new File("outputSumFromFile.txt");
        boolean newFile = output.createNewFile();
        System.out.println(newFile);
        FileWriter myWriter = new FileWriter(output);
        myWriter.write("ayy lmao");


        int total = 0;
        try{
            Scanner input = new Scanner(dataset);
            while(input.hasNext()){
                total += Integer.parseInt(input.next());
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        System.out.println(total);
        myWriter.write("Total: " + total);
        myWriter.close();
    }
}
