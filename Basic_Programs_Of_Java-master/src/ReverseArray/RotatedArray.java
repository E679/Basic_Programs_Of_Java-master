package ReverseArray;

/*
Rotate an array by n positions

Input:
  int [] arr={1, 2, 3, 4, 5};
  positions=2;

Output:
  Rotated Array: 4 5 1 2 3
 */
public class RotatedArray {
    public static void main(String[] args) {
        int [] arr={1, 2, 3, 4, 5};
        int positions=2;

        int [] nums={10, 20, 30, 40, 50};
        int k=2;
        int n=nums.length;

        int[] rotatedArr=new int[arr.length];

        for (int i=0;i< arr.length;i++){
            int newPos=(i+positions) % arr.length;
            rotatedArr[newPos]=arr[i];
        }

        System.out.println("Rotated Array: ");
        for (int num:rotatedArr) {
            System.out.print(num+" ");
        }

        //Another way
        int[] res=rotatearrayUsingPositions(nums,n,k);
        System.out.println("\nrotatearrayUsingPositions: \n");
        for (int i=0;i<n;++i){
            System.out.print(res[i]+" ");
        }
    }

    private static int[] rotatearrayUsingPositions(int[] nums, int n,int k) {
        if (k > n)
            k = k % n;

        int[] ans = new int[n];

        for (int i = 0; i < k; i++) {
            ans[i] = nums[n - k + i];
        }

        int index = 0;
        for (int i = k; i < n; i++) {
            ans[i] = nums[index++];
        }
        return ans;
    }
}
