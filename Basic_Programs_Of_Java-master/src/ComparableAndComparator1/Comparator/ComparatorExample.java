package ComparableAndComparator1.Comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// Using the same Student class as above, but without implementing Comparable
class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }
}

class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name); // Sort by name alphabetically
    }
}

class StudentAgeDescendingComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s2.age - s1.age; // Sort by age in descending order
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 19));

        System.out.println("Before sorting: " + students);

        // Sort by name using StudentNameComparator
        Collections.sort(students, new StudentNameComparator());
        System.out.println("After sorting by name: " + students);

        // Sort by age in descending order using StudentAgeDescendingComparator
        Collections.sort(students, new StudentAgeDescendingComparator());
        System.out.println("After sorting by age (descending): " + students);
    }
}
