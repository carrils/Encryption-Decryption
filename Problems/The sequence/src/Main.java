/*
Sam Carrillo
7.20.2020
-------------
Its dark out, isn't it?
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] nums = new int[n];

        //fill nums array
        for(int i = 0; i < nums.length; i++){
            nums[i] = input.nextInt();
        }

        int largest = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] % 4 == 0){
                if(nums[j] > largest){
                    largest = nums[j];
                }
            }
        }

        System.out.println(largest);
    }
}