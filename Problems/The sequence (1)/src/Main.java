/*
Sam Carrillo
7.28.2020
-------------
This program prints a sequence of integers
repeated as many times and the integers value.
Takes a positive integer N and stops printing
at N values.
For example, if n = 7,
then the program should output 1 2 2 3 3 3 4.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int numCount = 0;
        boolean limitReached = false;

        //initialize i to 1 to prevent printing 0
        for(int i = 1; i <= n; i++){
            //j < i because if <= then prints 1 twice
            for(int j = 0; j < i; j++){
                System.out.print(i + " ");
                numCount++;

                if(numCount == n){
                    limitReached = true;
                    break;
                }
            }

            if(limitReached){
                break;
            }
        }
    }
}