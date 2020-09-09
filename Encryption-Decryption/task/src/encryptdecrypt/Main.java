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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operation = input.nextLine();
        char[] chars = input.
                nextLine().toCharArray();
        int key = input.nextInt();

        if(operation.equals("enc")){
            System.out.println(encrypt(chars,key));
        }else if(operation.equals("dec")){
            System.out.println(decrypt(chars,key));
        }

    }

    public static String decrypt(char[]_chars, int _key){
        //method for decrypt
        char nullChar = 0;//beginning of base ASCII table
        char delChar = 127;//ending of base ASCII table
        int size = 128;
        String result = "";
        //for-each loop for decrypting chars array
        for(char item : _chars){
            char shiftItem = (char)(((item + nullChar - _key) % size) - nullChar);
            result += shiftItem;
        }
        return result;
    }

    public static String encrypt(char[] _chars, int _key){
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