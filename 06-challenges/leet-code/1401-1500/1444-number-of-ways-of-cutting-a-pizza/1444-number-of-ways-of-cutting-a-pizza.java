// https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

// Solution: DP + Prefix Sum — O(k * rows * cols * (rows+cols)) time, O(k * rows * cols) space
class Solution {
    public int ways(String[] pizza, int k) {
        int R = pizza.length, C = pizza[0].length();
        long MOD = 1_000_000_007;
        int[][] suf = new int[R+1][C+1];
        for (int r = R-1; r >= 0; r--)
            for (int c = C-1; c >= 0; c--)
                suf[r][c] = (pizza[r].charAt(c)=='A'?1:0) + suf[r+1][c] + suf[r][c+1] - suf[r+1][c+1];
        long[][][] dp = new long[R][C][k+1];
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                if (suf[r][c] > 0) dp[r][c][1] = 1;
        for (int p = 2; p <= k; p++)
            for (int r = 0; r < R; r++)
                for (int c = 0; c < C; c++) {
                    for (int nr = r+1; nr < R; nr++)
                        if (suf[r][c]-suf[nr][c] > 0) dp[r][c][p] = (dp[r][c][p]+dp[nr][c][p-1]) % MOD;
                    for (int nc = c+1; nc < C; nc++)
                        if (suf[r][c]-suf[r][nc] > 0) dp[r][c][p] = (dp[r][c][p]+dp[r][nc][p-1]) % MOD;
                }
        return (int) dp[0][0][k];
    }
}
