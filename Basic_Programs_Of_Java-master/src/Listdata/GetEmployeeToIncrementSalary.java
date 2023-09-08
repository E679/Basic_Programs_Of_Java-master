package Listdata;

import java.util.ArrayList;
import java.util.List;

public class GetEmployeeToIncrementSalary {
    public static void main(String[] args) {
        // Get Employee whose age is greater than 25 and increment salary by 10%
        List<Employee> employees=new ArrayList<>();
        Employee e1=new Employee("shyam",26,22000);
        Employee e2=new Employee("Ram",21,21000);
        Employee e3=new Employee("Bheem",24,28000);
        Employee e4=new Employee("Arjun",27,25000);
        Employee e5=new Employee("vijay",28,29000);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        System.out.println("Before Increment :"+employees);
        System.out.println("After Increment :"+getEmployeeWithIncrement(employees));

    }

    private static List<Employee> getEmployeeWithIncrement(List<Employee> emp){
        List<Employee> employeeListincremented=new ArrayList<>();
        for(Employee employee:emp){
            if(employee.getAge()>25){
                employee.setSalary(employee.getSalary() * 1.10);
                employeeListincremented.add(employee);
            }
        }
        return employeeListincremented;
    }
}
