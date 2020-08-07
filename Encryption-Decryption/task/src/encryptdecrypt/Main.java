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
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        //encrypt sourceArray
        for(int i = 0; i < sourceArray.length; i++){
            for(int j = 0; j < alphabet.length; j++){//fix going over 26 by making a follow z
                if(sourceArray[i] == alphabet[j]){
                    sourceArray[i] = alphabet[j + key];
                    break;
                }
            }
        }

        //print result
        String encryptedSource = new String(sourceArray);
        System.out.println(encryptedSource);
    }
}
