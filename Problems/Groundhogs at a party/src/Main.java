import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        A successful groundhog party will have between
        10 and 20 Reese's peanut butter cups, inclusive unless it is the weekend,
        in which case they will need 15 to 25 Reese's peanut butter cups, inclusive
         */

        int cups = scanner.nextInt();
        boolean weekend = scanner.nextBoolean();

        boolean lit = ((weekend == false)&&((cups <= 20)&&(cups >= 10))) || ((weekend == true)&&((cups <= 25)&&(cups >= 15)));

        System.out.println(lit);
    }
}