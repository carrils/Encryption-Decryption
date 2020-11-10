import java.util.Scanner;

interface PersonSelectionAlgorithm {
    //this is the common strategy interface
    Person[] select(Person[] persons);
}

class SelectionContext {
    //this is the context that delegates execution to the concrete class
    //and has a setter for the algorithm, or private field of type <interface>
    private PersonSelectionAlgorithm algorithm;

    public void setAlgorithm(PersonSelectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Person[] selectPersons(Person[] persons) {
        return this.algorithm.select(persons);
    }
}

class TakePersonsWithStepAlgorithm implements PersonSelectionAlgorithm {
    //extracted algorithm, concrete strategy following the CSI
    int step;

    public TakePersonsWithStepAlgorithm(int step) {
        this.step = step;
    }

    @Override
    public Person[] select(Person[] persons) {
        //first what is needed is to initialize the team object array with the correct size.
        int length;
        if (persons.length % step == 0) {
            length = persons.length / step;
        } else {
            //compensate for integer division concatenation
            length = persons.length / step + 1;
        }

        Person[] team = new Person[length];
        if (persons.length == 1) {
            team = persons;
        } else {
            for (int i = 0; i < persons.length; i += step) {
                team[i / step] = persons[i];
            }
        }
        return team;
    }
}


class TakeLastPersonsAlgorithm implements PersonSelectionAlgorithm {
    int fromLast;

    public TakeLastPersonsAlgorithm(int count) {
        fromLast = count;
    }

    @Override
    public Person[] select(Person[] persons) {
        Person[] team = new Person[fromLast]; //length should be count
        if (persons.length == 1) {
            team = persons;
        } else {
            int j = 0;
            for (int i = persons.length - fromLast; i < persons.length; i++) {
                team[j] = persons[i];
                j++;
            }
        }
        return team;
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int count = Integer.parseInt(scanner.nextLine());
        final Person[] persons = new Person[count];

        for (int i = 0; i < count; i++) {
            persons[i] = new Person(scanner.nextLine());
        }

        final String[] configs = scanner.nextLine().split("\\s+");

        final PersonSelectionAlgorithm alg = create(configs[0], Integer.parseInt(configs[1]));
        SelectionContext ctx = new SelectionContext();
        ctx.setAlgorithm(alg);

        final Person[] selected = ctx.selectPersons(persons);
        for (Person p : selected) {
            System.out.println(p.name);
        }
    }

    public static PersonSelectionAlgorithm create(String algType, int param) {
        switch (algType) {
            case "STEP": {
                return new TakePersonsWithStepAlgorithm(param);
            }
            case "LAST": {
                return new TakeLastPersonsAlgorithm(param);
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type " + algType);
            }
        }
    }
}