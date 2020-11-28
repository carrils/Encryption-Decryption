package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

interface Encryptor{
    String encrypt(char[] _chars, int _key);
}

 class Encrypter implements Encryptor{

    public String encrypt(char[] _chars, int _key) {
        //method for encrypt
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

    public static void encryptFile(String inputFileName, String outputFileName, int _key, boolean usingOut) {
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

    public static void encrypt_NewAlg() {

    }
}
