class Cat {
    String name;
    int age;
    static int counter;

    public Cat(String name, int age) {
        this.age = age;
        this.name = name;
        counter++;

        if(counter > 5){
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return counter;
    }
}