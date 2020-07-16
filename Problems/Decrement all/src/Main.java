//Sam Carrillo
//7.14.2020
//------------
//This program reads in 4
//ints and decrements them

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //initialize num variables
        int numOne = scanner.nextInt();
        int numTwo = scanner.nextInt();
        int numThree = scanner.nextInt();
        int numFour = scanner.nextInt();

        //decrement
        numOne--;
        numTwo--;
        numThree--;
        numFour--;


        //print
        System.out.print(numOne + " ");
        System.out.print(numTwo + " ");
        System.out.print(numThree + " ");
        System.out.print(numFour + " ");

    }
}