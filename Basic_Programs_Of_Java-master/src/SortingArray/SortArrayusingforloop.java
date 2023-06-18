package SortingArray;

public class SortArrayusingforloop {
    public static void main(String[] args) {
        int[] arr=new int[]{60,20,50,30,10,90};
        int len=arr.length;
        System.out.println("UnSorted Integer array is: ");
        for(int i=0;i<len;i++) {

            System.out.println(arr[i]);
        }
        System.out.println("Sorted Integer array is: ");
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int temp=0;
                if(arr[i]>arr[j]){

                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                }
            }
            System.out.println(arr[i]);
        }
        System.out.println("Sorted array in Reverse: ");
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int temp=0;
                if(arr[i]<arr[j]){

                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                }
            }

        }
        System.out.println("Reverse Integer array");
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
        }
    }
}
