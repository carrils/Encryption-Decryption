/*
Sam Carrillo
7.30.2020
--------------
This program calculates the percentage of G characters (guanine)
and C characters (cytosine) in the entered string.

For example, in the string "acggtgttat" the percentage of
characters G and C equals to (4/10) * 100 = 40.0
where 4 is the number of symbols G and C, and 10 is the length of the string.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String inString = input.nextLine().toLowerCase();
        char[] charArray = inString.toCharArray();
        double c_g_count = 0;
        double percentage = 0;

        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == 'g' || charArray[i] == 'c'){
                c_g_count++;
            }
        }

        percentage = (c_g_count/charArray.length) * 100.0;

        System.out.print(percentage);
    }
}