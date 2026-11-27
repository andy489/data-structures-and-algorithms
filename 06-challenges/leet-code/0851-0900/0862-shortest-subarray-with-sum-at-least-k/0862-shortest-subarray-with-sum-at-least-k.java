// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

// Solution: Prefix Sum + Monotonic Deque — O(n) time, O(n) space
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int ans = n + 1;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                ans = Math.min(ans, i - dq.pollFirst());
            }
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return ans <= n ? ans : -1;
    }
}
