import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        boolean arbitraryCondition = (x != y)&&(y != z)&&(z != x);

        System.out.println(arbitraryCondition);
    }
}