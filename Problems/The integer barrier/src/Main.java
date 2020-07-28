/*
Sam Carrillo
7.28.2020
-------------
This program reads a sequence of integers
and adds them. if an int is 0 it breaks
and prints the sum of the integers. if
the sum is equal or exceeds 1000 then
the program stops and prints the sum - 1000.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x, y = 0;

        while(input.hasNext()){
            x = input.nextInt();
            y += x;

            if(x == 0){
                break;
            }
            if(y >= 1000){
                y -= 1000;
                break;
            }
        }

        System.out.print(y);
    }
}