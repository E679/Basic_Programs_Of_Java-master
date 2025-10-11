package Arrays.InsertAndDeleteElements;

public class Insert_element_in_array_at_given_index_shift_others {
    //Dynamic approach for any given index
    public static int[] insertElementAtGivenIndex(int[] originalArray, int elementToInsert, int index) {
        // Check for valid index and array capacity
        if (index < 0 || index > originalArray.length) {
            throw new IndexOutOfBoundsException("Invalid index for insertion.");
        }

        // Create a new array with increased size
        int[] newArray = new int[originalArray.length + 1];

        // Copy elements before the insertion point
        for (int i = 0; i < index; i++) {
            newArray[i] = originalArray[i];
        }

        // Insert the new element
        newArray[index] = elementToInsert;

        // Shift and copy elements after the insertion point
        for (int i = index; i < originalArray.length; i++) {
            newArray[i + 1] = originalArray[i];
        }

        return newArray;
    }

    public static int[] insertAtBeginning(int[] originalArray, int elementToInsert) {
        // Create a new array with size + 1
        int[] newArray = new int[originalArray.length + 1];

        // Place the new element at the first position (index 0)
        newArray[0] = elementToInsert;

        // Copy the elements from the original array to the new array,
        // shifting them one position to the right
        for (int i = 0; i < originalArray.length; i++) {
            newArray[i + 1] = originalArray[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 5};
        int element = 4;
        int insertIndex = 3; // Insert at index 3 (after 3, before 5)

        int[] updatedArray = insertElementAtGivenIndex(myArray, element, insertIndex);

        System.out.print("Original Array: ");
        for (int num : myArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Updated Array: ");
        for (int num : updatedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        //insertAtBeginning()
        int[] myArray1 = {10, 20, 30, 40};
        int element1 = 5;

        System.out.println("Original Array:");
        for (int val : myArray1) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] updatedArray1 = insertAtBeginning(myArray1, element1);

        System.out.println("Array after insertion:");
        for (int val : updatedArray1) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
