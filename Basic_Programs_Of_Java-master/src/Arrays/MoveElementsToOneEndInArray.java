package Arrays;

public class MoveElementsToOneEndInArray {
    public static void main(String[] args) {
        /*
        Move all 1's to last
         */
        int[] arr={1,2,3,2,4,1,1,2,1,3,1};

        int[] resultArray = moveAllOnesToLast(arr);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i]+",");
        }

        System.out.println("");
        int[] arr1={1,2,3,2,4,1,1,2,1,3,1};
        int[] resultArray1 = moveAllOnesToFirst(arr1);
        for (int i = 0; i < resultArray1.length; i++) {
            System.out.print(resultArray1[i]+",");
        }
    }

    private static int[] moveAllOnesToLast(int[] arr) {
        int count=0;
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 1) {
                arr[count++]=arr[i];
            }
        }

        while (count<n) {
            arr[count++] = 1;
        }

        return arr;
    }

    private static int[] moveAllOnesToFirst(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                continue;
            }
            if (count == 0) {
                count = i;
            }

            if (arr[i] != 1) {
                arr[count--] = arr[i];
            }
        }

        while (count >= 0) {
            arr[count--] = 1;
        }

        return arr;
    }
}
