package Arrays.Complex.Level2_Common_in_Product_Companies;
//Sliding Window Maximum (Deque approach)

import java.util.*;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
            while (!dq.isEmpty() && a[dq.peekLast()] < a[i]) dq.pollLast();
            dq.offer(i);
            if (i >= k - 1) res[i - k + 1] = a[dq.peek()];
        }
        return res;
    }
}
//Time: O(n), Space: O(k)
