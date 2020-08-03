/*
Sam Carrillo
8.1.2020
--------------
This program takes in a string s and
and int n, shifts the first n characters
of s to the end of the string.
if n > s.length then outputs the string
unchanged.
Sample Input:
Hello 3

Sample Output:
loHel
 */

import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        //initialize s and n from input
        String s = input.next();
        int n = input.nextInt();

        char[] sArray = s.toCharArray();
        String s1 = "";
        String s2 = "";

        //create string from the character array from n to end of original string
        if(n < s.length()){
            s2 = String.valueOf(Arrays.copyOfRange(sArray, n, sArray.length));
        }

        //create the string that will "shift" to the end of the original string
        for(int i = 0; i < n; i++){
            //if n is bigger than length output unmodified original string
            if(n > s.length()){
                s1 = s;
                break;
            }

            s1 += sArray[i];
        }

        //print output based on n
        if(n > s.length()){
            System.out.print(s1);
        }else{
            s2 += s1;
            System.out.print(s2);
        }


        /*
        better version:
                public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                String str = scanner.next();
                int offset = scanner.nextInt();

                if (offset < str.length()) {
                    System.out.print(str.substring(offset) + str.substring(0, offset));
                } else {
                    System.out.println(str);
                }
            }
         */
    }
}