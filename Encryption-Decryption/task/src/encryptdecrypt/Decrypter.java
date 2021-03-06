package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//Common Strategy Interface
interface DecryptMethod {
    String decrypt(AggregateMessage message);
}

//concrete strategy
class UnicodeDecrypt implements DecryptMethod {
    public  String decrypt(AggregateMessage message) {
        //method for decrypt
        char nullChar = 0;//beginning of base ASCII table
        int size = 128;
        String result = "";
        //for-each loop for decrypting chars array
        for (char item : message.chars) {
            //calculates ASCII value of character after shifting <key>, casts ASCII value back to char
            char shiftItem = (char) (((item + nullChar - message.key) % size) - nullChar);
            //concatenate the shifted char back into the file line 'result'
            result += shiftItem;
        }
        return result;
    }
}

//concrete strategy
class UnicodeDecryptFromFile implements DecryptMethod {
    public String decrypt(AggregateMessage message) {
        //The encrypt method for files
        //Takes 4 parameters, Encrypts according to key value and prints according to usingOut value
        File inputFile = new File(message.inputFile);
        File outputFile = new File(message.outputFile);
        String result = "";
        try (Scanner input = new Scanner(inputFile)) {


            while (input.hasNext()) {
                //encrypt loop
                char nullChar = 0; // \0
                char delChar = 127;// 007F
                int size = 128;

                char[] fileLine = input.next().toCharArray();
                for (char item : fileLine) {
                    //calculates ASCII value of character after shifting <key>, casts ASCII value back to char
                    char shiftItem = (char) (((item + nullChar - message.key) % size) - nullChar);
                    //concatenate the shifted char back into the file line 'result'
                    result += shiftItem;
                }
                //print either to standard output or to file depending on boolean 'usingOut'

                // *** HERE ***
                //separate the writing mechanism and mete out printwriting to client code
                //this way we can return a string and have it match the common strategy interface return type

            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        return result;
    }
}

//concrete strategy
class ShiftDecrypt implements DecryptMethod{
    @Override
    public String decrypt(AggregateMessage message) {
        char a = 'a';
        char A = 'A';
        char z = 'z';
        char Z = 'Z';
        int size = 26;
        String result = "";
        //for-each decrypting the chars array
        for(char item: message.chars){
            if (item >= a && item <= z){
                char shiftItem = (char) (((item + a - message.key) % size) - a);
                result += shiftItem;
            } else if (item >= A && item <= Z){
                char shiftItem = (char) (((item + A - message.key) % size) - A);
                result += shiftItem;
            }
        }
        return result;
    }
}

//context
class MessageDecrypter{
    private DecryptMethod method;

    public void setMethod(DecryptMethod method) {
        this.method = method;
    }

    //since we are making the "from-file" encrypt and decrypt methods their own strategy
    //we will need to make an object that holds all necessary parameters and pass them to this
    public void decrypt (AggregateMessage message){
        //specialsaus
        this.method.decrypt(message);
    }
}

