package JavaStreamAPI.EmployeePackage;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee1> list1 = Arrays.asList(
                new Employee1(1, "John"),
                new Employee1(2, "Alice"),
                new Employee1(3, "Bob")
        );

        List<Employee2> list2 = Arrays.asList(
                new Employee2("Alice", 85),
                new Employee2("Bob", 92),
                new Employee2("John", 78)
        );

        // Convert list2 to a Map for quick lookup by empName
        Map<String, Integer> empMarksMap = list2.stream()
                .collect(Collectors.toMap(Employee2::getEmpName, Employee2::getEmpMarks));

        // Join using streams
        List<Result> finalList = list1.stream()
                .filter(e1 -> empMarksMap.containsKey(e1.getEmpName()))
                .map(e1 -> new Result(e1.getEmpId(), empMarksMap.get(e1.getEmpName())))
                .collect(Collectors.toList());

        // Print final result
        finalList.forEach(System.out::println);

        Map<Integer, Integer> integerIntegerMap = list1.stream()
                .filter(e1 -> empMarksMap.containsKey(e1.getEmpName()))
                //.map(e1 -> new Result(e1.getEmpId(), empMarksMap.get(e1.getEmpName())))
                .collect(Collectors.toMap(e1 -> e1.getEmpId(), e1 -> empMarksMap.get(e1.getEmpName())));
        for(Map.Entry<Integer,Integer> entry:integerIntegerMap.entrySet()){
            System.out.println("empId="+entry.getKey()+", empMarks="+entry.getValue());
        }
    }
}
