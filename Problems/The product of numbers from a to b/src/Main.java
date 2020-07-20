/*
Sam Carrillo
7.19.2020
--------------
This program takes 2 ints, A and Z
Then outputs the product of all numbers
from A to Z excluding Z
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //input a and z
        int a = input.nextInt();
        int z = input.nextInt();

        //create int array and initialize product
        int[] nums = new int[z - a];
        long product = 0;

        //fill nums[] with a - z excluding z
        for(int i = 0; i < nums.length; i++){
            nums[i] = a + i;
        }

        //find the product by running "*=", (z-a) times
        for(int j = 0; j < nums.length; j++){
            if(product == 0 && j == 0){
                product = nums[j];
            }else{
                product *= nums[j];
            }
        }

        //print product
        System.out.println(product);
    }
}