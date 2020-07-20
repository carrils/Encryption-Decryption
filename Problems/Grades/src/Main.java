/*
Sam Carrillo
7.18.20
--------------
This program take an int N and then inputs
N integers within the range 1 - 5.
5 = A, 4 = B, 3 = C, 2 = D. We dont count F's :]
Then outputs the total number of students with
each grade. <D's> <C's> <B's> <A's>
 */

import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        //build scanner
        Scanner input = new Scanner(System.in);

        //initiate the number of students
        int n = input.nextInt();
        int i = 0;
        int[] grades = new int[n];

        //read into grades[] until n students
        do{
            grades[i] = input.nextInt();
            i++;
        }while(i < n);

        //create and initialize the grades
        int a = 0, b = 0, c = 0, d = 0;
        for(int j = 0; j < n; j++){
            if(grades[j] == 5){
                a++;
            }else if(grades[j] == 4){
                b++;
            }else if(grades[j] == 3){
                c++;
            }else if(grades[j] == 2){
                d++;
            }
        }

        //print totals
        System.out.print(d + " " + c + " " + b + " " + a);
    }
}