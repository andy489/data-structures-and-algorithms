// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/

// Solution: 3D DP — O(n*m*k*m) time, O(n*m*k) space
class Solution {
    public int numOfArrays(int n, int m, int k) {
        long MOD = 1_000_000_007;
        long[][][] dp = new long[n+1][m+1][k+1];
        for (int j = 1; j <= m; j++) dp[1][j][1] = 1;
        for (int i = 1; i < n; i++)
            for (int j = 1; j <= m; j++)
                for (int c = 1; c <= k; c++) {
                    if (dp[i][j][c] == 0) continue;
                    dp[i+1][j][c] = (dp[i+1][j][c] + dp[i][j][c] * j) % MOD;
                    for (int v = j+1; v <= m; v++)
                        dp[i+1][v][c+1] = (dp[i+1][v][c+1] + dp[i][j][c]) % MOD;
                }
        long ans = 0;
        for (int j = 1; j <= m; j++) ans = (ans + dp[n][j][k]) % MOD;
        return (int) ans;
    }
}
