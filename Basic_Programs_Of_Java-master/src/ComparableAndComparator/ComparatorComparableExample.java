package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorComparableExample {
    public static void main(String[] args) {
        List<Person> people=new ArrayList<>();
        people.add(new Person(30,"Alice"));
        people.add(new Person(25,"Bob"));
        people.add(new Person(35,"John"));

        System.out.println("Sorting by age (Comparable):");
        Collections.sort(people);// Sorts using compareTo (by age)

        for (Person p:people){
            System.out.println(p);
        }

        System.out.println("\nSorting by name (Comparator):");
        Collections.sort(people,new NameComparator());// Sorts using Comparator (by name)

        for (Person p:people){
            System.out.println(p);
        }
    }
}

////Output:
//Sorting by age (Comparable):
//Person{age=25, name='Bob'}
//Person{age=30, name='Alice'}
//Person{age=35, name='John'}

//Sorting by name (Comparator):
//Person{age=30, name='Alice'}
//Person{age=25, name='Bob'}
//Person{age=35, name='John'}
