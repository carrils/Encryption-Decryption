import java.util.Scanner;

public class Main {
    /*
        Find all factors of the number.
            find all numbers where number%n == 0 all the way until number where n is sequential > number
        If the number has only two factors, 1 and itself, then it is prime.
        If the number has more than two factors, then it is composite.
     */
    public static boolean isComposite(long number) {
        boolean result = false;
        int count = 0;
        for(int i = 1; i <= number; i ++){
            if(number % i == 0){
                count++;
            }
        }
        if (count > 2){
            result = true;
        }
        return result;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long number = scanner.nextLong();
        System.out.println(isComposite(number));
    }
}