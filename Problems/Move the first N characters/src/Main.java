/*
Sam Carrillo
8.1.2020
--------------
This program takes in a string s and
and int n, shifts the first n characters
of s to the end of the string.
if n > s.length then outputs the string
unchanged.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        //initialize s and n from input
        String s = input.nextLine();
        int n = input.nextInt();
        char[] sArray = s.toCharArray();
        String s1 = "";

        for(int i = 0; i < n; i++){

            if(n > s.length()){
                break;
            }

            //create the string to append to the end of s
            //remove the first n characters from s
            //append string to end of s?
                //might need to be in conditional stmt or
                //outside of loop
        }

        //output s1 (or whatever the modified string is called)
    }
}