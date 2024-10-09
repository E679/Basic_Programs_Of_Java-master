package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    /*
    Input : [1,2,2,1], [2,2]
    Output : 2,2
     */
    public static void main(String[] args) {
        int[] arr1={1,2,2,3,4};
        int[] arr2={2,2,3,5};
        //intersectionOfTwoArrays: [2, 2, 3]
        List<Integer> intersectionOfTwoArrays = getIntersectionOfTwoArrays(arr1, arr2);
        System.out.println("intersectionOfTwoArrays: "+intersectionOfTwoArrays);

        int[] arr3 = {1, 2, 2, 3, 4};
        int[] arr4 = {2, 3, 5};

        Set<Integer> intersection = Arrays.stream(arr1)
                .distinct()
                .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))
                .boxed()
                .collect(Collectors.toSet());

        System.out.println("Unique elements Intersection Using streams: " + intersection);
    }

    private static List<Integer> getIntersectionOfTwoArrays(int[] arr1, int[] arr2) {
        int i=0,j=0;
        List<Integer> ans= new ArrayList<>();
        while (i<arr1.length && j< arr2.length) {
            if(arr1[i]<arr2[j]) {
                i++;
            } else if (arr2[j]<arr1[i]) {
                j++;
            } else {
                ans.add(arr1[i]);
                i++;
                j++;
            }

        }
        return ans;
    }
}
