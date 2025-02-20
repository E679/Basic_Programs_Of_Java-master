package DSA;

/*
Binary Search Tree (BST) Implementation in Java
A Binary Search Tree (BST) is a tree data structure where:

Each node has at most two children.
The left child contains values smaller than the parent.
The right child contains values greater than the parent.
Operations in BST
✅ Insertion (insert) – Adds a new node.
✅ Search (search) – Checks if a value exists.
✅ Inorder Traversal (inorder) – Prints elements in sorted order.
✅ Delete (delete) – Removes a node while maintaining BST properties.

📌 Time Complexity:

Best/Average Case: O(log n) (Balanced BST)
Worst Case: O(n) (Skewed BST)

 */
class BST {
    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root; // Root node of BST

    // Insert a new node into BST
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    // Search for a key in BST
    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.data) {
            return true;
        }

        return key < root.data ? searchRecursive(root.left, key) : searchRecursive(root.right, key);
    }

    // Inorder Traversal (Left -> Root -> Right) (Sorted Order)
    public void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    // Delete a node in BST
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRecursive(root.right, key);
        } else {
            // Case 1: No child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children -> Get inorder successor (smallest in right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    // Main method to test BST
    public static void main(String[] args) {
        BST tree = new BST();

        // Insert elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal (Sorted order)
        System.out.print("Inorder Traversal: ");
        tree.inorder(); // Output: 20 30 40 50 60 70 80

        // Search for elements
        System.out.println("Search 40: " + tree.search(40)); // Output: true
        System.out.println("Search 90: " + tree.search(90)); // Output: false

        // Delete node 50 (Root Node)
        tree.delete(50);
        System.out.print("Inorder after deleting 50: ");
        tree.inorder(); // Output: 20 30 40 60 70 80
    }
}
/*
How It Works
Insertion (insert):

Recursively places the node in the correct position.
O(log n) in a balanced tree.
Search (search):

Recursively compares with root until found.
O(log n) average, O(n) worst case (skewed tree).
Inorder Traversal (inorder):

Prints elements in sorted order.
Uses recursion to traverse left → root → right.
Delete (delete):

Case 1: No child → Remove node.
Case 2: One child → Replace with child.
Case 3: Two children → Replace with inorder successor (smallest value in right subtree).
Edge Cases Handled
✅ Empty Tree (Handles insert, delete, and search gracefully).
✅ Skewed Tree (Worst-case performance handled).
✅ Deleting Root (Replaces with inorder successor).
✅ Deleting Leaf Node (Removes without issues).
 */
