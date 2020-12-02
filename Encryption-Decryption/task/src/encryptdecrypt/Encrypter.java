package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//common strategy interface with one abstract method
interface EncryptMethod{
    String encrypt(char[] _chars, int _key);
}
/*
    Main difference between unicode and shift is that
    shift only handles letters A-Za-z and not special characters.
    Unicode does.
 */

//concrete strategy
class UnicodeEncrypt implements EncryptMethod{
     @Override
    public String encrypt(char[] _chars, int _key) {
        //this is unicode algorithm
        char nullChar = 0; // \0
        int size = 128;
        String result = "";
        //for-each loop for encrypting chars array
        for (char item : _chars) {
            //calculates ASCII value of character after shifting <key>, casts ASCII value back to char
            char shiftItem = (char) (((item - nullChar + _key) % size) + nullChar);
            //concatenate the shifted char back into the file line 'result'
            result += shiftItem;
        }
        return result;
    }
}

//concrete strategy
//the from-files need to be their own concrete strategy because the function name needs to be
//the implementation of the CSI abstract function name and also needs to be able to call it in context
class UnicodeEncryptFromFile implements EncryptMethod{
    public static void encrypt(String inputFileName, String outputFileName, int _key, boolean usingOut) {
        //The encrypt method for files
        //Takes 4 parameters, Encrypts according to key value and prints according to usingOut value
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        try (Scanner input = new Scanner(inputFile)) {
            //can possibly clean this up? filewriter might be able to
            //be cleaned up like scanner in the try()
            FileWriter output = new FileWriter(outputFile);

            while (input.hasNext()) {
                //encrypt loop
                char nullChar = 0; // \0
                int size = 128;
                String result = "";
                char[] fileLine = input.nextLine().toCharArray();
                for (char item : fileLine) {
                    //calculates ASCII value of character after shifting <key>, casts ASCII value back to char
                    char shiftItem = (char) (((item - nullChar + _key) % size) + nullChar);
                    //concatenate the shifted char back into the file line 'result'
                    result += shiftItem;
                }
                //print either to standard output or to file depending on boolean 'usingOut'
                if (usingOut) {
                    output.write(result);
                } else {
                    System.out.print(result);
                }
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}

//concrete strategy
class ShiftEncrypt implements EncryptMethod{
    @Override
    public String encrypt(char[] _chars, int _key) {
        //do we need these chars? might just be able to use character literals
        //for comparison and shiftItem calculation
        char a = 'a';
        char A = 'A';
        char z = 'z';
        char Z = 'Z';
        int size = 26;
        String result = "";
        //for-each encrypting the chars array
        for(char item: _chars){
            if (item >= a && item <= z){
                char shiftItem = (char) (((item - a + _key) % size) + a);
                result += shiftItem;
            } else if (item >= A && item <= Z){
                char shiftItem = (char) (((item - A + _key) % size) + A);
                result += shiftItem;
            }
        }
        return result;
    }
}

//context
class MessageEncrypter{
    //the reference to the csi
    private EncryptMethod method;

    //allows us to change the method of encryption
    public void setEncryptMethod(EncryptMethod method) {
        this.method = method;
    }

    //this is the delegation of execution (encryption) to a concrete strategy through the csi
    //since we are making the "from-file" encrypt and decrypt methods their own strategy
    //we will need to make an object that holds all necessary parameters and pass them to this
    public void encrypt(char[] _chars, int _key){
        /*
        This right here is the special sauce and what makes Strategy as a design pattern good.
        because the encryption method of each concrete strategy shares the
        same name (encrypt) you can do this: this.method.encrypt(_chars, _key);
        literally, the method <method> of type <EncryptMethod>, use the encrypt function common
        between all concrete strategies on this set of chars using this key
         */
        this.method.encrypt(_chars, _key);
    }
}
