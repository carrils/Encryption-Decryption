/*
Sam Carrillo
7.11.2020
--------------
This program is a multi-use encryption/decryption program.
It can both encrypt and decrypt text. It can read and write cipher
text to files.
--------------
Assumptions:
1. If there is no -mode, the program should work in enc mode.
2. If there is no -key, the program should consider that key = 0.
3. If there is no -data, and there is no -in the program should assume that the data is an empty string.
4. If there is no -out argument, the program must print data to the standard output.
5. If there are both -data and -in arguments, your program should prefer -data over -in.
 */
package encryptdecrypt;

import java.io.*;
import java.util.Scanner;
/*
TODO:
- make it so you do not have to use absolute file paths on -in and -out when running from CLI
- add in different algorithm functionality i.e shift or hash etc etc.
 */
public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        char[] chars = {};
        boolean usingData = false;
        boolean usingIn = false;
        boolean hasOut = false;
        String inputFileName = "";
        String outPutFileName = "";

        //Parameter processing
        for (int i = 0; i < args.length - 1; i += 2) {
            //iterates by 2, {[-in] [input.txt]} are 2 elements, if -in is 0, input.txt is 1 or i+1
            //keys on odd value iterations to grab parameters from command line
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

        //Execution
        try {
            //[Encrypt]
            if (mode.equals("enc")) {
                PrintWriter writer = new PrintWriter(outPutFileName);
                if (usingData && usingIn) {
                    //both using in and data
                    if (hasOut) {
                        writer.println(encrypt(chars, key));
                    } else {
                        System.out.println(encrypt(chars, key));
                    }
                } else if (usingIn) {
                    //in only
                    if (hasOut) {
                        //write to outfile the encrypted string of infile
                        encryptFile(inputFileName, outPutFileName, key, true);
                    } else {
                        encryptFile(inputFileName, outPutFileName, key, false);
                    }
                } else {
                    //If there is no -data, and there is no -in
                    //the program should assume that the data is an empty string.
                    if (hasOut) {
                        writer.println(chars);
                    } else {
                        System.out.println(chars);
                    }
                }
                //[Decrypt]
            } else if (mode.equals("dec")) {
                PrintWriter writer = new PrintWriter(outPutFileName);
                if (usingData && usingIn) {
                    //using both in and data
                    if (hasOut) {
                        writer.println(decrypt(chars, key));
                    } else {
                        System.out.println(decrypt(chars, key));
                    }
                } else if (usingIn) {
                    //using in only
                    if (hasOut) {
                        //write to outfile the decrypted string of infile
                        decryptFile(inputFileName, outPutFileName, key, true);
                    } else {
                        decryptFile(inputFileName, outPutFileName, key, false);
                    }
                } else {
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
        int size = 128;
        String result = "";
        //for-each loop for decrypting chars array
        for (char item : _chars) {
            //calculates ASCII value of character after shifting <key>, casts ASCII value back to char
            char shiftItem = (char) (((item + nullChar - _key) % size) - nullChar);
            //concatenate the shifted char back into the file line 'result'
            result += shiftItem;
        }
        return result;
    }

    public static String encrypt(char[] _chars, int _key) {
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

    public static void decryptFile(String inputFileName, String outputFileName, int _key, boolean usingOut) {
        //The encrypt method for files
        //Takes 4 parameters, Encrypts according to key value and prints according to usingOut value
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        try (Scanner input = new Scanner(inputFile)) {
            FileWriter output = new FileWriter(outputFile);

            while (input.hasNext()) {
                //encrypt loop
                char nullChar = 0; // \0
                char delChar = 127;// 007F
                int size = 128;
                String result = "";
                char[] fileLine = input.next().toCharArray();
                for (char item : fileLine) {
                    //calculates ASCII value of character after shifting <key>, casts ASCII value back to char
                    char shiftItem = (char) (((item + nullChar - _key) % size) - nullChar);
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