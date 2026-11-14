// https://leetcode.com/problems/unique-paths/

// Solution: DP (1D Space-Optimized) — O(m·n) time, O(n) space
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}

// Solution 2: Combinatorics — O(min(m,n)) time, O(1) space
class Solution2 {
    public int uniquePaths(int m, int n) {
        long result = 1;
        int k = Math.min(m, n) - 1;
        for (int i = 0; i < k; i++) {
            result = result * (m + n - 2 - i) / (i + 1);
        }
        return (int) result;
    }
}
