import java.util.Scanner;

public class Main {
    /*
    Find all factors of the number.
    If the number has only two factors, 1 and itself, then it is prime.
    If the number has more than two factors, then it is composite.
     */
    public static double divide(long a, long b) {
        return (double) a / b;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final long a = scanner.nextLong();
        final long b = scanner.nextLong();
        System.out.println(divide(a, b));
    }
}