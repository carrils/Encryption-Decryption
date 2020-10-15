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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //set with default parameters per instructions
        String mode = "enc";
        int key = 0;
        char[] chars = {};//presume data is an empty string
        boolean usingData = false;// usingIn redundant? could just be this one
        boolean usingIn = false;// redundant?
        boolean hasOut = false;
        String inputFileName = "";
        String outPutFileName = "";

        //parameter processing
        for (int i = 0; i < args.length - 1; i += 2) {
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
                    usingIn = true;
                    inputFileName = args[i + 1];

                    break;
                case "-out":
                    hasOut = true;
                    outPutFileName = args[i + 1];
                    break;
            }
        }

        //doing portion
        try {
            //[ENCRYPT]
            if (mode.equals("enc")) {
                PrintWriter writer = new PrintWriter(outPutFileName);
                if (usingData && usingIn) {
                    //both using in and data
                    if (hasOut) {
                        writer.println(encrypt(chars, key));
                        System.out.println("printed with printwriter to 1: " + outPutFileName);
                    } else {
                        System.out.println(encrypt(chars, key));
                        System.out.println("printed with printwriter to 2: " + outPutFileName);
                    }
                } else if (usingIn) {
                    //in only
                    if (hasOut) {
                        //PrintWriter writer = new PrintWriter(outPutFileName);
                        //write to outfile the encrypted string of infile
                        encryptFile(inputFileName, outPutFileName, key, true);
                        System.out.println("printed with printwriter to 3: " + outPutFileName);
                    } else {
                        //System.out.println(encrypt(chars, key));//this is from -data and not -in
                        encryptFile(inputFileName, outPutFileName, key, false);
                        System.out.println("printed with printwriter to 4: " + outPutFileName);
                    }
                } else {
                    //case where no data and no in
                    //If there is no -data, and there is no -in
                    //the program should assume that the data is an empty string.
                    if (hasOut) {
                        writer.println(chars);//this should be right provided chars is empty
                    } else {
                        System.out.println(chars);
                    }
                }
                //[DECRYPT]
            } else if (mode.equals("dec")) {
                PrintWriter writer = new PrintWriter(outPutFileName);
                if (usingData && usingIn) {
                    //using both in and data
                    if (hasOut) {
                        writer.println(decrypt(chars, key));
                        System.out.println("printed with printwriter to 5: " + outPutFileName);
                    } else {
                        System.out.println(decrypt(chars, key));
                    }
                } else if (usingIn) {
                    //using in only
                    if (hasOut) {
                        //write to outfile the decrypted string on infile
                        //writer.println(decrypt(readFileAsString(inputFileName).toCharArray(), key));
                        decryptfile(inputFileName, outPutFileName, key, true);
                        System.out.println("printed with printwriter to 6: " + outPutFileName);
                    } else {
                        //System.out.println(decrypt(readFileAsString(inputFileName).toCharArray(), key));
                        decryptfile(inputFileName, outPutFileName, key, false);
                        System.out.println("printed with printwriter to 7: " + outPutFileName);
                    }
                } else {
                    //case where no data and no in
                    //If there is no -data, and there is no -in
                    //the program should assume that the data is an empty string.
                    if (hasOut) {
                        writer.println(chars);
                    } else {
                        System.out.println(chars);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found, " + e.getMessage());
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

    public static void encryptFile(String inputFileName, String outputFileName, int _key, boolean usingOut) {
        //make this return string so that we can use this on scenario:
        //-in but no -out, that way we can print the string <---- here
        //and write the string, -in and -out <----- here
        //could just add flag to see if it is has an -out and if so write, if not print
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        String fileString = "";
        try (Scanner input = new Scanner(inputFile)) {
            FileWriter output = new FileWriter(outputFile);
            while (input.hasNext()) {
                char nullChar = 0; // \0
                char delChar = 127;// 007F
                int size = 128;
                String result = "";
                char[] fileLine = input.nextLine().toCharArray();
                for (char item : fileLine) {
                    char shiftItem = (char) (((item - nullChar + _key) % size) + nullChar);
                    result += shiftItem;
                }
                if (usingOut) {
                    output.write(result);
                } else {
                    System.out.print(result); //<--- here is the string return
                }
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public static void decryptfile(String inputFileName, String outputFileName, int _key, boolean usingOut) {
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        try (Scanner input = new Scanner(inputFile)) {
            FileWriter output = new FileWriter(outputFile);
            while (input.hasNext()) {
                char nullChar = 0; // \0
                char delChar = 127;// 007F
                int size = 128;
                String result = "";
                char[] fileLine = input.next().toCharArray();
                for (char item : fileLine) {
                    char shiftItem = (char) (((item + nullChar - _key) % size) - nullChar);
                    result += shiftItem;
                }
                if (usingOut) {
                    output.write(result);
                } else {
                    System.out.print(result); //<--- here is the string return
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