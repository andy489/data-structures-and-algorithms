// https://leetcode.com/problems/constrained-subsequence-sum/

// Solution: Monotonic Deque DP — O(n) time, O(n) space
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length, ans = Integer.MIN_VALUE;
        int[] dp = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i] + (dq.isEmpty() ? 0 : Math.max(0, dp[dq.peekFirst()]));
            ans = Math.max(ans, dp[i]);
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) dq.pollLast();
            dq.offerLast(i);
            if (i - dq.peekFirst() >= k) dq.pollFirst();
        }
        return ans;
    }
}
