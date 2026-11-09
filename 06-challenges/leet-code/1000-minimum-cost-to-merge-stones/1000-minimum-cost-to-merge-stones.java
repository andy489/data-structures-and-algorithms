// https://leetcode.com/problems/minimum-cost-to-merge-stones/

// Solution: Interval DP with Prefix Sums — O(n³/k) time, O(n²) space
class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        // each merge reduces pile count by (k-1); need (n-1) total reductions
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        // prefix[i+1] = sum of stones[0..i] for O(1) range sum queries
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // dp[i][j] = min cost to reduce stones[i..j] to the minimum possible piles
        int[][] dp = new int[n][n];

        for (int len = k; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                // step by (k-1): left part stones[i..m] must be reducible to 1 pile,
                // which requires (m-i) % (k-1) == 0, so m = i, i+(k-1), i+2(k-1), ...
                for (int m = i; m < j; m += k - 1) {
                    if (dp[i][m] != Integer.MAX_VALUE && dp[m + 1][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                    }
                }
                // if stones[i..j] can be reduced to exactly 1 pile, add the final merge cost
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }

        return dp[0][n - 1];
    }
}
