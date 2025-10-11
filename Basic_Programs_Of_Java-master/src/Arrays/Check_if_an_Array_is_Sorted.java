package Arrays;

public class Check_if_an_Array_is_Sorted {
    //recursive
    static boolean isSortedHelper(int arr[], int n){

        // Base Case
        if (n == 1 || n == 0)
            return true;

        // Check if current and previous elements are in order
        // and recursively check the rest of the array
        return arr[n - 1] >= arr[n - 2] && isSortedHelper(arr, n - 1);
    }

    static boolean isSorted(int arr[]) {

        return isSortedHelper(arr, arr.length);
    }

    public static void main(String[] args) {

        int arr[] = { 10, 20, 30, 40, 50 };
        int n = arr.length;

        if (isSorted(arr))
            System.out.print("true");
        else
            System.out.print("false");

        if (isSorted1(arr))
            System.out.print("true");
        else
            System.out.print("false");
    }

    //Another way
    static boolean isSorted1(int arr[]) {

        int n = arr.length;
        // Iterate over the array and check if
        // every element is greater than or
        // equal to previous element.
        for (int i = 0; i < n-1; i++)
            if (arr[i] > arr[i+1])
                return false;

        return true;
    }
}
