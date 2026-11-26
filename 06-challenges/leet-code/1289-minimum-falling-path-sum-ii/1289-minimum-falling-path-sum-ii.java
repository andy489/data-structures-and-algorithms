// https://leetcode.com/problems/minimum-falling-path-sum-ii/

// Solution: Dynamic Programming — O(n²) time, O(n) space
// Solution: DP with Two Minimums — O(n²) time, O(n) space
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = grid[0].clone();
        for (int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, minCol = -1;
            for (int j = 0; j < n; j++) {
                if (dp[j] < min1) { min2 = min1; min1 = dp[j]; minCol = j; }
                else if (dp[j] < min2) { min2 = dp[j]; }
            }
            int[] ndp = new int[n];
            for (int j = 0; j < n; j++) ndp[j] = grid[i][j] + (j == minCol ? min2 : min1);
            dp = ndp;
        }
        int res = Integer.MAX_VALUE;
        for (int x : dp) res = Math.min(res, x);
        return res;
    }
}
