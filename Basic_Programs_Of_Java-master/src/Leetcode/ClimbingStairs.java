package Leetcode;
/*
Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Example 1:
Input: n = 2Output: 2Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: n = 3Output: 3Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;  // Ways to reach step 1
        int second = 2; // Ways to reach step 2
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = first + second; // Ways to reach current step
            first = second;          // Move forward
            second = result;
        }

        return result;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        System.out.println("Ways to climb 2 stairs: " + cs.climbStairs(2)); // Output: 2
        System.out.println("Ways to climb 3 stairs: " + cs.climbStairs(3)); // Output: 3
        System.out.println("Ways to climb 5 stairs: " + cs.climbStairs(5)); // Output: 8
    }
}