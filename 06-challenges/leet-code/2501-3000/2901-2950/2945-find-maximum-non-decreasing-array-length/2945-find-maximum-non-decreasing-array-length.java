// https://leetcode.com/problems/find-maximum-non-decreasing-array-length/

// Solution: DP + Monotonic Deque + Prefix Sums — O(n) time, O(n) space
class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        // dp[i] = max number of segments using nums[0..i-1]
        int[] dp = new int[n + 1];
        // last[i] = the last segment sum of the optimal partition ending at index i
        long[] last = new long[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);

        for (int i = 1; i <= n; i++) {
            // Remove from front: indices j where last[j] > prefix[i] - prefix[j]
            // i.e. the segment [j..i] sum < last[j] — not valid
            while (deque.size() > 1) {
                int j = deque.peekFirst();
                if (last[j] > prefix[i] - prefix[j]) {
                    deque.pollFirst();
                } else {
                    break;
                }
            }
            int j = deque.peekFirst();
            dp[i] = dp[j] + 1;
            last[i] = prefix[i] - prefix[j];
            // Maintain deque: remove from back if adding i is better
            while (!deque.isEmpty()) {
                int k = deque.peekLast();
                // If we can reach k from i with same or better dp+1 and smaller last value
                // Replace k if dp[i]+1 >= dp[k]+1 and last[i] <= last[k] for future queries
                if (dp[i] >= dp[k] && last[i] <= last[k]) {
                    deque.pollLast();
                } else {
                    break;
                }
            }
            deque.addLast(i);
        }
        return dp[n];
    }
}
