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
    - make it read in 3 parameters
        target operation for encryption and decryption (enc and dec)
        message
        integer key (shift)
    - All non-characters should be encrypted as well (use unicode table for number representation of each char)
    - decompose program, methods for encrypting and decrypting
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] chars = input.nextLine().toCharArray();
        int key = input.nextInt();

        char a = 'a';
        char z = 'z';
        int size = 26;

        //for-each loop for encrypting chars array
        for (char item : chars) {
            if (item >= a && item <= z) {
                char shiftItem = (char) (((item - a + key) % size) + a);
                System.out.print(shiftItem);
            } else {
                System.out.print(item);
            }
        }
    }
}