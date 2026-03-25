package temp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FindPeekElementInArray {
    /*
     A peak element is an element that is strictly greater than its neighbors.
     Given a 0-indexed integer array nums, find a peak element, // and return its index.
     If the array contains multiple peaks, return the index to any of the peaks.
     You may imagine that nums[-1] = nums[n] = -∞. In other words,
     an element is always considered to be strictly greater than a neighbor that is outside the array.

     You must write an algorithm that runs in O(log n) time.
     Example 1: // Input: nums = [1,2,3,1] // Output: 2
     Explanation: 3 is a peak element and your function should return the index number 2.
     Example 2: // Input: nums = [1,2,1,3,5,6,4] // Output: 5
     Explanation: Your function can return either index number 1 //where the peak element is 2, or index number 5 where the peak element is 6.
     Constraints: // 1 <= nums.length <= 1000 // -2^31 <= nums[i] <= 2^31 - 1 // nums[i] != nums[i + 1] for all valid i.

    Find a peek element which is not smaller than its neighbours

    Example 1: [5,10,20,15]
    The element 20 has neighbours 10 and 15, both of them are less than 20
    Example 2: [10,20,30,40,50] 50 is the peak element
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Elements:");
        int N= scanner.nextInt();
        int[] arr=new int[N];
        System.out.println("Enter Array Elements:");
        for (int i=0;i< arr.length;i++) {
            try {
                arr[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please Enter digits...... Program Terminated!");
                throw new RuntimeException(e);
            }
        }

        int peekElement = getPeekElement(arr);
        System.out.println("peekElement is: " + peekElement);
        int peekElementIndex = findPeakElement(arr);
        System.out.println("peekElementIndex is: " + peekElementIndex);
        int[] result = findPeak(arr);
        System.out.println("Peak Index: " + result[0]);
        System.out.println("Peak Element: " + result[1]);
        scanner.close();
    }

    private static int getPeekElement(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if ((i + 1) >= n) {
                return arr[n - 1];
            }
            if (((i - 1) > -1) && (arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1])) {
                return arr[i];
            }
        }
        return 0;
    }

    //correct way
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1; // go right
            } else {
                high = mid; // go left
            }
        }

        return low; // or high (both same)
    }
    /*
    How to Explain in Interview (Important)

You can say:

"Since the problem requires O(log n), I used binary search.
At any mid, I compare it with mid+1.
If the slope is increasing, peak must be on right.
If decreasing, peak is on left including mid.
Finally, low == high → that index is peak."
     */


    //Return peek element and it's index
    public static int[] findPeak(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return new int[]{low, nums[low]};
    }
}
