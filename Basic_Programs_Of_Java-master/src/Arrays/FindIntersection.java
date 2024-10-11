package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FindIntersection {
    public static String findIntersection(String[] strArr) {
        // Split the two input strings into arrays of integers
        String[] firstList = strArr[0].split(",\\s*");
        String[] secondList = strArr[1].split(",\\s*");

        //Convert array to list
        List<String> list = Arrays.asList(firstList);

        // Find the intersection using streams
        List<String> intersection = Arrays.stream(secondList)
                .filter(list::contains) // Keep only elements that are in the list
                .sorted(Comparator.comparingInt(Integer::parseInt)) // Sort the results
                .collect(Collectors.toList()); // Collect to a list

        // If there are no intersections, return "false"
        if (intersection.isEmpty()) {
            return "false";
        }

        // Join the sorted numbers into a comma-separated string
        return String.join(",", intersection);
    }

    public static void main(String[] args) {
        String[] input1 = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        String[] input2 = {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"};

        System.out.println(findIntersection(input1)); // Output: 1,4,13
        System.out.println(findIntersection(input2)); // Output: 1,9,10
    }
}

class anotherWayFindIntersectionUsingJava7{
    public static String FindIntersection(String[] strArr) {
        // code goes here
        String[] firstArray=strArr[0].split(",\\s*");
        String[] secondArray=strArr[1].split(",\\s*");

        List<String> list=Arrays.asList(firstArray);

        List<String> finallist=new ArrayList<>();

        for(String s:secondArray){
            if(list.contains(s)){
                finallist.add(s);
            }
        }

        if(finallist.isEmpty()){
            return "";
        }

        Collections.sort(finallist, (o1,o2)->Integer.parseInt(o1)-Integer.parseInt(o2));

        return String.join(",",finallist);
    }

    public static void main (String[] args) {
        String[] input1 = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        String[] input2 = {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"};

        System.out.println(FindIntersection(input1)); // Output: 1,4,13
        System.out.println(FindIntersection(input2)); // Output: 1,9,10
    }
}
