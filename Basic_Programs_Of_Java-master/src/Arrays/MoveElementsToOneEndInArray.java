package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        //Move all zeros to end in a list
        List<Integer> list= Arrays.asList(2,0,5,0,3,0,8,7);
        List<Integer> result= new ArrayList<>();
        int count=0;
        for(Integer n:list){
            if(n!=0){
                result.add(n);
            } else {
                count++;
            }
        }

        for (int i = 0; i < count; i++){
            result.add(0);
        }

        System.out.println("result list "+result);
        //using stream

        List<Integer> nonzeroslist = list.stream().filter(x -> x != 0).collect(Collectors.toList());

        long count1 = list.stream().filter(x -> x == 0).count();

        for (int i=0;i<count1;i++){
            nonzeroslist.add(0);
        }
        System.out.println("result list using streams "+nonzeroslist);
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
