/*
Sam Carrillo
7.11.2020
--------------
This is a program that encrypts a message
"we found a treasure!"
replacing each letter with the letter that
is in the corresponding position from the end
of the English alphabet
(a→z, b→y, c→x, ... x→c, y →b, z→a)
 */
package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //set with default parameters per instructions
        String mode = "enc";
        int key = 0;
        char[] chars = {};//presume data is an empty string
        boolean usingData = false;
        boolean usingIn = false;
        boolean hasOut = false;
        String inputFileName = ""; //should these be strings for the file names or actually files
        String outPutFileName = ""; //same^ and null?

        //parameter processing
        for (int i = 0; i < args.length - 1; i += 2) {
            //change to case switch?
//            if (args[i].equals("-mode")) {
//                mode = args[i + 1];
//            } else if (args[i].equals("-key")) {
//                key = Integer.valueOf(args[i + 1]);
//            } else if (args[i].equals("-data")) {
//                chars = args[i + 1].toCharArray();
//            }

            //If there is no -out argument, the program must print data to the standard output.
            //If there are both -data and -in arguments, your program should prefer -data over -in.
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    usingData = true;
                    chars = args[i + 1].toCharArray();
                    break;
                case "-in":
                    //order might matter as in if -in before -data it would see usingData as false
                    //only has to initialize the file.
                    //the try catch will be in the doing portion
                    usingIn = true;
                    inputFileName = args[i + 1];

                    break;
                case "-out":
                    hasOut = true;
                    outPutFileName = args[i] + 1;
                    break;
            }
        }

        //doing portion
        try {
            //[ENCRYPT]
            if (mode.equals("enc")) {
                //System.out.println(encrypt(chars, key));
                if (usingData && usingIn) {
                    if (hasOut) {
                        PrintWriter writer = new PrintWriter(outPutFileName);
                        writer.println(encrypt(chars, key));
                    } else if (usingIn) {
                        System.out.println(encrypt(chars, key));
                    } else {
                        //If there is no -data, and there is no -in the program should assume that the data is an empty string.
                    }
                } else if (usingIn) {
                    //encrypt(input file > string > char array, key)
                    if (hasOut) {
                        PrintWriter writer = new PrintWriter(outPutFileName);
                        //write to outfile the encrypted string of infile
                        writer.println(encrypt(readFileAsString(inputFileName).toCharArray(), key));
                    } else {
                        System.out.println(encrypt(readFileAsString(inputFileName).toCharArray(), key));
                    }
                }
                //[DECRYPT]
            } else if (mode.equals("dec")) {
                //System.out.println(decrypt(chars, key));
                if (usingData && usingIn) {
                    if (hasOut) {
                        PrintWriter writer = new PrintWriter(outPutFileName);
                        writer.println(decrypt(chars, key));
                    } else {
                        System.out.println(decrypt(chars, key));
                    }
                } else if (usingIn) {
                    if (hasOut) {
                        PrintWriter writer = new PrintWriter(outPutFileName);
                        //write to outfile the decrypted string on infile
                        writer.println(decrypt(readFileAsString(inputFileName).toCharArray(), key));
                    } else {
                        System.out.println(decrypt(readFileAsString(inputFileName).toCharArray(), key));
                    }
                } else {
                    //If there is no -data, and there is no -in the program should assume that the data is an empty string.
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found, " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: IOException, " + e.getMessage());
        } finally {

        }

    }

    public static String decrypt(char[] _chars, int _key) {
        //method for decrypt
        char nullChar = 0;//beginning of base ASCII table
        char delChar = 127;//ending of base ASCII table
        int size = 128;
        String result = "";
        //for-each loop for decrypting chars array
        for (char item : _chars) {
            char shiftItem = (char) (((item + nullChar - _key) % size) - nullChar);
            result += shiftItem;
        }
        return result;
    }

    public static String encrypt(char[] _chars, int _key) {
        //method for encrypt
        char nullChar = 0; // \0
        char delChar = 127;// 007F
        int size = 128;
        String result = "";
        //for-each loop for encrypting chars array
        for (char item : _chars) {
            char shiftItem = (char) (((item - nullChar + _key) % size) + nullChar);
            result += shiftItem;
        }
        return result;
    }

    public static String readFileAsString(String fileName) throws IOException {
        //returns all text of a file as a single string
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}