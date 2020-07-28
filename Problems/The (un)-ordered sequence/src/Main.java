/*
Sam Carrillo
7.23.2020
-------------
This program takes in a sequence
of integers and prints "true" if
the integers are ordered either
in ascending order or descending
order. will print "false" otherwise.
If there are 2 numbers of same value
back to back, this counts as in order.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y;

        boolean asc = true; //ascending
        boolean desc = true; //descending

        while(true){
            y = x;
            x = input.nextInt();

            if(x == 0){
                break;
            }

            if(asc && x < y){
                asc = false;
                continue;
            }

            if(desc && x >y){
                desc = false;
                continue;
            }

            if(!desc && !asc){
                break;
            }
        }

        System.out.print(asc || desc);
    }
}