package JavaStreamAPI.EmployeePackage;
import java.util.*;
import java.util.stream.Collectors;

/*
I have two lists based on employee object, list1 contains empId and empname, and
list2 contains empname and empmarks. Now use Java 8 streams to produce final list
to print empId and empmarks

 Input:

list1: List of Employee1 with empId and empName

list2: List of Employee2 with empName and empMarks
 */

public class Employee1 {
    private int empId;
    private String empName;

    public Employee1(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
}
