class Problem {

    public static void main(String[] args) {
        String temp1 = "";
        String temp2 = "";
        String glue = "";
        String[] gluedItems = new String[args.length];
        for (int i = 2; i <= args.length + 2; i++) {
            int j = 0;
            if (i % 2 == 0) {
                //create temp 1 variable for arg
                temp1 = args[i];
            } else{
                temp2 = args[i];
            }
            glue = temp1.toString() + "=" +temp2.toString();
            gluedItems[j] += glue;
            j++;
        }

        for(String item : gluedItems){
            System.out.println(item);
        }
    }
}
