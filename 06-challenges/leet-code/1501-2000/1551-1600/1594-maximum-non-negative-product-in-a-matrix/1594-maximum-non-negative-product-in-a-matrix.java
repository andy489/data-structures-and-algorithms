// https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/

// Solution: DP Track Min/Max — O(m*n) time, O(m*n) space
class Solution {
    public int maxProductPath(int[][] grid) {
        int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        long[][] dpMax = new long[m][n];
        long[][] dpMin = new long[m][n];
        dpMax[0][0] = dpMin[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dpMax[i][0] = dpMin[i][0] = dpMax[i - 1][0] * grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dpMax[0][j] = dpMin[0][j] = dpMax[0][j - 1] * grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long v = grid[i][j];
                long[] candidates = {
                    dpMax[i - 1][j] * v, dpMin[i - 1][j] * v,
                    dpMax[i][j - 1] * v, dpMin[i][j - 1] * v
                };
                dpMax[i][j] = Math.max(Math.max(candidates[0], candidates[1]), Math.max(candidates[2], candidates[3]));
                dpMin[i][j] = Math.min(Math.min(candidates[0], candidates[1]), Math.min(candidates[2], candidates[3]));
            }
        }
        long ans = dpMax[m - 1][n - 1];
        return ans < 0 ? -1 : (int) (ans % MOD);
    }
}
