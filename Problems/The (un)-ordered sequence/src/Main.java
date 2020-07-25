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
        int x = 0, y = 0;
        int[] nums = new int[0];
        boolean inOrder = true;

        while(input.hasNext()){
            x = input.nextInt();
            if(x <= y || x >= y){
                y = x;
                continue;
            }else{
                inOrder = false;
            }
            //y = x;
        }

        System.out.print(inOrder);
        
//        for(int i = 0; input.nextInt() != 0; i++){
//            nums[i] = input.nextInt();
//        }

//        do{
//
//        }while(input.nextInt() != 0);

    }
}