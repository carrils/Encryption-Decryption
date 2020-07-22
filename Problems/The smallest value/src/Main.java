/*
Sam Carrillo
7.20.2020
-------------
finds smallest number of n
factorial where n! > m, and m
is a long integer input by user
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long m = input.nextLong();
        long factorial = 1;
        int n = 0;

        for(int i = 1; i < m; i++){
            //starting i at 1 to avoid assigning 0 to factorial thus everything being 0 when f * i
            factorial = factorial * i;

            if(factorial > m){
                n = i;
                break;
            }
        }

        System.out.print(n);
    }
}