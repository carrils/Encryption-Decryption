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
/*
    TODO:
    - All non-characters should be encrypted as well (use unicode table for number representation of each char)
    - fill out decrypt
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operation = input.nextLine();
        char[] chars = input.nextLine().toCharArray();
        int key = input.nextInt();


    }

    public static String decrypt(char[]_chars, int _key){
        //this is encrypt in reverse first get all nonalphabetic chars encrypted
        String result = "";
        return result;
    }

    public static String encrypt(char[] _chars, int _key){
        char a = 'a';
        char z = 'z';
        int size = 26;
        String result = "";
        //for-each loop for encrypting chars array
        for (char item : _chars) {
            if (item >= a && item <= z) {
                char shiftItem = (char) (((item - a + _key) % size) + a);
                result += shiftItem;
            } else {
                //this is all the non-alphabetical characters.
                //widen to cover these to and just += shift item
                System.out.print(item);
            }
        }
    }
}