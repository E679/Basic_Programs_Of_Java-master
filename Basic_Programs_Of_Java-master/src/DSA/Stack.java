package DSA;


//1. Implement a stack using a linked list.
//
//Implementing a Stack using a Linked List in Java
//A stack follows LIFO (Last In, First Out) order, meaning elements are added and removed from the top. A linked list implementation allows dynamic memory allocation without worrying about size constraints, unlike an array-based stack.
//
//Implementation Details
//1. Node Class: Represents a node in the linked list, containing data and a reference to the next node.
//2. Stack Class:
// i)push(int data): Adds an element to the top of the stack.
// ii)pop(): Removes and returns the top element.
// iii)peek(): Returns the top element without removing it.
// iv)isEmpty(): Checks if the stack is empty.
// v)printStack(): Displays all elements in the stack.
//


// Node class for Linked List
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class using Linked List
class StackLinkedList {
    private Node top; // Top of the stack

    public StackLinkedList() {
        this.top = null;
    }

    // Push operation
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; // New node points to previous top
        top = newNode; // Update top to new node
        System.out.println("Pushed: " + data);
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No elements to pop.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next; // Move top to the next node
        return poppedData;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Print Stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // Output: 30 -> 20 -> 10 -> NULL

        System.out.println("Popped: " + stack.pop()); // Output: 30
        stack.printStack(); // Output: 20 -> 10 -> NULL

        System.out.println("Peek: " + stack.peek()); // Output: 20
    }
    /*
    Time Complexity
Operation	Time Complexity
Push	        𝑂(1)
Pop             O(1)
Peek            𝑂(1)
isEmpty         O(1)
     */
}
