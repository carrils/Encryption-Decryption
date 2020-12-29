/*
Sam Carrillo
11.30.2020
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
6. If there is no -alg argument, algorithm type shift is assumed.
 */
package encryptdecrypt;

import java.io.*;
import java.util.Scanner;
/*
TODO:
- make it so you do not have to use absolute file paths on -in and -out when running from CLI
- reference the 'context' class of Encrypter or Decrypter based on what is in -alg arg. default to shift <--here-->
- need to make shiftDecryptFromFile
- logically hash out the exection portion, cover redundancies and catch uncaught options (if there are any)
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

        //need to create an aggregate type here to reference in the execution portion
        //perhaps to be ambiguous and remove the redundant class
        EncryptedMessage msg = new EncryptedMessage();
        msg.key = key;
        msg.chars = chars;
        msg.inputFile = inputFileName;
        msg.outputFile = outPutFileName;
        msg.usingOut = hasOut;

        //Execution
        try {
            //[Encrypt]
            if (mode.equals("enc")) {
                //PrintWriter writer = new PrintWriter(outPutFileName);
                FileWriter output = new FileWriter(msg.outputFile);
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
                PrintWriter writer = new PrintWriter(outPutFileN ame);
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
        } catch (IOException e) {
            System.err.println("Error: IOException, " + e.getMessage());
        }
    }
}

