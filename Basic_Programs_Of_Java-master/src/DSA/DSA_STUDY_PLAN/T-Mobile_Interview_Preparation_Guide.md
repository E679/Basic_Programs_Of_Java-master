# T-Mobile Backend Developer Interview Preparation Guide
## Complete Answer Guide for All 4 Technical Rounds

---

## Table of Contents
1. [Round 1: DSA Solutions](#round-1-dsa-solutions)
2. [Round 2: Java & Spring Boot Deep Dive](#round-2-java-spring-boot)
3. [Round 3: Microservices & Cloud](#round-3-microservices-cloud)
4. [Round 4: System Design](#round-4-system-design)
5. [Behavioral Questions](#behavioral-questions)

---

## Round 1: DSA Solutions

### 1. Two Sum Problem
**Problem:** Given an array of integers, return indices of two numbers that add up to a target.

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        
        map.put(nums[i], i);
    }
    
    throw new IllegalArgumentException("No solution found");
}

// Time Complexity: O(n)
// Space Complexity: O(n)

// Example:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: nums[0] + nums[1] = 2 + 7 = 9
```

**Approach Explanation:**
1. Use HashMap to store number and its index
2. For each number, calculate complement (target - current number)
3. Check if complement exists in map
4. If yes, return indices; if no, add current number to map

---

### 2. Reverse a Linked List
**Problem:** Reverse a singly linked list.

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    
    while (current != null) {
        ListNode nextTemp = current.next;  // Save next node
        current.next = prev;                // Reverse the link
        prev = current;                     // Move prev forward
        current = nextTemp;                 // Move current forward
    }
    
    return prev;  // New head
}

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5
// Output: 5 -> 4 -> 3 -> 2 -> 1
```

**Approach Explanation:**
1. Use three pointers: prev, current, nextTemp
2. Iterate through list
3. Save next node before changing link
4. Reverse the current node's pointer
5. Move all pointers one step forward

---

### 3. Maximum Subarray (Kadane's Algorithm)
**Problem:** Find the contiguous subarray with the largest sum.

```java
public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        // Either extend existing subarray or start new one
        maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
        
        // Update global maximum
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    
    return maxSoFar;
}

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6
```

**Key Insight:**
- At each position, decide: extend current subarray or start fresh
- Keep track of maximum sum seen so far

---

### 4. Valid Anagram
**Problem:** Check if two strings are anagrams.

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    
    int[] charCount = new int[26];  // For lowercase letters
    
    for (int i = 0; i < s.length(); i++) {
        charCount[s.charAt(i) - 'a']++;
        charCount[t.charAt(i) - 'a']--;
    }
    
    for (int count : charCount) {
        if (count != 0) {
            return false;
        }
    }
    
    return true;
}

// Time Complexity: O(n)
// Space Complexity: O(1) - fixed size array

// Example:
// Input: s = "anagram", t = "nagaram"
// Output: true
```

**Alternative Approach using HashMap:**
```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    
    Map<Character, Integer> map = new HashMap<>();
    
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    
    for (char c : t.toCharArray()) {
        if (!map.containsKey(c)) return false;
        map.put(c, map.get(c) - 1);
        if (map.get(c) < 0) return false;
    }
    
    return true;
}
```

---

### 5. Binary Tree Level Order Traversal
**Problem:** Return level order traversal of binary tree.

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    
    if (root == null) {
        return result;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
        
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            currentLevel.add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        result.add(currentLevel);
    }
    
    return result;
}

// Time Complexity: O(n) - visit each node once
// Space Complexity: O(n) - queue can hold up to n/2 nodes

// Example:
// Input:     3
//           / \
//          9  20
//            /  \
//           15   7
// Output: [[3], [9,20], [15,7]]
```

---

### 6. Longest Substring Without Repeating Characters
**Problem:** Find length of longest substring without repeating characters.

```java
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int maxLength = 0;
    int left = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char currentChar = s.charAt(right);
        
        // If character already exists, move left pointer
        if (map.containsKey(currentChar)) {
            left = Math.max(left, map.get(currentChar) + 1);
        }
        
        map.put(currentChar, right);
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
}

// Time Complexity: O(n)
// Space Complexity: O(min(m, n)) where m is charset size

// Example:
// Input: "abcabcbb"
// Output: 3
// Explanation: "abc" is the longest substring
```

**Sliding Window Technique:**
- Use two pointers (left and right)
- Expand window by moving right pointer
- Shrink window by moving left pointer when duplicate found
- Track maximum window size

---

### 7. Merge Intervals
**Problem:** Merge overlapping intervals.

```java
public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) {
        return intervals;
    }
    
    // Sort by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    List<int[]> result = new ArrayList<>();
    int[] currentInterval = intervals[0];
    result.add(currentInterval);
    
    for (int[] interval : intervals) {
        int currentEnd = currentInterval[1];
        int nextStart = interval[0];
        int nextEnd = interval[1];
        
        if (currentEnd >= nextStart) {
            // Overlapping - merge
            currentInterval[1] = Math.max(currentEnd, nextEnd);
        } else {
            // Non-overlapping - add new interval
            currentInterval = interval;
            result.add(currentInterval);
        }
    }
    
    return result.toArray(new int[result.size()][]);
}

// Time Complexity: O(n log n) - sorting
// Space Complexity: O(n)

// Example:
// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
```

---

### 8. Number of Islands (Graph DFS)
**Problem:** Count number of islands in a 2D grid.

```java
public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
        return 0;
    }
    
    int count = 0;
    
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
                count++;
                dfs(grid, i, j);
            }
        }
    }
    
    return count;
}

private void dfs(char[][] grid, int i, int j) {
    // Boundary check
    if (i < 0 || i >= grid.length || 
        j < 0 || j >= grid[0].length || 
        grid[i][j] == '0') {
        return;
    }
    
    // Mark as visited
    grid[i][j] = '0';
    
    // Explore all 4 directions
    dfs(grid, i + 1, j);  // Down
    dfs(grid, i - 1, j);  // Up
    dfs(grid, i, j + 1);  // Right
    dfs(grid, i, j - 1);  // Left
}

// Time Complexity: O(m * n)
// Space Complexity: O(m * n) - recursion stack

// Example:
// Input:
// 1 1 0 0 0
// 1 1 0 0 0
// 0 0 1 0 0
// 0 0 0 1 1
// Output: 3
```

---


