package solved.P2644_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2644 {

    static class Person {
        int name;
        Person parent;

        public Person(int name) {
            this.name = name;
        }

        public void connectWithChild(Person child) {
            child.parent = this;
        }

        public List<Person> getParents() {
            List<Person> parents = new ArrayList<>();

            if (parent != null) {
                parents.add(parent);
                parents.addAll(parent.getParents());
            }

            return parents;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numberInput = br.readLine().split(" ");

        int a = Integer.parseInt(numberInput[0]);
        int b = Integer.parseInt(numberInput[1]);
        int m = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            people.add(new Person(i));
        }

        for (int i = 0; i < m; i++) {
            String[] inputXY = br.readLine().split(" ");
            int X = Integer.parseInt(inputXY[0]);
            int Y = Integer.parseInt(inputXY[1]);

            Person personX = people.get(X);
            Person personY = people.get(Y);

            personX.connectWithChild(personY);

        }

        Person personA = people.get(a);
        Person personB = people.get(b);

        List<Person> aParents = personA.getParents();
        List<Person> bParents = personB.getParents();

        aParents.add(0, personA);
        bParents.add(0, personB);

        List<Person> larger = aParents.size() >= bParents.size() ? aParents : bParents;
        List<Person> smaller = aParents.size() < bParents.size() ? aParents : bParents;

        int lagerCount = -1;
        int smallerCount;
        for (Person lagerPerson : larger) {
            lagerCount++;

            smallerCount = -1;
            for (Person smallerPerson : smaller) {
                smallerCount++;

                if (lagerPerson == smallerPerson) {
                    System.out.println(lagerCount + smallerCount);
                    return;
                }
            }

        }

        System.out.println("-1");

    }
}
