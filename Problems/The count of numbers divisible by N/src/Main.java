
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