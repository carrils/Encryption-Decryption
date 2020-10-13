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

/*
    TODO:
    - Figure out why we are writing nothing to output.txt
 */

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
                //System.out.println(encrypt(chars, key));
                if (usingData && usingIn) {
                    if (hasOut) {
                        PrintWriter writer = new PrintWriter(outPutFileName);
                        writer.println(encrypt(chars, key));
                        System.out.println("printed with printwriter to 1: " + outPutFileName);
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
                        //writer.println(encrypt(readFileAsString(inputFileName).toCharArray(), key));
                        encryptFile(inputFileName, outPutFileName, key);
                        System.out.println("printed with printwriter to 2: " + outPutFileName);

                    } else {
                        //System.out.println(encrypt(readFileAsString(inputFileName).toCharArray(), key));
                        System.out.println("printed with printwriter to 3: " + outPutFileName);
                    }
                }
                //[DECRYPT]
            } else if (mode.equals("dec")) {
                //System.out.println(decrypt(chars, key));
                if (usingData && usingIn) {
                    if (hasOut) {
                        PrintWriter writer = new PrintWriter(outPutFileName);
                        writer.println(decrypt(chars, key));
                        System.out.println("printed with printwriter to 4: " + outPutFileName);
                    } else {
                        System.out.println(decrypt(chars, key));
                    }
                } else if (usingIn) {
                    if (hasOut) {
                        PrintWriter writer = new PrintWriter(outPutFileName);
                        //write to outfile the decrypted string on infile
                        //writer.println(decrypt(readFileAsString(inputFileName).toCharArray(), key));
                        System.out.println("printed with printwriter to 6: " + outPutFileName);
                    } else {
                        //System.out.println(decrypt(readFileAsString(inputFileName).toCharArray(), key));
                        System.out.println("printed with printwriter to 7: " + outPutFileName);
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
//    public static String readFileAsString(String fileName) throws IOException {
//        //returns all text of a file as a single string
//        //return new String(Files.readAllBytes(Paths.get(fileName)));
//        String result = new String(Files.readAllBytes(Paths.get(fileName)));//store in result and return result var
//        return result;
//    }


    public static void encryptFile(String inputFileName, String outputFileName, int _key) {
        //it is in this method that you use the actual encrypt decrypt methods
        //because this is where we are going to iterate through all lines of a file
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        try(Scanner input = new Scanner(inputFile)){
            FileWriter output = new FileWriter(outputFile);
            while(input.hasNext()){
                char nullChar = 0; // \0
                char delChar = 127;// 007F
                int size = 128;
                String result = "";
                char[] fileLine = input.next().toCharArray();
                for (char item : fileLine) {
                    char shiftItem = (char) (((item - nullChar + _key) % size) + nullChar);
                    result += shiftItem;
                }
                System.out.println(result);
                output.write(result);
                output.close();
            }
        }catch(FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }finally {
        }
    }
}