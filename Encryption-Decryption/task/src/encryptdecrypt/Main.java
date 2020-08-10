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
        String sourceString = input.nextLine();
        int key = input.nextInt();

        //create a character array of the String & alphabet char array
        char[] sourceArray = sourceString.toCharArray();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        //data structure for encrypting sourceArray
        for (int i = 0; i < sourceArray.length; i++) {
            //ignore spaces, add in here anything you want to ignore. can be better.
            if(sourceArray[i] == ' '){
                continue;
            }
            for (int j = 0; j <= alphabet.length; j++) {
                //make A follow Z if not found in first revolution
                if (j == alphabet.length) {
                    j = 0;
                }
                //encrypt sourceArray with the key
                if (sourceArray[i] == alphabet[j]) {
                    //if value after shifting > 25, adjust shifted value
                    if (j + key > alphabet.length) {
                        sourceArray[i] = alphabet[(j - 26) + key];
                        break;
                    } else {
                        sourceArray[i] = alphabet[j + key];
                        break;
                    }
                }
            }
        }

        //print result
        String encryptedSource = new String(sourceArray);
        System.out.println(encryptedSource);
    }
}
/* "official solution"
IMPROVISE
ADAPT
OVERCOME
LMAO

package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int shift = scanner.nextInt();

        char a = 'a';
        char z = 'z';
        int size = 26;

        for (char item : chars) {
            if (item >= a && item <= z) {
                char shiftItem = (char) (((item - a + shift) % size) + a);
                System.out.print(shiftItem);
            } else {
                System.out.print(item);
            }
        }
    }
}
 */