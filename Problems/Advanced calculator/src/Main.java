
class Problem {

    public static void main(String[] args) {
        //operator guaranteed to be first argument so initialize to [0]
        String operator = args[0];

        //create an integer array scoops of length args.length
        int[] scoops = new int[args.length];
        //initialize scoops with the values of the args starting at 1 bc operator being [0]
        for (int i = 1; i < args.length; i++) {
            scoops[i] = Integer.parseInt(args[i]);
        }

        //switch on operator type to perform the method
        switch (operator) {
            case "MAX":
                System.out.println(findMax(scoops));
                break;
            case "MIN":
                System.out.println(findMin(scoops));
                break;
            case "SUM":
                System.out.println(findSum(scoops));
                break;
        }
    }

    public static int findMax(int[] _scoops) {
        int max = 0;
        for (int i = 1; i < _scoops.length; i++) {
            if (_scoops[i] > max) {
                max = _scoops[i];
            }
        }
        return max;
    }

    public static int findMin(int[] _scoops) {
        int temp = _scoops[1];
        for (int i = 1; i < _scoops.length; i++) {
            if (_scoops[i] < temp) {
                temp = _scoops[i];
            }
        }
        return temp;
    }

    public static int findSum(int[] _scoops) {
        int sum = 0;
        for (int i = 1; i < _scoops.length; i++) {
            sum += _scoops[i];
        }
        return sum;
    }
}