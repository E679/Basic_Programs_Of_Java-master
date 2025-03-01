package DSA.LRUCacheImplementation;

import java.util.*;

class LRUCache<K, V> {
    // Node class for the doubly linked list
    private class Node {
        K key;
        V value;
        Node prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity; // Maximum capacity of the cache
    private final Map<K, Node> map; // HashMap to store key and corresponding node
    private final Node head, tail; // Dummy head and tail for easy insertion/deletion

    // Constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(null, null); // Dummy head node
        this.tail = new Node(null, null); // Dummy tail node
        head.next = tail; // Connect head to tail
        tail.prev = head; // Connect tail to head
    }

    // Method to retrieve a value from the cache
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null; // If key is not present, return null
        }
        Node node = map.get(key);
        // Move the accessed node to the front (most recently used)
        moveToHead(node);
        return node.value;
    }

    // Method to add a key-value pair to the cache
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            // If the key already exists, update the value and move it to the front
            Node node = map.get(key);
            node.value = value; // Update value
            moveToHead(node);
        } else {
            // If the key is new, create a new node
            Node newNode = new Node(key, value);
            map.put(key, newNode); // Add to HashMap
            addToHead(newNode); // Insert into linked list

            // If size exceeds capacity, remove the least recently used node
            if (map.size() > capacity) {
                Node lru = removeTail(); // Remove the node from linked list
                map.remove(lru.key); // Remove from HashMap
            }
        }
    }

    // Helper method to move a node to the front of the doubly linked list
    private void moveToHead(Node node) {
        removeNode(node); // Remove from current position
        addToHead(node); // Add to the front (just after head)
    }

    // Helper method to remove a node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to add a node to the front of the doubly linked list
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper method to remove the tail node (least recently used)
    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru); // Remove it from the doubly linked list
        return lru;
    }

    public void printCache() {
        Node current = head.next; // Start after dummy head
        System.out.print("Cache: ");
        while (current != tail) { // Stop before dummy tail
            System.out.print("(" + current.key + ", " + current.value + ") ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.printCache(); // Cache: (1, One) (2, Two) (3, Three)

        cache.get(2); // Access key 2 (move it to the front)
        cache.printCache(); // Cache: (1, One) (3, Three) (2, Two)

        cache.put(4, "Four"); // Add key 4 (evicts key 1, least recently used)
        cache.printCache(); // Cache: (3, Three) (2, Two) (4, Four)

        cache.get(1); // Access key 1 (not in cache, returns null)
        System.out.println("Key 1 value: " + cache.get(1)); // null

        cache.put(5, "Five"); // Add key 5 (evicts key 3)
        cache.printCache(); // Cache: (2, Two) (4, Four) (5, Five)
    }
}
/*
### Explanation:
1. **Approach**:
    - Use a **HashMap** to store the key and its corresponding node in a **doubly linked list**.
    - The **doubly linked list** maintains the order of elements, with the most recently used items at the front and the least recently used at the back.

2. **Core Methods**:
    - **`get(K key)`**:
        - If the key exists, move the node to the front (most recently used) and return its value.

    - **`put(K key, V value)`**:
        - If the key already exists, update its value and move the node to the front.
        - If it's a new key, insert the node at the front. If the cache exceeds capacity, remove the least recently used node (the one at the tail).

3. **Helper Functions**:
    - **`addToHead(Node node)`**: Adds a node right after the dummy `head`.
    - **`removeNode(Node node)`**: Removes a node from its current position.
    - **`removeTail()`**: Removes the node at the `tail` (least recently used).

4. **Dummy Nodes**:
    - To simplify edge cases when adding or removing nodes, we use dummy `head` and `tail` nodes.

5. **Time and Space Complexity**:
    - **Time Complexity**:
        - `get`: O(1) (HashMap lookup and linked list operations).
        - `put`: O(1) (HashMap and linked list operations).

    - **Space Complexity**: O(capacity) due to storage in the HashMap and linked list.

6. **Example Output**:
   Cache: (1, One) (2, Two) (3, Three)
   Cache: (1, One) (3, Three) (2, Two)
   Cache: (3, Three) (2, Two) (4, Four)
   Key 1 value: null
   Cache: (2, Two) (4, Four) (5, Five)
 */