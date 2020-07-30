/*
Sam Carrillo
7.30.2020
-------------
This program takes in a string and then
outputs another string with doubled characters
 */

import java.util.Scanner;
import static java.lang.String.valueOf;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String inString = input.nextLine();
        String outString = "";
        for(int i = 0; i < inString.length(); i++){
            char ch = inString.charAt(i);

            outString += ch;
            outString += ch;
        }

        System.out.print(outString);
    }
}