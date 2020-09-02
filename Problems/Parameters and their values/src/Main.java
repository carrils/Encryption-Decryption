class Problem {

    public static void main(String[] args) {
        String temp1 = "";
        String temp2 = "";
        String glue = "";
        String[] gluedItems;
        for (int i = 0; i < args.length; i++) {

            if (i % 2 == 0) {
                //create temp 1 variable for arg
                temp1 = args[i];
            } else if (i % 2 != 0) {
                temp2 = args[i];
            }
            glue = temp1.toString() + "=" +temp2.toString();
            gluedItems += glue;
        }
        //print the array
    }
}
