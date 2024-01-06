package JavaStreamAPI;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class InterviewPreparationQuestions {
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee(101,"siva",101,"active",2000));
        employeeList.add(new Employee(102,"reddy",101,"active",5000));
        employeeList.add(new Employee(103,"raju",102,"inactive",78000));
        employeeList.add(new Employee(104,"shivam",102,"inactive",4000));
        employeeList.add(new Employee(105,"bob",103,"active",3500));
        employeeList.add(new Employee(106,"alice",103,"inactive",3500));
        employeeList.add(new Employee(107,"srinu",104,"active",3500));

//1.Write a program to print employee details based on department(group employees dept wise)

        //Key will be DeptId and values will be List of employees
        Map<Integer, List<Employee>> empListByDeptId = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId));

        empListByDeptId.entrySet().forEach(emp->{
            System.out.println("Key is: "+emp.getKey()+" Value is:"+emp.getValue());
        });
//2.Write a program to print employees count working in each department

        Map<Integer, Long> count = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
        //System.out.println(count);
        count.entrySet().forEach(emp->{
             System.out.println("dept : "+emp.getKey()+" ---- "+emp.getValue());
        });
//3.Write a program to print active and inactive employees in the given collection
        long activeCount = employeeList.stream().filter(employee -> "active".equals(employee.getStatus())).count();
        System.out.println("activeCount is "+activeCount);
        long inActiveCount = employeeList.stream().filter(employee -> "inactive".equals(employee.getStatus())).count();
        System.out.println("inActiveCount is "+inActiveCount);


//4.Write a program to print Max/Min employee salary from the given collection
        Optional<Employee> maxSal = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println("maxsal is: "+maxSal.get());
        Optional<Employee> minSal = employeeList.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println("minsal is: "+minSal.get());

//5.Write a program to print the max salary of an employee from each department

        Map<Integer, Optional<Employee>> maxsalofemp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId,
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
        maxsalofemp.entrySet().forEach(emp->{
            System.out.println("dept : "+emp.getKey()+" top emp sal: "+emp.getValue().get());
        });
    }
}
