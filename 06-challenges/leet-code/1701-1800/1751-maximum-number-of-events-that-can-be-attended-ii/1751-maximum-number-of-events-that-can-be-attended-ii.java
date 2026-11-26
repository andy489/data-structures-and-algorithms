// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/

// Solution: Sort + DP + Binary Search — O(n·k·log n) time, O(n·k) space
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int start = events[i - 1][0], val = events[i - 1][2];
            // Binary search: find last event ending strictly before start
            int lo = 0, hi = i - 1;
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                if (events[mid - 1][1] < start) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[lo][j - 1] + val);
            }
        }
        return dp[n][k];
    }
}
