// https://leetcode.com/problems/unique-binary-search-trees/

// Solution: Dynamic Programming (Catalan Number) — O(n²) time, O(n) space
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int k = 2; k <= n; k++) {
            for (int i = 1; i <= k; i++) {
                dp[k] += dp[i - 1] * dp[k - i];
            }
        }
        return dp[n];
    }
}

// Solution 2: Closed-Form Catalan Number — O(n) time, O(1) space
class Solution2 {
    public int numTrees(int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result = result * (2 * n - i) / (i + 1);
        }
        return (int) (result / (n + 1));
    }
}
