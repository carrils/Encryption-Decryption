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

/*
    TODO
       - The program must parse three arguments: -mode, -key and -data.
            The first argument should determine the program’s mode (enc for encryption, dec for decryption).
            The second argument is an integer key to modify the message,
            and the third argument is a text or ciphertext to encrypt or decrypt.
       - Test 
 */
/*
for the part where parameters dont come in a set order just use this and put a conditional on the args[i]
        for (int i = 0; i < args.length - 1; i += 2) {
            System.out.println(args[i] + "=" + args[i + 1]);
        }
 */
public class Main {
    public static void main(String[] args) {
        //set with default parameters per instructions
        String mode = "enc";
        int key = 0;
        char[] chars = {};//presume data is an empty string?
        for (int i = 0; i < args.length - 1; i += 2) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.valueOf(args[i + 1]);
            } else if (args[i].equals("-data")) {
                chars = args[i + 1].toCharArray();
//                for (int j = 0; i < args[i + 1].length(); j++) {
//                    chars[j] +=
//                }
            }
        }


        if (mode.equals("enc")) {
            System.out.println(encrypt(chars, key));
        } else if (mode.equals("dec")) {
            System.out.println(decrypt(chars, key));
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
}