package JavaStreamAPI.GroupMaleAndFemaleBasedOnDept;
import java.util.*;
import java.util.stream.Collectors;
public class Employee {
    private String name;
    private String gender;
    private String department;

    public Employee(String name, String gender, String department) {
        this.name = name;
        this.gender = gender;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', gender='" + gender + "', department='" + department + "'}";
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Female", "IT"),
                new Employee("Bob", "Male", "HR"),
                new Employee("Charlie", "Male", "IT"),
                new Employee("Diana", "Female", "HR"),
                new Employee("Eve", "Female", "IT")
        );

        String department = "IT"; // Example: Department passed as a method argument
        Map<String, List<Employee>> groupedByGender = groupByGenderInDept(employees, department);

        System.out.println("Grouped Employees by Gender in Department " + department + ":");
        groupedByGender.forEach((gender, empList) -> {
            System.out.println(gender + ": " + empList);
        });
    }

    public static Map<String, List<Employee>> groupByGenderInDept(List<Employee> employees, String department) {
        // Stream and group by gender where department matches the passed argument
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department)) // Filter by department
                .collect(Collectors.groupingBy(Employee::getGender)); // Group by gender
    }
}
