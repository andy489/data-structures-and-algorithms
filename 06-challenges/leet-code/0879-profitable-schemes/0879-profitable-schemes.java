// https://leetcode.com/problems/profitable-schemes/

// Solution: 2D DP — O(k*n*p) time, O(n*p) space
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int k = 0; k < group.length; k++) {
            int g = group[k], pr = profit[k];
            for (int j = n; j >= g; j--) {
                for (int p = minProfit; p >= 0; p--) {
                    dp[j][Math.min(p + pr, minProfit)] = (dp[j][Math.min(p + pr, minProfit)] + dp[j - g][p]) % MOD;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j <= n; j++) {
            ans = (ans + dp[j][minProfit]) % MOD;
        }
        return ans;
    }
}
