package JavaStreamAPI.SortEmployeesList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Java 8: Sort Employee by Name and Salary (Ascending and Descending)
public class SortEmployeesByNameAndSalary {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Jane", 60000));
        employees.add(new Employee("Jack", 40000));
        employees.add(new Employee("John", 45000));

        String s = "abcd";
        long count = s.chars().count();
        System.out.println("charCount of " + s + " is " + count);

        //Sort Employee by Name (Ascending)
        List<Employee> sortedByNameAsc = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

        System.out.println("Sorted by Name (Ascending):");
        sortedByNameAsc.forEach(System.out::println);

        //Sort Employee by Name (Descending)
        List<Employee> sortedByNameDesc = employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());

        System.out.println("Sorted by Name (Descending):");
        sortedByNameDesc.forEach(System.out::println);

        //Sort Employee by Salary (Ascending)
        List<Employee> sortedBySalaryAsc = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println("Sorted by Salary (Ascending):");
        sortedBySalaryAsc.forEach(System.out::println);

        //Sort Employee by Salary (Descending)
        List<Employee> sortedBySalaryDesc = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println("Sorted by Salary (Descending):");
        sortedBySalaryDesc.forEach(System.out::println);

        //Sorting by Name and then by Salary (Ascending)
        List<Employee> sortedByNameAndSalaryAsc = employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparingDouble(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println("Sorted by Name and Salary (Ascending):");
        sortedByNameAndSalaryAsc.forEach(System.out::println);

        //Sorting by Name and then by Salary (Descending)
        List<Employee> sortedByNameAndSalaryDesc = employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed()
                        .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()))
                .collect(Collectors.toList());

        System.out.println("Sorted by Name and Salary (Descending):");
        sortedByNameAndSalaryDesc.forEach(System.out::println);

/*
Output:

Sorted by Name (Ascending):
Employee{name='Jack', salary=40000.0}
Employee{name='Jane', salary=60000.0}
Employee{name='John', salary=50000.0}

Sorted by Name (Descending):
Employee{name='John', salary=50000.0}
Employee{name='Jane', salary=60000.0}
Employee{name='Jack', salary=40000.0}

Sorted by Salary (Ascending):
Employee{name='Jack', salary=40000.0}
Employee{name='John', salary=50000.0}
Employee{name='Jane', salary=60000.0}

Sorted by Salary (Descending):
Employee{name='Jane', salary=60000.0}
Employee{name='John', salary=50000.0}
Employee{name='Jack', salary=40000.0}

Sorted by Name and Salary (Ascending):
Employee{name='Jack', salary=40000.0}
Employee{name='Jane', salary=60000.0}
Employee{name='John', salary=45000.0}
Employee{name='John', salary=50000.0}

Sorted by Name and Salary (Descending):
Employee{name='John', salary=50000.0}
Employee{name='John', salary=45000.0}
Employee{name='Jane', salary=60000.0}
Employee{name='Jack', salary=40000.0}
 */
    }
}
