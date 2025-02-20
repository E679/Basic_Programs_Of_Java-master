package DSA.FindTheMiddleElementOfLinkedlist;

/*
Finding the Middle Element of a Linked List in Java
To find the middle element of a singly linked list, we use the two-pointer (slow and fast) approach.

Optimal Approach: Two-Pointer Method
Slow Pointer (slow) moves one step at a time.
Fast Pointer (fast) moves two steps at a time.
When fast reaches the end, slow will be at the middle of the list.
📌 Time Complexity: O(n)
📌 Space Complexity: O(1) (No extra space used)

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

    // Find middle element using the two-pointer approach
    public int findMiddle() {
        if (head == null) {
            throw new IllegalStateException("List is empty!");
        }

        Node slow = head, fast = head;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data; // Middle element
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
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> NULL
        System.out.println("Middle Element: " + list.findMiddle()); // Output: 30

        list.insert(60);
        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> NULL
        System.out.println("Middle Element: " + list.findMiddle()); // Output: 40
    }
}
/*
How It Works
slow moves one step at a time.
fast moves two steps at a time.
When fast reaches the end (null or fast.next == null), slow is at the middle.
Edge Cases Handled
✅ Odd-sized list (returns the middle element).
✅ Even-sized list (returns the second middle element).
✅ Single-element list (returns the only element).
✅ Empty list (throws an exception).
 */