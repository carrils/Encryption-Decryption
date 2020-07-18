/*
Sam Carrillo
7.17.2020
---------------
This program takes 3 integers separated by a space or entered separately.
integers A, B, N. This program prints the value of how many numbers in the
range of [A . . . B] are divisible by N.
 */
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt(); //range begin
        int b = input.nextInt(); //range end
        int n = input.nextInt(); //divisor

        int count = 0;

        for(int i = a; i <= b ;i++){
            if(i % n == 0){
                count++;
            }
        }

        System.out.println(count);
    }
}