/*
Sam Carrillo
7.22.2020
--------------
No longer raining!
This program takes 3 values, M P and K
where M is a deposit to a bank, P is percent
bank increases deposit annually, K being target
value to reach. Outputs years it would take to
reach target amount K.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double m = input.nextInt();//deposit
        double p = input.nextDouble();//percentage increase on deposit
        double k = input.nextInt();//target to reach in x years
        int years = 0;

        for(int i = 0; m < k; i++){
            m += (p / 100.0) * (m);
            years++;
        }

        System.out.print(years);

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i < 3) {
                continue;
            } else {
                for (int j = 0; j < 5; j++) {
                    System.out.println(j);
                }
            }
        }

    }
}