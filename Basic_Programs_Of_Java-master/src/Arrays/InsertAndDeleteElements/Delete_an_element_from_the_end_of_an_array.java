package Arrays.InsertAndDeleteElements;
import java.util.*;

public class Delete_an_element_from_the_end_of_an_array {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>
                (Arrays.asList(10, 20, 30, 40));

        System.out.println("Array before deletion");
        for (int ele : arr)
            System.out.print(ele + " ");

        // Remove the last element from the array
        arr.remove(arr.size() - 1);

        System.out.println("\nArray after deletion");
        for (int ele : arr)
            System.out.print(ele + " ");
    }
}
