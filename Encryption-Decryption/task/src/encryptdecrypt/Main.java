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

public class Main {
    public static void main(String[] args) {
        //set with default parameters per instructions
        String mode = "enc";
        int key = 0;
        char[] chars = {};//presume data is an empty string
        boolean usingData = false;
        boolean hasOut = false;
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
            //If there are both -data and -in arguments, your program should prefer -data over -in.
            switch (args[i]){
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
                    if (usingData) {
                        break;
                    } else {
                        //only has to initialize the file.
                        //the try catch will be in the doing portion
                        File inputFile = new File(args[i + 1]);
                    }
                    break;
                case "-out":
                    //mkdir i think
                    hasOut = true;
                    File outPutFile = new File(args[i] + 1);
                    break;
            }
        }

        //doing portion
        if (mode.equals("enc")) {
            //System.out.println(encrypt(chars, key));
        } else if (mode.equals("dec")) {
            //System.out.println(decrypt(chars, key));
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
}