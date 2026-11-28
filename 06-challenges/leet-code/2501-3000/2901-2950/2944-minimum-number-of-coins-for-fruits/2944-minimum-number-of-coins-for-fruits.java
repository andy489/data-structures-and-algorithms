// https://leetcode.com/problems/minimum-number-of-coins-for-fruits/

// Solution: DP with Monotonic Deque — O(n) time, O(n) space
class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(n); // sentinel: buying "nothing" beyond index n costs 0

        for (int i = n - 1; i >= 0; i--) {
            // Window: next purchase index j in [i+1, 2*i+2] (0-indexed next i+1..2i+2)
            // But we store 1-indexed logic: buying fruit i+1 (0-indexed i) gives i free,
            // so next must buy at index > i + i = 2i (0-indexed), i.e., j in [i+1..2i+1] inclusive
            // We add sentinel at n so the right boundary doesn't go out
            while (!deque.isEmpty() && deque.peekFirst() > 2 * i + 2) {
                deque.pollFirst();
            }
            dp[i] = prices[i] + dp[deque.peekFirst()];
            while (!deque.isEmpty() && dp[deque.peekLast()] >= dp[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return dp[0];
    }
}
