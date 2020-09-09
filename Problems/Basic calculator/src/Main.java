import static java.lang.Integer.*;

class Problem {

    public static void main(String[] args) {

        char operator = args[0].charAt(0);
        int num1 = valueOf(args[1]);
        int num2 = valueOf(args[2]);

        if (operator == '+') {
            System.out.println(num1 + num2);
        } else if (operator == '-') {
            System.out.println(num1 - num2);
        } else if (operator == '*') {
            System.out.println(num1 * num2);
        } else {
            System.out.println("Unknown operator");
        }

    }
}