// https://leetcode.com/problems/dice-roll-simulation/

// Solution: Dynamic Programming — O(n*6*15) time, O(n*6*15) space
// Solution: Dynamic Programming — O(n*6*15) time, O(n*6*15) space
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int MOD = 1_000_000_007;
        int[][][] dp = new int[n+1][6][16];
        for (int j = 0; j < 6; j++) dp[1][j][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int pj = 0; pj < 6; pj++) {
                        if (pj == j) {
                            if (k >= 2) for (int pk = 1; pk <= rollMax[j]; pk++) dp[i][j][k] = (dp[i][j][k] + dp[i-1][pj][k-1]) % MOD;
                        } else {
                            for (int pk = 1; pk <= rollMax[pj]; pk++) dp[i][j][1] = (dp[i][j][1] + dp[i-1][pj][pk]) % MOD;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j < 6; j++) for (int k = 1; k <= rollMax[j]; k++) res = (res + dp[n][j][k]) % MOD;
        return res;
    }
}
