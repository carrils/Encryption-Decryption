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

public class Main {
    public static void main(String[] args) {
        String sourceString = "we found a treasure!";

        //create a character array of the String & alphabet char array
        char[] fruitloops = sourceString.toCharArray();
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        //encrypt fruitloops
        for(int i = 0; i < fruitloops.length; i++){
            for(int j = 0; j < alphabet.length; j++){
                if(fruitloops[i] == alphabet[j]){
                    fruitloops[i] = alphabet[25 - j];
                    break;
                }
            }
        }

        //print result
        String encryptedSource = new String(fruitloops);
        System.out.println(encryptedSource);
    }
}
