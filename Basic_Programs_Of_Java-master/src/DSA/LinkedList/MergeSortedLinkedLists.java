package DSA.LinkedList;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortedLinkedLists {

    // Function to merge two sorted linked lists
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Create a dummy node to start the merged list
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists and choose the smaller value at each step
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append any remaining nodes from either list
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the merged list (dummy.next skips the dummy node)
        return dummy.next;
    }

    // Helper method to create a linked list from an array
    public static Node createLinkedList(int[] values) {
        if (values.length == 0) return null;

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to print a linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create two sample sorted linked lists
        Node l1 = createLinkedList(new int[]{1, 2, 4});
        Node l2 = createLinkedList(new int[]{1, 3, 4});

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        // Merge the two sorted lists
        Node mergedList = mergeTwoLists(l1, l2);

        System.out.println("Merged List:");
        printList(mergedList);
    }
}
/*
### Explanation of the Code:
1. **Logic**:
    - Use a **dummy node** to simplify the handling of pointers while merging the lists.
    - Traverse both input lists (`l1` and `l2`) until one of them is exhausted:
        - Compare the current node values (`l1.val` and `l2.val`) and append the smaller node to the merged list.

    - Append the remaining nodes from the non-exhausted list to the merged list.

2. **Helper Functions**:
    - `createLinkedList(int[] values)`: To create a linked list from an array of integers for testing purposes.
    - `printList(ListNode head)`: To print the elements of a linked list.

3. **Edge Cases**:
    - If one of the lists is empty, immediately return the other list.

4. **Time Complexity**:
    - Each node is processed exactly once, and the total number of nodes is the combined length of both lists.
    - **O(n + m)**, where `n` and `m` are the lengths of the two lists.

5. **Space Complexity**:
    - This solution uses iterative merging, so it requires **O(1)** extra space (besides input and output).

### Input and Output Example:
#### Input:
- List 1: `1 -> 2 -> 4 -> null`
- List 2: `1 -> 3 -> 4 -> null`

#### Output:
- Merged List: `1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null`

 */
