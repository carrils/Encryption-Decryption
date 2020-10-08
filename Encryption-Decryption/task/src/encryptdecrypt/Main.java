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

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        //set with default parameters per instructions
        String mode = "enc";
        int key = 0;
        char[] chars = {};//presume data is an empty string
        boolean usingData = false;
        boolean usingIn = false;
        boolean hasOut = false;
        String inputFile = ""; //should these be strings for the file names or actually files
        String outPutFile = ""; //same^ and null?

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
            //If there is no -mode, the program should work in enc mode.
            //If there is no -key, the program should consider that key = 0.
            //If there is no -data, and there is no -in the program should assume that the data is an empty string.
            //If there is no -out argument, the program must print data to the standard output.
            //If there are both -data and -in arguments, your program should prefer -data over -in. (
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.valueOf(args[i + 1]);
                    break;
                case "-data":
                    usingData = true;
                    chars = args[i + 1].toCharArray();
                    break;
                case "-in":
                    //order might matter as in if -in before -data it would see usingdata as false
                    //only has to initialize the file.
                    //the try catch will be in the doing portion
                    usingIn = true;
                    inputFile = args[i + 1];

                    break;
                case "-out":
                    //mkdir i think
                    hasOut = true;
                    outPutFile = args[i] + 1;
                    break;
            }
        }

        //doing portion
        if (mode.equals("enc")) {
            //System.out.println(encrypt(chars, key));
            if (usingData && usingIn) {
                //go into Data processing
                encrypt(chars, key);
                if (hasOut) {
                    try {
                        PrintWriter output = new PrintWriter(outPutFile);
                    }  catch (FileNotFoundException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }

        } else if (mode.equals("dec")) {
            //System.out.println(decrypt(chars, key));
        }

    }

    public static void decrypt(char[] _chars, int _key) {
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
        //return result;
    }

    public static void encrypt(char[] _chars, int _key) {
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
        //return result;
    }
}