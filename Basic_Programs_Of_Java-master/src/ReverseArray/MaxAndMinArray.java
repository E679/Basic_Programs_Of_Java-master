package ReverseArray;

public class MaxAndMinArray {
    public static void main(String[] args) {
        int arr[]={48,2,49,56,12,52,14,99,102};
        int max=0;
        int min=0;
        System.out.println("Max is:");
        getMaxFromArr(arr,max);
        System.out.println("Min is:");
        getMinFromArr(arr,min);
    }

    private static void getMinFromArr(int[] arr, int min) {
        for (int i=0;i<arr.length;i++){
            if(arr[i]<arr[0]){
                min=arr[i];
            }
        }
        System.out.println(min);
    }

    private static void getMaxFromArr(int[] arr, int max) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] > arr[0]) {
               max=arr[i];
            }
        }
        System.out.println(max);
    }
}
