package ReverseArray;

public class FormalReverseArray {

        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5};

            System.out.println("Original Array:");
            printArray(array);

            reverseArray(array);

            System.out.println("\nReversed Array:");
            printArray(array);
        }

        // Method to reverse the array
        private static void reverseArray(int[] arr) {
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


