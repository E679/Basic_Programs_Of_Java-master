package JavaStreamAPI.Streams;

// Java Program for problem solution
// Using Stream API
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
N’th Highest Salary Using Stream API
Approach: Java 8’s Stream API streamlines finding the nth highest salary in a list. Its declarative and functional approach makes the solution elegant and efficient. We’ll explore this technique in detail.

Step By Step Implementation
Step 1: Create a Map of Employees mapping to their respective salaries.
Employees
Salaries
Abrar

30,000

Chand

80,000

Kalam

70,000

Raheem

25,000

Kiran

63,000

Esa

45,000

Step 2: Let’s sort them in descending order by their salaries.
Employees
Salaries
Chand

80,000

Kalam

70,000

Kiran

63,000

Esa

45,000

Abrar

30,000

Raheem

25,000

From the above table, we can easily get the nth highest salary from the top. For example, 2nd highest salary is holding by the 2nd row [70,000->Kalam]


Output
70000 = [ kalam ]

 */
public class nthHighestSalary {
    public static void main(String[] args)
    {
        // Create a HashMap to store employee
        // names and their corresponding salaries
        Map<String, Integer> map = new HashMap<>();

        map.put("Abrar", 30000);
        map.put("Chand", 80000);
        map.put("kalam", 70000);
        map.put("Raheem", 25000);
        map.put("Kiran", 63000);
        map.put("Esa", 45000);

        // Specify the desired value of n
        int n = 2;

        // Get the nth highest salary along
        // with the corresponding employee name
        Map.Entry<String, Integer> res
                = getNthHighestSalary(map, n);

        // Print the result
        System.out.println(res.getValue() + " = [ "
                + res.getKey() + " ]");
    }

    public static Map.Entry<String, Integer> getNthHighestSalary(Map<String, Integer> employeeSalaries, int n)
    {

        // Use Stream API to sort the entries
        // by salary in descending order
        // Collect the sorted
        // entries into a List
        // Get the nth element from the list
        return employeeSalaries.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(n - 1);
    }
}
