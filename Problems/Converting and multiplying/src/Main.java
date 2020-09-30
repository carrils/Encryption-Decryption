import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            String x = input.next();
            try {
                int y = Integer.valueOf(x); //can throw number format exception
                if (x.equals("0")) {
                    //break while loop if input is 0
                    break;
                } else {
                    System.out.println(y * 10);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + x);
            }
        }
    }
}