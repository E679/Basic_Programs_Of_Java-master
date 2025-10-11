package Arrays.ArrayRotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
Problem statement
Given an array 'arr' with 'n' elements, the task is to rotate the array to the left by 'k' steps, where 'k' is non-negative.



Example:
'arr '= [1,2,3,4,5]
'k' = 1  rotated array = [2,3,4,5,1]
'k' = 2  rotated array = [3,4,5,1,2]
'k' = 3  rotated array = [4,5,1,2,3] and so on.


Sample Input 1:
8
7 5 2 11 2 43 1 1
2
Sample Output 1:
2 11 2 43 1 1 7 5
Explanation of Sample Input 1:
Rotate 1 steps to the left: 5 2 11 2 43 1 1 7
Rotate 2 steps to the left: 2 11 2 43 1 1 7 5
Sample Input 2:
4
5 6 7 8
3
Sample Output 2:
8 5 6 7
Explanation of Sample Input 2:
Rotate 1 steps to the left: 6 7 8 5
Rotate 2 steps to the left: 7 8 5 6
Rotate 2 steps to the left: 8 5 6 7
Expected Time Complexity:
O(n), where ‘n’ is the size of the array ‘arr’ and ‘k’ is the number of rotations.
Constraints:
1 <= 'n' <= 10^3
1 <= 'arr'[i] <= 10^9
1 <= 'k' < 'n'

 */
public class leftRotateArrayUsingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the list
        int n = scanner.nextInt();

        // Input the list elements
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        // Input the number of rotations
        int k = scanner.nextInt();

        // Perform left rotation
        leftRotate(arr, k);

        // Print the rotated list
        System.out.println(arr);

        scanner.close();
    }

    // Function to perform left rotation
    private static void leftRotate(List<Integer> arr, int k) {
        Collections.rotate(arr.subList(0, k), k);
    }
}
