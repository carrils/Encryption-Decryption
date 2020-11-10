import java.util.Scanner;

interface FindingStrategy {
    //common strategy interface
    /**
     * Returns search result
     */
    int getResult(int[] numbers);

}

class Finder {
    //context, references sending method and allows us to change method used
    private FindingStrategy strategy;

    //the <finding> method, <*adjective*> is changed with the logic of the common strategy interface
    public Finder(FindingStrategy strategy) {
        this.strategy = strategy;
    }

    //the delegation of execution to a concrete interface through the common strategy interface
    public int find(int[] numbers) {
        return this.strategy.getResult(numbers);
    }

}

class MaxFindingStrategy implements FindingStrategy {
    //extracted algorithm (concrete strategy)
    public int getResult(int[] numbers) {
        if(numbers.length == 0){
            return Integer.MIN_VALUE;
        }else{
            int max = numbers[0];
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] > max){
                    max = numbers[i];
                }
            }
            return max;
        }
    }
}

class MinFindingStrategy implements FindingStrategy {
    //extracted algorithm (concrete strategy)
    public int getResult(int[] numbers) {
        if(numbers.length == 0) {
            return Integer.MAX_VALUE;
        }else{
            int min = numbers[0];
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] < min){
                    min = numbers[i];
                }
            }
            return min;
        }
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final String[] elements = scanner.nextLine().split("\\s+");
        int[] numbers = null;

        if (elements[0].equals("EMPTY")) {
            numbers = new int[0];   
        } else {
            numbers = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                numbers[i] = Integer.parseInt(elements[i]);
            }
        }

        final String type = scanner.nextLine();

        Finder finder = null;

        switch (type) {
            case "MIN":
                finder = new Finder(new MinFindingStrategy());
                break;
            case "MAX":
                finder = new Finder(new MaxFindingStrategy());
                break;
            default:
                break;
        }

        if (finder == null) {
            throw new RuntimeException(
                    "Unknown strategy type passed. Please, write to the author of the problem.");
        }

        System.out.println(finder.find(numbers));
    }
}