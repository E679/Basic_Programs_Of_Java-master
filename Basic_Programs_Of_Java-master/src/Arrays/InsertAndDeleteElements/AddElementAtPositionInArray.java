package Arrays.InsertAndDeleteElements;

// Java Program to Insert an element
// at a specific position in an Array
// using ArrayList
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddElementAtPositionInArray {

    // Method to add element at position
    private static void
    addElement(Integer[] arr, int element, int position)
    {
        // Printing the original array
        System.out.println("Initial Array:\n"
                + Arrays.toString(arr));

        // Converting array to ArrayList
        List<Integer> list
                = new ArrayList<>(Arrays.asList(arr));

        // Adding the element at position
        list.add(position - 1, element);

        // Converting the list back to array
        arr = list.toArray(arr);

        // Printing the updated array
        System.out.println("\nArray with " + element
                + " inserted at position "
                + position + ":\n"
                + Arrays.toString(arr));
    }

    // Drivers Method
    public static void main(String[] args)
    {
        // Sample array
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Element to be inserted
        int element = 50;

        // Position to insert
        int position = 5;

        // Calling the function to insert
        addElement(arr, element, position);
    }
}
