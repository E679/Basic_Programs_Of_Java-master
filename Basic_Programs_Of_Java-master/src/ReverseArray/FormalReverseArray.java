package ReverseArray;

public class FormalReverseArray {

        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5};
            int[] array1 = {10,9,8,7,6,5};

            System.out.println("Original Array:");
            printArray(array);

            System.out.println("\nReversed Array Using While Loop: \n");
            reverseUsingWhileLoop(array);
            printArray(array);
            System.out.println("\nReversed Array Using For Loop: \n");
            reverseUsingForLoop(array1);

//            System.out.println("\nReversed Array: \n");
//            printArray(array);
        }

    private static void reverseUsingForLoop(int[] array) {
        for(int i=array.length - 1; i>=0; i--){
            System.out.print(array[i]+" ");
        }
        /*
        Another way
        store in new array and send the new array
         */

//        int[] res=new int[array.length];
//        int j=0;
//        for(int i=array.length - 1; i>=0; i--){
//            res[j++]=array[i];
//        }
//        //printing the new array within index j length
//        for(int i=0; i<j; i++){
//            System.out.print(res[i]+" ");
//        }
    }

    // Method to reverse the array
        private static void reverseUsingWhileLoop(int[] arr) {
            int start = 0;
            int end = arr.length - 1;

            while (start < end) {
                // Swap elements at start and end indices
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                // Move indices towards the center
                start++;
                end--;
            }
        }

        // Method to print the array
        private static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


