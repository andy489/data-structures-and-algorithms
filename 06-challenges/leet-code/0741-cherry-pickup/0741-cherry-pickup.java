// https://leetcode.com/problems/cherry-pickup/

// Solution: 3D DP (Two Simultaneous Paths) — O(n³) time, O(n²) space
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int NEG_INF = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, NEG_INF);
        }
        dp[0][0] = grid[0][0];
        for (int t = 1; t < 2 * n - 1; t++) {
            int[][] ndp = new int[n][n];
            for (int[] row : ndp) {
                java.util.Arrays.fill(row, NEG_INF);
            }
            for (int r1 = Math.max(0, t - (n - 1)); r1 <= Math.min(t, n - 1); r1++) {
                int c1 = t - r1;
                if (grid[r1][c1] == -1) {
                    continue;
                }
                for (int r2 = r1; r2 <= Math.min(t, n - 1); r2++) {
                    int c2 = t - r2;
                    if (grid[r2][c2] == -1) {
                        continue;
                    }
                    int cherries = grid[r1][c1] + (r1 != r2 ? grid[r2][c2] : 0);
                    int best = NEG_INF;
                    for (int dr1 : new int[]{0, 1}) {
                        for (int dr2 : new int[]{0, 1}) {
                            int pr1 = r1 - dr1, pr2 = r2 - dr2;
                            if (pr1 >= 0 && pr2 >= 0 && dp[pr1][pr2] != NEG_INF) {
                                best = Math.max(best, dp[pr1][pr2] + cherries);
                            }
                        }
                    }
                    ndp[r1][r2] = best;
                }
            }
            dp = ndp;
        }
        return Math.max(0, dp[n - 1][n - 1]);
    }
}
