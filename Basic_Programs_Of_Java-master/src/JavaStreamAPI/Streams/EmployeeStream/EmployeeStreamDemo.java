package JavaStreamAPI.Streams.EmployeeStream;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
    static List<Employee> employeeList = new ArrayList<Employee>();

    public static void main(String[] args) {

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //joining
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String result = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);  // Output: [Alice, Bob, Charlie]

        // Query 1 : How many male and female employees are there in the organization?
        method1();
        System.out.println("\n");
        // Query 2 : Print the name of all departments in the organization?
        method2();
        System.out.println("\n");
        // Query 3 : What is the average age of male and female employees?
        method3();
        System.out.println("\n");
        // Query 4 : Get the details of highest paid employee in the organization?
        method4();
        System.out.println("\n");
        // Query 5 : Get the names of all employees who have joined after 2015?
        method5();
        System.out.println("\n");
        // Query 6 : Count the number of employees in each department?
        method6();
        System.out.println("\n");
        // Query 7 : What is the average salary of each department?
        method7();
        System.out.println("\n");
        // Query 8 : Get the details of youngest male employee in the product
        // development department?
        method8();
        System.out.println("\n");
        // Query 9 : Who has the most working experience in the organization?
        method9();
        System.out.println("\n");
        // Query 10 : How many male and female employees are there in the sales and
        // marketing team?
        method10();
        System.out.println("\n");
        // Query 11 : What is the average salary of male and female employees?
        method11();
        System.out.println("\n");
        // Query 12 : List down the names of all employees in each department?
        method12();
        System.out.println("\n");
        // Query 13 : What is the average salary and total salary of the whole
        // organization?
        method13();
        System.out.println("\n");
        // Query 14 : Separate the employees who are younger or equal to 25 years from
        // those employees who are older than 25 years.
        method14();
        System.out.println("\n");
        // Query 15 : Who is the oldest employee in the organization? What is his age
        // and which department he belongs to?
        method15();
        //Query 16: Sort Employees by Name and Salary using stream
        method16();
        //Query 17: Group Employees by department using stream
        method17();
        //Query 18: Group Employees who are Eligible or Ineligible
        method18();
        //Query 19: Sort a Map based on keys and values
        method19();

    }

    public static void method1() {
        System.out.println("Query 1 : How many male and female employees are there in the organization?");
        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);
    }

    public static void method2() {
        System.out.println("Query 2 : Print the name of all departments in the organization?");
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    }

    public static void method3() {
        System.out.println("Query 3 : What is the average age of male and female employees?");
        Map<String, Double> averageAgeOfMaleAndFemaleEmployee = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAgeOfMaleAndFemaleEmployee);
    }

    public static void method4() {
        System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
        Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(highestPaidEmployeeWrapper.get().getName());

        //Get Highest salary another way
        Employee highestemployee = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst().orElse(null);
        if (highestemployee != null) {
            System.out.println("highest salary: " + highestemployee.getSalary());
        }

        Employee employee = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null);
        if (employee != null) {
            System.out.println("Second highest salary: " + employee.getSalary());
        }
    }

    public static void method5() {
        System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
                .forEach(System.out::println);
    }

    public static void method6() {
        System.out.println("Query 6 : Count the number of employees in each department?");
        Map<String, Long> employeeCountByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

        for (Entry<String, Long> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void method7() {
        System.out.println("Query 7 : What is the average salary of each department?");
        Map<String, Double> avgSalaryOfDepartments =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        Set<Entry<String, Double>> entrySet = avgSalaryOfDepartments.entrySet();

        for (Entry<String, Double> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void method8() {
        System.out
                .println("Query 8 : Get the details of youngest male employee in the product development department?");
        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper =
                employeeList.stream()
                        .filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
                        .min(Comparator.comparingInt(Employee::getAge));

        Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();

        System.out.println("Details Of Youngest Male Employee In Product Development");

        System.out.println("----------------------------------------------");

        System.out.println("ID : " + youngestMaleEmployeeInProductDevelopment.getId());

        System.out.println("Name : " + youngestMaleEmployeeInProductDevelopment.getName());

    }

    public static void method9() {
        System.out.println("Query 9 : Who has the most working experience in the organization?");
        Optional<Employee> seniorMostEmployeeWrapper =
                employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

        Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();

        System.out.println("Senior Most Employee Details :");

        System.out.println("----------------------------");

        System.out.println("ID : " + seniorMostEmployee.getId());

        System.out.println("Name : " + seniorMostEmployee.getName());
    }

    public static void method10() {
        System.out.println("Query 10 : How many male and female employees are there in the sales and marketing team?");
        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing =
                employeeList.stream()
                        .filter(e -> e.getDepartment() == "Sales And Marketing")
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(countMaleFemaleEmployeesInSalesMarketing);
    }

    public static void method11() {
        System.out.println("Query 11 : What is the average salary of male and female employees?");
        Map<String, Double> avgSalaryOfMaleAndFemaleEmployees =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryOfMaleAndFemaleEmployees);
    }

    public static void method12() {
        System.out.println("Query 12 : List down the names of all employees in each department?");
        Map<String, List<Employee>> employeeListByDepartment =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        Set<Entry<String, List<Employee>>> entrySet = employeeListByDepartment.entrySet();

        for (Entry<String, List<Employee>> entry : entrySet) {
            System.out.println("--------------------------------------");

            System.out.println("Employees In " + entry.getKey() + " : ");

            System.out.println("--------------------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }
    }

    public static void method13() {
        System.out.println("Query 13 : What is the average salary and total salary of the whole organization?");
        DoubleSummaryStatistics employeeSalaryStatistics =
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());

        System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());
    }

    public static void method14() {
        System.out.println(
                "Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
        Map<Boolean, List<Employee>> partitionEmployeesByAge =
                employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        Set<Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();

        for (Entry<Boolean, List<Employee>> entry : entrySet) {
            System.out.println("----------------------------");

            if (entry.getKey()) {
                System.out.println("Employees older than 25 years :");
            } else {
                System.out.println("Employees younger than or equal to 25 years :");
            }

            System.out.println("----------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }
    }

    public static void method15() {
        System.out.println(
                "Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?");
        Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));

        Employee oldestEmployee = oldestEmployeeWrapper.get();

        System.out.println("Name : " + oldestEmployee.getName());

        System.out.println("Age : " + oldestEmployee.getAge());

        System.out.println("Department : " + oldestEmployee.getDepartment());
    }

    private static void method16() {
        System.out.println("Sort Employee By Name and Salary in Ascending");
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary)).forEach(System.out::println);
        System.out.println("Sort Employee By Name and Salary in Descending");
        employeeList.stream().sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder())
                .thenComparing(Employee::getSalary, Comparator.reverseOrder())).forEach(System.out::println);
    }

    private static void method17() {
        System.out.println("Group Employees by Dept");
        Map<String, List<Employee>> empBydept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(empBydept);
    }

    private static void method18() {
        System.out.println("Group Employees who are Eligible or Ineligible");
       Map<String, List<Employee>> empeligibleAndIneligble= employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getAge() >= 30 ? "Eligible" : "InEligible"));
       System.out.println(empeligibleAndIneligble);
    }

    private static void method19() {
        Map<String, Integer> map= new HashMap<>();
        map.put("Narendra",32000);
        map.put("Kiran",43000);
        map.put("Gopal",45000);
        map.put("Hari",65000);
        map.put("john",65000);
        map.put("Ruhi",2000);
        map.put("prahi",2000);
        map.put("Maanas",44000);
        map.put("bunny",45000);

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        //get second Highest employee
        //here using reverseorder because we need in descending order
        Map.Entry<String, Integer> secondhighestemployee=map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList()).get(1);
        System.out.println("secondhighestemployee "+secondhighestemployee);
        //get second Lowest employee
        //here not using reverseorder because we need in ascending order
        Map.Entry<String, Integer> secondlowestemployee = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()).get(1);
        System.out.println("secondlowestemployee "+secondlowestemployee);

        //this approach won't work when there are same salary values for different employees in the map
        Map.Entry<String, Integer> results = getnthHighestSalary(2, map);
        System.out.println("nthHighestSalary results "+results);
        //below dynamic approach will work bcoz we group employees based on salary first
        Entry<Integer, List<String>> salaryresult = getDynamicnthHighestSalary(2,map);
        System.out.println(salaryresult);
    }

    private static Map.Entry<String, Integer> getnthHighestSalary(int num, Map<String, Integer> map) {
        //here num-1 bcoz index starts from 0
        return map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                collect(Collectors.toList()).get(num-1);
    }

    private static Map.Entry<Integer, List<String>> getDynamicnthHighestSalary(int num, Map<String, Integer> map) {
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(Entry::getValue, Collectors.mapping(Entry::getKey, Collectors.toList())))
                .entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByKey())).collect(Collectors.toList()).get(num-1);
    }

    /*
    Outputs For Above All queries

    [Alice, Bob, Charlie]
Query 1 : How many male and female employees are there in the organization?
{Male=11, Female=6}


Query 2 : Print the name of all departments in the organization?
HR
Sales And Marketing
Infrastructure
Product Development
Security And Transport
Account And Finance


Query 3 : What is the average age of male and female employees?
{Male=30.181818181818183, Female=27.166666666666668}


Query 4 : Get the details of highest paid employee in the organization?
Anuj Chettiar
highest salary: 35700.0
Second highest salary: 34500.0


Query 5 : Get the names of all employees who have joined after 2015?
Iqbal Hussain
Amelia Zoe
Nitin Joshi
Nicolus Den
Ali Baig


Query 6 : Count the number of employees in each department?
Product Development : 5
Security And Transport : 2
Sales And Marketing : 3
Infrastructure : 3
HR : 2
Account And Finance : 2


Query 7 : What is the average salary of each department?
Product Development : 31960.0
Security And Transport : 10750.25
Sales And Marketing : 11900.166666666666
Infrastructure : 15466.666666666666
HR : 23850.0
Account And Finance : 24150.0


Query 8 : Get the details of youngest male employee in the product development department?
Details Of Youngest Male Employee In Product Development
----------------------------------------------
ID : 222
Name : Nitin Joshi


Query 9 : Who has the most working experience in the organization?
Senior Most Employee Details :
----------------------------
ID : 177
Name : Manu Sharma


Query 10 : How many male and female employees are there in the sales and marketing team?
{Female=1, Male=2}


Query 11 : What is the average salary of male and female employees?
{Male=21300.090909090908, Female=20850.0}


Query 12 : List down the names of all employees in each department?
--------------------------------------
Employees In Product Development :
--------------------------------------
Murali Gowda
Wang Liu
Nitin Joshi
Sanvi Pandey
Anuj Chettiar
--------------------------------------
Employees In Security And Transport :
--------------------------------------
Iqbal Hussain
Jaden Dough
--------------------------------------
Employees In Sales And Marketing :
--------------------------------------
Paul Niksui
Amelia Zoe
Nicolus Den
--------------------------------------
Employees In Infrastructure :
--------------------------------------
Martin Theron
Jasna Kaur
Ali Baig
--------------------------------------
Employees In HR :
--------------------------------------
Jiya Brein
Nima Roy
--------------------------------------
Employees In Account And Finance :
--------------------------------------
Manu Sharma
Jyothi Reddy


Query 13 : What is the average salary and total salary of the whole organization?
Average Salary = 21141.235294117647
Total Salary = 359401.0


Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
----------------------------
Employees younger than or equal to 25 years :
----------------------------
Paul Niksui
Amelia Zoe
Nitin Joshi
Nicolus Den
Ali Baig
----------------------------
Employees older than 25 years :
----------------------------
Jiya Brein
Martin Theron
Murali Gowda
Nima Roy
Iqbal Hussain
Manu Sharma
Wang Liu
Jaden Dough
Jasna Kaur
Jyothi Reddy
Sanvi Pandey
Anuj Chettiar


Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
Name : Iqbal Hussain
Age : 43
Department : Security And Transport
Sort Employee By Name and Salary in Ascending
Id : 255, Name : Ali Baig, age : 23, Gender : Male, Department : Infrastructure, Year Of Joining : 2018, Salary : 12700.0
Id : 199, Name : Amelia Zoe, age : 24, Gender : Female, Department : Sales And Marketing, Year Of Joining : 2016, Salary : 11500.0
Id : 277, Name : Anuj Chettiar, age : 31, Gender : Male, Department : Product Development, Year Of Joining : 2012, Salary : 35700.0
Id : 166, Name : Iqbal Hussain, age : 43, Gender : Male, Department : Security And Transport, Year Of Joining : 2016, Salary : 10500.0
Id : 200, Name : Jaden Dough, age : 38, Gender : Male, Department : Security And Transport, Year Of Joining : 2015, Salary : 11000.5
Id : 211, Name : Jasna Kaur, age : 27, Gender : Female, Department : Infrastructure, Year Of Joining : 2014, Salary : 15700.0
Id : 111, Name : Jiya Brein, age : 32, Gender : Female, Department : HR, Year Of Joining : 2011, Salary : 25000.0
Id : 233, Name : Jyothi Reddy, age : 27, Gender : Female, Department : Account And Finance, Year Of Joining : 2013, Salary : 21300.0
Id : 177, Name : Manu Sharma, age : 35, Gender : Male, Department : Account And Finance, Year Of Joining : 2010, Salary : 27000.0
Id : 133, Name : Martin Theron, age : 29, Gender : Male, Department : Infrastructure, Year Of Joining : 2012, Salary : 18000.0
Id : 144, Name : Murali Gowda, age : 28, Gender : Male, Department : Product Development, Year Of Joining : 2014, Salary : 32500.0
Id : 244, Name : Nicolus Den, age : 24, Gender : Male, Department : Sales And Marketing, Year Of Joining : 2017, Salary : 10700.5
Id : 155, Name : Nima Roy, age : 27, Gender : Female, Department : HR, Year Of Joining : 2013, Salary : 22700.0
Id : 222, Name : Nitin Joshi, age : 25, Gender : Male, Department : Product Development, Year Of Joining : 2016, Salary : 28200.0
Id : 122, Name : Paul Niksui, age : 25, Gender : Male, Department : Sales And Marketing, Year Of Joining : 2015, Salary : 13500.0
Id : 266, Name : Sanvi Pandey, age : 26, Gender : Female, Department : Product Development, Year Of Joining : 2015, Salary : 28900.0
Id : 188, Name : Wang Liu, age : 31, Gender : Male, Department : Product Development, Year Of Joining : 2015, Salary : 34500.0
Sort Employee By Name and Salary in Descending
Id : 188, Name : Wang Liu, age : 31, Gender : Male, Department : Product Development, Year Of Joining : 2015, Salary : 34500.0
Id : 266, Name : Sanvi Pandey, age : 26, Gender : Female, Department : Product Development, Year Of Joining : 2015, Salary : 28900.0
Id : 122, Name : Paul Niksui, age : 25, Gender : Male, Department : Sales And Marketing, Year Of Joining : 2015, Salary : 13500.0
Id : 222, Name : Nitin Joshi, age : 25, Gender : Male, Department : Product Development, Year Of Joining : 2016, Salary : 28200.0
Id : 155, Name : Nima Roy, age : 27, Gender : Female, Department : HR, Year Of Joining : 2013, Salary : 22700.0
Id : 244, Name : Nicolus Den, age : 24, Gender : Male, Department : Sales And Marketing, Year Of Joining : 2017, Salary : 10700.5
Id : 144, Name : Murali Gowda, age : 28, Gender : Male, Department : Product Development, Year Of Joining : 2014, Salary : 32500.0
Id : 133, Name : Martin Theron, age : 29, Gender : Male, Department : Infrastructure, Year Of Joining : 2012, Salary : 18000.0
Id : 177, Name : Manu Sharma, age : 35, Gender : Male, Department : Account And Finance, Year Of Joining : 2010, Salary : 27000.0
Id : 233, Name : Jyothi Reddy, age : 27, Gender : Female, Department : Account And Finance, Year Of Joining : 2013, Salary : 21300.0
Id : 111, Name : Jiya Brein, age : 32, Gender : Female, Department : HR, Year Of Joining : 2011, Salary : 25000.0
Id : 211, Name : Jasna Kaur, age : 27, Gender : Female, Department : Infrastructure, Year Of Joining : 2014, Salary : 15700.0
Id : 200, Name : Jaden Dough, age : 38, Gender : Male, Department : Security And Transport, Year Of Joining : 2015, Salary : 11000.5
Id : 166, Name : Iqbal Hussain, age : 43, Gender : Male, Department : Security And Transport, Year Of Joining : 2016, Salary : 10500.0
Id : 277, Name : Anuj Chettiar, age : 31, Gender : Male, Department : Product Development, Year Of Joining : 2012, Salary : 35700.0
Id : 199, Name : Amelia Zoe, age : 24, Gender : Female, Department : Sales And Marketing, Year Of Joining : 2016, Salary : 11500.0
Id : 255, Name : Ali Baig, age : 23, Gender : Male, Department : Infrastructure, Year Of Joining : 2018, Salary : 12700.0
Group Employees by Dept
{Product Development=[Id : 144, Name : Murali Gowda, age : 28, Gender : Male, Department : Product Development, Year Of Joining : 2014, Salary : 32500.0, Id : 188, Name : Wang Liu, age : 31, Gender : Male, Department : Product Development, Year Of Joining : 2015, Salary : 34500.0, Id : 222, Name : Nitin Joshi, age : 25, Gender : Male, Department : Product Development, Year Of Joining : 2016, Salary : 28200.0, Id : 266, Name : Sanvi Pandey, age : 26, Gender : Female, Department : Product Development, Year Of Joining : 2015, Salary : 28900.0, Id : 277, Name : Anuj Chettiar, age : 31, Gender : Male, Department : Product Development, Year Of Joining : 2012, Salary : 35700.0], Security And Transport=[Id : 166, Name : Iqbal Hussain, age : 43, Gender : Male, Department : Security And Transport, Year Of Joining : 2016, Salary : 10500.0, Id : 200, Name : Jaden Dough, age : 38, Gender : Male, Department : Security And Transport, Year Of Joining : 2015, Salary : 11000.5], Sales And Marketing=[Id : 122, Name : Paul Niksui, age : 25, Gender : Male, Department : Sales And Marketing, Year Of Joining : 2015, Salary : 13500.0, Id : 199, Name : Amelia Zoe, age : 24, Gender : Female, Department : Sales And Marketing, Year Of Joining : 2016, Salary : 11500.0, Id : 244, Name : Nicolus Den, age : 24, Gender : Male, Department : Sales And Marketing, Year Of Joining : 2017, Salary : 10700.5], Infrastructure=[Id : 133, Name : Martin Theron, age : 29, Gender : Male, Department : Infrastructure, Year Of Joining : 2012, Salary : 18000.0, Id : 211, Name : Jasna Kaur, age : 27, Gender : Female, Department : Infrastructure, Year Of Joining : 2014, Salary : 15700.0, Id : 255, Name : Ali Baig, age : 23, Gender : Male, Department : Infrastructure, Year Of Joining : 2018, Salary : 12700.0], HR=[Id : 111, Name : Jiya Brein, age : 32, Gender : Female, Department : HR, Year Of Joining : 2011, Salary : 25000.0, Id : 155, Name : Nima Roy, age : 27, Gender : Female, Department : HR, Year Of Joining : 2013, Salary : 22700.0], Account And Finance=[Id : 177, Name : Manu Sharma, age : 35, Gender : Male, Department : Account And Finance, Year Of Joining : 2010, Salary : 27000.0, Id : 233, Name : Jyothi Reddy, age : 27, Gender : Female, Department : Account And Finance, Year Of Joining : 2013, Salary : 21300.0]}
Group Employees who are Eligible or Ineligible
{InEligible=[Id : 122, Name : Paul Niksui, age : 25, Gender : Male, Department : Sales And Marketing, Year Of Joining : 2015, Salary : 13500.0, Id : 133, Name : Martin Theron, age : 29, Gender : Male, Department : Infrastructure, Year Of Joining : 2012, Salary : 18000.0, Id : 144, Name : Murali Gowda, age : 28, Gender : Male, Department : Product Development, Year Of Joining : 2014, Salary : 32500.0, Id : 155, Name : Nima Roy, age : 27, Gender : Female, Department : HR, Year Of Joining : 2013, Salary : 22700.0, Id : 199, Name : Amelia Zoe, age : 24, Gender : Female, Department : Sales And Marketing, Year Of Joining : 2016, Salary : 11500.0, Id : 211, Name : Jasna Kaur, age : 27, Gender : Female, Department : Infrastructure, Year Of Joining : 2014, Salary : 15700.0, Id : 222, Name : Nitin Joshi, age : 25, Gender : Male, Department : Product Development, Year Of Joining : 2016, Salary : 28200.0, Id : 233, Name : Jyothi Reddy, age : 27, Gender : Female, Department : Account And Finance, Year Of Joining : 2013, Salary : 21300.0, Id : 244, Name : Nicolus Den, age : 24, Gender : Male, Department : Sales And Marketing, Year Of Joining : 2017, Salary : 10700.5, Id : 255, Name : Ali Baig, age : 23, Gender : Male, Department : Infrastructure, Year Of Joining : 2018, Salary : 12700.0, Id : 266, Name : Sanvi Pandey, age : 26, Gender : Female, Department : Product Development, Year Of Joining : 2015, Salary : 28900.0], Eligible=[Id : 111, Name : Jiya Brein, age : 32, Gender : Female, Department : HR, Year Of Joining : 2011, Salary : 25000.0, Id : 166, Name : Iqbal Hussain, age : 43, Gender : Male, Department : Security And Transport, Year Of Joining : 2016, Salary : 10500.0, Id : 177, Name : Manu Sharma, age : 35, Gender : Male, Department : Account And Finance, Year Of Joining : 2010, Salary : 27000.0, Id : 188, Name : Wang Liu, age : 31, Gender : Male, Department : Product Development, Year Of Joining : 2015, Salary : 34500.0, Id : 200, Name : Jaden Dough, age : 38, Gender : Male, Department : Security And Transport, Year Of Joining : 2015, Salary : 11000.5, Id : 277, Name : Anuj Chettiar, age : 31, Gender : Male, Department : Product Development, Year Of Joining : 2012, Salary : 35700.0]}
Gopal=45000
Hari=65000
Kiran=43000
Maanas=44000
Narendra=32000
Ruhi=2000
bunny=45000
john=65000
prahi=2000
Ruhi=2000
prahi=2000
Narendra=32000
Kiran=43000
Maanas=44000
bunny=45000
Gopal=45000
Hari=65000
john=65000
secondhighestemployee john=65000
secondlowestemployee prahi=2000
nthHighestSalary results john=65000
45000=[bunny, Gopal]
     */

}

class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
                + department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
    }
}
