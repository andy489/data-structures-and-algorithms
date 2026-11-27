// https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/
class Solution {
    public int minimumOperations(int[][] grid) {
        int ops = 0;
        int m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            int prev = grid[0][j];
            for (int i = 1; i < m; i++) {
                if (grid[i][j] <= prev) {
                    ops += prev + 1 - grid[i][j];
                    prev = prev + 1;
                } else {
                    prev = grid[i][j];
                }
            }
        }
        return ops;
    }
}
