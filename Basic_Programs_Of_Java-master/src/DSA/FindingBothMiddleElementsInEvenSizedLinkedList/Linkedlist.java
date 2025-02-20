package DSA.FindingBothMiddleElementsInEvenSizedLinkedList;

/*
Finding Both Middle Elements in an Even-Sized Linked List
For an odd-sized linked list, we return the middle element.
For an even-sized linked list, we return both middle elements.

Approach
Use the two-pointer technique:
slow moves one step at a time.
fast moves two steps at a time.
When fast reaches the end:
If the list is odd-sized, return slow as the single middle element.
If the list is even-sized, return both slow and slow.next elements.
 */

class LinkedList {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head of the linked list

    // Add node to the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Find middle element(s)
    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node slow = head, fast = head;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If even-sized list, return both middle elements
        if (fast == null) {
            System.out.println("Middle Elements: " + slow.data + " & " + (slow.next != null ? slow.next.data : ""));
        } else {
            // If odd-sized list, return single middle element
            System.out.println("Middle Element: " + slow.data);
        }
    }

    // Print linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main method to test
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Test case 1: Odd number of elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> NULL
        list.findMiddle(); // Output: Middle Element: 30

        // Test case 2: Even number of elements
        list.insert(60);
        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> NULL
        list.findMiddle(); // Output: Middle Elements: 30 & 40
    }
}
/*

How It Works
For an odd-sized list (e.g., 5 elements):

Example: 10 -> 20 -> 30 -> 40 -> 50
slow stops at 30 → returns 30.
For an even-sized list (e.g., 6 elements):

Example: 10 -> 20 -> 30 -> 40 -> 50 -> 60
slow stops at 30, but fast reaches null.
Returns both 30 and 40.
Edge Cases Handled
✅ Empty List → Prints "List is empty!"
✅ Single Element → Returns that element
✅ Odd Number of Elements → Returns one middle element
✅ Even Number of Elements → Returns two middle elements
 */