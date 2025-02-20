package DSA;

/*
Implementing a Hash Table in Java
A hash table (hash map) is a data structure that stores key-value pairs and provides efficient insertion, deletion, and lookup operations in O(1) average time complexity.

Concepts Used in Hash Table
Hashing: Converts keys into array indices using a hash function.
Collision Handling:
Chaining (using Linked Lists in each bucket)
Open Addressing (Linear Probing, Quadratic Probing, Double Hashing)
Operations:
put(K key, V value): Inserts a key-value pair.
get(K key): Retrieves a value by key.
remove(K key): Deletes a key-value pair.
containsKey(K key): Checks if a key exists.
size(): Returns the number of stored elements.
Java Implementation of a Hash Table (Using Chaining)
 */

import java.util.LinkedList;

class HashTable<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private LinkedList<Entry<K, V>>[] buckets;

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to determine bucket index
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % INITIAL_CAPACITY);
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key already exists
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    // Check if key exists
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Display Hash Table contents
    public void printTable() {
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry<K, V> entry : buckets[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("Alice", 25);
        hashTable.put("Bob", 30);
        hashTable.put("Charlie", 35);
        hashTable.put("Alice", 26); // Updating value for Alice

        System.out.println("Alice's Age: " + hashTable.get("Alice")); // Output: 26

        hashTable.remove("Bob");
        System.out.println("Contains Bob? " + hashTable.containsKey("Bob")); // Output: false

        hashTable.printTable(); // Display table contents
    }
    /*
    How It Works
Buckets: An array of linked lists stores key-value pairs.
Hashing: Converts a key into an index (hashCode() % capacity).
Collision Handling: Uses chaining (linked list in each bucket).
Insertion (put): If key exists, update the value; otherwise, add a new entry.
Retrieval (get): Searches the linked list at the hashed index.
Deletion (remove): Removes the key-value pair from the list.

     */
}
