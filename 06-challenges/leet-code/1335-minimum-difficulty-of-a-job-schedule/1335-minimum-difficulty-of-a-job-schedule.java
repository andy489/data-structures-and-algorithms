// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

// Solution: DP — O(d*n^2) time, O(d*n) space
class Solution {
    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;
        if (n < d) return -1;
        int[][] dp = new int[d+1][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
        dp[0][0] = 0;
        // dp[day][i] = min cost using exactly `day` days for first i+1 jobs
        int[][] maxRight = new int[n][n];
        for (int i = 0; i < n; i++) {
            maxRight[i][i] = jd[i];
            for (int j = i+1; j < n; j++) maxRight[i][j] = Math.max(maxRight[i][j-1], jd[j]);
        }
        // Restate: dp[k][j] = min cost doing first j jobs in k days
        int[][] dp2 = new int[d+1][n+1];
        for (int[] row : dp2) Arrays.fill(row, Integer.MAX_VALUE/2);
        dp2[0][0] = 0;
        for (int k = 1; k <= d; k++) {
            for (int j = k; j <= n; j++) {
                int mx = 0;
                for (int i = j-1; i >= k-1; i--) {
                    mx = Math.max(mx, jd[i]);
                    if (dp2[k-1][i] < Integer.MAX_VALUE/2) {
                        dp2[k][j] = Math.min(dp2[k][j], dp2[k-1][i] + mx);
                    }
                }
            }
        }
        return dp2[d][n];
    }
}
