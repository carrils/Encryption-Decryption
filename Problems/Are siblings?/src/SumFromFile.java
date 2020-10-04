import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class SumFromFile {
    public static void main(String[] args){
        File dataset = new File("/Users/sam/IdeaProjects/Encryption-Decryption/Problems/Are siblings?/src/dataset_91033.txt");
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
    }
}
