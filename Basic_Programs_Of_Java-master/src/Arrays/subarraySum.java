package Arrays;

public class subarraySum {
    public static void main(String[] args) {
        int[] nums={3,2,1};
        int k=3;
        int c=subarraySumUptoKelements(nums,k);
        System.out.println(c);

    }
    private static int subarraySumUptoKelements(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;

            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];

                if (currentSum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
