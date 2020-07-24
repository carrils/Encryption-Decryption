/*
Sam Carrillo
7.23.2020
--------------
Given a sequence integers
this program outputs "even"
if the number is even, otherwise,
"odd". If the number is 0 the
program stops.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x;

        while(input.hasNext()){
            x = input.nextInt();
            if(x == 0){
                break;
            }else if(x % 2 == 0){
                System.out.println("even");
            }else{
                System.out.println("odd");
            }
        }
    }
}