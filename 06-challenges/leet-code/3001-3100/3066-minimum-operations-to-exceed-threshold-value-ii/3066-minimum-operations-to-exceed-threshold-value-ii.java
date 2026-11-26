// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

// Solution: Min-Heap (Priority Queue) — O(n log n) time, O(n) space
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int x : nums) { pq.offer((long) x); }
        int ops = 0;
        while (pq.peek() < k) {
            long x = pq.poll(), y = pq.poll();
            pq.offer(x * 2 + y);
            ops++;
        }
        return ops;
    }
}
