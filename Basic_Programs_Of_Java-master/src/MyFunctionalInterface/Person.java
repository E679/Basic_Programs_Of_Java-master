package MyFunctionalInterface;

import java.util.*;

import static java.util.Comparator.comparing;

public class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}


class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));

        Collections.sort(people, new AgeComparator());
        //easy way for above line

        List<String> wordlist= new ArrayList<>();
        wordlist.add("Banana");
        wordlist.add("Apple");
        wordlist.add("Orange");
        wordlist.add("Grapes");

        Collections.sort(wordlist, new Comparator<String>() {
            @Override
            public int compare(String s1,String s2){
                return s1.compareTo(s2);// For alphabetical order
            }
        });

        System.out.println("Sorted List:");
        for (String s : wordlist) {
            System.out.println(s);
        }


        for (Person p : people) {
            System.out.println(p.getName() + ": " + p.getAge());
        }
        //Using Lambda Expressions
        List<Person> people1 = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));

        // Using a lambda expression for comparison
        Collections.sort(people1, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        for (Person p : people1) {
            System.out.println(p.getName() + ": " + p.getAge());
        }

        //
        List<Person> people2 = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));

        // Using Comparator.comparing
        Collections.sort(people2, comparing(Person::getAge));

        for (Person p : people2) {
            System.out.println(p.getName() + ": " + p.getAge());
        }
    }
}
