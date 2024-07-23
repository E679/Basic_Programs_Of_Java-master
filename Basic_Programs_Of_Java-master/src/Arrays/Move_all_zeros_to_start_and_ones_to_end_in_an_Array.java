package Arrays;

public class Move_all_zeros_to_start_and_ones_to_end_in_an_Array {
    /*
    Move all zeros to start and ones to end in an Array of random integers
    Input: arr[] = {1, 2, 0, 4, 3, 0, 5, 0}
    Output: 0 0 0 2 4 3 5 1
    Input: arr[] = {1, 2, 0, 0, 0, 3, 6};
    Output: 0 0 0 2 3 6 1
     */
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 0, 0, 0, 3, 6 };
        int n = arr.length;
        pushBinaryToBorder(arr, n);
        printArr(arr, n);

    }
    static void printArr(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
    }

    // Function that pushes all the zeros
// to the start and ones to the end of an array
    static void pushBinaryToBorder(int arr[], int n)
    {

        // To store the count of elements
        // which are not equal to 1
        int count1 = 0;

        // Traverse the array and calculate
        // count of elements which are not 1
        for (int i = 0; i < n; i++)
            if (arr[i] != 1)
                arr[count1++] = arr[i];

        // Now all non-ones elements have been shifted to
        // front and 'count1' is set as index of first 1.
        // Make all elements 1 from count to end.
        while (count1 < n)
            arr[count1++] = 1;

        // Initialize lastNonBinary position to zero
        int lastNonOne = 0;

        // Traverse the array and pull non-zero
        // elements to the required indices
        for (int i = n - 1; i >= 0; i--)
        {

            // Ignore the 1's
            if (arr[i] == 1)
                continue;
            if (lastNonOne == 0)
            {

                // Mark the position Of
                // last NonBinary integer
                lastNonOne = i;
            }

            // Place non-zero element to
            // their required indices
            if (arr[i] != 0)
                arr[lastNonOne--] = arr[i];
        }

        // Put zeros to start of array
        while (lastNonOne >= 0)
            arr[lastNonOne--] = 0;
    }
}
