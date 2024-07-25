package Arrays;

public class FindSecondLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int secondLargestElementInAnArray = findSecondLargestElementInAnArray(nums);
        System.out.println("secondLargestElementInAnArray: "+secondLargestElementInAnArray);
    }

    static int findSecondLargestElementInAnArray(int[] nums) {
        int highest=Integer.MIN_VALUE;
        int secondHighest=Integer.MIN_VALUE;
        for (int num:nums) {
            if(num>highest) {
                secondHighest=highest;
                highest = num;
            } else if (num>secondHighest && num!=highest) {
                secondHighest=num;
            }
        }
        return secondHighest;
    }
}
